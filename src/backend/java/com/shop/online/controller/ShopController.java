package com.shop.online.controller;

import com.shop.online.image.ImageService;
import com.shop.online.item.Item;
import com.shop.online.item.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("backend")
@CrossOrigin("*")
@RequiredArgsConstructor
public class ShopController {

    private final ItemService itemService;
    private final ImageService imageService;

    @GetMapping
    public Set<Item> getAll() {
        Item item1 = new Item("Golarka", "OneBlade", 200.5);
        Item item2 = new Item("Iphone", "12 pro", 5000);
        Item item3 = new Item("Dell", "XPS 13", 7900);
        itemService.save(Arrays.asList(item1, item2, item3));
        return itemService.getAll();
    }

    @PostMapping(path = "{id}/image/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void uploadUserProfileImage(@PathVariable("id") String id, @RequestParam("file") MultipartFile file) {
        Item currItem = itemService.getById(UUID.fromString(id));
        imageService.saveImageItem(currItem, file);
        System.out.println(id + " file: " + file);
    }
}
