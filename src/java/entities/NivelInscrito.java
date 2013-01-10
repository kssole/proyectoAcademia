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
@Table(name = "nivel_inscrito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NivelInscrito.findAll", query = "SELECT n FROM NivelInscrito n"),
    @NamedQuery(name = "NivelInscrito.findByIdNivelInscrito", query = "SELECT n FROM NivelInscrito n WHERE n.idNivelInscrito = :idNivelInscrito"),
    @NamedQuery(name = "NivelInscrito.findByAutorizacion", query = "SELECT n FROM NivelInscrito n WHERE n.autorizacion = :autorizacion")})
public class NivelInscrito implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_nivel_inscrito")
    private Integer idNivelInscrito;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "autorizacion")
    private String autorizacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNivelInscrito")
    private Collection<NivelAprobado> nivelAprobadoCollection;
    @JoinColumn(name = "id_nivel_ofertado", referencedColumnName = "id_nivel_ofertado")
    @ManyToOne(optional = false)
    private NivelOfertado idNivelOfertado;
    @JoinColumn(name = "id_estudiantes", referencedColumnName = "id_estudiantes")
    @ManyToOne(optional = false)
    private Estudiantes idEstudiantes;

    public NivelInscrito() {
    }

    public NivelInscrito(Integer idNivelInscrito) {
        this.idNivelInscrito = idNivelInscrito;
    }

    public NivelInscrito(Integer idNivelInscrito, String autorizacion) {
        this.idNivelInscrito = idNivelInscrito;
        this.autorizacion = autorizacion;
    }

    public Integer getIdNivelInscrito() {
        return idNivelInscrito;
    }

    public void setIdNivelInscrito(Integer idNivelInscrito) {
        this.idNivelInscrito = idNivelInscrito;
    }

    public String getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(String autorizacion) {
        this.autorizacion = autorizacion;
    }

    @XmlTransient
    public Collection<NivelAprobado> getNivelAprobadoCollection() {
        return nivelAprobadoCollection;
    }

    public void setNivelAprobadoCollection(Collection<NivelAprobado> nivelAprobadoCollection) {
        this.nivelAprobadoCollection = nivelAprobadoCollection;
    }

    public NivelOfertado getIdNivelOfertado() {
        return idNivelOfertado;
    }

    public void setIdNivelOfertado(NivelOfertado idNivelOfertado) {
        this.idNivelOfertado = idNivelOfertado;
    }

    public Estudiantes getIdEstudiantes() {
        return idEstudiantes;
    }

    public void setIdEstudiantes(Estudiantes idEstudiantes) {
        this.idEstudiantes = idEstudiantes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNivelInscrito != null ? idNivelInscrito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelInscrito)) {
            return false;
        }
        NivelInscrito other = (NivelInscrito) object;
        if ((this.idNivelInscrito == null && other.idNivelInscrito != null) || (this.idNivelInscrito != null && !this.idNivelInscrito.equals(other.idNivelInscrito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.NivelInscrito[ idNivelInscrito=" + idNivelInscrito + " ]";
    }
    
}
