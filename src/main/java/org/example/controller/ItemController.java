package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Item;
import org.example.service.ItemService;
import org.springframework.http.HttpStatus;
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
    ResponseEntity<String> saveItem(@RequestBody Item item){
        itemService.saveItem(item);
        return ResponseEntity.ok().body("Item Saved!");
    }

    @GetMapping("/get-all")
    ResponseEntity<List<Item>> getAllItems(){
        return  ResponseEntity.ok().body(itemService.getAllItems());
    }

    @GetMapping("/get-by-id/{id}")
    ResponseEntity<Item> getItemById(@PathVariable Integer id){
        return ResponseEntity.ok().body(itemService.getItemById(id));
    }

    @PutMapping("/update")
    ResponseEntity<String> updateItem(@RequestBody Item item){
        boolean result = itemService.updateItem(item);
        if (result){
            return ResponseEntity.ok().body("Item Update Successfully!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item Not Found!");
    }

    @DeleteMapping("/delete-by-id/{id}")
    ResponseEntity<String> deleteItemById(@PathVariable Integer id){
        boolean result = itemService.deleteItemById(id);
        if (result){
            return ResponseEntity.ok().body("Item Delete Successfully!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item Not Found!");
    }


}
