package com.netcracker.barkun.web.controller;

import com.netcracker.barkun.web.dto.catalog.OfferDto;
import com.netcracker.barkun.web.dto.inventory.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class ProcessorController {

    private final RestTemplate restTemplate;

    private final String catalogUrl;

    private final String inventoryUrl;

    private final String customerManagementUrl;

    @Autowired
    public ProcessorController(RestTemplate restTemplate, @Value("${catalog.url}") String catalogUrl,
                               @Value("${inventory.url}") String inventoryUrl,
                               @Value("${customer-management.url}") String customerManagementUrl) {
        this.restTemplate = restTemplate;
        this.catalogUrl = catalogUrl;
        this.inventoryUrl = inventoryUrl;
        this.customerManagementUrl = customerManagementUrl;
    }

    @PostMapping
    public OrderDto createOrder(@RequestBody OfferDto offerDto){

        UriComponentsBuilder catalogComponentBuilder = UriComponentsBuilder.fromHttpUrl(catalogUrl).queryParam("offerDto" , OfferDto.class);
        System.out.println("sdfsd");
        return null;
    }
}
