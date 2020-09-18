package controller;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Estudante;

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
    
    public ArrayList<Estudante> list(){
        em.getTransaction().begin();
        /*try{
            em.createQuery("SELECT * FROM estudante");
            em.
        }*/
        return null;
    }
    
    public Estudante findEstudante(long id) {
        try {
            return em.find(Estudante.class, id);
        } finally {
            em.close();
        }
    }
    
    public ArrayList<Estudante> findEstudante(String nome){
        ArrayList<Estudante> est = new ArrayList();
        try{
            est.add(em.find(Estudante.class, nome));
        }finally{
            em.close();
        }
        return est;
    }
    
    public void edit(Estudante estudante) {
        em.getTransaction().begin();
        try {            
            estudante = em.merge(estudante);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = estudante.getId();
                if (findEstudante(id) == null) {
                    throw new Error("The newEntity with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {            
            em.close();            
        }
    }

    public void delete(long id){
        em.getTransaction().begin();
        Estudante estudante;
        try{
            estudante = em.getReference(Estudante.class, id);
            estudante.getId();
            
            em.remove(estudante);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            em.close();
        }
    }
}
