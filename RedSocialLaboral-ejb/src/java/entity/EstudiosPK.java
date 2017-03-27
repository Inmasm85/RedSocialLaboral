/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Inma
 */
@Embeddable
public class EstudiosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigInteger id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USUARIO")
    private BigInteger usuario;

    public EstudiosPK() {
    }

    public EstudiosPK(BigInteger id, BigInteger usuario) {
        this.id = id;
        this.usuario = usuario;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getUsuario() {
        return usuario;
    }

    public void setUsuario(BigInteger usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        hash += (usuario != null ? usuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstudiosPK)) {
            return false;
        }
        EstudiosPK other = (EstudiosPK) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        if ((this.usuario == null && other.usuario != null) || (this.usuario != null && !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.EstudiosPK[ id=" + id + ", usuario=" + usuario + " ]";
    }
    
}
