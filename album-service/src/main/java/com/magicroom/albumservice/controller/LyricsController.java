package com.magicroom.albumservice.controller;

import com.magicroom.albumservice.controller.response.LyricsResponse;
import com.magicroom.albumservice.dto.LyricsDTO;
import com.magicroom.albumservice.service.LyricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LyricsController {
    @Autowired
    LyricsService lyricsService;

    @GetMapping("/lyrics/{song_id}")
    private ResponseEntity<List<LyricsResponse>> getLyricsBySongId(@PathVariable("song_id") int song_id) {
        List<LyricsDTO> lyricsDTOList = lyricsService.getLyricsListBySongId(song_id);
        if (lyricsDTOList != null ) {
            List<LyricsResponse> lyricsResponses = lyricsDTOList.stream().map(lyricsDTO -> new LyricsResponse()
                    .setContent(lyricsDTO.getContent())
                    .setLang(lyricsDTO.getLang())
                    .setDefaultFlag(lyricsDTO.getDefaultFlag())
            ).toList();
            return ResponseEntity.status(HttpStatus.OK).body(lyricsResponses);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
