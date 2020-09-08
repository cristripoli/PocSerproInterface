package poc.api.interfaces.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poc.api.interfaces.entities.serpro.PublicQueryResponse;

public interface IPublicQueryResponseRepository extends JpaRepository<PublicQueryResponse, Long>{

}
