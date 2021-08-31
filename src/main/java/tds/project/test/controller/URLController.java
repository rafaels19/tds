package tds.project.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tds.project.test.entity.Historico;
import tds.project.test.entity.URL;
import tds.project.test.service.IURLService;

/**
 * 
 * @author R148891
 * 
 * 1 - criacao de api encurtador de url que segue padrao rest
 * 
 * 2 - ao cadastrar uma url deve-se retornar outra url encurtada...que ao ser acessada redireciona para a original
 * 
 * 3 - deve criar endpoint para estatisticas de acesso das urls geradas
 * 
 * 4 - implementar testes
 *
 */

@RestController
@RequestMapping(value = "/url")
public class URLController {

	@Autowired
	private IURLService urlService;

	@RequestMapping("/hello")
    public String teste() {
		
		return "Primeira rota!";
	}
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> cadastrarUrl(@RequestParam(required=true) String urlOriginal) {
		
		this.urlService.cadastrarUrl(urlOriginal);
		
		return new ResponseEntity<>("URL cadastrada com sucesso", HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/consultar", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> consultarUrl(@RequestParam(required=false) String urlEncurtada) {
		
		URL url = this.urlService.findByEncurtada(urlEncurtada);
		
		return new ResponseEntity<>(url, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/estatisticas", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> consultarEstatisticas() {
		
		List<Historico> historico = this.urlService.findAll();
		
		return new ResponseEntity<>(historico, HttpStatus.OK);
	}
}
