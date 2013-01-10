/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "nivel_ofertado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NivelOfertado.findAll", query = "SELECT n FROM NivelOfertado n"),
    @NamedQuery(name = "NivelOfertado.findByIdNivelOfertado", query = "SELECT n FROM NivelOfertado n WHERE n.idNivelOfertado = :idNivelOfertado"),
    @NamedQuery(name = "NivelOfertado.findByCupos", query = "SELECT n FROM NivelOfertado n WHERE n.cupos = :cupos")})
public class NivelOfertado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_nivel_ofertado")
    private Integer idNivelOfertado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cupos")
    private int cupos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNivelOfertado")
    private Collection<NivelInscrito> nivelInscritoCollection;
    @JoinColumn(name = "id_academia", referencedColumnName = "id_academia")
    @ManyToOne(optional = false)
    private Academia idAcademia;
    @JoinColumn(name = "id_nivel", referencedColumnName = "id_nivel")
    @ManyToOne(optional = false)
    private NivelAcademia idNivel;

    public NivelOfertado() {
    }

    public NivelOfertado(Integer idNivelOfertado) {
        this.idNivelOfertado = idNivelOfertado;
    }

    public NivelOfertado(Integer idNivelOfertado, int cupos) {
        this.idNivelOfertado = idNivelOfertado;
        this.cupos = cupos;
    }

    public Integer getIdNivelOfertado() {
        return idNivelOfertado;
    }

    public void setIdNivelOfertado(Integer idNivelOfertado) {
        this.idNivelOfertado = idNivelOfertado;
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }

    @XmlTransient
    public Collection<NivelInscrito> getNivelInscritoCollection() {
        return nivelInscritoCollection;
    }

    public void setNivelInscritoCollection(Collection<NivelInscrito> nivelInscritoCollection) {
        this.nivelInscritoCollection = nivelInscritoCollection;
    }

    public Academia getIdAcademia() {
        return idAcademia;
    }

    public void setIdAcademia(Academia idAcademia) {
        this.idAcademia = idAcademia;
    }

    public NivelAcademia getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(NivelAcademia idNivel) {
        this.idNivel = idNivel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNivelOfertado != null ? idNivelOfertado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelOfertado)) {
            return false;
        }
        NivelOfertado other = (NivelOfertado) object;
        if ((this.idNivelOfertado == null && other.idNivelOfertado != null) || (this.idNivelOfertado != null && !this.idNivelOfertado.equals(other.idNivelOfertado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.NivelOfertado[ idNivelOfertado=" + idNivelOfertado + " ]";
    }
    
}
