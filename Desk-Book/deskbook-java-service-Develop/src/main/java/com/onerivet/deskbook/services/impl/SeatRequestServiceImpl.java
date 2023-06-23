package com.onerivet.deskbook.services.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onerivet.deskbook.models.entity.Employee;
import com.onerivet.deskbook.models.entity.SeatConfiguration;
import com.onerivet.deskbook.models.entity.SeatNumber;
import com.onerivet.deskbook.models.entity.SeatRequest;
import com.onerivet.deskbook.models.payload.AcceptRejectDto;
import com.onerivet.deskbook.models.payload.BodyDto;
import com.onerivet.deskbook.models.payload.EmailDto;
import com.onerivet.deskbook.models.payload.SeatRequestInformationDto;
import com.onerivet.deskbook.repository.EmployeeRepo;
import com.onerivet.deskbook.repository.SeatConfigurationRepo;
import com.onerivet.deskbook.repository.SeatRequestRepo;
import com.onerivet.deskbook.services.EmailService;
import com.onerivet.deskbook.services.SeatRequestService;

import jakarta.mail.MessagingException;

@Service
public class SeatRequestServiceImpl implements SeatRequestService {

	@Autowired
	private SeatRequestRepo seatRequestRepo;

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private EmailService emailService;
	
	@Autowired
	private SeatConfigurationRepo seatConfigurationRepo;

	public SeatRequestServiceImpl(SeatRequestRepo seatRequestRepo, EmployeeRepo employeeRepo,
			EmailService emailService, SeatConfigurationRepo seatConfigurationRepo) {
		super();
		this.seatRequestRepo = seatRequestRepo;
		this.employeeRepo = employeeRepo;
		this.emailService = emailService;
		this.seatConfigurationRepo=seatConfigurationRepo;
	}

	@Override
	public String requestSeat(String empId, SeatRequestInformationDto seatReqInfoDto) throws MessagingException {

		SeatConfiguration seatConfiguration = seatConfigurationRepo
				.findBySeatNumberAndDeletedByNull(new SeatNumber(seatReqInfoDto.getSeatId()));
		
		SeatRequest request = seatRequestRepo.alreadyBookedOrNot(new SeatNumber(seatReqInfoDto.getSeatId()),
				seatReqInfoDto.getRequestDateTime(), new Employee(empId));
		Employee employee = employeeRepo.findById(empId).get();

		int count = seatRequestRepo.findEmployeeRequestForDay(employee, seatReqInfoDto.getRequestDateTime());

		if (count > 2) {
			return "Maximum limit for request seats is reached, up to 3 seats can be requested for a day";
		}
		if (request != null) {
			return "You already requested this seat";
		}
		System.out.println(count);
		if (employee != null && request == null && count < 3) {
			SeatNumber seatNumber = new SeatNumber(seatReqInfoDto.getSeatId());
			SeatRequest seatRequest = new SeatRequest();

			seatRequest.setSeat(seatNumber);
			seatRequest.setReason(seatReqInfoDto.getReason());
			seatRequest.setEmployee(new Employee(empId));
			seatRequest.setBookingDate(seatReqInfoDto.getRequestDateTime());
			seatRequest.setCreatedDate(LocalDateTime.now());
			seatRequest.setRequestStatus(1);

			seatRequestRepo.save(seatRequest);
			EmailDto emailDto = new EmailDto();
			emailDto.setSubject("Request for Seat Reservation in Deskbook Application");

			if (seatConfiguration == null) {
				// Owner = null, Email send Admin
				emailDto.setTo("harshpatel4018@gmail.com");// pooja
				emailDto.setBody(new BodyDto("Pooja", seatRequest.getBookingDate()));// Admin name

				emailService.sendMailRequest(emailDto);
				
			} else {
				// Owner Employee
				emailDto.setTo(seatConfiguration.getEmployee().getEmailId());
				emailDto.setBody(
						new BodyDto(seatConfiguration.getEmployee().getFirstName(), seatRequest.getBookingDate()));

				emailService.sendMailRequest(emailDto);
			}
			return "Your seat request has been submitted";
		}

		return "Error";

	}

