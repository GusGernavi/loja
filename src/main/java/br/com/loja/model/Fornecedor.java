package br.com.loja.model;

import java.util.List;

//@Entity
public class Fornecedor extends Empresa {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

//	@ManyToMany
	private List<Produto> produtos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
