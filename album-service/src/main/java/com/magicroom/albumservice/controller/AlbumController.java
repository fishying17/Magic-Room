package com.magicroom.albumservice.controller;

import com.magicroom.albumservice.controller.response.AlbumResponse;
import com.magicroom.albumservice.controller.response.ArtistResponse;
import com.magicroom.albumservice.controller.response.SongResponse;
import com.magicroom.albumservice.dto.AlbumDTO;
import com.magicroom.albumservice.dto.ArtistDTO;
import com.magicroom.albumservice.dto.SongDTO;
import com.magicroom.albumservice.service.AlbumService;
import com.magicroom.albumservice.service.ArtistService;
import com.magicroom.albumservice.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AlbumController {
    @Autowired
    private ArtistService artistService;

    @Autowired
    private AlbumService albumService;

    @Autowired
    private SongService songService;

    @GetMapping("/artist/{id}")
    private ResponseEntity<ArtistResponse> getArtistDetails(@PathVariable("id") int id) {
        ArtistDTO artistDTO = artistService.getArtistById(id);
        if (artistDTO != null ) {
            ArtistResponse artistResponse = new ArtistResponse()
                    .setName(artistDTO.getName())
                    .setDebutDate(artistDTO.getDebutDate());
            return ResponseEntity.status(HttpStatus.OK).body(artistResponse);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping("/album")
    private ResponseEntity<List<AlbumResponse>> getAllAlbum() {
        List<AlbumDTO> albumDTOList = albumService.fetchAlbumList();
        if (albumDTOList != null ) {
            List<AlbumResponse> albumResponseList = new ArrayList<>();
            for (AlbumDTO albumDTO : albumDTOList) {
                ArtistDTO artistDTO = artistService.getArtistById(albumDTO.getArtistId());
                if (artistDTO != null) {
                    String artistName = artistDTO.getName();
                    AlbumResponse albumResponse = new AlbumResponse()
                                    .setId(albumDTO.getId())
                                    .setName(albumDTO.getName())
                                    .setReleaseDate(albumDTO.getReleaseDate())
                                    .setType(albumDTO.getType())
                                    .setGenre(albumDTO.getGenre())
                                    .setCoverCode(albumDTO.getCoverCode())
                                    .setArtistName(artistName);
                    albumResponseList.add(albumResponse);
                }
            }
            return ResponseEntity.status(HttpStatus.OK).body(albumResponseList);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping("/song/list/{album_id}")
    private ResponseEntity<List<SongResponse>> getSongListByAlbumId(@PathVariable("album_id") int album_id) {
        List<SongDTO> songDTOList = songService.getSongListByAlbumId(album_id);
        if (songDTOList != null) {
            List<SongResponse> songResponseList = songDTOList.stream().map(songDTO -> new SongResponse()
                    .setId(songDTO.getId())
                    .setName(songDTO.getName())
                    .setComposer(songDTO.getComposer())
                    .setLyricist(songDTO.getLyricist())
                    .setProducer(songDTO.getProducer())
                    .setTrackIndex(songDTO.getTrackIndex())
                    .setFeaturingArtist(songDTO.getFeaturingArtist())
                    .setIsTitle(songDTO.getIsTitle())
                    .setBugsSongId(songDTO.getBugsSongId())
            ).toList();
            return ResponseEntity.status(HttpStatus.OK).body(songResponseList);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