	@Override
	public String acceptReject(String employeeId, AcceptRejectDto accept) throws MessagingException {

		SeatRequest requestedEmployee = seatRequestRepo
				.findByRequestStatusAndEmployeeIdAndSeatIdAndBookingDateAndDeletedDateNull(1, accept.getEmployeeId(),
						accept.getSeatId(), accept.getBookingDate());

		if (accept.getRequestStatus() == 2) {// Approve = 2
			System.out.println("reach upside");
			// Update for approve

			System.out.println("down side");

			requestedEmployee.setRequestStatus(2);
			requestedEmployee.setModifiedBy(new Employee(employeeId));
			requestedEmployee.setModifiedDate(LocalDateTime.now());

			SeatRequest save = seatRequestRepo.save(requestedEmployee);

// Call Email service for Approved seat
			if (save != null) {
				BodyDto body = new BodyDto();

				body.setEmployeeName(requestedEmployee.getEmployee().getFirstName());
				body.setBookingDate(requestedEmployee.getBookingDate());
				body.setCity(requestedEmployee.getSeat().getColumn().getFloor().getCity().getCityName());
				body.setFloorName(requestedEmployee.getSeat().getColumn().getFloor().getFloorName());
				body.setSeatNumber(accept.getSeatId());
				body.setDuration("Full Day");

				EmailDto emailDto = new EmailDto();

				System.out.println("1st");
				emailDto.setTo(requestedEmployee.getEmployee().getEmailId());
				emailDto.setSubject("Approval of Your Office Seat in the Deskbook Application System");
				emailDto.setBody(body);

				System.out.println("2st");
				emailService.sendMailApprove(emailDto);
			}

			List<SeatRequest> rejectSeatList = seatRequestRepo
					.findByEmployeeIdAndRequestStatusAndBookingDateAndDeletedDateNull(accept.getEmployeeId(), 1,
							accept.getBookingDate());

			if (rejectSeatList != null) {

				for (int i = 0; i < rejectSeatList.size(); i++) {

					rejectSeatList.get(i).setRequestStatus(3);
					rejectSeatList.get(i).setModifiedBy(new Employee(employeeId));
					rejectSeatList.get(i).setModifiedDate(LocalDateTime.now());
// Call Email service for rejected seat

					seatRequestRepo.save(rejectSeatList.get(i));

					EmailDto emailDto = new EmailDto();
					emailDto.setTo(rejectSeatList.get(i).getEmployee().getEmailId());
					emailDto.setSubject("Deskbook Application - Seat Request Rejection ");
					emailDto.setBody(new BodyDto(rejectSeatList.get(i).getEmployee().getFirstName()));

					emailService.sendMailReject(emailDto);

				}
			}
// Other Employee on same seat request will automatic rejected        
			List<SeatRequest> otherEmployeeRequest = seatRequestRepo
					.getByRequestStatusAndBookingDateAndSeatIdAndDeletedDateNull(1, accept.getBookingDate(),
							accept.getSeatId());

			if (otherEmployeeRequest != null) {

				for (int i = 0; i < otherEmployeeRequest.size(); i++) {

					otherEmployeeRequest.get(i).setRequestStatus(3);
					otherEmployeeRequest.get(i).setModifiedBy(new Employee(employeeId));
					otherEmployeeRequest.get(i).setModifiedDate(LocalDateTime.now());

// Call Email service for rejected seat

					seatRequestRepo.save(otherEmployeeRequest.get(i));

					EmailDto emailDto = new EmailDto();
					emailDto.setTo(otherEmployeeRequest.get(i).getEmployee().getEmailId());
					emailDto.setSubject("Deskbook Application - Seat Request Rejection ");
					emailDto.setBody(new BodyDto(otherEmployeeRequest.get(i).getEmployee().getFirstName()));

					emailService.sendMailReject(emailDto);
				}
			}

			return "Seat Approved";

		} else {
			// If requestStatus = 3

			requestedEmployee.setRequestStatus(3);
			requestedEmployee.setModifiedBy(new Employee(employeeId));
			requestedEmployee.setModifiedDate(LocalDateTime.now());

			// Call Email service for rejected seat
			seatRequestRepo.save(requestedEmployee);

			EmailDto emailDto = new EmailDto();
			emailDto.setTo(requestedEmployee.getEmployee().getEmailId());
			emailDto.setSubject("Deskbook Application - Seat Request Rejection");
			emailDto.setBody(new BodyDto(requestedEmployee.getEmployee().getFirstName()));

			emailService.sendMailReject(emailDto);
			return "Seat Reject";

		}
	}
}