package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Controller
@RequiredArgsConstructor
public class AddressController {

    final AddressRepository addressRepository;

    @GetMapping("/address/{zip}")
    public ResponseEntity<Mono<Address>> user(@PathVariable("zip") final String zip) {
        return ResponseEntity.ok(addressRepository.findById(zip));

    }

    @MessageMapping("addresses")
    public Flux<Address> addresses() {
        return addressRepository.findAll().delayElements(Duration.ofSeconds(1));
    }
}
