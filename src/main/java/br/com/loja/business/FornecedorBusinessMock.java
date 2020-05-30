package br.com.loja.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.loja.model.Endereco;
import br.com.loja.model.Fornecedor;
import br.com.loja.model.Produto;

public class FornecedorBusinessMock {

	private static List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();

	public FornecedorBusinessMock() {
		if (fornecedores.size() < 1) {

			for (int i = 0; i < 10; i++) {
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setId(i + 1);
				fornecedor.setCnpj("123456789");
				fornecedor.setEndereco(new Endereco());
				fornecedor.setNomeFantasia("Teste " + (i + 1));
				fornecedor.setProdutos(Arrays.asList(new Produto(), new Produto(), new Produto()));
				fornecedor.setRazaoSocial("Razão social teste " + (i + 1));
				
				fornecedores.add(fornecedor);
			}
		}
	}

	public void criarFornecedor(List<Fornecedor> fornecedores, Fornecedor fornecedor) {
		fornecedores.add(fornecedor);
	}

	public void excluirFornecedor(List<Fornecedor> fornecedores, Fornecedor fornecedor) {
		fornecedores.remove(fornecedor);
	}

	public Fornecedor obterFornecedor(Integer id) {
		return fornecedores.stream().filter(forn -> forn.getId().equals(id)).findFirst().get();
	}

	public void atualizarFornecedor(List<Fornecedor> fornecedores, Fornecedor fornecedor) {
		fornecedores.set(fornecedores.indexOf(fornecedor), fornecedor);
	}

	public List<Fornecedor> obterFornecedores(){
		return fornecedores;
	}

}
