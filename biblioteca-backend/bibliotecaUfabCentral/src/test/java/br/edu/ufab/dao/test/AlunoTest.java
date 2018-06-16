package br.edu.ufab.dao.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufab.model.Aluno;
import br.edu.ufab.model.Curso;
import br.edu.ufab.model.enumerador.CursoEnum;
import br.edu.ufab.repository.usuarios.AlunoDao;

public class AlunoTest {

	AlunoDao alunoDao; 
	Aluno aluno;

	Curso curso;
	
	@Before
	public void inicializarTest(){
		
		curso = new Curso(75,"Biologia","area","BI",CursoEnum.GRADUACAO);

		aluno = new Aluno("Samuel Jr.","Socorro","123413","1233",
				"Cajazeiras","rua padre ibiapina","971386687","freo@gmail.com",
				"13413as",curso,2012,"1");
		
		alunoDao= new AlunoDao();	
		
	}
	
	@Test
	public void inserir() {
		aluno.setId(1);
		aluno.setMatricula("1234");
		assertTrue(alunoDao.create(aluno));
	}
	
	@Test
	public void buscarPorMatricula(){
		assertTrue(alunoDao.buscaPorMatricula("1234"));
	}
	
	@Test
	public void atualizarAlunoTest(){
		aluno.setId(1);
		aluno.setCpf("123413");
		assertTrue(alunoDao.update(aluno));	
	}
	
	@Test
	public void excluirAlunoTest(){
		aluno.setId(1);
		assertTrue(alunoDao.remove(aluno));
	}
	
	
}
