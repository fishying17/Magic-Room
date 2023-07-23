package com.magicroom.albumservice.dto;

import com.magicroom.albumservice.model.BaseModel;
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
public class AlbumDTO {
        String name;
        LocalDate release_date;
        String type;
        String genre;
        String cover_code;
        String artist_name;
}
