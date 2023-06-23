package com.onerivet.deskbook.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.onerivet.deskbook.exception.ResourceNotFoundException;
import com.onerivet.deskbook.models.entity.ColumnDetails;
import com.onerivet.deskbook.models.entity.Employee;
import com.onerivet.deskbook.models.entity.Floor;
import com.onerivet.deskbook.models.entity.SeatConfiguration;
import com.onerivet.deskbook.models.entity.SeatNumber;
import com.onerivet.deskbook.models.entity.SeatRequest;
import com.onerivet.deskbook.models.payload.RequestHistoryDto;
import com.onerivet.deskbook.repository.EmployeeRepo;
import com.onerivet.deskbook.repository.SeatConfigurationRepo;
import com.onerivet.deskbook.repository.SeatRequestRepo;

@ExtendWith(MockitoExtension.class)
public class RequestHistoryServiceImplTest {

    @Mock
    private SeatRequestRepo seatRequestRepo;

    @Mock
    private SeatConfigurationRepo seatConfigurationRepo;

    @Mock
    private EmployeeRepo employeeRepo;

    @InjectMocks
    private RequestHistoryServiceImpl requestHistoryService;

  
    @Test
    public void testGetRequestHistory_AllRequests() {
        // Mock data
    	String employeeId = "037c1ed8-452b-4332-ba77-bbe2286ebf6a";
        Pageable pageable = PageRequest.of(0, 10);
        Integer requestStatus = null;

        SeatConfiguration seatConfiguration = new SeatConfiguration();
        seatConfiguration.setSeatNumber(new SeatNumber(1));

        SeatRequest seatRequest = new SeatRequest();
        seatRequest.setEmployee(new Employee());
        seatRequest.getEmployee().setFirstName("John");
        seatRequest.getEmployee().setLastName("Doe");
        seatRequest.getEmployee().setEmailId("johndoe@gmail.com");
        seatRequest.setSeat(new SeatNumber(1));
        seatRequest.getSeat().setColumn(new ColumnDetails());
        seatRequest.getSeat().getColumn().setColumnName("A");
        seatRequest.getSeat().getColumn().setFloor(new Floor());
        seatRequest.getSeat().getColumn().getFloor().setId(1);
        seatRequest.getSeat().setSeatNumber(1);
        seatRequest.setRequestStatus(1);
        seatRequest.setReason("Reason");

        List<SeatRequest> seatRequestList = Collections.singletonList(seatRequest);

        // Mock method calls
        employeeRepo = mock(EmployeeRepo.class);
        seatConfigurationRepo = mock(SeatConfigurationRepo.class);
        seatRequestRepo = mock(SeatRequestRepo.class);
        
        requestHistoryService = new RequestHistoryServiceImpl(seatRequestRepo, seatConfigurationRepo, employeeRepo);

        when(employeeRepo.findById(employeeId)).thenReturn(Optional.of(new Employee()));
        when(seatConfigurationRepo.findByEmployeeAndDeletedByNull(any(Employee.class))).thenReturn(seatConfiguration);
        when(seatRequestRepo.findSeatRequestBySeat(any(SeatNumber.class), any(Pageable.class))).thenReturn(seatRequestList);

        // Perform the method call
        List<RequestHistoryDto> result = requestHistoryService.getRequestHistory(employeeId, pageable, requestStatus);

        // Assertions
        assertEquals(1, result.size());
        RequestHistoryDto requestHistoryDto = result.get(0);
        assertEquals("John Doe", requestHistoryDto.getName());
        assertEquals("A1", requestHistoryDto.getDeskNo());
        assertEquals("johndoe@gmail.com", requestHistoryDto.getEmailId());
        assertEquals("Reason", requestHistoryDto.getReason());
        // Add more assertions for other fields
    }
    

