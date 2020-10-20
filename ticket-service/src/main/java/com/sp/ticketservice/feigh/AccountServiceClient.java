package com.sp.ticketservice.feigh;

import com.sp.client.contract.HesapDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("account-service")
public interface AccountServiceClient{

    @RequestMapping("/hesap/{id}")
    ResponseEntity<HesapDTO> get(@PathVariable("id") String id);

}

