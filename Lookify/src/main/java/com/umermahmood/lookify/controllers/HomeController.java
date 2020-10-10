package com.umermahmood.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.umermahmood.lookify.models.Song;
import com.umermahmood.lookify.services.SongService;

@Controller // Assigns class as controller
public class HomeController {
	// Attributes
	private final SongService songService; // dependency injection

	// Constructors
	public HomeController(SongService songService) {
		this.songService = songService;

	}

	// Methods
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "/lookify/index.jsp";
	}

	// GET route
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String dashboard(Model model) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "/lookify/dashboard.jsp";
	}

	// GET route for Top 10
	@RequestMapping(value = "/search/topTen", method = RequestMethod.GET)
	public String topTen(Model model) {
		List<Song> songs = songService.topTenSongs();
		model.addAttribute("songs", songs);
		return "/lookify/topTen.jsp";
	}

	// GET route show for song by id
	@RequestMapping(value = "/songs/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") Long id, Model model) {
		Song song = songService.findSong(id);
		model.addAttribute("song", song);
		return "/lookify/show.jsp";
	}

	// GET route for new song
	@RequestMapping(value = "/songs/new", method = RequestMethod.GET)
	// @ModelAttribute initiate a blank model
	public String newSong(@ModelAttribute("song") Song song) {
		return "/lookify/new.jsp";
	}

	// GET route for search by artist
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(@RequestParam("artist") String artist, Model model) {
		List<Song> songs = songService.songsContainingArtist(artist);
		model.addAttribute("artist", artist);
		model.addAttribute("songs", songs);

		return "/lookify/searchResults.jsp";
	}

	// POST routes
	@RequestMapping(value = "/songs/new", method = RequestMethod.POST)
	public String createSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if (result.hasErrors()) {
			return "/lookify/new.jsp";
		} else {
			songService.createSong(song);
			return "redirect:/dashboard";
		}
	}

	// DELETE route by id
	@RequestMapping(value = "/songs/{id}", method = RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/dashboard";
	}

}
