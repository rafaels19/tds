package tds.project.test.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import tds.project.test.entity.URL;

public interface URLRepository extends CrudRepository<URL, Long> {

	List<URL> findByOriginal(String original);
	
	URL findByEncurtada(String encurtada);

	URL findByValorUrlEncurtada(Integer valorUrlEncurtada);
	
	URL findById(long id);
}
