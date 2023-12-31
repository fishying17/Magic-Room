package com.magicroom.albumservice.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
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
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    int id;
    String name;
    LocalDate releaseDate;
    String type;
    String genre;
    String coverCode;
    String artistName;
}
