package br.com.loja.business;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.loja.model.Fornecedor;

@Stateless
public class FornecedorBusiness {
	@Inject
	private EntityManager em;
	
	@Inject
	private Logger logger;
	
	public void criarFornecedor(Fornecedor fornecedor) {
		em.persist(fornecedor);
		logger.info("Fornecedor " + fornecedor.getNomeFantasia() + "criado com sucesso");
	}
	
	public void excluirFornecedor(Fornecedor fornecedor) {
		
		String nome = fornecedor.getNomeFantasia();
		em.remove(fornecedor);
		logger.info("Fornecedor" + nome + "Excluido com sucesso");
	}
	
	public Fornecedor obterFornecedor(Integer id) {
		TypedQuery <Fornecedor> query = em.createNamedQuery("SELECT f FROM Fornecedor f where id = :id", Fornecedor.class);
		query.setParameter(1, id);
		return query.getSingleResult();
	}
	
	public void atualizarFornecedor(Integer id) {
		Fornecedor fornecedor = this.obterFornecedor(id);
		em.merge(fornecedor);
	}
}
