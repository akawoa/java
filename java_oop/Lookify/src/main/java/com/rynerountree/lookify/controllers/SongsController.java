package com.rynerountree.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rynerountree.lookify.models.Song;
import com.rynerountree.lookify.services.SongService;

@Controller
public class SongsController {
    private final SongService songService;
    
    public SongsController(SongService songService) {
        this.songService = songService;
    }
    
    @RequestMapping("/")
    public String index() {
        return "/songs/home.jsp";
    }
    
    @RequestMapping("/songs")
    public String index(Model model) {
        List<Song> songs = songService.allSongs();
        model.addAttribute("songs", songs);
        model.addAttribute("song", new Song());
        return "/songs/index.jsp";
    }
    
    @RequestMapping("/songs/topten")
    public String topTen(Model model) {
        List<Song> songs = songService.topTen();
        model.addAttribute("songs", songs);
        model.addAttribute("song", new Song());
        return "/songs/topTen.jsp";
    }
    
    @RequestMapping("/songs/{id}")
    public String show(Model model,@PathVariable("id") Long id) {
    	Song song = songService.findSong(id);
        model.addAttribute("song", song);
        return "/songs/show.jsp";
    }
    
    @RequestMapping("/songs/new")
    public String newSong(@ModelAttribute("song") Song song) {
        return "/songs/new.jsp";
    }
    
    @RequestMapping(value="/songs/process", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
        if (result.hasErrors()) {
            return "/songs/index.jsp";
        } else {
        	songService.createSong(song);
            return "redirect:/songs";
        }
    }
    
    @RequestMapping("/songs/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
    	Song song = songService.findSong(id);
        model.addAttribute("song", song);
        return "/songs/edit.jsp";
    }
    
   
    @RequestMapping(value="/songs/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("song") Song song, BindingResult result) {
        if (result.hasErrors()) {
            return "/songs/edit.jsp";
        } else {
        	songService.updateSong(song);
            return "redirect:/songs";
        }
    }
    
    @RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
    	songService.deleteSong(id);
        return "redirect:/songs";
    }
    
  //delete
  	//post from edit-language
  	@RequestMapping(value="songs/delete/{id}")
  	public String deleteSong(@PathVariable("id") Long id) {
  		//delete by ID
  		songService.deleteSong(id);
  		//return to dashboard
  		return "redirect:/songs";
  	}
}
