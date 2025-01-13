package fr.daguerretech.mmapp.model.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.daguerretech.mmapp.model.entity.User;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserDAOTest {

	private static final Logger log = LoggerFactory.getLogger(UserDAOTest.class);

	private UserDAO userDao;

	private User refUser, tstUser;
	@BeforeAll
	protected void setUp() {
		// initialisation de la persistance
		userDao = new UserDAO();

		// initialisation des donnees de references
		refUser = new User();
		refUser.setName("John Doe");
		refUser.setEmail("john.doe@example.com");

		// initialisation des donnees a tester
		tstUser = new User();
	}



//	@AfterEach
//	public void tearDown() {
//		// Clean up after each test
//		Transaction transaction = null;
//
//		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//			transaction = session.beginTransaction();
//			session.createQuery("DELETE FROM Student").executeUpdate();
//			transaction.commit();
//		} catch (Exception e) {
//			if (transaction != null) {
//				transaction.rollback();
//			}
//			e.printStackTrace();
//		}
//	}

	/**
	 * test de creation de l'utilisateur
	 */
	@Test
	public void testCreateUser() {

		userDao.create(refUser);

		tstUser = userDao.read(refUser);
		assertNotNull(tstUser);
		assertEquals(tstUser.getName(), refUser.getName());

	}

	/**
	 * test dee modification de l'utilisateur
	 */
	@Test
	public void testUpdateUser() {
		userDao.create(refUser);

		tstUser = userDao.read(refUser);
		tstUser.setName("Jane Doe");
		tstUser.setEmail("jane.doe@example.Com");
		userDao.update(tstUser);

		User myUserModified = userDao.read(tstUser);

		if(log.isTraceEnabled())
		{
			log.trace("utilisateur de reference"+refUser);
			log.trace("utilisateur de test"+tstUser);
		}

		assertNotNull(tstUser);
		assertEquals(tstUser.getName(), myUserModified.getName());
		assertEquals(tstUser.getEmail(), myUserModified.getEmail());

	}

	@Test
	public void testDeleteUser() {

		userDao.create(refUser);

		userDao.delete(refUser);

		User tstUser = userDao.read(refUser);
		assertNull(tstUser);


	}
	@Test
	public void testBulkCreateUser() throws Throwable {

//		userDao.create(refUser);
		List<User> userList = new ArrayList<>();
		for(int i=0; i<20;i++)
		{
			log.debug(String.valueOf(i));
			tstUser = new User();
			tstUser.setName("name "+ String.valueOf(i));
			tstUser.setEmail("mail "+ String.valueOf(i));
			userList.add(tstUser);

		}
		userDao.create(userList);
		for(int i=0; i<100;i++)
		{
			log.debug(String.valueOf(i));
			tstUser = new User();
			tstUser.setName("name "+ String.valueOf(i));
			tstUser.setEmail("mail "+ String.valueOf(i));
			userList.add(tstUser);

		}
		userDao.create(userList);




	}

}