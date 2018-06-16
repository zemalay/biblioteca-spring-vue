package br.edu.ufab.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.ufab.model.Item;

/**
 * @autor geovanniovinhas <vinhasgeovannio@gmail.com
 */
@Transactional
public interface ItemRepository extends JpaRepository<Item, Long> {
	/**
	 * Seleciona o objeto de acordo com seu id. Caso não seja encontrado é retornado
	 * null
	 * 
	 * @param id
	 * @return Curso
	 */
	@Query("SELECT i FROM Item i WHERE i.id = :idItem")
	Item procurarPorId(@Param("idItem") Long id);

	/**
	 * Verifica se o objeto ja existe no banco de dados. Se a operação for realizada
	 * com sucesso é retornado true, caso contrário false
	 * 
	 * 
	 * @param nome
	 * @return boolean
	 */
	@Query("SELECT CASE WHEN COUNT(i) > 0 THEN true ELSE false END FROM Item i WHERE i.titulo = :titulo")
	boolean isExiste(@Param("titulo") String titulo);
}
