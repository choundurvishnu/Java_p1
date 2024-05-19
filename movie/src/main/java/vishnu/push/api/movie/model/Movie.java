package vishnu.push.api.movie.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.net.URL;
import java.util.List;
import java.util.Map;

@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Movie {
    @Id
    private ObjectId id;

    private List<String> genres;

    private String runtime;

    private List<String> cast;

    private URL poster;

    private String title;

    private String fullplot;

    private List<String> languages;

    private String released;

    private List<String> directors;

    private String rated;

    private String lastupdated;

    //@DBRef
    //private Awards awards;
    private Map<String, Object> awards;

    private List<String> countries;

    private String type;

    //@DBRef
    //private Imdb imdb;
    private Map<String, Object> imdb;

    private String year;

    private Map<String, Object> tomatoes;

    private int num_mflix_comments;

   /*

   @DocumentReference
    private List<Awards> Awards;

    //private Imdb imdb;
    @DocumentReference
    private List<Imdb> imdb;

    private List<String> countries;

    private String type;

    //private Tomatoes tomatoes;
    @DocumentReference
    private List<Review> tomatoes;

    private int num_mflix_comments;
*/



}
