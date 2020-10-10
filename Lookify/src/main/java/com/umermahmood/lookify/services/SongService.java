package com.umermahmood.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.umermahmood.lookify.models.Song;
import com.umermahmood.lookify.repositories.SongRepository;

// Designates class as a Service
@Service
public class SongService {
	// Attributes
	private final SongRepository songRepo; // Dependency injection

	// Constructors
	public SongService(SongRepository songRepo) {
		this.songRepo = songRepo;

	}

	// Methods
	public List<Song> allSongs() {
		return songRepo.findAll();

	}

	// * from songs where
	public List<Song> songsContainingArtist(String artist) {
		return songRepo.findByArtistContaining(artist);

	}

	// * from songs sortby rating desc limit 10
	public List<Song> topTenSongs() {
		return songRepo.findTop10ByOrderByRatingDesc();

	}

	// * from songs where id
	public Song findSong(Long id) {
		Optional<Song> optionalSong = songRepo.findById(id);
		if (optionalSong.isPresent()) {
			return optionalSong.get();
		} else {
			return null;
		}
	}

	public Song createSong(Song song) {
		return songRepo.save(song);

	}

	public void deleteSong(Long id) {
		Optional<Song> optionalSong = songRepo.findById(id);
		if (optionalSong.isPresent()) {
			songRepo.deleteById(id);
		}
	}
}
