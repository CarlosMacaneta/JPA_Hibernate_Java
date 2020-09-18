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
        em.getTransaction().begin();//iniciando conexoo com o banco
        try{
            em.persist(estudante);//persistencia no banco
            em.getTransaction().commit();///salvando os dados no banco
        } catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();//terminando conexao com o banco
        }
    }
}
