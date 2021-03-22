package com.shop.online.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public void save(final Item item) {
        itemRepository.save(item);
    }

    public void delete(final Item item) {
        itemRepository.delete(item);
    }

    public void deleteById(UUID id) {
        itemRepository.deleteById(id);
    }

    public Item getById(UUID id) {
        return itemRepository.getOne(id);
    }

    public Set<Item> getAll() {
        return new HashSet<>(itemRepository.findAll());
    }

    public void save(List<Item> itemList) {
        itemRepository.saveAll(itemList);
    }
}