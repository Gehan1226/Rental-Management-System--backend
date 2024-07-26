package org.example.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.dto.Customer;
import org.example.dto.Item;
import org.example.entity.ItemEntity;
import org.example.repository.ItemRepository;
import org.example.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ObjectMapper objectMapper;

    @Override
    public void saveItem(Item item) {
        itemRepository.save(objectMapper.convertValue(item, ItemEntity.class));
    }

    @Override
    public List<Item> getAllItems() {
        List<Item> itemList = new ArrayList<>();
        Iterable<ItemEntity> all = itemRepository.findAll();

        all.forEach(itemEntity -> itemList.add(objectMapper.convertValue(itemEntity, Item.class)));
        return itemList;
    }

    @Override
    public Item getItemById(Integer id) {
        return objectMapper.convertValue(itemRepository.findById(id), Item.class);
    }
}
