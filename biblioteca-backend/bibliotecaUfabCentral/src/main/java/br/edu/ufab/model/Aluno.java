package br.edu.ufab.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A classe Aluno consiste em um Java Bean com anotacoes JPA
 * 
 * @author Jose George e Caio Silva
 */

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Aluno implements Serializable {

	private static final long serialVersionUID = 5805441993737959124L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String nomeMae;
	private String matricula;
	private String cpf;
	private String rg;
	private String naturalidade;
	private String endereco;
	private String telefone;
	private String email;
	private String senha;
	@ManyToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;
	private String anoIngresso;
	private String periodoIngresso;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getAnoIngresso() {
		return anoIngresso;
	}

	public void setAnoIngresso(String anoIngresso) {
		this.anoIngresso = anoIngresso;
	}

	public String getPeriodoIngresso() {
		return periodoIngresso;
	}

	public void setPeriodoIngresso(String periodoIngresso) {
		this.periodoIngresso = periodoIngresso;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", nomeMae=" + nomeMae + ", matricula=" + matricula + ", cpf="
				+ cpf + ", rg=" + rg + ", naturalidade=" + naturalidade + ", endereco=" + endereco + ", telefone="
				+ telefone + ", email=" + email + ", senha=" + senha + ", curso=" + curso + ", anoIngresso="
				+ anoIngresso + ", periodoIngresso=" + periodoIngresso + "]";
	}

}
