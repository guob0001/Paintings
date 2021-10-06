package edu.kea.paintings.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.kea.paintings.models.Artist;
import edu.kea.paintings.models.Painting;
import edu.kea.paintings.repositories.PaintingRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@Api(value= "Painting controller", description= "REST APIs for the painting class")
@RestController
public class Paintings {
    @Autowired
    PaintingRepository paintings;

    //private ArrayList<Painting> paintings = new ArrayList<Painting>();

    //@ApiOperation(value= "This method is used to get list of paintings.", hidden = true)
    @GetMapping("/paintings")
        public Iterable<Painting> getPaintings(){
            return paintings.findAll();
    }
    @GetMapping("/paintings/{id}")
    public Painting getAPaintingById(@PathVariable Long id){
        return paintings.findById(id).get();
    }
    //GET /paintings/1

    //request body = payload Annotationen for at få fat i bodyen (headers of body)
    //I JSON {
    //    "artist": "kurt",
    //    "price": 2000.00,
    //    "title": "xuxo",
    //    "genre": "abstract",
    //    "year": 2020
    //
    //
    //}
    //@ApiOperation()
    @PostMapping("/paintings")
    public Painting addPainting(@RequestBody Painting newPainting){
        return paintings.save(newPainting);
    }
    @PutMapping("/paintings/{id}")
        public String addPainting(@PathVariable Long id, @RequestBody Painting paintingToUpdateWith){
        if(paintings.existsById(id)){
            paintingToUpdateWith.setId(id);
            paintings.save(paintingToUpdateWith);
            return "painting updated";
        }else{
            return "artist not updated";
        }
    }
    /*@PutMapping("/paintings/{id}")
        public Painting updatePaintingById(@PathVariable int id, @RequestBody Painting newPainting){
            return paintings.set(id, newPainting);
    }*/
    @PatchMapping("/paintings/{id}")
    public String patchPaintingById(@PathVariable Long id, @RequestBody Painting paintingToBeUpdatedWith){
        return paintings.findById(id).map(foundPainting -> {
            if(paintingToBeUpdatedWith.getArtist() != null)foundPainting.setArtist(paintingToBeUpdatedWith.getArtist());
            if(paintingToBeUpdatedWith.getPrice() != 0)paintingToBeUpdatedWith.setPrice(paintingToBeUpdatedWith.getPrice());
            if(paintingToBeUpdatedWith.getTitle() != null)foundPainting.setTitle(paintingToBeUpdatedWith.getTitle());
            if(paintingToBeUpdatedWith.getGenre() != null)foundPainting.setGenre(paintingToBeUpdatedWith.getGenre());
            if(paintingToBeUpdatedWith.getYear() != 0) foundPainting.setYear(paintingToBeUpdatedWith.getYear());

            paintings.save(foundPainting);
            return "Painting updated";
        }).orElse("Not Found");
    }

    @DeleteMapping("paintings/{id}")
        public void deletePaintingById(@PathVariable Long id){
        paintings.deleteById(id);
    }

}
