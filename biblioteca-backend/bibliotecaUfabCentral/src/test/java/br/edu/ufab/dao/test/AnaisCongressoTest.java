package br.edu.ufab.dao.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufab.model.acervo.AnaisCongresso;
import br.edu.ufab.model.enumerador.AnaisEnum;
import br.edu.ufab.repository.acervo.AnaisDao;

public class AnaisCongressoTest {

	private AnaisCongresso anais;
	private AnaisDao anaisDao = new AnaisDao();
	
	@Before
	public void inicializandoTeste(){
		 anais = new AnaisCongresso(121212,AnaisEnum.ARTIGO, "CBA"
				,"Computacao parelala", "Jose ",null , "CG");
	}
	
	@Test
	public void inserir(){
		assertTrue(anaisDao.create(anais));
	}
	
	
	@Test
	public void testEditarCadastro() {
		anais.setNomeDoCongresso("CBA - 2018 - JP");
		anais.setId(1);
		assertTrue(anaisDao.update(anais));
	}
	
	
	/*
	@Test
	public void buscar(){
		ArrayList<AnaisCongresso> anais = new ArrayList<AnaisCongresso>();
		anais = anaisDao.search("CBA - 2018 - JP");
		assertEquals("CBA - 2018 - JP",anais.get(0).getNomeDoCongresso());
	}
	*/
	
	@Test
	public void excluir(){
		anais.setId(1);
		assertTrue(anaisDao.remove(anais));
	}
	 
	
	
}
