package com.example.ApiProject.Dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class AppointementDto {
   
	private Long id;

    // private Long contryId;

    // private Long cityId;

    // private Long  municipaliityId;

    // private Long categoryId

    private Long hospitalId;
    
    private Long patientId;
    
    private Long specialityId;
    
    private Date date; 
    


}
