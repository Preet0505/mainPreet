package com.onerivet.deskbook.repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.onerivet.deskbook.models.entity.Employee;
import com.onerivet.deskbook.models.entity.SeatNumber;
import com.onerivet.deskbook.models.entity.SeatRequest;

@ExtendWith(MockitoExtension.class)
class SeatRequestRepoTest {
	
	@Mock
	private SeatRequestRepo seatRequestRepo;
	

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testFindSeatRequestBySeatId() {
		
		SeatNumber seatId = new SeatNumber();
		seatId.setId(1);
		
		SeatRequest seatRequest = new SeatRequest();
		seatRequest.setId(0);
		
		List<SeatRequest> seatRequestList = new ArrayList<>();
		seatRequestList.add(seatRequest);
		
		Pageable pageable = (Pageable) PageRequest.of(0, 10);
		when(seatRequestRepo.findSeatRequestBySeatId(seatId, pageable)).thenReturn(seatRequestList);
		List<SeatRequest> result = seatRequestRepo.findSeatRequestBySeatId(seatId, pageable);
		System.out.println(result);
		assertEquals(seatRequestList, result);
		
	}

	@Test
	void testFindSeatRequestBySeatIdAndRequestStatus() {
		
		int requestStatus = 1;
		
		SeatNumber seatId = new SeatNumber();
		seatId.setId(1);
		
		SeatRequest seatRequest = new SeatRequest();
		seatRequest.setId(0);
		seatRequest.setRequestStatus(1);
		
		List<SeatRequest> seatRequestList = new ArrayList<>();
		seatRequestList.add(seatRequest);
		
		Pageable pageable = (Pageable) PageRequest.of(0, 10);
		when(seatRequestRepo.findSeatRequestBySeatIdAndRequestStatus(seatId, pageable, requestStatus)).thenReturn(seatRequestList);
		List<SeatRequest> result = seatRequestRepo.findSeatRequestBySeatIdAndRequestStatus(seatId, pageable, requestStatus);
		System.out.println(result);
		assertEquals(seatRequestList, result);
		
	}

	@Test
	void testGetByFirstNameAndLastName() {
		
		String firstName = "Preet";
		String lastName = "Patel";
		
		SeatRequest seatRequest = new SeatRequest();
		seatRequest.setEmployee(new Employee("Preet", "Patel"));
		seatRequest.setId(0);
		List<SeatRequest> seatRequestsList = new ArrayList<>();
		seatRequestsList.add(seatRequest);
		
		Pageable pageable = (Pageable) PageRequest.of(0, 10);
		when(seatRequestRepo.getByFirstNameAndLastName(firstName, lastName, pageable)).thenReturn(seatRequestsList);
		List<SeatRequest> result = seatRequestRepo.getByFirstNameAndLastName(firstName, lastName, pageable);
		System.out.println(result);
		System.out.println(seatRequestsList);
		assertEquals(seatRequestsList, result);
		
	}

}
