package vishnu.push.api.movie.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "imdb")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Imdb {
    @Id
    private String Iid;
    private Integer id;
    private Float rating;
    private Integer votes;
}