package br.edu.ufab.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.ufab.model.Aluno;

/**
 * @autor geovanniovinhas <vinhasgeovannio@gmail.com
 */
@Transactional
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	/**
	 * Seleciona o objeto de acordo com seu id. Caso não seja encontrado é retornado
	 * null
	 * 
	 * @param id
	 * @return Curso
	 */
	@Query("SELECT a FROM Aluno a WHERE a.id = :idAluno")
	Aluno procurarPorId(@Param("idAluno") Long id);

	/**
	 * Verifica se a matricula ja existe no banco de dados. Se a operação for
	 * realizada com sucesso é retornado true, caso contrário false
	 * 
	 * 
	 * @param matricula
	 * @return boolean
	 */
	@Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM Aluno a WHERE a.matricula = :matricula")
	boolean isMatriculaExiste(@Param("matricula") String matricula);

	/**
	 * Verifica se o aluno com cpf ja existe no banco de dados. Se a operação for
	 * realizada com sucesso é retornado true, caso contrário false
	 * 
	 * 
	 * @param cpf
	 * @return boolean
	 */
	@Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM Aluno a WHERE a.cpf = :cpf")
	boolean isCpfExiste(@Param("cpf") String cpf);

	/**
	 * Pegar o ultimo aluno cadastrado
	 * 
	 * @return Aluno
	 */
	@Query("SELECT max(a.id) FROM Aluno a ORDER BY a.id DESC")
	long getLastAluno();

	/**
	 * Seleciona o objeto aluno pelo id do curso.
	 * 
	 * @param id
	 * @return Aluno
	 */
	@Query("SELECT a FROM Aluno a WHERE a.curso.id = :idCurso")
	List<Aluno> procuraPorCursoId(@Param("idCurso") Long curso_id);
}
