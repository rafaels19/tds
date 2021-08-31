package tds.project.test.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tds.project.test.entity.Historico;
import tds.project.test.entity.URL;
import tds.project.test.repository.HistoricoRepository;
import tds.project.test.repository.URLRepository;
import tds.project.test.service.IURLService;

public class URLServiceImpl implements IURLService {

	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static final int    BASE     = ALPHABET.length();

	@Autowired
	private URLRepository urlRepository;
	
	@Autowired
	private HistoricoRepository historicoRepository;

	@Override
	public List<URL> findByOriginal(String original) {
		return this.urlRepository.findByOriginal(original);
	}

	@Override
	public URL findByEncurtada(String encurtada) {
		return this.urlRepository.findByEncurtada(encurtada);
	}

	@Override
	public URL findById(long id) {
		return this.urlRepository.findById(id);
	}

	@Override
	public void cadastrarUrl(String urlOriginal) {

		URL urlNova = new URL();
		String shorturl = idToShortURL(BASE);

		urlNova.setOriginal(urlOriginal);
		urlNova.setEncurtada(shorturl);
		urlNova.setValorUrlEncurtada(shortURLtoID(shorturl));
		
		this.urlRepository.save(urlNova);
	}
	
	@Override
	public Historico consultarHistorico(URL url) {
		return this.historicoRepository.findByUrl(url);
	}
	
	@Override
	public List<Historico> findAll() {
		return (List<Historico>) this.historicoRepository.findAll();
	}
	
	@Override
	public void cadastrarHistorico(URL url) {
		
		Historico historico = this.historicoRepository.findByUrl(url);
		
		if(historico == null) {
			
			historico = new Historico();
			historico.setUrl(url);
			historico.setQtdAcessos(1);
		
		} else {
			
			historico.setQtdAcessos(historico.getQtdAcessos() + 1);
		}
		
		this.historicoRepository.save(historico);
	}

	private String idToShortURL(int n) {
		// Map to store 62 possible characters
		char map[] = ALPHABET.toCharArray();

		StringBuffer shorturl = new StringBuffer();

		// Convert given integer id to a base 62 number
		while (n > 0)
		{
			// use above map to store actual character
			// in short url
			shorturl.append(map[n % 62]);
			n = n / 62;
		}

		// Reverse shortURL to complete base conversion
		return shorturl.reverse().toString();
	}
	
	private Integer shortURLtoID(String shortURL) {
		int id = 0; // initialize result

		// A simple base conversion logic
		for (int i = 0; i < shortURL.length(); i++) {
			if ('a' <= shortURL.charAt(i) &&
					shortURL.charAt(i) <= 'z')
				id = id * 62 + shortURL.charAt(i) - 'a';
			if ('A' <= shortURL.charAt(i) &&
					shortURL.charAt(i) <= 'Z')
				id = id * 62 + shortURL.charAt(i) - 'A' + 26;
			if ('0' <= shortURL.charAt(i) &&
					shortURL.charAt(i) <= '9')
				id = id * 62 + shortURL.charAt(i) - '0' + 52;
		}
		
		return id;
	}
	
}
