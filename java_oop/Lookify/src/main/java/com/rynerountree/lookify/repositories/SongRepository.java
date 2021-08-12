package com.rynerountree.lookify.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rynerountree.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
    // this method retrieves all the songs from the database
    List<Song> findAll();
    List<Song> findByArtistContainsAllIgnoreCase(String search);
	Optional<Song> findById(Long id);
	void deleteById(Long id);
	List<Song> findTop10ByOrderByRatingDesc();
}
