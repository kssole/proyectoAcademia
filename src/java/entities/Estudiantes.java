/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "estudiantes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiantes.findAll", query = "SELECT e FROM Estudiantes e"),
    @NamedQuery(name = "Estudiantes.findByIdEstudiantes", query = "SELECT e FROM Estudiantes e WHERE e.idEstudiantes = :idEstudiantes"),
    @NamedQuery(name = "Estudiantes.findByNombre", query = "SELECT e FROM Estudiantes e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Estudiantes.findByApellido", query = "SELECT e FROM Estudiantes e WHERE e.apellido = :apellido"),
    @NamedQuery(name = "Estudiantes.findByEmail", query = "SELECT e FROM Estudiantes e WHERE e.email = :email"),
    @NamedQuery(name = "Estudiantes.findByUser", query = "SELECT e FROM Estudiantes e WHERE e.user = :user"),
    @NamedQuery(name = "Estudiantes.findByContra", query = "SELECT e FROM Estudiantes e WHERE e.contra = :contra")})
public class Estudiantes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_estudiantes")
    private Integer idEstudiantes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "apellido")
    private String apellido;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Correo electrónico no válido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "user")
    private String user;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "contra")
    private String contra;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstudiantes")
    private Collection<NivelAprobado> nivelAprobadoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstudiantes")
    private Collection<NivelInscrito> nivelInscritoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstudiantes")
    private Collection<Expediente> expedienteCollection;

    public Estudiantes() {
    }

    public Estudiantes(Integer idEstudiantes) {
        this.idEstudiantes = idEstudiantes;
    }

    public Estudiantes(Integer idEstudiantes, String nombre, String apellido, String email, String user, String contra) {
        this.idEstudiantes = idEstudiantes;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.user = user;
        this.contra = contra;
    }

    public Integer getIdEstudiantes() {
        return idEstudiantes;
    }

    public void setIdEstudiantes(Integer idEstudiantes) {
        this.idEstudiantes = idEstudiantes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public Collection<NivelAprobado> getNivelAprobadoCollection() {
        return nivelAprobadoCollection;
    }

    public void setNivelAprobadoCollection(Collection<NivelAprobado> nivelAprobadoCollection) {
        this.nivelAprobadoCollection = nivelAprobadoCollection;
    }

    @XmlTransient
    public Collection<NivelInscrito> getNivelInscritoCollection() {
        return nivelInscritoCollection;
    }

    public void setNivelInscritoCollection(Collection<NivelInscrito> nivelInscritoCollection) {
        this.nivelInscritoCollection = nivelInscritoCollection;
    }

    @XmlTransient
    public Collection<Expediente> getExpedienteCollection() {
        return expedienteCollection;
    }

    public void setExpedienteCollection(Collection<Expediente> expedienteCollection) {
        this.expedienteCollection = expedienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstudiantes != null ? idEstudiantes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiantes)) {
            return false;
        }
        Estudiantes other = (Estudiantes) object;
        if ((this.idEstudiantes == null && other.idEstudiantes != null) || (this.idEstudiantes != null && !this.idEstudiantes.equals(other.idEstudiantes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Estudiantes[ idEstudiantes=" + idEstudiantes + " ]";
    }
    
}
