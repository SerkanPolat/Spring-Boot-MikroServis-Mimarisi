package com.sp.ticketservice.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Table(name="ticket")
@Entity
@Getter
@Setter
@EqualsAndHashCode(of={"id"})
@NoArgsConstructor
@AllArgsConstructor
public class Ticket extends BaseEntityModel{

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id")
    private String id;
    @Column(name = "description")
    private String description;
    @Column(name = "notes")
    private String notes;
    @Column(name = "assignee")
    private String assignee;
    @Column(name = "ticketDate")
    private Date ticketDate;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "priorityType")
    private PriorityType priorityType;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "ticketStatus")
    private TicketStatus ticketStatus;


}
