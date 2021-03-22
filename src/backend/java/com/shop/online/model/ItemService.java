package com.shop.online.model;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public void deleteById(Integer id) {
        itemRepository.deleteById(id);
    }

    public Item getById(int id){
        return itemRepository.getOne(id);
    }

    public Set<Item> getAll() {
        return new HashSet<>(itemRepository.findAll());
    }

    public void save(List<Item> itemList) {
        itemRepository.saveAll(itemList);
    }

}
