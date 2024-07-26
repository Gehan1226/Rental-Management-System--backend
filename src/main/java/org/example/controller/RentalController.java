package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Rental;
import org.example.service.RentalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/rentals")
public class RentalController {

    private final RentalService rentalService;

    @PostMapping("/save")
    ResponseEntity<String> saveRental(@RequestBody Rental rental){
        rentalService.saveRental(rental);
        return ResponseEntity.ok().body("Rental Saved!");
    }

    @GetMapping("/get-all")
    ResponseEntity<List<Rental>> getAllRentals(){
        return  ResponseEntity.ok().body(rentalService.getAllRentals());
    }

    @GetMapping("/get-by-id/{id}")
    ResponseEntity<Rental> getRentalById(@PathVariable Integer id){
        return ResponseEntity.ok().body(rentalService.getRentalById(id));
    }

    @PutMapping("/update")
    ResponseEntity<String> updateItem(@RequestBody Rental rental){
        boolean result = rentalService.updateRental(rental);
        if (result){
            return ResponseEntity.ok().body("Rental Update Successfully!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rental Not Found!");
    }

    @DeleteMapping("/delete-by-id/{id}")
    ResponseEntity<String> deleteItemById(@PathVariable Integer id){
        boolean result = rentalService.deleteRentalById(id);
        if (result){
            return ResponseEntity.ok().body("Rental Delete Successfully!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rental Not Found!");
    }

}
