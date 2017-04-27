/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Estudios;
import java.math.BigDecimal;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author NetBeans
 */
@Stateless
public class EstudiosFacade extends AbstractFacade<Estudios> {

    @PersistenceContext(unitName = "RedSocialLaboral-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstudiosFacade() {
        super(Estudios.class);
    }
    
    // author: Roberto Sanchez
    public Collection<Estudios> findByIdUsuario(BigDecimal id) {
        Query q = em.createNamedQuery("Estudios.findByIdUsuario");
        q.setParameter("id", id);
        return q.getResultList();
    }
}
