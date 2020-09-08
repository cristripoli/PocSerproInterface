package poc.api.interfaces.entities.serpro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Map;

@Document(collection = "responses")
@Data
@RequiredArgsConstructor
public class Response implements Serializable {

    @Id
    private String id;

    @NonNull
    private String body;
}
