package vishnu.push.api.movie.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "viewer")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Viewer {

    private double rating;
    private int numReviews;
    private int meter;

}
