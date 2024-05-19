package vishnu.push.api.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vishnu.push.api.movie.model.Awards;
import vishnu.push.api.movie.service.AwardsService;


import java.util.List;

@RestController
@RequestMapping("/api/v1/movies/awards")

public class AwardsController {

    @Autowired
    private AwardsService awardsService;
    @Autowired

    @GetMapping
    public ResponseEntity<List<Awards>> getAllAwards(){
        return new ResponseEntity<List<Awards>>(awardsService.allAwards(), HttpStatus.OK);


    }

    @PostMapping
    public ResponseEntity<Awards> createAwards(@RequestBody Awards awards){
        Awards createawards = awardsService.addAward(awards);
        return new ResponseEntity<Awards>(createawards, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Awards> updateAwards(@RequestBody Awards newawards){
        Awards updateawards = awardsService.updateAwards(newawards);
        return new ResponseEntity<Awards>(updateawards, HttpStatus.OK);
    }
}
