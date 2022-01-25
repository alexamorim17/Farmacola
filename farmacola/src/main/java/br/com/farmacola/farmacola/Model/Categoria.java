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

@Entity //entidade 
@Table(name ="tb_categoria") //nome da tabela no banco de dados
public class Categoria {
	
	@Id//identificador 
	@GeneratedValue(strategy = GenerationType.IDENTITY)//para falar que o campo mapeado será gerado automaticamente pelo banco de dados
	private long id; 
	
	@NotNull // Não permite atributos com valor nulo
	@Size(min = 20, max = 255,message = "Valor mínimo de 20 caracteres e máximo de 255")/* serve para falar que o campo mapeado será gerado automaticamente pelo banco de dados,
	impede que o usuario coleque caracteres menor que 5 e maior que 255*/
	private String descricao;
	
	@NotNull // Não permite atributos com valor nulo
	@Size(min = 5, max = 255,message = "Valor mínimo de 5 caracteres e máximo de 255")/* serve para falar que o campo mapeado 
	será gerado automaticamente pelo banco de dados, impede que o usuario coleque caracteres menor que 5 e maior que 255 */
	private String categoria;
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)/*permite excluir ou atualizar os registros relacionados presentes na tabela filha 
	automaticamente */
	@JsonIgnoreProperties("categoria")//permite um controle mais preciso sobre quais objetos devem ignorar campos desconhecidos e quais não devem.
	private List <Produto> produto;
	
	//Get set
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
