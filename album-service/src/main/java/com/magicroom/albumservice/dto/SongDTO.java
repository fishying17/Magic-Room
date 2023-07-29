package com.magicroom.albumservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class SongDTO {
    private int id;
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
