package br.com.farmacola.farmacola.Model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
//Imports
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name ="tb_categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	
	@NotNull // Não permite atributos com valor nulo
	@Size(min = 20, max = 255,message = "Valor mínimo de 20 caracteres e máximo de 255")
	private String descricao;
	
	@NotNull // Não permite atributos com valor nulo
	@Size(min = 5, max = 255,message = "Valor mínimo de 5 caracteres e máximo de 255") 
	private String categoria;
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoria")
	private List <Produto> produto;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

	

}
