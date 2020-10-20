package com.sp.ticketservice.dto;

import com.sp.ticketservice.model.PriorityType;
import com.sp.ticketservice.model.TicketStatus;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Data
public class TicketDTO {

    private String id;
    private String description;
    private String notes;
    private String assignee;
    private Date ticketDate;
    private String priorityType;
    private String ticketStatus;

}
