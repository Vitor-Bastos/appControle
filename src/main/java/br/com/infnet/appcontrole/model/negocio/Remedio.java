package br.com.infnet.appcontrole.model.negocio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TRemedio")
@Inheritance(strategy = InheritanceType.JOINED)
public class Remedio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	@ManyToMany(mappedBy = "remedios")
	private List<Controle> controles;
	
	@Override
	public String toString() {
		return String.format("%s", this.getDescricao());
	}
	
	public Remedio() {
	}
	public Remedio(Integer id) {
		this();
		this.setId(id);
	}
	public Remedio(Integer id, String descricao) {
		this(id);
		this.setDescricao(descricao);
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Controle> getControles() {
		return controles;
	}
	public void setControles(List<Controle> controles) {
		this.controles = controles;
	}
}
