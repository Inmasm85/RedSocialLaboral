/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Aficion;
import java.math.BigDecimal;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Inma
 */
@Stateless
public class AficionFacade extends AbstractFacade<Aficion> {

    @PersistenceContext(unitName = "RedSocialLaboral-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AficionFacade() {
        super(Aficion.class);
    }
    
    public Collection<Aficion> findByIdUsuario(BigDecimal id) {
        Query q = em.createNamedQuery("Aficion.findByIdUsuario");
        q.setParameter("id", id);
        return q.getResultList();
    }
    
    public Aficion findByIdUsuarioAndNombreAficion(BigDecimal id, String nombre) {
        Query q = em.createNamedQuery("Aficion.findByIdUsuarioAndNombreAficion");
        q.setParameter("id", id);
        q.setParameter("nombre", nombre);
        return (Aficion) q.getResultList().get(0);
    }
}