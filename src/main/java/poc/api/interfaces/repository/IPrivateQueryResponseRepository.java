package poc.api.interfaces.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poc.api.interfaces.entities.serpro.PrivateQueryGenericResponse;

public interface IPrivateQueryResponseRepository extends JpaRepository<PrivateQueryGenericResponse, Long>{

}
