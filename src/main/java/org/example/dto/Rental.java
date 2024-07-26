package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Rental {
    private Integer id;
    private LocalDate rentalDate;
    private LocalDate returndate;
    private LocalDate dueDate;
    private double totalCost;
    private List<Integer> itemIdList;
    private Integer customerId;
}
