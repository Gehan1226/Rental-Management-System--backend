package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Customer;
import org.example.dto.Item;
import org.example.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/save")
    ResponseEntity<String> saveCustomer(@RequestBody Item item){
        itemService.saveItem(item);
        return ResponseEntity.ok().body("Item Saved!");
    }

    @GetMapping("/get-all")
    ResponseEntity<List<Item>> getAllItems(){
        return  ResponseEntity.ok().body(itemService.getAllItems());
    }

}
