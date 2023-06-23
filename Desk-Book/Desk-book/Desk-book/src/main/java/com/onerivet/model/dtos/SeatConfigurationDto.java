package com.onerivet.model.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class SeatConfigurationDto {
	

	private int id;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="EmployeeId")
//	private EmployeeDto employee;
//
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "City")
//	private CityDto city;
//	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "Column")
//	private ColumnsDto columns;
//	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "Floor")
//	private FloorDto floor;
//	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn
//	private SeatNumberDto seatNumber;
}
