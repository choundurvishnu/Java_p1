package vishnu.push.api.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import vishnu.push.api.movie.model.Imdb;
import vishnu.push.api.movie.repository.ImdbRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ImdbService {

    @Autowired
    private ImdbRepository imdbRepository;

    @GetMapping("/imdb")
    public List<Imdb> allImdb() {
        return imdbRepository.findAll();
    }

    public Imdb addImdb(Imdb imdb) {
        return imdbRepository.save(imdb);
    }

    public Imdb updateImdb(Imdb newimdb) {
        Optional<Imdb> imdb = imdbRepository.findById(String.valueOf(newimdb.getId()));
        if (imdb.isPresent()) {
            Imdb oldimdb = imdb.get();
            oldimdb.setId(imdb.get().getId());
            oldimdb.setVotes(imdb.get().getVotes());
            oldimdb.setRating(imdb.get().getRating());
            return imdbRepository.save(newimdb);
        }
        else {
            return null;
        }
    }
}