    @Test
    public void testGetRequestHistory_WithRequestStatus() {
        // Mock data
        String employeeId = "037c1ed8-452b-4332-ba77-bbe2286ebf6a";
        Pageable pageable = PageRequest.of(0, 10);
        Integer requestStatus = 1;

        SeatConfiguration seatConfiguration = new SeatConfiguration();
        seatConfiguration.setSeatNumber(new SeatNumber(1));

        SeatRequest seatRequest = new SeatRequest();
        seatRequest.setEmployee(new Employee());
        seatRequest.getEmployee().setFirstName("John");
        seatRequest.getEmployee().setLastName("Doe");
        seatRequest.getEmployee().setEmailId("johndoe@gmail.com");
        seatRequest.setSeat(new SeatNumber(1));
        seatRequest.getSeat().setColumn(new ColumnDetails());
        seatRequest.getSeat().getColumn().setColumnName("A");
        seatRequest.getSeat().getColumn().setFloor(new Floor());
        seatRequest.getSeat().getColumn().getFloor().setId(1);
        seatRequest.getSeat().setSeatNumber(1);
        seatRequest.setRequestStatus(1);
        seatRequest.setReason("Reason");

        List<SeatRequest> seatRequestList = Collections.singletonList(seatRequest);

        // Mock method calls
        when(employeeRepo.findById(employeeId)).thenReturn(Optional.of(new Employee()));
        when(seatConfigurationRepo.findByEmployeeAndDeletedByNull(any(Employee.class))).thenReturn(seatConfiguration);
        when(seatRequestRepo.findSeatRequestBySeatAndRequestStatus(any(SeatNumber.class), any(Pageable.class), anyInt())).thenReturn(seatRequestList);

        // Perform the method call
        List<RequestHistoryDto> result = requestHistoryService.getRequestHistory(employeeId, pageable, requestStatus);

        // Assertions
        assertEquals(1, result.size());
        RequestHistoryDto requestHistoryDto = result.get(0);
        assertEquals("John Doe", requestHistoryDto.getName());
        assertEquals("A1", requestHistoryDto.getDeskNo());
        assertEquals("johndoe@gmail.com", requestHistoryDto.getEmailId());
        assertEquals("Reason", requestHistoryDto.getReason());
        // Add more assertions for other fields
    }
    

    @Test
    public void testSearchByFirstNameOrLastName() {
        // Mock data
        String employeeId = "037c1ed8-452b-4332-ba77-bbe2286ebf6a";
        Pageable pageable = PageRequest.of(0, 10);
        String name = "John";

        SeatRequest seatRequest = new SeatRequest();
        seatRequest.setEmployee(new Employee());
        seatRequest.getEmployee().setFirstName("John");
        seatRequest.getEmployee().setLastName("Doe");
        seatRequest.getEmployee().setEmailId("johndoe@gmail.com");
        seatRequest.setSeat(new SeatNumber(1));
        seatRequest.getSeat().setColumn(new ColumnDetails());
        seatRequest.getSeat().getColumn().setColumnName("A");
        seatRequest.getSeat().getColumn().setFloor(new Floor());
        seatRequest.getSeat().getColumn().getFloor().setId(1);
        seatRequest.getSeat().setSeatNumber(1);
        seatRequest.setRequestStatus(1);

        List<SeatRequest> seatRequestList = Collections.singletonList(seatRequest);

        // Mock method calls
        when(employeeRepo.findById(employeeId)).thenReturn(Optional.of(new Employee()));
        when(seatRequestRepo.getByFirstNameOrLastName(name, name, pageable)).thenReturn(seatRequestList);

        // Perform the method call
        List<RequestHistoryDto> result = requestHistoryService.searchByFirstNameOrLastName(employeeId, name, pageable);

        // Assertions
        assertEquals(1, result.size());
        RequestHistoryDto requestHistoryDto = result.get(0);
        assertEquals("John Doe", requestHistoryDto.getName());
        assertEquals("A1", requestHistoryDto.getDeskNo());
        assertEquals("johndoe@gmail.com", requestHistoryDto.getEmailId());
        assertEquals(1, requestHistoryDto.getStatus());
        // Add more assertions for other fields
    }

    @Test
    public void testSearchByFirstNameOrLastName_ResourceNotFound() {
        // Mock data
        String employeeId = "037c1ed8-452b-4332-ba77-bbe2286ebf6a";
        Pageable pageable = PageRequest.of(0, 10);
        String name = "John";

        // Mock method calls
        when(employeeRepo.findById(employeeId)).thenReturn(Optional.of(new Employee()));
        when(seatRequestRepo.getByFirstNameOrLastName(name, name, pageable)).thenReturn(Collections.emptyList());

        // Perform the method call and assert the exception
        assertThrows(ResourceNotFoundException.class, () -> {
            requestHistoryService.searchByFirstNameOrLastName(employeeId, name, pageable);
        });
    }
}
