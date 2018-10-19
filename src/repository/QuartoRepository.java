package repository;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Quarto;

public class QuartoRepository extends Repository<Quarto> {

	public QuartoRepository(EntityManager entityManager) {
		super(entityManager);
		
	}

	public List<Quarto> getQuartos(String numeroquarto) {
		Query query = getEntityManager().createQuery("SELECT c FROM Quarto c WHERE lower(c.numeroquarto) like(:numeroquarto)");
		query.setParameter("numeroquarto", "%" + numeroquarto + "%");

		List<Quarto> lista = query.getResultList();
		if (lista == null) {
			lista = new ArrayList<Quarto>();
		}
		return lista;
	}
	
	public List<Quarto> getOcupado() {
		Query query = getEntityManager().createNativeQuery("SELECT c FROM Quarto c WHERE c.ocupado = true");
//		query.setParameter("ocupado", "%" + ocupado + "%");
// (1,2,3,4,5) 1= id, 2=descricao, 3 = numeroquarto, 4=tipoquarto, 5=ocupado
		
		
		List<Quarto> lista = query.getResultList();

		
		if (lista == null) {
			lista = new ArrayList<Quarto>();
		}
		return lista;
	}
	
	public Object getCountQuartos() {
		Object contagem = null;
		
		Query query = getEntityManager().createNativeQuery("SELECT COUNT(0) from Quarto");
		contagem = query.getSingleResult();

		return contagem;
	}

	
}
