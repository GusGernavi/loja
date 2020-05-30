package br.com.loja.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.loja.business.FornecedorBusinessMock;
import br.com.loja.model.Fornecedor;

@Named
public class FornecedorController {
	
	private List<Fornecedor> listaFornecedor;
	
	@Inject
	private FornecedorBusinessMock business;
	
	private Fornecedor fornecedorPadrao = new Fornecedor();
	
	@PostConstruct
	public void montaFornecedores (){
		listaFornecedor = business.obterFornecedores();
	}
	
	public String salvar() {
		System.out.println(fornecedorPadrao.getNomeFantasia());
		
		business.criarFornecedor(listaFornecedor, fornecedorPadrao);
		
		return "/fornecedor.xhtml";
	}
	
	public String excluirFornecedor(Fornecedor fornecedor) {
		business.excluirFornecedor(listaFornecedor, fornecedor);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Pronto!", "Fornecedor Apagado com sucesso!"));
		return "\fornecedor.xhtml";
	}
	
	public String editar(Fornecedor forn) {
		this.fornecedorPadrao = forn;
		return "novoFornecedor.xhml?faces=redirect=true";
	}

	public String editaFornecedor(Fornecedor forn) {
		business.atualizarFornecedor(listaFornecedor, forn);
		return "fornecedor.xhtml?faces-redirect=true";
	}

	public List<Fornecedor> getListaFornecedor() {
		if(listaFornecedor.isEmpty() || listaFornecedor == null) {
			return new ArrayList<Fornecedor>();
		}
		return listaFornecedor;
	}

	public void setListaFornecedor(List<Fornecedor> listaFornecedor) {
		this.listaFornecedor = listaFornecedor;
	}

	public Fornecedor getFornecedorPadrao() {
		return fornecedorPadrao;
	}

	public void setFornecedorPadrao(Fornecedor fornecedor) {
		this.fornecedorPadrao = fornecedor;
	}
	
}
