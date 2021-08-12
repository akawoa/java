package com.rynerountree.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rynerountree.lookify.models.Song;
import com.rynerountree.lookify.repositories.SongRepository;

@Service
public class SongService {
	private final SongRepository songRepository;

	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}

	// returns all the songs
	public List<Song> allSongs() {
		return songRepository.findAll();
	}

	// creates a song
	public Song createSong(Song s) {
		return songRepository.save(s);
	}

	// retrieves a song
	public Song findSong(Long id) {
		Optional<Song> optionalSong = songRepository.findById(id);
		if (optionalSong.isPresent()) {
			return optionalSong.get();
		} else {
			return null;
		}
	}
	
	//retrieves top ten songs list by rating
	public List<Song> topTen() {
		return songRepository.findTop10ByOrderByRatingDesc();
	}
	
	//retrieves all songs by an artist in a list
	public List<Song> discography(String search) {
		return songRepository.findByArtistContainsAllIgnoreCase(search);
	}

	// deletes a song
	public void deleteSong(Long id) {
		songRepository.deleteById(id);
	}

	// edits a song
	public Song updateSong(Song s) {
		return songRepository.save(s);
	}

	public Optional<Song> updateSong(Long id, String title, String artist, Integer rating) {
		Optional<Song> temp = songRepository.findById(id);
		if (songRepository.findById(id).isPresent()) {
			Song existingSong = songRepository.findById(id).get();

			existingSong.setTitle(title);
			existingSong.setArtist(artist);
			existingSong.setRating(rating);

			Song updatedSong = songRepository.save(existingSong);

			return songRepository.findById(updatedSong.getId());

		}
		return null;
	}
}
