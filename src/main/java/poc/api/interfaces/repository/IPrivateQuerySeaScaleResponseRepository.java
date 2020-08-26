package poc.api.interfaces.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poc.api.interfaces.entities.serpro.PrivateQuerySeaScaleResponse;

public interface IPrivateQuerySeaScaleResponseRepository extends JpaRepository<PrivateQuerySeaScaleResponse, Long>{

}
