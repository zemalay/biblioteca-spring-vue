package br.edu.ufab.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.edu.ufab.model.enumerador.AnaisEnum;
import br.edu.ufab.model.enumerador.MidiaEnum;
import br.edu.ufab.model.enumerador.TipoItem;
import br.edu.ufab.model.enumerador.TrabalhoEnum;

/**
 * A classe POJO do Item
 * 
 * @autor geovanniovinhas <vinhasgeovannio@gmail.com
 */
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	private TipoItem tipoItem;
	private String isbn;
	private String titulo;
	@Enumerated(EnumType.STRING)
	AnaisEnum tipoAnais;
	@Enumerated(EnumType.STRING)
	MidiaEnum tipoMidia;
	@Enumerated(EnumType.STRING)
	TrabalhoEnum tipoTrabalho;
	private String autor;
	private String congresso;
	private String anoPublicacao;
	private String local;
	private String editora;
	private String edicao;
	private int numeroPagina;
	private String area;
	private String tema;
	private String dataGravacao;
	private String orientador;
	private String data;
	private int quantidade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoItem getTipoItem() {
		return tipoItem;
	}

	public void setTipoItem(String tipoItem) {
		this.tipoItem = TipoItem.valueOf(tipoItem);
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public AnaisEnum getTipoAnais() {
		return tipoAnais;
	}

	public void setTipoAnais(String tipoAnais) {
		this.tipoAnais = AnaisEnum.valueOf(tipoAnais);
	}

	public MidiaEnum getTipoMidia() {
		return tipoMidia;
	}

	public void setTipoMidia(String tipoMidia) {
		this.tipoMidia = MidiaEnum.valueOf(tipoMidia);
	}

	public TrabalhoEnum getTipoTrabalho() {
		return tipoTrabalho;
	}

	public void setTipoTrabalho(String tipoTrabalho) {
		this.tipoTrabalho = TrabalhoEnum.valueOf(tipoTrabalho);
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getCongresso() {
		return congresso;
	}

	public void setCongresso(String congresso) {
		this.congresso = congresso;
	}

	public String getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(String anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public int getNumeroPagina() {
		return numeroPagina;
	}

	public void setNumeroPagina(int numeroPagina) {
		this.numeroPagina = numeroPagina;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getDataGravacao() {
		return dataGravacao;
	}

	public void setDataGravacao(String dataGravacao) {
		this.dataGravacao = dataGravacao;
	}

	public String getOrientador() {
		return orientador;
	}

	public void setOrientador(String orientador) {
		this.orientador = orientador;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", tipoItem=" + tipoItem + ", isbn=" + isbn + ", titulo=" + titulo + ", tipoAnais="
				+ tipoAnais + ", tipoMidia=" + tipoMidia + ", tipoTrabalho=" + tipoTrabalho + ", autor=" + autor
				+ ", congresso=" + congresso + ", anoPublicacao=" + anoPublicacao + ", local=" + local + ", editora="
				+ editora + ", edicao=" + edicao + ", numeroPagina=" + numeroPagina + ", area=" + area + ", tema="
				+ tema + ", dataGravacao=" + dataGravacao + ", orientador=" + orientador + ", data=" + data
				+ ", quantidade=" + quantidade + "]";
	}

}
