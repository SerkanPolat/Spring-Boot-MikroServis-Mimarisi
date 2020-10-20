package com.sp.ticketservice.service;


import com.sp.ticketservice.model.Ticket;

public interface TicketNotificationService {
    void sendToQueue(Ticket ticket);
}
