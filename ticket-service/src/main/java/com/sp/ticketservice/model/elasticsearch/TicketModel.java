package com.sp.ticketservice.model.elasticsearch;

import com.sp.ticketservice.model.PriorityType;
import com.sp.ticketservice.model.TicketStatus;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@EqualsAndHashCode(of={"id"})
@Document(indexName = "ticket")

public class TicketModel implements Serializable {

    @Id
    private String id;
    private String description;
    private String notes;
    private String assignee;
    private Date ticketDate;
    private String priorityType;
    private String ticketStatus;


}
