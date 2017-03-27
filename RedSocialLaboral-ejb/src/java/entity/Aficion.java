/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Inma
 */
@Entity
@Table(name = "AFICION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aficion.findAll", query = "SELECT a FROM Aficion a")
    , @NamedQuery(name = "Aficion.findByNombre", query = "SELECT a FROM Aficion a WHERE a.aficionPK.nombre = :nombre")
    , @NamedQuery(name = "Aficion.findByUsuario", query = "SELECT a FROM Aficion a WHERE a.aficionPK.usuario = :usuario")})
public class Aficion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AficionPK aficionPK;
    @JoinColumn(name = "USUARIO", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario1;

    public Aficion() {
    }

    public Aficion(AficionPK aficionPK) {
        this.aficionPK = aficionPK;
    }

    public Aficion(String nombre, BigInteger usuario) {
        this.aficionPK = new AficionPK(nombre, usuario);
    }

    public AficionPK getAficionPK() {
        return aficionPK;
    }

    public void setAficionPK(AficionPK aficionPK) {
        this.aficionPK = aficionPK;
    }

    public Usuario getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aficionPK != null ? aficionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aficion)) {
            return false;
        }
        Aficion other = (Aficion) object;
        if ((this.aficionPK == null && other.aficionPK != null) || (this.aficionPK != null && !this.aficionPK.equals(other.aficionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Aficion[ aficionPK=" + aficionPK + " ]";
    }
    
}
