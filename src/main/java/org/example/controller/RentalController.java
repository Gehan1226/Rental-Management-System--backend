package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Item;
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
    ResponseEntity<String> saveItem(@RequestBody Rental rental){
        rentalService.saveRental(rental);
        return ResponseEntity.ok().body("Rental Saved!");
    }
}
