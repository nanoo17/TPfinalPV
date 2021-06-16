package ar.edu.unju.edm.repository;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.model.Turista_Poi;
@Repository
public interface ITurista_PoiDAO  extends CrudRepository<Turista_Poi, Integer>{
	@Query("from Poi c order by c.idTurista_Poi")
	public List<Turista_Poi> obtenerTuristas_Pois();
		
		public Optional<Turista_Poi> findByIdTurista_Poi(int idTurista_Poi);

}
