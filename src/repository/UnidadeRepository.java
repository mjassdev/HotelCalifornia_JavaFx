package repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Unidade;

public class UnidadeRepository extends Repository<Unidade>{

	public UnidadeRepository(EntityManager entityManager) {
		super(entityManager);
	}

	public List<Unidade> getListUnidades(){
		Query query = getEntityManager().createQuery("SELECT u FROM Unidade u");

		List<Unidade> lista = query.getResultList();
		if(lista == null) {
			lista = new ArrayList<Unidade>();
		}
		return lista;
	}
}
