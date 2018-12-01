package br.edu.ufab.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.edu.ufab.model.Curso;
import br.edu.ufab.repository.AlunoRepository;
import br.edu.ufab.repository.CursoRepository;

/**
 * @autor geovanniovinhas <vinhasgeovannio@gmail.com
 */
@Component
public class CursoService implements Service<Curso> {

	@Autowired
	private CursoRepository cursoRepository;

	@Autowired
	private AlunoRepository alunoRepository;
	private static Logger logger = Logger.getLogger(CursoService.class);

	/**
	 * @see {@link Service#cadastrar(Object)}
	 */
	public boolean cadastrar(Curso obj) {
		logger.info("Cadastrando o curso: " + obj);
		if (cursoRepository.isExiste(obj.getNome())) {
			logger.warn("Curso ja existe");
			return false;
		}
		cursoRepository.save(obj);
		logger.info("Curso foi cadastrado" + obj);
		return true;
	}

	/**
	 * @see {@link Service#atualizar(Long, Object)}
	 */
	public boolean atualizar(Long id, Curso obj) {
		logger.info("Atualizando o curso: id: " + id + " - " + obj);
		Curso curso = cursoRepository.procurarPorId(id);

		if (curso == null) {
			logger.warn("Curso nao existe");
			return false;
		}
		obj.setId(id);
		cursoRepository.save(obj);
		logger.info("Curso foi atualizado" + obj);
		return true;
	}

	/**
	 * @see {@link Service#remover(Long)}
	 */
	public boolean remover(Long id) {
		logger.info("Removendo o curso: " + id);
		Curso curso = cursoRepository.procurarPorId(id);

		if (curso == null) {
			logger.warn("Curso nao existe");
			return false;
		}
		if (alunoRepository.procuraPorCursoId(curso.getId()) != null) {
			return false;
		}
		cursoRepository.delete(curso);
		logger.info("Curso foi removido");
		return true;
	}

	/**
	 * @see {@link Service#pegarTodos()}
	 */
	public List<Curso> pegarTodos() {
		logger.info("Pegar todos os cursos no banco");

		return cursoRepository.findAll();
	}

}
