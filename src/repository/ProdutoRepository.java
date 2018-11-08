package repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Produto;
import model.Usuario;

public class ProdutoRepository extends Repository<Produto> {

	public ProdutoRepository(EntityManager entityManager) {
		super(entityManager);
		
	}

	public List<Produto> getProdutos() {
		Query query = getEntityManager().createQuery("SELECT c FROM Produto c");
//		query.setParameter("descricao", "%" + descricao + "%");

		List<Produto> lista = query.getResultList();
		if (lista == null) {
			lista = new ArrayList<Produto>();
		}
		return lista;
	}
}
