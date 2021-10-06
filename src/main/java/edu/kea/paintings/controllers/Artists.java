package edu.kea.paintings.controllers;

import edu.kea.paintings.models.Artist;
import edu.kea.paintings.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Artists {

    @Autowired
    ArtistRepository artists;

    @GetMapping("/artists")
        public Iterable<Artist> getArtists(){
            return artists.findAll();
    }
    @GetMapping("/artists/{id}")
        public Artist getArtistById(@PathVariable Long id){
            return artists.findById(id).get();
    }
    @PostMapping("/artists")
        public Artist addArtist(@RequestBody Artist newArtist) {
        return artists.save(newArtist);
    }

    @PutMapping("/artists/{id}")
        public String updateArtistsById(@PathVariable Long id, @RequestBody Artist artistToUpdateWith){
        if(artists.existsById(id)){
            artistToUpdateWith.setId(id);
            artists.save(artistToUpdateWith);
            return "artist was found";
        }else{
            return "artist was not found";
        }

    }

    @PatchMapping("/artists/{id}")
        public String patchArtistById(@PathVariable Long id, @RequestBody Artist artistToBeUpdatedWith){
            return artists.findById(id).map(foundArtist -> {
                if(artistToBeUpdatedWith.getName() != null)foundArtist.setName(artistToBeUpdatedWith.getName());
                if(artistToBeUpdatedWith.getAge() != 0)foundArtist.setAge(artistToBeUpdatedWith.getAge());
                if(artistToBeUpdatedWith.getNationality() != null)foundArtist.setNationality(artistToBeUpdatedWith.getNationality());
                if(artistToBeUpdatedWith.getPrimaryStyle() != null)foundArtist.setPrimaryStyle(artistToBeUpdatedWith.getPrimaryStyle());
                if(artistToBeUpdatedWith.getDate() != null) foundArtist.setDate(artistToBeUpdatedWith.getDate());
                if(artistToBeUpdatedWith.getGender() != null)foundArtist.setGender(artistToBeUpdatedWith.getGender());

                artists.save(foundArtist);
                return "Artist updated";
            }).orElse("Not Found");
    }

    @DeleteMapping("/artists/{id}")
        public void deleteArtistsById(@PathVariable long id){
        artists.deleteById(id);

    }
}
