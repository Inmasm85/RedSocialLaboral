/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

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
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "RedSocialLaboral-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    // author: Roberto Sanchez
    public Usuario findByEmail(String email) {
        Query q = em.createNamedQuery("Usuario.findByEmail");
        q.setParameter("email", email);
        List<Usuario> lu = q.getResultList();
        return lu.isEmpty() ? null : lu.get(0);
    }
}
