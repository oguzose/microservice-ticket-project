package com.ozkaraca.ticketproject.model.es;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "ticket")
public class TicketModel implements Serializable {

    @Id
    private String id;

    private String description;

    private String notes;

    private String assignee;

    private LocalDate ticketDate;

    private String priorityType;

    private String ticketStatus;
}
