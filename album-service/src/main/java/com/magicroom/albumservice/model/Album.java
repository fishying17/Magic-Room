package com.magicroom.albumservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
public class Album{
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private int artistId;
    private LocalDate releaseDate;
    private String type;
    private String genre;
    private String coverCode;
}
