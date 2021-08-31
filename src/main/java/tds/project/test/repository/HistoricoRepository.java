package tds.project.test.repository;

import org.springframework.data.repository.CrudRepository;

import tds.project.test.entity.Historico;
import tds.project.test.entity.URL;

public interface HistoricoRepository extends CrudRepository<Historico, Long> {

	Historico findByUrl(URL url);
	
	Historico findById(long id);
}