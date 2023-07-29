package com.magicroom.albumservice.repository;

import com.magicroom.albumservice.model.Lyrics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LyricsRepo extends JpaRepository<Lyrics, Integer> {
    List<Lyrics> findBySongId(int song_id);
}
