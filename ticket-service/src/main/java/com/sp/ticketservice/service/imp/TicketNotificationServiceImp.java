package com.sp.ticketservice.service.imp;

import com.sp.messaging.contract.TicketNotification;
import com.sp.ticketservice.model.Ticket;
import com.sp.ticketservice.service.TicketNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Source.class)
@RequiredArgsConstructor
public class TicketNotificationServiceImp implements TicketNotificationService {
    private final Source source;
    @Override
    public void sendToQueue(Ticket ticket) {
        TicketNotification ticketNotification = new TicketNotification();
        ticketNotification.setAccountId(ticket.getAssignee());
        ticketNotification.setTicketId(ticket.getId());
        ticketNotification.setTicketDescription(ticket.getDescription());

        source.output().send(MessageBuilder.withPayload(ticketNotification).build());

    }
}