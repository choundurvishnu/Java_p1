package vishnu.push.api.movie.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import vishnu.push.api.movie.model.Imdb;

@Repository
public interface ImdbRepository extends MongoRepository<Imdb,String> {
}
