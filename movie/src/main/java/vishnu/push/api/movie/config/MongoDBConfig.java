package vishnu.push.api.movie.config;

import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.stereotype.Component;

@Component

public class MongoDBConfig {
    private final MongoDatabaseFactory mongo;

    public MongoDBConfig(MongoDatabaseFactory mongo) {
        this.mongo = mongo;
    }
}


