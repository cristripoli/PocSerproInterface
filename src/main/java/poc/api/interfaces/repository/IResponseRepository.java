package poc.api.interfaces.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import poc.api.interfaces.entities.serpro.Response;

public interface IResponseRepository extends MongoRepository<Response, String> {
}
