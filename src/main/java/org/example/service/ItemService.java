package org.example.service;

import org.example.dto.Item;

import java.util.List;

public interface ItemService {
    void saveItem(Item item);

    List<Item> getAllItems();

    Item getItemById(Integer id);

    boolean updateItem(Item item);

    boolean deleteItemById(Integer id);
}
