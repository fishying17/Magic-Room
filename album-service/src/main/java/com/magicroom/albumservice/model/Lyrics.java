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
public class Lyrics {
    @Id
    @GeneratedValue
    private Integer id;
    private String content;
    private String lang;
    private Boolean defaultFlag;
    private int songId;


}
