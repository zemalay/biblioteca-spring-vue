package br.edu.ufab.service;

import java.util.List;

/**
 * @autor geovanniovinhas <vinhasgeovannio@gmail.com
 */
public interface Service<T> {

	/**
	 * Insere um novo objeto no banco de dados. Se a operação for realizada com
	 * sucesso é retornado true, caso contrario false
	 *
	 * @param obj
	 *            O objeto a ser inserido
	 * @return boolean
	 */
	boolean cadastrar(T obj);

	/**
	 * Atualiza os dados do objeto no banco de dados. Se a operação for realizada
	 * com sucesso é retornado true, caso contrário false
	 * 
	 * @param id
	 * @param obj
	 * @return boolean
	 */
	boolean atualizar(Long id, T obj);

	/**
	 * Remove o objeto do banco de dados. Se a operação for realizada com sucesso é
	 * retornado true, caso contrário false
	 * 
	 * @param id
	 * @return boolean
	 */
	boolean remover(Long id);

	/**
	 * Retorna uma lista com todos objeto cadastrados no banco de dados
	 * 
	 * @return List<T>
	 */
	List<T> pegarTodos();
}
