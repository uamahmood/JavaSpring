package com.umermahmood.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.umermahmood.lookify.models.Song;


// Class as repo
@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
	// Method overrides
	@Override
	List<Song> findAll(); // return list of songs

	List<Song> findByArtistContaining(String search); // find artist based on certain criteria

	List<Song> findTop10ByOrderByRatingDesc(); // query top 10 by rating

}
