/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Inma
 */
@Entity
@Table(name = "ESTUDIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudios.findAll", query = "SELECT e FROM Estudios e")
    , @NamedQuery(name = "Estudios.findById", query = "SELECT e FROM Estudios e WHERE e.estudiosPK.id = :id")
    , @NamedQuery(name = "Estudios.findByUsuario", query = "SELECT e FROM Estudios e WHERE e.estudiosPK.usuario = :usuario")
    , @NamedQuery(name = "Estudios.findByFechainicio", query = "SELECT e FROM Estudios e WHERE e.fechainicio = :fechainicio")
    , @NamedQuery(name = "Estudios.findByFechafin", query = "SELECT e FROM Estudios e WHERE e.fechafin = :fechafin")
    , @NamedQuery(name = "Estudios.findByUbicacion", query = "SELECT e FROM Estudios e WHERE e.ubicacion = :ubicacion")
    , @NamedQuery(name = "Estudios.findByDescripcion", query = "SELECT e FROM Estudios e WHERE e.descripcion = :descripcion")})
public class Estudios implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EstudiosPK estudiosPK;
    @Column(name = "FECHAINICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechainicio;
    @Column(name = "FECHAFIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechafin;
    @Size(max = 100)
    @Column(name = "UBICACION")
    private String ubicacion;
    @Size(max = 200)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinColumn(name = "USUARIO", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario1;

    public Estudios() {
    }

    public Estudios(EstudiosPK estudiosPK) {
        this.estudiosPK = estudiosPK;
    }

    public Estudios(BigInteger id, BigInteger usuario) {
        this.estudiosPK = new EstudiosPK(id, usuario);
    }

    public EstudiosPK getEstudiosPK() {
        return estudiosPK;
    }

    public void setEstudiosPK(EstudiosPK estudiosPK) {
        this.estudiosPK = estudiosPK;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (estudiosPK != null ? estudiosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudios)) {
            return false;
        }
        Estudios other = (Estudios) object;
        if ((this.estudiosPK == null && other.estudiosPK != null) || (this.estudiosPK != null && !this.estudiosPK.equals(other.estudiosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Estudios[ estudiosPK=" + estudiosPK + " ]";
    }
    
}
