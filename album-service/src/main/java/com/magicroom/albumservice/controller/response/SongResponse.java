package com.magicroom.albumservice.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class SongResponse {
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    int id;
    private String name;
    private String composer;
    private String lyricist;
    private String producer;
    private int trackIndex;
    private String featuringArtist;
    private Boolean isTitle;
    private String bugsSongId;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String albumId;
}
