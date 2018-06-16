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

import br.edu.ufab.model.Item;
import br.edu.ufab.service.ItemAcervoService;

/**
 * @autor geovanniovinhas <vinhasgeovannio@gmail.com
 */
@RestController
public class ItemController {

	@Autowired
	private ItemAcervoService itemAcervoService;
	private static Logger logger = Logger.getLogger(ItemController.class);

	/**
	 * Endpoint para cadastro do Item
	 * 
	 * @param item
	 * @param ucBuilder
	 * @return ResponseEntity<Void>
	 */
	@CrossOrigin
	@RequestMapping(value = "/item/", method = RequestMethod.POST)
	public ResponseEntity<Void> cadastraItem(@RequestBody Item item, UriComponentsBuilder ucBuilder) {
		logger.info("O endpoint POST /item/ foi solicitado");

		if (!itemAcervoService.cadastrar(item)) {
			logger.warn("O cadastro do curso nao foi realizado");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/item/{id}").buildAndExpand(item.getId()).toUri());

		logger.info("O cadastro do item foi realizado com sucesso");
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	/**
	 * Endpoint para atualizar Item
	 * 
	 * @param id
	 * @param item
	 * @return ResponseEntity<Void>
	 */
	@RequestMapping(value = "/item/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizarItem(@PathVariable("id") long id, @RequestBody Item item) {
		logger.info("O endpoint PUT /item/{id} foi solicitado");

		if (!itemAcervoService.atualizar(id, item)) {
			logger.warn("A atualizacao do item nao foi realizado");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		logger.info("A atualizacao do item foi realizado com sucesso");
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	/**
	 * Endpoint para remover Item
	 * 
	 * @param id
	 * @return ResponseEntity<Void>
	 */
	@RequestMapping(value = "/item/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletarItem(@PathVariable("id") long id) {
		logger.info("O endpoint DELETE /curso/{id} foi solicitado");

		if (!itemAcervoService.remover(id)) {
			logger.warn("A remocao do item nao foi realizado");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		logger.info("A remocao do item foi realizado");
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	/**
	 * Endpoint para listar todos os itens
	 * 
	 * @return ResponseEntity<List<Item>>
	 */
	@RequestMapping(value = "/item/", method = RequestMethod.GET)
	public ResponseEntity<List<Item>> listarItens() {
		logger.info("O endpoint GET /item/ foi solicitado");

		if (itemAcervoService.pegarTodos().isEmpty()) {
			logger.info("Nao tem item cadastrado");

			return new ResponseEntity<List<Item>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Item>>(itemAcervoService.pegarTodos(), HttpStatus.OK);
	}

}
