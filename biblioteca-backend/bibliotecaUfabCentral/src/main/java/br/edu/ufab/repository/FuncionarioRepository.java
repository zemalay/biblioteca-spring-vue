package br.edu.ufab.repository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.ufab.model.Funcionario;

/**
 * @autor geovanniovinhas <vinhasgeovannio@gmail.com
 *
 *
 */
@Transactional
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	
	@Query("SELECT c FROM Funcionario c WHERE c.id = :idFuncionario")
	Funcionario getById(@Param("idFuncionario")Long id);
}

