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
@Table(name = "nivel_academia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NivelAcademia.findAll", query = "SELECT n FROM NivelAcademia n"),
    @NamedQuery(name = "NivelAcademia.findByIdNivel", query = "SELECT n FROM NivelAcademia n WHERE n.idNivel = :idNivel"),
    @NamedQuery(name = "NivelAcademia.findByNombre", query = "SELECT n FROM NivelAcademia n WHERE n.nombre = :nombre"),
    @NamedQuery(name = "NivelAcademia.findByDescripcion", query = "SELECT n FROM NivelAcademia n WHERE n.descripcion = :descripcion"),
    @NamedQuery(name = "NivelAcademia.findByIdAcademia", query = "SELECT n FROM NivelAcademia n WHERE n.idAcademia = :idAcademia")})
public class NivelAcademia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_nivel")
    private Integer idNivel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_academia")
    private int idAcademia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNivel")
    private Collection<NivelPlan> nivelPlanCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNivel")
    private Collection<NivelOfertado> nivelOfertadoCollection;

    public NivelAcademia() {
    }

    public NivelAcademia(Integer idNivel) {
        this.idNivel = idNivel;
    }

    public NivelAcademia(Integer idNivel, String nombre, String descripcion, int idAcademia) {
        this.idNivel = idNivel;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idAcademia = idAcademia;
    }

    public Integer getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(Integer idNivel) {
        this.idNivel = idNivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdAcademia() {
        return idAcademia;
    }

    public void setIdAcademia(int idAcademia) {
        this.idAcademia = idAcademia;
    }

    @XmlTransient
    public Collection<NivelPlan> getNivelPlanCollection() {
        return nivelPlanCollection;
    }

    public void setNivelPlanCollection(Collection<NivelPlan> nivelPlanCollection) {
        this.nivelPlanCollection = nivelPlanCollection;
    }

    @XmlTransient
    public Collection<NivelOfertado> getNivelOfertadoCollection() {
        return nivelOfertadoCollection;
    }

    public void setNivelOfertadoCollection(Collection<NivelOfertado> nivelOfertadoCollection) {
        this.nivelOfertadoCollection = nivelOfertadoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNivel != null ? idNivel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelAcademia)) {
            return false;
        }
        NivelAcademia other = (NivelAcademia) object;
        if ((this.idNivel == null && other.idNivel != null) || (this.idNivel != null && !this.idNivel.equals(other.idNivel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.NivelAcademia[ idNivel=" + idNivel + " ]";
    }
    
}
