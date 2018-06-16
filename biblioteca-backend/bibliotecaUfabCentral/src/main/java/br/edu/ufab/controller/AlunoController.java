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
import br.edu.ufab.model.Aluno;
import br.edu.ufab.service.AlunoService;

/**
 * @autor geovanniovinhas <vinhasgeovannio@gmail.com
 */

@RestController
public class AlunoController {

	@Autowired
	private AlunoService alunoService;
	private static Logger logger = Logger.getLogger(AlunoController.class);

	/**
	 * Endpoint para cadastro do aluno
	 * 
	 * @param aluno
	 * @param ucBuilder
	 * @return ResponseEntity<Void>
	 */
	@CrossOrigin
	@RequestMapping(value = "/aluno/", method = RequestMethod.POST)
	public ResponseEntity<Void> cadastraAluno(@RequestBody Aluno aluno, UriComponentsBuilder ucBuilder) {
		logger.info("O endpoint POST /aluno/ foi solicitado");

		if (!alunoService.cadastrar(aluno)) {
			logger.warn("O cadastro do aluno nao foi realizado");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/aluno/{id}").buildAndExpand(aluno.getId()).toUri());

		logger.info("O cadastro do aluno foi realizado com sucesso");
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	/**
	 * Endpoint para atualizar aluno
	 * 
	 * @param id
	 * @param aluno
	 * @return ResponseEntity<Void>
	 */
	@RequestMapping(value = "/aluno/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizaAluno(@PathVariable("id") long id, @RequestBody Aluno aluno) {
		logger.info("O endpoint PUT /aluno/{id} foi solicitado");

		if (!alunoService.atualizar(id, aluno)) {
			logger.warn("A atualizacao do curso nao foi realizado");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		logger.info("A atualizacao do aluno foi realizado com sucesso");
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	/**
	 * Endpoint para remover o aluno
	 * 
	 * @param id
	 * @return ResponseEntity<Void>
	 */
	@RequestMapping(value = "/aluno/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletarAluno(@PathVariable("id") long id) {
		logger.info("O endpoint DELETE /aluno/{id} foi solicitado");

		if (!alunoService.remover(id)) {
			logger.warn("A remocao do aluno nao foi realizado");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		logger.info("A remocao do aluno foi realizado");
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	/**
	 * Endpoint para listar todos os alunos
	 * 
	 * @return ResponseEntity<List<Aluno>>
	 */
	@RequestMapping(value = "/aluno/", method = RequestMethod.GET)
	public ResponseEntity<List<Aluno>> listarAlunos() {
		logger.info("O endpoint GET /aluno/ foi solicitado");

		if (alunoService.pegarTodos().isEmpty()) {
			return new ResponseEntity<List<Aluno>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Aluno>>(alunoService.pegarTodos(), HttpStatus.OK);
	}

}
