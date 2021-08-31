package tds.project.test.service;

import java.util.List;

import tds.project.test.entity.Historico;
import tds.project.test.entity.URL;

public interface IURLService {

	public List<URL> findByOriginal(String original);
	
	public URL findByEncurtada(String encurtada);

	public URL findById(long id);
	
	public void cadastrarUrl(String urlOriginal);
	
	public void cadastrarHistorico(URL url);
	
	public Historico consultarHistorico(URL url);
	
	public List<Historico> findAll();
}
