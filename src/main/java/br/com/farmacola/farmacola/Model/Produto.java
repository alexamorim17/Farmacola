package br.com.farmacola.farmacola.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity // Cria a tabela
@Table(name = "tb_produto") //Define o nome da tabela;
public class Produto {
	
	@Id // Define a chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Equivale ao auto-increment no Mysql
	private long id;
	@Size(min = 3, max = 30) //Define o tamanho mínimo de 3 caracteres e máximo 30 caracteres
	private String nome;
	
	private boolean disponivel;
	
	
	private double preco;
	
	@Size(min = 3, max = 30) //Define o tamanho mínimo de 3 caracteres e máximo 30 caracteres
    private String tarja;
	
	@ManyToOne // Relação de um para muitos, ou seja varios produtos pertecem a uma categoria 
	@JsonIgnoreProperties("tb_produto") //Utilizado para evitar looping
	private Categoria categoria;
    
	//Getters e Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getTarja() {
		return tarja;
	}

	public void setTarja(String tarja) {
		this.tarja = tarja;
	}
    
    
	
	

}
