package br.edu.ufab.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.ufab.model.Curso;

/**
 * @autor geovanniovinhas <vinhasgeovannio@gmail.com
 */
@Transactional
public interface CursoRepository extends JpaRepository<Curso, Long> {

	/**
	 * Seleciona o objeto de acordo com seu id. Caso não seja encontrado é retornado
	 * null
	 * 
	 * @param id
	 * @return Curso
	 */
	@Query("SELECT c FROM Curso c WHERE c.id = :idCurso")
	Curso procurarPorId(@Param("idCurso") Long id);

	/**
	 * Verifica se o objeto ja existe no banco de dados. Se a operação for realizada
	 * com sucesso é retornado true, caso contrário false
	 * 
	 * 
	 * @param nome
	 * @return boolean
	 */
	@Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Curso c WHERE c.nome = :nomeCurso")
	boolean isExiste(@Param("nomeCurso") String nome);
}
