package poc.api.interfaces.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poc.api.interfaces.entities.serpro.PrivateQueryBillOfLadingItemResponse;

public interface IPrivateQueryBillOfLadingItemResponseRepository extends JpaRepository<PrivateQueryBillOfLadingItemResponse, Long>{

}
