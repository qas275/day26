package vttp2022.day26.day26.controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import vttp2022.day26.day26.repositories.TVShowRepo;
import vttp2022.day26.model.Show;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ShowController {
    
    @Autowired
    private TVShowRepo showRepo;


    @GetMapping (path = "/genres")
    public ResponseEntity<String> showGenres(){
        List<String> genres = showRepo.findGenres();
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        for(String s: genres){
            arrayBuilder.add(s);
        }
        JsonArray arr = arrayBuilder.build();

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(arr.toString());
    }

    @GetMapping (path = "/tvshow/{genre}")
    public ResponseEntity<String> showGenreShows(@PathVariable String genre){
        List<Document> showsByGenre = showRepo.findShowsByGenre(genre);
        List<Show> shows = Show.createShow(showsByGenre);
        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        for (Show s: shows){
            arrBuilder.add(s.toJSON());
        }
        JsonArray arr = arrBuilder.build();

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(arr.toString());
    }



}
