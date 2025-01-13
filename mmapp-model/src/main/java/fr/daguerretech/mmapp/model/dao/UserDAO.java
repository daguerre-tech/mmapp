package fr.daguerretech.mmapp.model.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.daguerretech.mmapp.model.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserDAO {
	private static final Logger log = LoggerFactory.getLogger(UserDAO.class);

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("fr.daguerretech.web-demo.pu");
	private EntityManager em;

	public UserDAO() {
		em = emf.createEntityManager();

	}

	public void create(User user) {
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}

	public void update(User user) {
		em.getTransaction().begin();
		em.merge(user);
		em.getTransaction().commit();
	}

	public User read(User user) {
		em.getTransaction().begin();
		User myUser = em.find(User.class, user.getId());
		em.getTransaction().commit();
		return myUser;
	}

	public void delete(User user) {
		em.getTransaction().begin();
		em.remove(user);
		em.getTransaction().commit();
	}

	public void create(List<User> userList) {
		em.getTransaction().begin();
		userList.stream().forEach(u -> em.persist(u));
		em.getTransaction().commit();
	}
}
