/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Inma
 */
@Entity
@Table(name = "INCIDENCIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Incidencia.findAll", query = "SELECT i FROM Incidencia i")
    , @NamedQuery(name = "Incidencia.findByIdIncidencia", query = "SELECT i FROM Incidencia i WHERE i.idIncidencia = :idIncidencia")
    , @NamedQuery(name = "Incidencia.findByDireccion", query = "SELECT i FROM Incidencia i WHERE i.direccion = :direccion")
    , @NamedQuery(name = "Incidencia.findByFecha", query = "SELECT i FROM Incidencia i WHERE i.fecha = :fecha")
    , @NamedQuery(name = "Incidencia.findByNombre", query = "SELECT i FROM Incidencia i WHERE i.nombre = :nombre")
    , @NamedQuery(name = "Incidencia.findByObservaciones", query = "SELECT i FROM Incidencia i WHERE i.observaciones = :observaciones")
    , @NamedQuery(name = "Incidencia.findByEmail", query = "SELECT i FROM Incidencia i WHERE i.email = :email")
    , @NamedQuery(name = "Incidencia.findByLat", query = "SELECT i FROM Incidencia i WHERE i.lat = :lat")
    , @NamedQuery(name = "Incidencia.findByLng", query = "SELECT i FROM Incidencia i WHERE i.lng = :lng")
    , @NamedQuery(name = "Incidencia.findByPitch", query = "SELECT i FROM Incidencia i WHERE i.pitch = :pitch")
    , @NamedQuery(name = "Incidencia.findByHeading", query = "SELECT i FROM Incidencia i WHERE i.heading = :heading")})
public class Incidencia implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_INCIDENCIA")
    private BigDecimal idIncidencia;
    @Size(max = 200)
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Size(max = 45)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 500)
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 25)
    @Column(name = "LAT")
    private String lat;
    @Size(max = 25)
    @Column(name = "LNG")
    private String lng;
    @Size(max = 25)
    @Column(name = "PITCH")
    private String pitch;
    @Size(max = 25)
    @Column(name = "HEADING")
    private String heading;
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    @ManyToOne
    private Cliente idCliente;
    @JoinColumn(name = "ID_OPERADOR", referencedColumnName = "ID_OPERADOR")
    @ManyToOne
    private Operador idOperador;
    @OneToMany(mappedBy = "idIncidencia")
    private Collection<Operacion> operacionCollection;

    public Incidencia() {
    }

    public Incidencia(BigDecimal idIncidencia) {
        this.idIncidencia = idIncidencia;
    }

    public BigDecimal getIdIncidencia() {
        return idIncidencia;
    }

    public void setIdIncidencia(BigDecimal idIncidencia) {
        this.idIncidencia = idIncidencia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getPitch() {
        return pitch;
    }

    public void setPitch(String pitch) {
        this.pitch = pitch;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Operador getIdOperador() {
        return idOperador;
    }

    public void setIdOperador(Operador idOperador) {
        this.idOperador = idOperador;
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
        hash += (idIncidencia != null ? idIncidencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Incidencia)) {
            return false;
        }
        Incidencia other = (Incidencia) object;
        if ((this.idIncidencia == null && other.idIncidencia != null) || (this.idIncidencia != null && !this.idIncidencia.equals(other.idIncidencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Incidencia[ idIncidencia=" + idIncidencia + " ]";
    }
    
}
