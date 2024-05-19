package vishnu.push.api.movie.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "citric")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Critic {
    private double rating;
    private int numReviews;
    private int meter;

}
