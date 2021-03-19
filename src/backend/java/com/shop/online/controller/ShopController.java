package com.shop.online.controller;

import com.shop.online.model.Item;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("backend")
@CrossOrigin("*")
public class ShopController {

    @GetMapping
    public List<Item> getAll() {
        Item item1 = new Item("Golarka", 200.5);
        Item item2 = new Item("Golarka", 200.5);
        Item item3 = new Item("Golarka", 200.5);
        return Arrays.asList(item1, item2, item3);
    }
}
