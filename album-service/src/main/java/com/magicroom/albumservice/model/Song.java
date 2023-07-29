package com.magicroom.albumservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
public class Song {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String composer;
    private String lyricist;
    private String producer;
    private int trackIndex;
    private String featuringArtist;
    private Boolean isTitle;
    private String bugsSongId;
    private int albumId;

}
