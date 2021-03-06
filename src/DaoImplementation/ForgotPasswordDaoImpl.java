package DaoImplementation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import Model.Trainee;

public class ForgotPasswordDaoImpl {

	//get the info from the DB,, needs Entity manager method to create it 
	
	//method to get the entity manager 
	public EntityManager getForgotPasswordEntityManager() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("tremble_persistence_unit");
		return emf.createEntityManager();
	}
	
	public Trainee getTrainee(int id){
		Trainee trainee;
		EntityManager em = this.getForgotPasswordEntityManager();
		
		Query q = em.createQuery("select t from Trainee t where t.id_trainee="+id);
		trainee = (Trainee) q.getSingleResult();

		
		return trainee;
	}

	public void forgotPassword(int id, Trainee t){
//		Trainee oldTrainee = getTrainee(id);
		
		EntityManager em = this.getForgotPasswordEntityManager();
		Trainee tempTrainee = em.find(Trainee.class, id);
		tempTrainee.setPassword(t.getPassword());
		
		em.getTransaction().begin();
		em.merge(tempTrainee);
		em.getTransaction().commit();
		
		
		
	}
	
	
}
