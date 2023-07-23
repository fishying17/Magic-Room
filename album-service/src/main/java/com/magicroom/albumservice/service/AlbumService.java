package com.magicroom.albumservice.service;

import com.magicroom.albumservice.dto.AlbumDTO;
import com.magicroom.albumservice.model.Album;
import com.magicroom.albumservice.repository.AlbumRepo;
import com.magicroom.albumservice.repository.ArtistRepo;
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

    @Autowired
    private ArtistService artistService;

    public List<AlbumDTO> fetchAlbumList()
    {
        List<Album> albumList = albumRepo.findAll();
        if (albumList.size() != 0) {
            return albumList.stream().map(album -> {
                        return new AlbumDTO()
                                .setName(album.getName())
                                .setRelease_date(album.getRelease_date())
                                .setType(album.getType())
                                .setGenre(album.getGenre())
                                .setCover_code(album.getCover_code())
                                .setArtist_name(artistService.getArtistById(album.getArtist_id()).getName());
                    }
                        ).toList()
                    ;
        }
        return null;
    }


}
