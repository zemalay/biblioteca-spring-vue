package br.edu.ufab.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.edu.ufab.model.enumerador.TipoFuncionario;

/**
 * @author Jose George e Caio Silva
 * 
 */
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Funcionario implements Serializable{

	private static final long serialVersionUID = -7391299020227305312L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cpf;
	private String nomeCompleto;
	@Enumerated(EnumType.STRING)
	private TipoFuncionario tipo; /* USUARIO OPERADOR OU ADMINISTRADOR */
	private String rg;
	private String naturalidade;
	private String endereco;
	private String telefone;
	private String email;
	private String nomeUsuario;
	private String senha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public TipoFuncionario getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = TipoFuncionario.valueOf(tipo);
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", cpf=" + cpf + ", nomeCompleto=" + nomeCompleto + ", tipo=" + tipo + ", rg="
				+ rg + ", naturalidade=" + naturalidade + ", endereco=" + endereco + ", telefone=" + telefone
				+ ", email=" + email + ", nomeUsuario=" + nomeUsuario + ", senha=" + senha + "]";
	}

}
