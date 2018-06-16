package br.edu.ufab.dao.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufab.model.acervo.Revista;
import br.edu.ufab.repository.acervo.RevistaDao;

public class RevistaTest {
	
	private Revista revista; 
	RevistaDao revistaDao = new RevistaDao();
	
	@Before
	public void inicializandoTeste(){		
		revista = new Revista(9,"modas e vc","moda_ag-", null, 2, 21);
	}
	
	@Test
	public void inserir(){
		assertTrue(revistaDao.create(revista));
	}
	
	
	@Test
	public void testEditarCadastro() {
		revista.setTitulo("O tesouro escondido");
		revista.setId(1);
		assertTrue(revistaDao.update(revista));
	}

	@Test
	public void excluir(){
		revista.setId(1);
		assertTrue(revistaDao.remove(revista));
	}
}
