package br.edu.ufab.dao.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufab.model.acervo.MidiaEletronica;
import br.edu.ufab.model.enumerador.MidiaEnum;
import br.edu.ufab.repository.acervo.MidiaDao;

public class MidiaTest {

	private MidiaEletronica midia;
	MidiaDao midiaDao = new MidiaDao();
	
	@Before
	public void inicializandoTeste(){	
		midia = new MidiaEletronica(1111,MidiaEnum.CD, "trabalho ", null);
	}
	
	@Test
	public void inserir(){
		assertTrue(midiaDao.create(midia));
	}
	
	
	@Test
	public void testEditarCadastro() {
		midia.setTitulo("Trabalho Lindo");
		assertTrue(midiaDao.update(midia));
	}

	@Test
	public void excluir(){
		midia.setId(1);
		assertTrue(midiaDao.remove(midia));
	}
}
