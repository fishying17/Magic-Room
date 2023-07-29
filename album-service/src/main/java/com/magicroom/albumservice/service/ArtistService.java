package com.magicroom.albumservice.service;

import com.magicroom.albumservice.dto.ArtistDTO;
import com.magicroom.albumservice.model.Artist;
import com.magicroom.albumservice.repository.ArtistRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArtistService {
    private static final Logger logger = LoggerFactory.getLogger(ArtistService.class);
    @Autowired
    private ArtistRepo artistRepo;

    public ArtistDTO getArtistById(int id) {

        Optional<Artist> artist = artistRepo.findById(id);
        ArtistDTO artistDTO = null;
        logger.info("id: " + id);
        logger.info("artist.isPresent()): " + artist.isPresent());
        if (artist.isPresent()) {
            artistDTO = new ArtistDTO()
                    .setName(artist.get().getName())
                    .setDebutDate(artist.get().getDebutDate());
        }

//        // Using FeignClient
//        ResponseEntity<AddressResponse> addressResponse = addressClient.getAddressByEmployeeId(id);
//        employeeResponse.setAddressResponse(addressResponse.getBody());

        return artistDTO;
    }
}
