package com.sp.accountservice.entity;


import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString
@Table
@Getter
@Setter
public class Hesap implements Serializable{
    @PrimaryKey
    private String id = UUID.randomUUID().toString();
    @Column(value = "kulad")
    private String kullaniciAd;
    @Column(value = "ad")
    private String ad;
    @Column(value = "yas")
    private float yas;
    @Column(value = "email")
    private String email;
    @Column(value = "sifre")
    private String sifre;
    @Column(value = "aktifmi")
    private Boolean aktif;
}