package br.edu.ufab.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ufab.model.Item;
import br.edu.ufab.repository.ItemRepository;

/**
 * @autor geovanniovinhas <vinhasgeovannio@gmail.com
 */

@Component
public class ItemAcervoService implements Service<Item> {

	@Autowired
	private ItemRepository itemRepository;
	private static Logger logger = Logger.getLogger(ItemAcervoService.class);

	/**
	 * @see {@link Service#cadastrar(Object)}
	 */
	public boolean cadastrar(Item obj) {
		logger.info("Cadastrando o item: " + obj);

		if (itemRepository.isExiste(obj.getTitulo())) {
			logger.warn("O item ja existe");
			return false;
		}
		itemRepository.save(obj);

		logger.info("Item foi cadastrado");
		return true;
	}

	/**
	 * @see {@link Service#atualizar(Long, Object)}
	 */
	public boolean atualizar(Long id, Item obj) {
		logger.info("Atualizando o item: id: " + id + " - " + obj);

		Item item = itemRepository.procurarPorId(id);
		if (item == null) {
			logger.warn("Item nao ja existe");
			return false;
		}
		obj.setId(id);
		itemRepository.save(obj);
		logger.info("Aluno foi atualizado" + obj);
		return true;
	}

	/**
	 * @see {@link Service#remover(Long)}
	 */
	public boolean remover(Long id) {
		logger.info("Removendo o item: " + id);

		Item item = itemRepository.procurarPorId(id);
		if (item == null) {
			logger.warn("Item nao ja existe");
			return false;
		}

		itemRepository.delete(item);
		logger.info("Item foi removido");
		return true;
	}

	/**
	 * @see {@link Service#pegarTodos()}
	 */
	public List<Item> pegarTodos() {
		logger.info("Pegar todos os itens no banco");
		return itemRepository.findAll();
	}

}
