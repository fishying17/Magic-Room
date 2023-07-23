package com.magicroom.albumservice.model;

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
@Entity
public class Album extends BaseModel{
    String name;
    int artist_id;
    LocalDate release_date;
    String type;
    String genre;
    String cover_code;
}
