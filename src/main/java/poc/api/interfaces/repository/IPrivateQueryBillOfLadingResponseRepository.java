package poc.api.interfaces.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poc.api.interfaces.entities.serpro.PrivateQueryBillOfLadingResponse;

public interface IPrivateQueryBillOfLadingResponseRepository extends JpaRepository<PrivateQueryBillOfLadingResponse, Long>{

}
