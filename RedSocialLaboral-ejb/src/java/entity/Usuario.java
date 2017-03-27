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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id")
    , @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email")
    , @NamedQuery(name = "Usuario.findByPass", query = "SELECT u FROM Usuario u WHERE u.pass = :pass")
    , @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Usuario.findByApellidos", query = "SELECT u FROM Usuario u WHERE u.apellidos = :apellidos")
    , @NamedQuery(name = "Usuario.findByTwitter", query = "SELECT u FROM Usuario u WHERE u.twitter = :twitter")
    , @NamedQuery(name = "Usuario.findByInstagram", query = "SELECT u FROM Usuario u WHERE u.instagram = :instagram")
    , @NamedQuery(name = "Usuario.findByWeb", query = "SELECT u FROM Usuario u WHERE u.web = :web")
    , @NamedQuery(name = "Usuario.findByFoto", query = "SELECT u FROM Usuario u WHERE u.foto = :foto")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PASS")
    private String pass;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 50)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Size(max = 50)
    @Column(name = "TWITTER")
    private String twitter;
    @Size(max = 50)
    @Column(name = "INSTAGRAM")
    private String instagram;
    @Size(max = 50)
    @Column(name = "WEB")
    private String web;
    @Size(max = 100)
    @Column(name = "FOTO")
    private String foto;
    @JoinTable(name = "CONTACTO", joinColumns = {
        @JoinColumn(name = "CONTACTO", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "USUARIO", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Usuario> usuarioCollection;
    @ManyToMany(mappedBy = "usuarioCollection")
    private Collection<Usuario> usuarioCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario1")
    private Collection<Estudios> estudiosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario1")
    private Collection<Aficion> aficionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Collection<Experiencia> experienciaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Collection<Solicitud> solicitudCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario1")
    private Collection<Solicitud> solicitudCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "emisor")
    private Collection<Mensaje> mensajeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receptor")
    private Collection<Mensaje> mensajeCollection1;

    public Usuario() {
    }

    public Usuario(BigDecimal id) {
        this.id = id;
    }

    public Usuario(BigDecimal id, String email, String pass, String nombre) {
        this.id = id;
        this.email = email;
        this.pass = pass;
        this.nombre = nombre;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection1() {
        return usuarioCollection1;
    }

    public void setUsuarioCollection1(Collection<Usuario> usuarioCollection1) {
        this.usuarioCollection1 = usuarioCollection1;
    }

    @XmlTransient
    public Collection<Estudios> getEstudiosCollection() {
        return estudiosCollection;
    }

    public void setEstudiosCollection(Collection<Estudios> estudiosCollection) {
        this.estudiosCollection = estudiosCollection;
    }

    @XmlTransient
    public Collection<Aficion> getAficionCollection() {
        return aficionCollection;
    }

    public void setAficionCollection(Collection<Aficion> aficionCollection) {
        this.aficionCollection = aficionCollection;
    }

    @XmlTransient
    public Collection<Experiencia> getExperienciaCollection() {
        return experienciaCollection;
    }

    public void setExperienciaCollection(Collection<Experiencia> experienciaCollection) {
        this.experienciaCollection = experienciaCollection;
    }

    @XmlTransient
    public Collection<Solicitud> getSolicitudCollection() {
        return solicitudCollection;
    }

    public void setSolicitudCollection(Collection<Solicitud> solicitudCollection) {
        this.solicitudCollection = solicitudCollection;
    }

    @XmlTransient
    public Collection<Solicitud> getSolicitudCollection1() {
        return solicitudCollection1;
    }

    public void setSolicitudCollection1(Collection<Solicitud> solicitudCollection1) {
        this.solicitudCollection1 = solicitudCollection1;
    }

    @XmlTransient
    public Collection<Mensaje> getMensajeCollection() {
        return mensajeCollection;
    }

    public void setMensajeCollection(Collection<Mensaje> mensajeCollection) {
        this.mensajeCollection = mensajeCollection;
    }

    @XmlTransient
    public Collection<Mensaje> getMensajeCollection1() {
        return mensajeCollection1;
    }

    public void setMensajeCollection1(Collection<Mensaje> mensajeCollection1) {
        this.mensajeCollection1 = mensajeCollection1;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Usuario[ id=" + id + " ]";
    }
    
}
