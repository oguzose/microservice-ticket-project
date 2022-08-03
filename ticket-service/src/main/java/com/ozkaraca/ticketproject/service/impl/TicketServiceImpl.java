package com.ozkaraca.ticketproject.service.impl;

import com.ozkaraca.ticketproject.client.AccountServiceClient;
import com.ozkaraca.ticketproject.contract.AccountDto;
import com.ozkaraca.ticketproject.dto.TicketDto;
import com.ozkaraca.ticketproject.model.PriorityType;
import com.ozkaraca.ticketproject.model.Ticket;
import com.ozkaraca.ticketproject.model.TicketStatus;
import com.ozkaraca.ticketproject.model.es.TicketModel;
import com.ozkaraca.ticketproject.repository.TicketRepository;
import com.ozkaraca.ticketproject.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    //private final TicketElasticRepository ticketElasticRepository;

    private final ModelMapper modelMapper;

    private final AccountServiceClient accountServiceClient;

    @Override
    @Transactional
    public TicketDto save(TicketDto ticketDto) {
        // Ticket Entity
        if (ticketDto.getDescription() == null)
            throw new IllegalArgumentException("Description bos olamaz");

        Ticket ticket = new Ticket();

        ResponseEntity<AccountDto> accountResponseEntity = accountServiceClient.get(ticketDto.getAssignee());
        accountResponseEntity.getBody().getNameSurname();

        ticket.setDescription(ticketDto.getDescription());
        ticket.setNotes(ticketDto.getNotes());
        ticket.setTicketDate(ticketDto.getTicketDate());
        ticket.setTicketStatus(TicketStatus.valueOf(ticketDto.getTicketStatus()));
        ticket.setPriorityType(PriorityType.valueOf(ticketDto.getPriorityType()));
        ticket.setAssignee(accountResponseEntity.getBody().getId());

        // mysql kaydet
        ticket = ticketRepository.save(ticket);

        // TicketModel nesnesi yarat
        TicketModel ticketEsModel = TicketModel.builder()
                .description(ticket.getDescription())
                .notes(ticket.getNotes())
                .id(ticket.getId())
                .priorityType(ticket.getPriorityType().getLabel())
                .ticketStatus(ticket.getTicketStatus().getLabel())
                .assignee(accountResponseEntity.getBody().getNameSurname())
                .ticketDate(ticket.getTicketDate()).build();

        // elastic kaydet
        //ticketElasticRepository.save(ticketEsModel);

        // olusan nesneyi döndür
        ticketDto.setId(ticket.getId());

        // Kuyruga notification yaz
        //ticketNotificationService.sendToQueue(ticket);
        return ticketDto;
    }

    @Override
    public TicketDto update(String id, TicketDto ticketDto) {
        return null;
    }

    @Override
    public TicketDto getById(String ticketId) {
        return null;
    }

    @Override
    public Page<TicketDto> getPagination(Pageable pageable) {
        return null;
    }
}
