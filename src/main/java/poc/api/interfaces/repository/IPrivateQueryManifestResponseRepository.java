package poc.api.interfaces.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poc.api.interfaces.entities.serpro.PrivateQueryManifestResponse;

public interface IPrivateQueryManifestResponseRepository extends JpaRepository<PrivateQueryManifestResponse, Long>{

}
