package controller;

import model.Estudante;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EstudanteDao {

    private EntityManagerFactory emf;
    private EntityManager em;

    public EstudanteDao() {
        this.emf = Persistence.createEntityManagerFactory("estudante");
        this.em = emf.createEntityManager();
    }

    public void create(Estudante estudante){
        em.getTransaction().begin();
        try{
            em.persist(estudante);
            em.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
