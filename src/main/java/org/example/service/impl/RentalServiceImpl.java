package org.example.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.dto.Item;
import org.example.dto.Rental;
import org.example.entity.ItemEntity;
import org.example.entity.RentalEntity;
import org.example.repository.RentalRepository;
import org.example.service.RentalService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {

    private final RentalRepository rentalRepository;
    private final ObjectMapper objectMapper;

    @Override
    public void saveRental(Rental rental) {
       rentalRepository.save(objectMapper.convertValue(rental, RentalEntity.class));
    }

    @Override
    public Rental getRentalById(Integer id) {
        return objectMapper.convertValue(rentalRepository.findById(id), Rental.class);
    }

    @Override
    public boolean updateRental(Rental rental) {
        Optional<RentalEntity> byId = rentalRepository.findById(rental.getId());

        if (byId.isPresent()){
            RentalEntity existingEntity = byId.get();
            existingEntity.setDueDate(rental.getDueDate());
            existingEntity.setRentalDate(rental.getReturndate());
            existingEntity.setTotalCost(rental.getTotalCost());
            rentalRepository.save(existingEntity);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteRentalById(Integer id) {
        Optional<RentalEntity> byId = rentalRepository.findById(id);
        if (byId.isPresent()){
            rentalRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
