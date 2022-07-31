package com.ozkaraca.ticketproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketDto {

    private String id;

    private String description;

    private String notes;

    private String assignee;

    private LocalDate ticketDate;

    private String priorityType;

    private String ticketStatus;
}
