package com.shop.online.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Item {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @NonNull
    private String title;

    @Column(columnDefinition="LONGTEXT")
    @NonNull
    private String description;

    @NonNull
    private double price;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime updateDate = LocalDateTime.now();

    //1:19
}
