package edu.kea.paintings.controllers;

import edu.kea.paintings.models.Gallery;
import edu.kea.paintings.repositories.GalleryRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

//
//@Api annotation on our Controller class to describe our API.
//@ApiIgnore
@RestController
@Api(value="Gallery", description="CRUD methods")
public class Galleries {

    @Autowired
    GalleryRepository galleries;

    @GetMapping("/galleries")
    public Iterable<Gallery> getGalleries() {
        return galleries.findAll();
    }

    @GetMapping("/galleries{id}")
    public Gallery getGallery(@PathVariable Long id) {
        return galleries.findById(id).get();
    }

   /* @ApiOperation(value = "Create a new Gallery", response = Gallery.class)
    @ApiResponse(value = {
            @ApiResponse(code = 201, message = "Gallery created."),
            @ApiResponse(code = 401, message = "buller1")
    })*/

   @PostMapping("/galleries")
        public Gallery addGallery(@RequestBody Gallery newGallery){
            return galleries.save(newGallery);
   }

   @DeleteMapping("/galleries/{id}")
        public void deleteGalleryById(@PathVariable Long id){
        galleries.deleteById(id);
   }


}
