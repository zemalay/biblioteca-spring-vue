package br.edu.ufab.dao.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufab.model.Funcionario;
import br.edu.ufab.model.enumerador.TipoFuncionario;
import br.edu.ufab.repository.usuarios.FuncionarioDao;

public class FuncionarioTest {

	Funcionario func;
	FuncionarioDao funcDao;
	
	@Before
	public void inicializarTest() {
		func = new Funcionario(TipoFuncionario.ADMINISTRADOR, "1001", "Jose George", "1232", "Cajazeiras",
				"Aprigio Veloso", "99913413", "george.djc@gmail.com", "j.george", "123george");
		funcDao = new FuncionarioDao();
	}
	
	@Test
	public void inserir() {
		assertTrue(funcDao.create(func));
	}
	
	@Test
	public void atualizarTest() {
		func.setId(1);
		func.setEndereco("cabo branco");
		assertTrue(funcDao.update(func));
	}
	
	@Test
	public void remover() {
		func.setId(1);
		assertTrue(funcDao.remove(func));
	}

}
