package org.example.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.dto.Rental;
import org.example.entity.RentalEntity;
import org.example.repository.RentalRepository;
import org.example.service.RentalService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {

    private final RentalRepository rentalRepository;
    private final ObjectMapper objectMapper;

    @Override
    public void saveRental(Rental rental) {
        rentalRepository.save(objectMapper.convertValue(rental, RentalEntity.class));
    }
}
