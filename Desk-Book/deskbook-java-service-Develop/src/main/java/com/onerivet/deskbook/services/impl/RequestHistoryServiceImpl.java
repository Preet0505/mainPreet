package com.onerivet.deskbook.services.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onerivet.deskbook.exception.ResourceNotFoundException;
import com.onerivet.deskbook.models.entity.Employee;
import com.onerivet.deskbook.models.entity.SeatConfiguration;
import com.onerivet.deskbook.models.entity.SeatNumber;
import com.onerivet.deskbook.models.entity.SeatRequest;
import com.onerivet.deskbook.models.payload.RequestHistoryDto;
import com.onerivet.deskbook.repository.EmployeeRepo;
import com.onerivet.deskbook.repository.SeatConfigurationRepo;
import com.onerivet.deskbook.repository.SeatRequestRepo;
import com.onerivet.deskbook.services.RequestHistoryService;


@Transactional
@Service
public class RequestHistoryServiceImpl implements RequestHistoryService {

	@Autowired
	private SeatRequestRepo seatRequestRepo;

	@Autowired
	private SeatConfigurationRepo seatConfigurationRepo;
	
	@Autowired
	private EmployeeRepo employeeRepo;

	

	public RequestHistoryServiceImpl(SeatRequestRepo seatRequestRepo, SeatConfigurationRepo seatConfigurationRepo,
			EmployeeRepo employeeRepo) {
		super();
		this.seatRequestRepo = seatRequestRepo;
		this.seatConfigurationRepo = seatConfigurationRepo;
		this.employeeRepo = employeeRepo;
	}

	@Override
	public List<RequestHistoryDto> getRequestHistory(String employeeId, Pageable pageble, Integer requestStatus) {
		
		Employee employee = employeeRepo.findById(employeeId).orElse(null); 
		
		if(employee.getModeOfWork()!=null && employee.getModeOfWork().getId() == 2 ) {
			return Collections.emptyList();
		}
		

		SeatConfiguration seatConfiguration = seatConfigurationRepo
				.findByEmployeeAndDeletedByNull(new Employee(employeeId));

		if (requestStatus == null) {// call for all
			List<SeatRequest> seatRequest = this.seatRequestRepo
					.findSeatRequestBySeat(new SeatNumber(seatConfiguration.getSeatNumber().getId()), pageble);

			List<RequestHistoryDto> list = new ArrayList<>();
			for (int i = 0; i < seatRequest.size(); i++) {

				RequestHistoryDto requestHistoryDto = new RequestHistoryDto();
				requestHistoryDto.setName(seatRequest.get(i).getEmployee().getFirstName() + " "
						+ seatRequest.get(i).getEmployee().getLastName());
				requestHistoryDto.setDeskNo(seatRequest.get(i).getSeat().getColumn().getColumnName() + ""
						+ seatRequest.get(i).getSeat().getSeatNumber());
				requestHistoryDto.setEmailId(seatRequest.get(i).getEmployee().getEmailId());
				requestHistoryDto.setRequestFor(seatRequest.get(i).getBookingDate());
				requestHistoryDto.setSeatRequestId(seatRequest.get(i).getSeat().getId());
				requestHistoryDto.setRequestDate(seatRequest.get(i).getCreatedDate());
				requestHistoryDto.setFloorNo(seatRequest.get(i).getSeat().getColumn().getFloor().getId());
				requestHistoryDto.setStatus(seatRequest.get(i).getRequestStatus());
				requestHistoryDto.setEmployeeId(seatRequest.get(i).getEmployee().getId());
				requestHistoryDto.setReason(seatRequest.get(i).getReason());
				list.add(requestHistoryDto);
			}
			return list;
		}

		List<SeatRequest> seatRequest = this.seatRequestRepo.findSeatRequestBySeatAndRequestStatus(
				new SeatNumber(seatConfiguration.getSeatNumber().getId()), pageble, requestStatus);

		List<RequestHistoryDto> list = new ArrayList<>();
		for (int i = 0; i < seatRequest.size(); i++) {

			RequestHistoryDto requestHistoryDto = new RequestHistoryDto();
			requestHistoryDto.setName(seatRequest.get(i).getEmployee().getFirstName() + " "
					+ seatRequest.get(i).getEmployee().getLastName());
			requestHistoryDto.setDeskNo(seatRequest.get(i).getSeat().getColumn().getColumnName() + ""
					+ seatRequest.get(i).getSeat().getSeatNumber());
			requestHistoryDto.setEmailId(seatRequest.get(i).getEmployee().getEmailId());
			requestHistoryDto.setRequestFor(seatRequest.get(i).getBookingDate());
			requestHistoryDto.setSeatRequestId(seatRequest.get(i).getSeat().getId());
			requestHistoryDto.setRequestDate(seatRequest.get(i).getCreatedDate());
			requestHistoryDto.setFloorNo(seatRequest.get(i).getSeat().getColumn().getFloor().getId());
			requestHistoryDto.setStatus(seatRequest.get(i).getRequestStatus());
			requestHistoryDto.setEmployeeId(seatRequest.get(i).getEmployee().getId());
			requestHistoryDto.setReason(seatRequest.get(i).getReason());
			list.add(requestHistoryDto);
		}
		return list;
	}

	@Override
	public List<RequestHistoryDto> searchByFirstNameOrLastName(String employeeId,String name, Pageable pageable) {
		
	Employee employee = employeeRepo.findById(employeeId).orElse(null);
		
		if(employee.getModeOfWork()!=null && employee.getModeOfWork().getId() == 2 ) {
			 return Collections.emptyList();
		}
		
		if (name.length() < 2) {

			throw new IllegalArgumentException("Please enter at least two characters.");
		}

		List<SeatRequest> seatRequest = this.seatRequestRepo.getByFirstNameOrLastName(name, name, pageable);

		if (seatRequest.isEmpty()) {
			throw new ResourceNotFoundException("Resource not found.");
		}

		List<RequestHistoryDto> list = new ArrayList<>();
		for (int i = 0; i < seatRequest.size(); i++) {

			RequestHistoryDto requestHistoryDto = new RequestHistoryDto();
			requestHistoryDto.setName(seatRequest.get(i).getEmployee().getFirstName() + " "
					+ seatRequest.get(i).getEmployee().getLastName());
			requestHistoryDto.setDeskNo(seatRequest.get(i).getSeat().getColumn().getColumnName() + ""
					+ seatRequest.get(i).getSeat().getSeatNumber());
			requestHistoryDto.setEmailId(seatRequest.get(i).getEmployee().getEmailId());
			requestHistoryDto.setRequestFor(seatRequest.get(i).getBookingDate());
			requestHistoryDto.setRequestDate(seatRequest.get(i).getCreatedDate());
			requestHistoryDto.setSeatRequestId(seatRequest.get(i).getSeat().getId());
			requestHistoryDto.setFloorNo(seatRequest.get(i).getSeat().getColumn().getFloor().getId());
			requestHistoryDto.setEmployeeId(seatRequest.get(i).getEmployee().getId());
			requestHistoryDto.setStatus(seatRequest.get(i).getRequestStatus());

			list.add(requestHistoryDto);
		}
		return list;
	}
	
}