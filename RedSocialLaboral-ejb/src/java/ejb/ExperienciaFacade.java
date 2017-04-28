/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Experiencia;
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
public class ExperienciaFacade extends AbstractFacade<Experiencia> {

    @PersistenceContext(unitName = "RedSocialLaboral-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ExperienciaFacade() {
        super(Experiencia.class);
    }
    
    // author: Antonio Joaquín Luque
    public Collection<Experiencia> findByIdUsuario(BigDecimal id) {
        Query q = em.createNamedQuery("Experiencia.findByIdUsuario");
        q.setParameter("id", id);
        return q.getResultList();
    }
}