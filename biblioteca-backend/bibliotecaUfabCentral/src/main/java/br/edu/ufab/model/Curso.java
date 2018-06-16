package br.edu.ufab.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.edu.ufab.model.enumerador.CursoEnum;

/**
 * 
 * 
 * @author Jose George e Caio Silva
 */

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Curso implements Serializable {

	private static final long serialVersionUID = 1066556114169220310L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String area;

	private String sigla;
	@Enumerated(EnumType.STRING)
	private CursoEnum tipo;

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

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public CursoEnum getTipo() {
		return tipo;
	}

	public void setTipo(CursoEnum tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nome=" + nome + ", area=" + area + ", sigla=" + sigla + ", tipo=" + tipo + "]";
	}

}
