package com.magicroom.albumservice.service;

import com.magicroom.albumservice.dto.SongDTO;
import com.magicroom.albumservice.model.Song;
import com.magicroom.albumservice.repository.SongRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {
    private static final Logger logger = LoggerFactory.getLogger(SongService.class);
    @Autowired
    private SongRepo songRepo;

    public List<SongDTO> getSongListByAlbumId(int album_id) {
        List<Song> songList = songRepo.findByAlbumIdOrderByTrackIndexAsc(album_id);
        logger.info("Number of Songs in " + album_id + ": " + songList.size());
        if (songList.size() != 0) {
            return songList.stream().map(song -> new SongDTO()
                    .setId(song.getId())
                    .setName(song.getName())
                    .setComposer(song.getComposer())
                    .setLyricist(song.getLyricist())
                    .setProducer(song.getProducer())
                    .setTrackIndex(song.getTrackIndex())
                    .setFeaturingArtist(song.getFeaturingArtist())
                    .setIsTitle(song.getIsTitle())
                    .setBugsSongId(song.getBugsSongId())
            ).toList();
        }
        return null;
    }
}
