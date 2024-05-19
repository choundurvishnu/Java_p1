package vishnu.push.api.movie.service;
/*
*         *   * * *
* *       *  *      *
*   *     *  *      *
*     *   *  *      *
*       * *  *      *
*         *    * * *        */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import vishnu.push.api.movie.model.Awards;
import vishnu.push.api.movie.repository.AwardsRepository;

import java.util.List;
import java.util.Optional;


@Service
public class AwardsService {
    @Autowired
    private AwardsRepository awardsRepository;

    @GetMapping("/awards")
    public List<Awards> allAwards()
    {
        return awardsRepository.findAll();
    }

    public Awards addAward(Awards awards) {
        return awardsRepository.save(awards);
    }

    public Awards updateAwards(Awards newawards) {
        Optional<Awards> awardsOptional = awardsRepository.findById(newawards.getId());
        if (awardsOptional.isPresent()) {
            Awards awards = awardsOptional.get();
            awards.setWins(newawards.getWins());
            awards.setText(newawards.getText());
            awards.setNominations(newawards.getNominations());
            return awardsRepository.save(awards);
            //awards.setWins(awards.getWins() + newawards.getWins());
        }
        else{
            return null;
        }

    }
}

/*
Optional<Imdb> imdb = imdbRepository.findById(String.valueOf(newimdb.getId()));
        if (imdb.isPresent()) {
            Imdb oldimdb = imdb.get();
            oldimdb.setId(imdb.get().getId());
            oldimdb.setVotes(imdb.get().getVotes());
            oldimdb.setRating(imdb.get().getRating());
            return imdbRepository.save(newimdb);
        }
 */


