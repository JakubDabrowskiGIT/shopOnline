package com.shop.online.image;

import com.shop.online.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.springframework.util.MimeTypeUtils.IMAGE_GIF_VALUE;
import static org.springframework.util.MimeTypeUtils.IMAGE_JPEG_VALUE;
import static org.springframework.util.MimeTypeUtils.IMAGE_PNG_VALUE;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;

    public void delete(final Image image) {
        imageRepository.delete(image);
    }

    public void deleteById(UUID id) {
        imageRepository.deleteById(id);
    }

    public List<Image> getAll() {
        return new ArrayList<>(imageRepository.findAll());
    }

    public List<Image> getImageByItemId(Item item) {
        return imageRepository.findByItemId(item);
    }

    public void saveImageItem(Item item, MultipartFile file) {
        isFileEmpty(file);

        isImage(file);

        Map<String, String> metadata = extractMetadata(file);

        String filename = String.format("%s-%s", file.getOriginalFilename(), UUID.randomUUID());

        try {
            Image image = new Image();
            image.setItemId(item);
            image.setData(file.getBytes());
            image.setTitle(filename);
            imageRepository.save(image);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private Map<String, String> extractMetadata(MultipartFile file) {
        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));
        return metadata;
    }

    private void isImage(MultipartFile file) {
        if (!Arrays.asList(IMAGE_JPEG_VALUE, IMAGE_PNG_VALUE, IMAGE_GIF_VALUE).contains(file.getContentType())) {
            throw new IllegalStateException("File must be an image [" + file.getContentType() + "]");
        }
    }

    private void isFileEmpty(MultipartFile file) {
        if (file.isEmpty()) {
            throw new IllegalStateException("Cannot upload empty file [ " + file.getSize() + "]");
        }
    }
}
