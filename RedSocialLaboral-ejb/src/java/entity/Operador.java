/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Inma
 */
@Entity
@Table(name = "OPERADOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operador.findAll", query = "SELECT o FROM Operador o")
    , @NamedQuery(name = "Operador.findByIdOperador", query = "SELECT o FROM Operador o WHERE o.idOperador = :idOperador")
    , @NamedQuery(name = "Operador.findByNombre", query = "SELECT o FROM Operador o WHERE o.nombre = :nombre")
    , @NamedQuery(name = "Operador.findByPassword", query = "SELECT o FROM Operador o WHERE o.password = :password")
    , @NamedQuery(name = "Operador.findByEmail", query = "SELECT o FROM Operador o WHERE o.email = :email")})
public class Operador implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_OPERADOR")
    private BigDecimal idOperador;
    @Size(max = 45)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 45)
    @Column(name = "PASSWORD")
    private String password;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "EMAIL")
    private String email;
    @OneToMany(mappedBy = "idOperador")
    private Collection<Incidencia> incidenciaCollection;
    @OneToMany(mappedBy = "idOperador")
    private Collection<Operacion> operacionCollection;

    public Operador() {
    }

    public Operador(BigDecimal idOperador) {
        this.idOperador = idOperador;
    }

    public BigDecimal getIdOperador() {
        return idOperador;
    }

    public void setIdOperador(BigDecimal idOperador) {
        this.idOperador = idOperador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<Incidencia> getIncidenciaCollection() {
        return incidenciaCollection;
    }

    public void setIncidenciaCollection(Collection<Incidencia> incidenciaCollection) {
        this.incidenciaCollection = incidenciaCollection;
    }

    @XmlTransient
    public Collection<Operacion> getOperacionCollection() {
        return operacionCollection;
    }

    public void setOperacionCollection(Collection<Operacion> operacionCollection) {
        this.operacionCollection = operacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOperador != null ? idOperador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operador)) {
            return false;
        }
        Operador other = (Operador) object;
        if ((this.idOperador == null && other.idOperador != null) || (this.idOperador != null && !this.idOperador.equals(other.idOperador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Operador[ idOperador=" + idOperador + " ]";
    }
    
}
