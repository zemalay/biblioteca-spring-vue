package br.edu.ufab.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.edu.ufab.model.Curso;
import br.edu.ufab.service.CursoService;

/**
 * @autor geovanniovinhas <vinhasgeovannio@gmail.com
 */
@RestController
public class CursoController {

	@Autowired
	private CursoService cursoService;
	private static Logger logger = Logger.getLogger(CursoController.class);

	/**
	 * Endpoint para cadastro do curso
	 * 
	 * @param curso
	 * @param ucBuilder
	 * @return ResponseEntity<Void>
	 */
	@CrossOrigin
	@RequestMapping(value = "/curso/", method = RequestMethod.POST)
	public ResponseEntity<Void> cadastraCurso(@RequestBody Curso curso, UriComponentsBuilder ucBuilder) {
		logger.info("O endpoint POST /curso/ foi solicitado");

		if (!cursoService.cadastrar(curso)) {
			logger.warn("O cadastro do curso nao foi realizado");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/curso/{id}").buildAndExpand(curso.getId()).toUri());

		logger.info("O cadastro do curso foi realizado com sucesso");
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	/**
	 * Endpoint para atualizar o curso
	 * 
	 * @param id
	 * @param curso
	 * @return ResponseEntity<Void>
	 */
	@RequestMapping(value = "/curso/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizaCurso(@PathVariable("id") long id, @RequestBody Curso curso) {
		logger.info("O endpoint PUT /curso/{id} foi solicitado");

		if (!cursoService.atualizar(id, curso)) {
			logger.warn("A atualizacao do curso nao foi realizado");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		logger.info("A atualizacao do curso foi realizado com sucesso");
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	/**
	 * Endpoint para remover o curso
	 * 
	 * @param id
	 * @return ResponseEntity<Void>
	 */
	@RequestMapping(value = "/curso/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletarCurso(@PathVariable("id") long id) {
		logger.info("O endpoint DELETE /curso/{id} foi solicitado");

		if (!cursoService.remover(id)) {
			logger.warn("A remocao do curso nao foi realizado");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		logger.info("A remocao do curso foi realizado");
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	/**
	 * Endpoint para listar todos os cursos
	 * 
	 * @return ResponseEntity<List<Curso>>
	 */
	@RequestMapping(value = "/curso/", method = RequestMethod.GET)
	public ResponseEntity<List<Curso>> listarCursos() {
		logger.info("O endpoint GET /curso/ foi solicitado");
		if (cursoService.pegarTodos().isEmpty()) {
			logger.info("Nao tem curso cadastrado");

			return new ResponseEntity<List<Curso>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Curso>>(cursoService.pegarTodos(), HttpStatus.OK);
	}
	
}
