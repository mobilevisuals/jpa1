package simplejpa;

import entity.Person;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
public class SimpleJPA {
public static void main(String args[]){
Person p = new Person();
p.setName("Hendro Steven");
p.setAddress("Salatiga, Indonesia");


SimpleJPA demo = new SimpleJPA();
demo.persist(p);
}

public void persist(Object object) {
EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("SimpleJPAPU");
EntityManager em = emf.createEntityManager();
em.getTransaction().begin();
try {
em.persist(object);
em.getTransaction().commit();
} catch (Exception e) {
e.printStackTrace();
em.getTransaction().rollback();
} finally {
em.close();
}
}
}