package repository;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Reserva;

public class ReservaRepository extends Repository<Reserva> {

	public ReservaRepository(EntityManager entityManager) {
		super(entityManager);
	}

	public List<Reserva> getReservas() {
		Query query = getEntityManager().createQuery("SELECT c FROM Reserva c");

		List<Reserva> lista = query.getResultList();
		if (lista == null) {
			lista = new ArrayList<Reserva>();
		}
		
		return lista;
	}
	


	
}
