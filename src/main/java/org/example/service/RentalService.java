package org.example.service;

import org.example.dto.Rental;

public interface RentalService {
    void saveRental(Rental rental);
    Rental getRentalById(Integer id);
    boolean updateRental(Rental rental);
    boolean deleteRentalById(Integer id);
}
