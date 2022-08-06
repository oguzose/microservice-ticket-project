package com.ozkaraca.ticketproject.service;

import com.ozkaraca.ticketproject.model.Ticket;

public interface TicketNotificationService {

    void sendToQueue(Ticket ticket);

}
