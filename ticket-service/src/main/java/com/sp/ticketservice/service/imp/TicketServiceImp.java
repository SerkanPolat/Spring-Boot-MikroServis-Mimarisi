package com.sp.ticketservice.service.imp;

import com.sp.client.contract.HesapDTO;
import com.sp.ticketservice.dto.TicketDTO;
import com.sp.ticketservice.feigh.AccountServiceClient;
import com.sp.ticketservice.model.PriorityType;
import com.sp.ticketservice.model.Ticket;
import com.sp.ticketservice.model.TicketStatus;
import com.sp.ticketservice.model.elasticsearch.TicketModel;
import com.sp.ticketservice.repo.TicketRepository;
import com.sp.ticketservice.repo.elasticsearch.TicketElasticRepository;
import com.sp.ticketservice.service.TicketNotificationService;
import com.sp.ticketservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TicketServiceImp implements TicketService {

    private final TicketRepository ticketRepository;
    private final TicketNotificationService ticketNotificationService;
    private final TicketElasticRepository ticketElasticRepository;
    private final AccountServiceClient accountServiceClient;
    @Transactional
    @Override
    public TicketDTO save(TicketDTO ticketDTO) {
        Ticket ticket = new Ticket();

        ResponseEntity<HesapDTO> accountDtoResponseEntity = accountServiceClient.get(ticketDTO.getAssignee());
        /*
            Mysql veritabanina Bileti alan kisinin Id'si
            Elasticsearch veritabanina Ad ve mail bilgisi yazildi.
         */

        if(ticketDTO.getDescription()==null){
            throw new IllegalArgumentException("Description Bos");
        }
        ticket.setDescription(ticketDTO.getDescription());
        ticket.setNotes(ticketDTO.getNotes());
        ticket.setTicketDate(ticketDTO.getTicketDate());
        ticket.setPriorityType(PriorityType.valueOf(ticketDTO.getPriorityType()));
        ticket.setTicketStatus(TicketStatus.valueOf(ticketDTO.getTicketStatus()));
        ticket.setAssignee(accountDtoResponseEntity.getBody().getId());
        //MySql kayit
        ticket = ticketRepository.save(ticket);

        TicketModel ticketModel = TicketModel.builder()
                .description(ticket.getDescription())
                .assignee(accountDtoResponseEntity.getBody().getAdMail())
                .id(ticket.getId())
                .notes(ticket.getNotes())
                .ticketDate(ticket.getTicketDate())
                .priorityType(ticket.getPriorityType().getLabel())
                .ticketStatus(ticket.getTicketStatus().getLabel()).build();
        //Elasticsearch Kayit
        ticketElasticRepository.save(ticketModel);
        ticketDTO.setId(ticket.getId());

        ticketNotificationService.sendToQueue(ticket);
        return ticketDTO;
    }

    @Override
    public TicketDTO update(String id,TicketDTO ticketDTO) {
        return null;
    }

    @Override
    public TicketDTO getById(String id) {
        //Ticket ticket = ticketElasticRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        //return modelMapper.map(ticket,TicketDTO.class);
        return null;
    }

    @Override
    public Page<TicketDTO> getPagination(Pageable page) {
        return null;
    }

    @Override
    public TicketDTO getAll() {
        return null;
    }
}
