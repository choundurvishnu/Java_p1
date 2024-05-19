package vishnu.push.api.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vishnu.push.api.movie.model.Imdb;
import vishnu.push.api.movie.service.ImdbService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies/imdb")

public class ImdbController {
    @Autowired
    private ImdbService imdbService;

    @Autowired

    @GetMapping
    public ResponseEntity<List<Imdb>> getAllImdb() {
        return new ResponseEntity<List<Imdb>>(imdbService.allImdb(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Imdb> createImdb(@RequestBody Imdb imdb) {
        Imdb createimdb = imdbService.addImdb(imdb);
        return new ResponseEntity<Imdb>(createimdb, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Imdb> updateImdb(@RequestBody Imdb newimdb) {
        Imdb updateimdb = imdbService.updateImdb(newimdb);
        //if (updateimdb != null) {
        return new ResponseEntity<Imdb>(updateimdb, HttpStatus.OK);
        //}else { return new ResponseEntity<Imdb>(HttpStatus.NOT_FOUND);}
    }



    //@DeleteMapping
    //public ResponseEntity<Imdb> deleteImdb(@RequestBody Imdb imdb) {

    //}

}




