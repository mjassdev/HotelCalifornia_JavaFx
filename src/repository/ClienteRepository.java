package repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Cliente;
import model.Quarto;

public class ClienteRepository extends Repository<Cliente> {

	public ClienteRepository(EntityManager entityManager) {
		super(entityManager);
		
	}

	public List<Cliente> getClientes(String nome) {
		Query query = getEntityManager().createQuery("SELECT c FROM Cliente c WHERE lower(c.nome) like(:nome)");
		query.setParameter("nome", "%" + nome + "%");

		List<Cliente> lista = query.getResultList();
		if (lista == null) {
			lista = new ArrayList<Cliente>();
		}
		return lista;
	}
	
	public List<Cliente> getClientesGeral() {
		Query query = getEntityManager().createQuery("SELECT c FROM Cliente c");

		List<Cliente> lista = query.getResultList();
		if (lista == null) {
			lista = new ArrayList<Cliente>();
		}
		return lista;
	}
}
