/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Inma
 */
@Entity
@Table(name = "OPERACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operacion.findAll", query = "SELECT o FROM Operacion o")
    , @NamedQuery(name = "Operacion.findByIdOperacion", query = "SELECT o FROM Operacion o WHERE o.idOperacion = :idOperacion")
    , @NamedQuery(name = "Operacion.findByObservacion", query = "SELECT o FROM Operacion o WHERE o.observacion = :observacion")})
public class Operacion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_OPERACION")
    private BigDecimal idOperacion;
    @Size(max = 500)
    @Column(name = "OBSERVACION")
    private String observacion;
    @JoinColumn(name = "ID_INCIDENCIA", referencedColumnName = "ID_INCIDENCIA")
    @ManyToOne
    private Incidencia idIncidencia;
    @JoinColumn(name = "ID_OPERADOR", referencedColumnName = "ID_OPERADOR")
    @ManyToOne
    private Operador idOperador;

    public Operacion() {
    }

    public Operacion(BigDecimal idOperacion) {
        this.idOperacion = idOperacion;
    }

    public BigDecimal getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(BigDecimal idOperacion) {
        this.idOperacion = idOperacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Incidencia getIdIncidencia() {
        return idIncidencia;
    }

    public void setIdIncidencia(Incidencia idIncidencia) {
        this.idIncidencia = idIncidencia;
    }

    public Operador getIdOperador() {
        return idOperador;
    }

    public void setIdOperador(Operador idOperador) {
        this.idOperador = idOperador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOperacion != null ? idOperacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operacion)) {
            return false;
        }
        Operacion other = (Operacion) object;
        if ((this.idOperacion == null && other.idOperacion != null) || (this.idOperacion != null && !this.idOperacion.equals(other.idOperacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Operacion[ idOperacion=" + idOperacion + " ]";
    }
    
}
