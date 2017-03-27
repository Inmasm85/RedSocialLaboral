/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Estudios;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Inma
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
    
}
