package com.sp.accountservice.api;

import com.sp.accountservice.service.HesapService;
import com.sp.client.contract.HesapDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*

HesapDTO service-common modulunden alinmaktadir.
pom.xmlde tanimlidir.

 */

@RestController
@RequestMapping("/hesap")
public class HesapApi {

    private final HesapService hesapService;


    public HesapApi(HesapService hesapService) {
        this.hesapService = hesapService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HesapDTO> get(@PathVariable("id") String id) {
        return ResponseEntity.ok(hesapService.get(id));
    }
    @GetMapping
    public ResponseEntity<Slice<HesapDTO>> getAll(Pageable pageable){
        return ResponseEntity.ok(hesapService.getAll(pageable));
    }
    @PostMapping
    public ResponseEntity<HesapDTO> save(HesapDTO hesap) {
        return ResponseEntity.ok(hesapService.save(hesap));
    }
    @PutMapping
    public ResponseEntity<HesapDTO> update(@RequestBody HesapDTO hesap) {
        return ResponseEntity.ok(hesapService.update(hesap.getId(),hesap));
    }
    @DeleteMapping
    public void delete(String id) {
        hesapService.delete(id);
    }


}
