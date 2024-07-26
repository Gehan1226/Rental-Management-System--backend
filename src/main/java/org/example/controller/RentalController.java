package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Rental;
import org.example.service.RentalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/rentals")
public class RentalController {

    private final RentalService rentalService;

    @PostMapping("/save")
    ResponseEntity<String> saveRental(@RequestBody Rental rental){
        System.out.println(rental.getRentalDate());
        rentalService.saveRental(rental);
        return ResponseEntity.ok().body("Rental Saved!");
    }
}
