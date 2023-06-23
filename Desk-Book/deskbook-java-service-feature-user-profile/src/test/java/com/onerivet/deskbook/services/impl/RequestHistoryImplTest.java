package com.onerivet.deskbook.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Pageable;

import com.onerivet.deskbook.exception.ResourceNotFoundException;
import com.onerivet.deskbook.models.entity.ColumnDetails;
import com.onerivet.deskbook.models.entity.Employee;
import com.onerivet.deskbook.models.entity.Floor;
import com.onerivet.deskbook.models.entity.SeatConfiguration;
import com.onerivet.deskbook.models.entity.SeatNumber;
import com.onerivet.deskbook.models.entity.SeatRequest;
import com.onerivet.deskbook.models.payload.RequestHistoryDto;
import com.onerivet.deskbook.repository.SeatConfigurationRepo;
import com.onerivet.deskbook.repository.SeatRequestRepo;

public class RequestHistoryImplTest {

    @Mock
    private SeatRequestRepo seatRequestRepo;

    @Mock
    private SeatConfigurationRepo seatConfigurationRepo;

    @Mock
    private Pageable pageable;

    @InjectMocks
    private RequestHistoryImpl requestHistoryService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetRequestHistory_AllRequests() {
        // Mock data
        String employeeId = "037c1ed8-452b-4332-ba77-bbe2286ebf6a";
        SeatConfiguration seatConfiguration = new SeatConfiguration();
        seatConfiguration.setSeatNumber(new SeatNumber());
        SeatRequest seatRequest = new SeatRequest();
        
        Employee employee = new Employee();
        employee.setFirstName("Gracy ");
        employee.setLastName("Patel");
        employee.setEmailId("harsh1@gmail.com");
        
        seatRequest.setEmployee(employee);
        seatRequest.setSeatId(new SeatNumber());
        seatRequest.getSeatId().setColumn(new ColumnDetails());
        seatRequest.getSeatId().getColumn().setColumnName("A");
        seatRequest.getSeatId().getColumn().setFloor(new Floor());
        seatRequest.getSeatId().getColumn().getFloor().setId(1);
        seatRequest.getSeatId().setSeatNumber(1);
        seatRequest.setRequestStatus(1);

        List<SeatRequest> seatRequestList = new ArrayList<>();
        seatRequestList.add(seatRequest);

        // Mock method calls
        when(seatConfigurationRepo.findByEmployeeAndDeletedByNull(any(Employee.class))).thenReturn(seatConfiguration);
        when(seatRequestRepo.findSeatRequestBySeatId(any(SeatNumber.class), any(Pageable.class))).thenReturn(seatRequestList);

        // Perform the method call
        List<RequestHistoryDto> result = requestHistoryService.getRequestHistory(employeeId, pageable, null);

        // Assertions
        assertEquals(1, result.size());
        RequestHistoryDto requestHistoryDto = result.get(0);
        assertEquals("Gracy Patel", requestHistoryDto.getName());
        assertEquals("A1", requestHistoryDto.getDeskNo());
        assertEquals("harsh1@gmail.com", requestHistoryDto.getEmailId());
        assertEquals(seatRequest.getBookingDate(), requestHistoryDto.getRequestFor());
        assertEquals(seatRequest.getCreatedDate(), requestHistoryDto.getRequestDate());
        assertEquals(1, requestHistoryDto.getFloorNo());
        assertEquals(seatRequest.getRequestStatus(), requestHistoryDto.getStatus());
    }

