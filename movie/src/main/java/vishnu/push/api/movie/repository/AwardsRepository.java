package vishnu.push.api.movie.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import vishnu.push.api.movie.model.Awards;

@Repository
public interface AwardsRepository extends MongoRepository<Awards,String> {
}
