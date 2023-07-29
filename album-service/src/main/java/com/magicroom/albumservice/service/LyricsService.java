package com.magicroom.albumservice.service;

import com.magicroom.albumservice.dto.LyricsDTO;
import com.magicroom.albumservice.model.Lyrics;
import com.magicroom.albumservice.repository.LyricsRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LyricsService {
    private static final Logger logger = LoggerFactory.getLogger(LyricsService.class);
    @Autowired
    private LyricsRepo lyricsRepo;

    public List<LyricsDTO> getLyricsListBySongId(int song_id) {
        List<Lyrics> lyricsList = lyricsRepo.findBySongId(song_id);
        logger.info("Number of Lyrics in " + song_id + ": " + lyricsList.size());
        if (lyricsList.size() != 0) {
            return lyricsList.stream().map(lyrics -> new LyricsDTO()
                    .setContent(lyrics.getContent())
                    .setLang(lyrics.getLang())
                    .setDefaultFlag(lyrics.getDefaultFlag())
            ).toList();
        }
        return null;
    }
}
