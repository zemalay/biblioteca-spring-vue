package br.edu.ufab.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ufab.model.Aluno;
import br.edu.ufab.model.Curso;
import br.edu.ufab.repository.AlunoRepository;
import br.edu.ufab.repository.CursoRepository;

/**
 * 
 * @autor geovanniovinhas <vinhasgeovannio@gmail.com
 * 
 */
@Component
public class AlunoService implements Service<Aluno> {

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private CursoRepository cursoRepository;
	private static Logger logger = Logger.getLogger(AlunoService.class);

	/**
	 * @see {@link Service#cadastrar(Object)}
	 */
	public boolean cadastrar(Aluno obj) {
		logger.info("Cadastrando o aluno: " + obj);

		if (alunoRepository.isCpfExiste(obj.getCpf())) {
			logger.warn("Aluno com este cpf ja existe");
			return false;
		}

		Curso curso = cursoRepository.procurarPorId(obj.getCurso().getId());
		if(curso == null) {
			return false;
		}
		obj.setCurso(curso);

		obj.setMatricula(gerarMatricula(obj));

		if (alunoRepository.isMatriculaExiste(obj.getMatricula())) {
			logger.warn("A matricula ja existe");
			return false;
		}
		alunoRepository.save(obj);

		logger.info("Aluno foi cadastrado" + obj);
		return true;
	}

	/**
	 * @see {@link Service#atualizar(Long, Object)}
	 */
	public boolean atualizar(Long id, Aluno obj) {
		logger.info("Atualizando o aluno: id: " + id + " - " + obj);
		Aluno aluno = alunoRepository.procurarPorId(id);

		if (aluno == null) {
			logger.warn("Aluno nao existe");
			return false;
		}
		obj.setMatricula(aluno.getMatricula());
		alunoRepository.save(obj);
		logger.info("Aluno foi atualizado" + obj);
		return true;
	}

	/**
	 * @see {@link Service#remover(Long)}
	 */
	public boolean remover(Long id) {
		logger.info("Removendo o aluno: " + id);

		Aluno aluno = alunoRepository.procurarPorId(id);
		if (aluno == null) {
			logger.warn("Curso nao existe");
			return false;
		}

		alunoRepository.delete(aluno);

		logger.info("Curso foi removido");
		return true;
	}

	/**
	 * @see {@link Service#pegarTodos()}
	 */
	public List<Aluno> pegarTodos() {
		logger.info("Pegar todos os alunos no banco");

		return alunoRepository.findAll();
	}

	/**
	 * Gera matricula para o aluno cadastrado. A matricula e unico para cada aluno.
	 * 
	 * @param aluno
	 * @return matricula gerado
	 */
	private String gerarMatricula(Aluno aluno) {
		logger.info("Gerando a matricula do Aluno: " + aluno);
		String nivelAbreviacao = "", anoAbreviacao, ano, codigo, matricula;

		ano = aluno.getAnoIngresso();

		// Criar Abreviacao do nivel (e.g. Graduacao -> G)
		switch (aluno.getCurso().getTipo()) {
		case GRADUACAO:
			nivelAbreviacao = "G";
			break;
		case ESPECIALIZACAO:
			nivelAbreviacao = "E";
			break;
		case MESTRADO:
			nivelAbreviacao = "M";
			break;
		case DOUTORADO:
			nivelAbreviacao = "D";
			break;
		default:
			break;
		}

		// Criar abreviacao do ano de ingresso (e.g. 2010 -> 10)
		anoAbreviacao = ano.substring(2, ano.length());

		// Criar codigo (e.g. 1 -> 001)
		if (alunoRepository.getLastAluno() == 0) {
			codigo = String.format("%03d", 1);
		} else {
			codigo = String.format("%03d", alunoRepository.getLastAluno() + 1);
		}

		matricula = nivelAbreviacao + aluno.getCurso().getSigla().toUpperCase() + "-" + anoAbreviacao
				+ aluno.getPeriodoIngresso() + codigo;

		logger.info("A mtricula gerada: " + matricula);
		return matricula;
	}

}
