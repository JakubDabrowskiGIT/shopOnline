package com.shop.online.controller;

import com.shop.online.model.Item;
import com.shop.online.model.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Set;

@RestController
@RequestMapping("backend")
@CrossOrigin("*")
@RequiredArgsConstructor
public class ShopController {

    private final ItemService itemService;

    @GetMapping
    public Set<Item> getAll() {
        Item item1 = new Item("Golarka", "OneBlade", 200.5);
        Item item2 = new Item("Iphone", "12 pro", 5000);
        Item item3 = new Item("Dell", "XPS 13", 7900);
        itemService.save(Arrays.asList(item1, item2, item3));
        return itemService.getAll();
    }
}
