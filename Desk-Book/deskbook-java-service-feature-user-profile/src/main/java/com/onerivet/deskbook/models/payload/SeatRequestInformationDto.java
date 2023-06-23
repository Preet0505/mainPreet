package com.onerivet.deskbook.models.payload;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeatRequestInformationDto {
	
	private Integer seatId;
	
	private String reason;
	
	private LocalDate bookingDate;

}
