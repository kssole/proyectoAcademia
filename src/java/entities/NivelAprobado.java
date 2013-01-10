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
@Table(name = "nivel_aprobado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NivelAprobado.findAll", query = "SELECT n FROM NivelAprobado n"),
    @NamedQuery(name = "NivelAprobado.findByIdNivelAprobado", query = "SELECT n FROM NivelAprobado n WHERE n.idNivelAprobado = :idNivelAprobado"),
    @NamedQuery(name = "NivelAprobado.findByEstado", query = "SELECT n FROM NivelAprobado n WHERE n.estado = :estado")})
public class NivelAprobado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_nivel_aprobado")
    private Integer idNivelAprobado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "id_nivel_inscrito", referencedColumnName = "id_nivel_inscrito")
    @ManyToOne(optional = false)
    private NivelInscrito idNivelInscrito;
    @JoinColumn(name = "id_estudiantes", referencedColumnName = "id_estudiantes")
    @ManyToOne(optional = false)
    private Estudiantes idEstudiantes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNivelAprobado")
    private Collection<Expediente> expedienteCollection;

    public NivelAprobado() {
    }

    public NivelAprobado(Integer idNivelAprobado) {
        this.idNivelAprobado = idNivelAprobado;
    }

    public NivelAprobado(Integer idNivelAprobado, String estado) {
        this.idNivelAprobado = idNivelAprobado;
        this.estado = estado;
    }

    public Integer getIdNivelAprobado() {
        return idNivelAprobado;
    }

    public void setIdNivelAprobado(Integer idNivelAprobado) {
        this.idNivelAprobado = idNivelAprobado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public NivelInscrito getIdNivelInscrito() {
        return idNivelInscrito;
    }

    public void setIdNivelInscrito(NivelInscrito idNivelInscrito) {
        this.idNivelInscrito = idNivelInscrito;
    }

    public Estudiantes getIdEstudiantes() {
        return idEstudiantes;
    }

    public void setIdEstudiantes(Estudiantes idEstudiantes) {
        this.idEstudiantes = idEstudiantes;
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
        hash += (idNivelAprobado != null ? idNivelAprobado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelAprobado)) {
            return false;
        }
        NivelAprobado other = (NivelAprobado) object;
        if ((this.idNivelAprobado == null && other.idNivelAprobado != null) || (this.idNivelAprobado != null && !this.idNivelAprobado.equals(other.idNivelAprobado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.NivelAprobado[ idNivelAprobado=" + idNivelAprobado + " ]";
    }
    
}
