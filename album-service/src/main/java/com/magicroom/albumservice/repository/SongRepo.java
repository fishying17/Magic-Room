package com.magicroom.albumservice.repository;

import com.magicroom.albumservice.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepo extends JpaRepository<Song, Integer> {
    List<Song> findByAlbumIdOrderByTrackIndexAsc(int album_id);
}
