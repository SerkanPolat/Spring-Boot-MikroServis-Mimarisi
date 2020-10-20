package com.sp.ticketservice.service;

import com.sp.ticketservice.dto.TicketDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TicketService {
    TicketDTO save(TicketDTO ticketDTO);
    TicketDTO update(String id, TicketDTO ticketDTO);
    TicketDTO getById(String id);
    Page<TicketDTO> getPagination(Pageable page);
    TicketDTO getAll();

}
