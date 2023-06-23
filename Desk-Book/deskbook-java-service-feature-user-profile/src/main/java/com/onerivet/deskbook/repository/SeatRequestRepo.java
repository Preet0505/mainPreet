package com.onerivet.deskbook.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.onerivet.deskbook.models.entity.Employee;
import com.onerivet.deskbook.models.entity.SeatNumber;
import com.onerivet.deskbook.models.entity.SeatRequest;

public interface SeatRequestRepo extends JpaRepository<SeatRequest, Integer>{

//	@Query("SELECT s FROM SeatRequest s ORDER BY s.bookingDate DESC")
//	List<SeatRequest> getRequestHistoryByEmployee(Employee employee,Pageable pageable);
	
//	@Query("SELECT r FROM SeatRequest r WHERE r.RequestStatus IN (1 , 2 , 3) ORDER BY r.bookingDate DESC")
//	public List<SeatRequest> findByRequestStatus(Employee employee,Pageable pageable,Integer status);

	@Query(value = "SELECT sr FROM SeatRequest sr WHERE  sr.seatId =:seatId ORDER BY sr.bookingDate DESC")
    public List<SeatRequest> findSeatRequestBySeatId(SeatNumber seatId,Pageable pageable);
	
	@Query(value = "SELECT sr FROM SeatRequest sr WHERE  sr.seatId =:seatId AND sr.requestStatus=:requestStatus ORDER BY sr.bookingDate DESC")
    public List<SeatRequest> findSeatRequestBySeatIdAndRequestStatus(SeatNumber seatId,Pageable pageable, int requestStatus);
	
	@Query(value = "SELECT sr FROM SeatRequest sr LEFT JOIN sr.employee e WHERE e.firstName LIKE CONCAT(:firstName, '%') OR e.lastName LIKE CONCATE(:lastName, '%'")
	public List<SeatRequest> getByFirstNameAndLastName(@Param("firstName")String firstName,@Param("lastName")String lastName,Pageable pageable);
	
}