    @Test
    public void testGetRequestHistory_FilteredRequests() {
        // Mock data
        String employeeId = "037c1ed8-452b-4332-ba77-bbe2286ebf6a";
        SeatConfiguration seatConfiguration = new SeatConfiguration();
        seatConfiguration.setSeatNumber(new SeatNumber());
        SeatRequest seatRequest = new SeatRequest();
        
        Employee employee = new Employee();
        employee.setFirstName("Gracy ");
        employee.setLastName("Patel");
        employee.setEmailId("harsh1@gmail.com");
        
        seatRequest.setEmployee(employee);
        seatRequest.setSeatId(new SeatNumber());
        seatRequest.getSeatId().setColumn(new ColumnDetails());
        seatRequest.getSeatId().getColumn().setColumnName("A");
        seatRequest.getSeatId().getColumn().setFloor(new Floor());
        seatRequest.getSeatId().getColumn().getFloor().setId(1);
        seatRequest.getSeatId().setSeatNumber(1);;
        seatRequest.setRequestStatus(2);

        List<SeatRequest> seatRequestList = new ArrayList<>();
        seatRequestList.add(seatRequest);

        // Mock method calls
        when(seatConfigurationRepo.findByEmployeeAndDeletedByNull(any(Employee.class))).thenReturn(seatConfiguration);
        when(seatRequestRepo.findSeatRequestBySeatIdAndRequestStatus(any(SeatNumber.class), any(Pageable.class), anyInt())).thenReturn(seatRequestList);

        // Perform the method call
        List<RequestHistoryDto> result = requestHistoryService.getRequestHistory(employeeId, pageable, 2);

        // Assertions
        assertEquals(1, result.size());
        RequestHistoryDto requestHistoryDto = result.get(0);
        assertEquals("Gracy Patel", requestHistoryDto.getName());
        assertEquals("A1", requestHistoryDto.getDeskNo());
        assertEquals("harsh1@gmail.com", requestHistoryDto.getEmailId());
        assertEquals(seatRequest.getBookingDate(), requestHistoryDto.getRequestFor());
        assertEquals(seatRequest.getCreatedDate(), requestHistoryDto.getRequestDate());
        assertEquals(1, requestHistoryDto.getFloorNo());
        assertEquals(seatRequest.getRequestStatus(), requestHistoryDto.getStatus());
    }

    @Test
    public void testSearchByFirstNameOrLastName() {
        // Mock data
        String name = "Gracy";
        SeatRequest seatRequest = new SeatRequest();
        Employee employee = new Employee();
        employee.setFirstName("Gracy");
        employee.setLastName("Patel");
        employee.setEmailId("harsh1@gmail.com");
        
        seatRequest.setEmployee(employee);
        seatRequest.setSeatId(new SeatNumber());
        seatRequest.getSeatId().setColumn(new ColumnDetails());
        seatRequest.getSeatId().getColumn().setColumnName("A");
        seatRequest.getSeatId().getColumn().setFloor(new Floor());
        seatRequest.getSeatId().getColumn().getFloor().setId(1);
        seatRequest.getSeatId().setSeatNumber(1);
        seatRequest.setRequestStatus(1);

        List<SeatRequest> seatRequestList = new ArrayList<>();
        seatRequestList.add(seatRequest);

        // Mock method calls
        when(seatRequestRepo.getByFirstNameAndLastName(anyString(), anyString(), any(Pageable.class))).thenReturn(seatRequestList);

        // Perform the method call
        List<RequestHistoryDto> result = requestHistoryService.searchByFirstNameOrLastName(name, pageable);

        // Assertions
        assertEquals(1, result.size());
        RequestHistoryDto requestHistoryDto = result.get(0);
        assertEquals("Gracy Patel", requestHistoryDto.getName());
        assertEquals("A1", requestHistoryDto.getDeskNo());
        assertEquals("harsh1@gmail.com", requestHistoryDto.getEmailId());
        assertEquals(seatRequest.getBookingDate(), requestHistoryDto.getRequestFor());
        assertEquals(seatRequest.getCreatedDate(), requestHistoryDto.getRequestDate());
        assertEquals(1, requestHistoryDto.getFloorNo());
        assertEquals(seatRequest.getRequestStatus(), requestHistoryDto.getStatus());
    }

    @Test
    public void testSearchByFirstNameOrLastName_InvalidName() {
        // Mock data
        String name = "J";

        // Perform the method call and assert that it throws an exception
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            requestHistoryService.searchByFirstNameOrLastName(name, pageable);
        });

        // Assertion
        assertEquals("Please enter at least three characters.", exception.getMessage());
    }

    @Test
    public void testSearchByFirstNameOrLastName_UserNotFound() {
        // Mock data
        String name = "John";
        List<SeatRequest> seatRequestList = new ArrayList<>();

        // Mock method calls
        when(seatRequestRepo.getByFirstNameAndLastName(anyString(), anyString(), any(Pageable.class))).thenReturn(seatRequestList);

        // Perform the method call and assert that it throws an exception
        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> {
            requestHistoryService.searchByFirstNameOrLastName(name, pageable);
        });

        // Assertion
        assertEquals("User not found.", exception.getMessage());
    }
}
