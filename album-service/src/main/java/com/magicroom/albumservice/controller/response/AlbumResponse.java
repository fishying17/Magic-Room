package com.magicroom.albumservice.controller.response;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class AlbumResponse {
    String name;
    LocalDate release_date;
    String type;
    String genre;
    String cover_code;
    String artist_name;
}
