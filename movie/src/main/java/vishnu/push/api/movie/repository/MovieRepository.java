package vishnu.push.api.movie.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import vishnu.push.api.movie.model.Movie;

import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {  //String
    //Optional<Movie> findById(ObjectId id);
}
