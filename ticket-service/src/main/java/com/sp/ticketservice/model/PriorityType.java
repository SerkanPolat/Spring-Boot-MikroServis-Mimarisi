package com.sp.ticketservice.model;

import lombok.Getter;

@Getter
public enum PriorityType {
    HIGH("Yuksek Oncelik"),
    URGENT("Acil"),
    LOW("Onemsiz");

    private String label;
    PriorityType(String label){
        this.label = label;
    }
}
