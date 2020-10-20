package com.sp.client.contract;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HesapDTO {


    private String id;
    private String kullaniciAd;
    private String ad;
    private int yas;
    private String email;
    public String getAdMail(){
        return this.ad+" "+email;
    }

}
