/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "inscribirse")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inscribirse.findAll", query = "SELECT i FROM Inscribirse i"),
    @NamedQuery(name = "Inscribirse.findByIdInscrito", query = "SELECT i FROM Inscribirse i WHERE i.idInscrito = :idInscrito"),
    @NamedQuery(name = "Inscribirse.findByNombreUsuario", query = "SELECT i FROM Inscribirse i WHERE i.nombreUsuario = :nombreUsuario"),
    @NamedQuery(name = "Inscribirse.findByIdEstudiante", query = "SELECT i FROM Inscribirse i WHERE i.idEstudiante = :idEstudiante"),
    @NamedQuery(name = "Inscribirse.findByNombreAcademia", query = "SELECT i FROM Inscribirse i WHERE i.nombreAcademia = :nombreAcademia"),
    @NamedQuery(name = "Inscribirse.findByNivelAcademia", query = "SELECT i FROM Inscribirse i WHERE i.nivelAcademia = :nivelAcademia"),
    @NamedQuery(name = "Inscribirse.findByAula", query = "SELECT i FROM Inscribirse i WHERE i.aula = :aula"),
    @NamedQuery(name = "Inscribirse.findByHorario", query = "SELECT i FROM Inscribirse i WHERE i.horario = :horario"),
    @NamedQuery(name = "Inscribirse.findByInstructor", query = "SELECT i FROM Inscribirse i WHERE i.instructor = :instructor"),
    @NamedQuery(name = "Inscribirse.findByNivelAprobado", query = "SELECT i FROM Inscribirse i WHERE i.nivelAprobado = :nivelAprobado"),
    @NamedQuery(name = "Inscribirse.findByInscrito", query = "SELECT i FROM Inscribirse i WHERE i.inscrito = :inscrito"),
    @NamedQuery(name = "Inscribirse.findByNivelInscrito", query = "SELECT i FROM Inscribirse i WHERE i.nivelInscrito = :nivelInscrito"),
    @NamedQuery(name = "Inscribirse.findByContra", query = "SELECT i FROM Inscribirse i WHERE i.contra = :contra")})
public class Inscribirse implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_inscrito")
    private Integer idInscrito;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_estudiante")
    private int idEstudiante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nombre_Academia")
    private String nombreAcademia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nivel_academia")
    private int nivelAcademia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "aula")
    private String aula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "horario")
    private String horario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "instructor")
    private String instructor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nivel_aprobado")
    private int nivelAprobado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inscrito")
    private int inscrito;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nivel_inscrito")
    private int nivelInscrito;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "contra")
    private String contra;

    public Inscribirse() {
    }

    public Inscribirse(Integer idInscrito) {
        this.idInscrito = idInscrito;
    }

    public Inscribirse(Integer idInscrito, String nombreUsuario, int idEstudiante, String nombreAcademia, int nivelAcademia, String aula, String horario, String instructor, int nivelAprobado, int inscrito, int nivelInscrito, String contra) {
        this.idInscrito = idInscrito;
        this.nombreUsuario = nombreUsuario;
        this.idEstudiante = idEstudiante;
        this.nombreAcademia = nombreAcademia;
        this.nivelAcademia = nivelAcademia;
        this.aula = aula;
        this.horario = horario;
        this.instructor = instructor;
        this.nivelAprobado = nivelAprobado;
        this.inscrito = inscrito;
        this.nivelInscrito = nivelInscrito;
        this.contra = contra;
    }

    public Integer getIdInscrito() {
        return idInscrito;
    }

    public void setIdInscrito(Integer idInscrito) {
        this.idInscrito = idInscrito;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombreAcademia() {
        return nombreAcademia;
    }

    public void setNombreAcademia(String nombreAcademia) {
        this.nombreAcademia = nombreAcademia;
    }

    public int getNivelAcademia() {
        return nivelAcademia;
    }

    public void setNivelAcademia(int nivelAcademia) {
        this.nivelAcademia = nivelAcademia;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getNivelAprobado() {
        return nivelAprobado;
    }

    public void setNivelAprobado(int nivelAprobado) {
        this.nivelAprobado = nivelAprobado;
    }

    public int getInscrito() {
        return inscrito;
    }

    public void setInscrito(int inscrito) {
        this.inscrito = inscrito;
    }

    public int getNivelInscrito() {
        return nivelInscrito;
    }

    public void setNivelInscrito(int nivelInscrito) {
        this.nivelInscrito = nivelInscrito;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInscrito != null ? idInscrito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inscribirse)) {
            return false;
        }
        Inscribirse other = (Inscribirse) object;
        if ((this.idInscrito == null && other.idInscrito != null) || (this.idInscrito != null && !this.idInscrito.equals(other.idInscrito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Inscribirse[ idInscrito=" + idInscrito + " ]";
    }
    
}
