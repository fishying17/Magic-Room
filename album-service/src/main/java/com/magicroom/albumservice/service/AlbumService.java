package com.magicroom.albumservice.service;

import com.magicroom.albumservice.dto.AlbumDTO;
import com.magicroom.albumservice.model.Album;
import com.magicroom.albumservice.repository.AlbumRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AlbumService {
    private static final Logger logger = LoggerFactory.getLogger(AlbumService.class);
    @Autowired
    private AlbumRepo albumRepo;

    public List<AlbumDTO> fetchAlbumList()
    {
        List<Album> albumList = albumRepo.findAll();
        if (albumList.size() != 0) {
            return albumList.stream().map(album -> new AlbumDTO()
                            .setId(album.getId())
                            .setName(album.getName())
                            .setReleaseDate(album.getReleaseDate())
                            .setType(album.getType())
                            .setGenre(album.getGenre())
                            .setCoverCode(album.getCoverCode())
                            .setArtistId(album.getArtistId())
                        ).toList();
        }
        return null;
    }


}
