package com.magicroom.albumservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class LyricsDTO {
    private Integer id;
    private String content;
    private String lang;
    private Boolean defaultFlag;
    private int songId;
}
