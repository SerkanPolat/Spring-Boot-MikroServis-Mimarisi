package com.sp.ticketservice.api;

import com.sp.ticketservice.dto.TicketDTO;
import com.sp.ticketservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/ticket")
@RestController
@RequiredArgsConstructor
public class TicketApi {

    private final TicketService ticketService;
    @GetMapping("/{id}")
    public ResponseEntity<TicketDTO> get(@PathVariable String id){
        return ResponseEntity.ok(ticketService.getById(id));
    }
    @PostMapping
    public ResponseEntity<TicketDTO> createTicket(TicketDTO ticketDTO){
        System.out.println("GELIYOR ");
        return ResponseEntity.ok(ticketService.save(ticketDTO));
    }
    @PostMapping("/update")
    public ResponseEntity<TicketDTO> updateTicket(String id,TicketDTO ticketDTO){
         return ResponseEntity.ok(ticketService.update(id, ticketDTO));
    }
    @PostMapping("/page")
    public ResponseEntity<Page<TicketDTO>> getAll(Pageable pageable){
        return ResponseEntity.ok(ticketService.getPagination(pageable));
    }
}
