package vishnu.push.api.movie.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "awards")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Awards {
    @Id
    private String id;

    private String text;

    private Integer wins;

    private Integer nominations;
}
