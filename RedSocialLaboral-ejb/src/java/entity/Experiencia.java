/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author NetBeans
 */
@Entity
@Table(name = "EXPERIENCIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Experiencia.findAll", query = "SELECT e FROM Experiencia e")
    , @NamedQuery(name = "Experiencia.findById", query = "SELECT e FROM Experiencia e WHERE e.id = :id")
    , @NamedQuery(name = "Experiencia.findByFechainicio", query = "SELECT e FROM Experiencia e WHERE e.fechainicio = :fechainicio")
    , @NamedQuery(name = "Experiencia.findByFechafin", query = "SELECT e FROM Experiencia e WHERE e.fechafin = :fechafin")
    , @NamedQuery(name = "Experiencia.findByEmpresa", query = "SELECT e FROM Experiencia e WHERE e.empresa = :empresa")
    , @NamedQuery(name = "Experiencia.findByPuesto", query = "SELECT e FROM Experiencia e WHERE e.puesto = :puesto")
    , @NamedQuery(name = "Experiencia.findByWebempresa", query = "SELECT e FROM Experiencia e WHERE e.webempresa = :webempresa")
    // CONSULTAS PERSONALIZADAS
      // author: anton
    , @NamedQuery(name = "Experiencia.findByIdUsuario", query = "SELECT e FROM Experiencia e WHERE e.usuario.id = :id")})
public class Experiencia implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "EXPERIENCIA_SEQ")
    @SequenceGenerator(name="EXPERIENCIA_SEQ", sequenceName = "EXPERIENCIA_SEQ", allocationSize=1)
    private BigDecimal id;
    @Column(name = "FECHAINICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechainicio;
    @Column(name = "FECHAFIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechafin;
    @Size(max = 50)
    @Column(name = "EMPRESA")
    private String empresa;
    @Size(max = 50)
    @Column(name = "PUESTO")
    private String puesto;
    @Size(max = 50)
    @Column(name = "WEBEMPRESA")
    private String webempresa;
    @JoinColumn(name = "USUARIO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Experiencia() {
    }

    public Experiencia(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
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

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getWebempresa() {
        return webempresa;
    }

    public void setWebempresa(String webempresa) {
        this.webempresa = webempresa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Experiencia)) {
            return false;
        }
        Experiencia other = (Experiencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Experiencia[ id=" + id + " ]";
    }
    
}
