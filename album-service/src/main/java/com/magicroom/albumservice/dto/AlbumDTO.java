package com.magicroom.albumservice.dto;

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
        private int id;
        private String name;
        private LocalDate releaseDate;
        private String type;
        private String genre;
        private String coverCode;
        private int artistId;
}
