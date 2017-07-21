package introsde.document.model;

import introsde.document.dao.LifeCoachDao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Cacheable(false)
@Table(name = "\"Person\"")
@NamedQueries({ @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
				@NamedQuery(name = "Person.findId", query = "SELECT p FROM Person p WHERE p.username=?1")
})
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "sqlite_person")
	@TableGenerator(name = "sqlite_person", table = "sqlite_sequence", pkColumnName = "name", valueColumnName = "seq", pkColumnValue = "Person")
	@Column(name = "\"idPerson\"")
	@XmlElement(name = "personId")
	private int personId;

	@Column(name = "\"username\"")
	@XmlElement
	private String username;

	@Column(name = "\"password\"")
	@XmlElement
	private String password;

	//@Temporal(TemporalType.DATE)
	@Column(name = "\"birthdate\"")
	@XmlElement
	private String birthdate;

	// mappedBy must be equal to the name of the attribute in LifeStatus that
	// maps this relation
	//@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	public List<Goal> goals;
	// Getters
	public int getIdPerson() {
		return personId;
	}

	public String getUserName() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getBirthdate() {
		return birthdate;
	}
	// Setters
	public void setIdPerson(int idPerson) {
		this.personId = idPerson;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setBirthdate(String birthdate){
		this.birthdate = birthdate;
	}

//	public void setCurrentHealth(List<Goal> currentGoal) {
//		this.goals = currentGoal;
//	}

	public String toString() {
		return "Person ( " + personId + " " + username + " " + password + " "
				+ birthdate + " )";
	}

	// database operations
	public static Person getPersonById(int id) {
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		// em.getEntityManagerFactory().getCache().evictAll();
		Person p = em.find(Person.class, id);
		LifeCoachDao.instance.closeConnections(em);
		return p;
	}
	//used to find the id by the username
	public static int getIdByUsername(String username){
		int id=0;
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		Person p = em.createNamedQuery("Person.findId",Person.class).setParameter(1, username).getSingleResult();
		id=p.getIdPerson();
		LifeCoachDao.instance.closeConnections(em);
		return id;
		
	}

	public static List<Person> getAll() {
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		// em.getEntityManagerFactory().getCache().evictAll();
		List<Person> list = em.createNamedQuery("Person.findAll", Person.class)
				.getResultList();
		LifeCoachDao.instance.closeConnections(em);
		return list;
	}

	public static Person savePerson(Person p) {
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(p);
		tx.commit();
		LifeCoachDao.instance.closeConnections(em);
		return p;
	}

	public static Person updatePerson(Person p) {
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		p = em.merge(p);
		tx.commit();
		LifeCoachDao.instance.closeConnections(em);
		return p;
	}

	public static void removePerson(Person p) {
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		p = em.merge(p);
		em.remove(p);
		tx.commit();
		LifeCoachDao.instance.closeConnections(em);
	}
	public static List<Person> getAll2() {
		System.out.println("--> Initializing Entity manager...");
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		System.out.println("--> Querying the database for all the people...");
	    List<Person> list = em.createNamedQuery("Person.findAll", Person.class).getResultList();
		System.out.println("--> Closing connections of entity manager...");
	    LifeCoachDao.instance.closeConnections(em);
	    return list;
	}
}
