package com.devsuperior.dsmeta.controllers;


import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.service.SaleService;
import com.devsuperior.dsmeta.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/sales" )
public class SaleController {

    @Autowired
    private SaleService service;

    @Autowired
    private SmsService smsService;

    @GetMapping
    public Page<Sale> findSales(
            @RequestParam (value = "minDate", defaultValue = "") String minDate,
            @RequestParam (value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable){

        return service.findSales(minDate, maxDate, pageable);
    }

    @GetMapping("/{id}/notification")
    public void notifySms(@PathVariable long id){
        smsService.sendSms(id);

    }

}