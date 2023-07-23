package com.magicroom.albumservice.controller;

import com.magicroom.albumservice.controller.response.AlbumResponse;
import com.magicroom.albumservice.controller.response.ArtistResponse;
import com.magicroom.albumservice.dto.AlbumDTO;
import com.magicroom.albumservice.dto.ArtistDTO;
import com.magicroom.albumservice.service.AlbumService;
import com.magicroom.albumservice.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AlbumController {
    @Autowired
    private ArtistService artistService;

    @Autowired
    private AlbumService albumService;
    @GetMapping("/artist/{id}")
    private ResponseEntity<ArtistResponse> getArtistDetails(@PathVariable("id") int id) {
        ArtistDTO artistDTO = artistService.getArtistById(id);
        if (artistDTO != null ) {
            ArtistResponse artistResponse = new ArtistResponse()
                    .setName(artistDTO.getName())
                    .setDebut_date(artistDTO.getDebut_date());
            return ResponseEntity.status(HttpStatus.OK).body(artistResponse);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping("/album")
    private ResponseEntity<List<AlbumResponse>> getAllAlbum() {
        List<AlbumDTO> albumDTOList = albumService.fetchAlbumList();
        if (albumDTOList != null ) {
            List<AlbumResponse> albumResponseList = albumDTOList.stream().map(albumDTO -> new AlbumResponse()
                    .setName(albumDTO.getName())
                    .setRelease_date(albumDTO.getRelease_date())
                    .setType(albumDTO.getType())
                    .setGenre(albumDTO.getGenre())
                    .setCover_code(albumDTO.getCover_code())
                    .setArtist_name(albumDTO.getArtist_name())
            ).toList();
            return ResponseEntity.status(HttpStatus.OK).body(albumResponseList);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }


}
