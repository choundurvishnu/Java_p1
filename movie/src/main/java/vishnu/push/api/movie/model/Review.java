package vishnu.push.api.movie.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Review {
    //@DocumentReference
    @DBRef
    private List<Viewer> viewer;
    private int fresh;
    //@DocumentReference
    @DBRef
    private List<Critic> critic;
    private int rotten;
    private String lastUpdated;

}
