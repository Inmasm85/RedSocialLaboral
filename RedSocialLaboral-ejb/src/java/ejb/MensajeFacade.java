/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Mensaje;
import entity.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author NetBeans
 */
@Stateless
public class MensajeFacade extends AbstractFacade<Mensaje> {

    @PersistenceContext(unitName = "RedSocialLaboral-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MensajeFacade() {
        super(Mensaje.class);
    }
    
    // author: Antonio Joaquín Luque
    public List<Mensaje> findByEmisor(Usuario usuario) {
        Query q;
        
        q = em.createNamedQuery("Mensaje.findByEmisor");
        q.setParameter("emisor", usuario);
        return q.getResultList(); 
    }
    
    // author: Antonio Joaquín Luque
    public List<Mensaje> findByReceptor(Usuario usuario) {
        Query q;
        
        q = em.createNamedQuery("Mensaje.findByReceptor");
        q.setParameter("receptor", usuario);
        return q.getResultList(); 
    }
    
    // author: Antonio Joaquín Luque
    public List<Mensaje> findByVistoYReceptor(char c, Usuario usuario) {
        Query q;
        
        q = em.createNamedQuery("Mensaje.findByVistoYReceptor");
        q.setParameter("visto", c);
        q.setParameter("receptor", usuario);
        return q.getResultList(); 
    }

}
