package com.example.adayazilim.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CustomException  extends RuntimeException{

    public CustomException(String message){
        super(message);

    }
}
