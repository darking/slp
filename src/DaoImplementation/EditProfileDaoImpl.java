package DaoImplementation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Model.Trainee;

public class EditProfileDaoImpl {

	//get the info from the DB,, needs Entity manager method to create it 
	
	//method to get the entity manager 
	public EntityManager getEditProfileEntityManager() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("tremble_persistence_unit");
		return emf.createEntityManager();
	}
	
	public Trainee getTrainee(int id){
		Trainee trainee;
		EntityManager em = this.getEditProfileEntityManager();
		
		Query q = em.createQuery("select t from Trainee t where t.id_trainee="+id);
		trainee = (Trainee) q.getSingleResult();

		
		return trainee;
	}

	public void editUserProfile(int id, Trainee t){
//		Trainee oldTrainee = getTrainee(id);
		
		EntityManager em = this.getEditProfileEntityManager();
		Trainee tempTrainee = em.find(Trainee.class, id);
		tempTrainee.setFirstname(t.getFirstname());
		tempTrainee.setEmail(t.getEmail());
		tempTrainee.setGrade(t.getGrade());
		tempTrainee.setPassword(t.getPassword());
//		tempTrainee.setId_Trainee(t.getId_Trainee());
		tempTrainee.setMobile(t.getMobile());
		tempTrainee.setSubject(t.getSubject());
		
		em.getTransaction().begin();
		em.merge(tempTrainee);
		em.getTransaction().commit();
		
	}
	
}
