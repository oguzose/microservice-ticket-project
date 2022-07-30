package com.ozkaraca.ticketproject.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AccountDto {

    private String id ;

    private String username;

    private String name;

    private String surname;

    private String email;

    private LocalDate birthDate;
}

