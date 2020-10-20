package com.sp.ticketservice.model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public abstract class BaseEntityModel implements Serializable {
    @CreatedDate
    @Column(name="olusturmatarihi")
    private Date olusturmaTarihi;
    @Column(name = "guncellemetarihi")
    private Date guncellemeTarihi;

}
