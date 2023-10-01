package com.example.adayazilim.exceptions;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

public class CustomException  extends RuntimeException{


    public CustomException(String message){
        super(message);

    }




}
