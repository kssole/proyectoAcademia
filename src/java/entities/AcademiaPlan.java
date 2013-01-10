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
@Table(name = "academia_plan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AcademiaPlan.findAll", query = "SELECT a FROM AcademiaPlan a"),
    @NamedQuery(name = "AcademiaPlan.findByIdAcademiaPlan", query = "SELECT a FROM AcademiaPlan a WHERE a.idAcademiaPlan = :idAcademiaPlan"),
    @NamedQuery(name = "AcademiaPlan.findByPeriodo", query = "SELECT a FROM AcademiaPlan a WHERE a.periodo = :periodo")})
public class AcademiaPlan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_academia_plan")
    private Integer idAcademiaPlan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "periodo")
    private String periodo;
    @JoinColumn(name = "id_academia", referencedColumnName = "id_academia")
    @ManyToOne(optional = false)
    private Academia idAcademia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAcademiaPlan")
    private Collection<NivelPlan> nivelPlanCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAcademiaPlan")
    private Collection<Expediente> expedienteCollection;

    public AcademiaPlan() {
    }

    public AcademiaPlan(Integer idAcademiaPlan) {
        this.idAcademiaPlan = idAcademiaPlan;
    }

    public AcademiaPlan(Integer idAcademiaPlan, String periodo) {
        this.idAcademiaPlan = idAcademiaPlan;
        this.periodo = periodo;
    }

    public Integer getIdAcademiaPlan() {
        return idAcademiaPlan;
    }

    public void setIdAcademiaPlan(Integer idAcademiaPlan) {
        this.idAcademiaPlan = idAcademiaPlan;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Academia getIdAcademia() {
        return idAcademia;
    }

    public void setIdAcademia(Academia idAcademia) {
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
    public Collection<Expediente> getExpedienteCollection() {
        return expedienteCollection;
    }

    public void setExpedienteCollection(Collection<Expediente> expedienteCollection) {
        this.expedienteCollection = expedienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAcademiaPlan != null ? idAcademiaPlan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AcademiaPlan)) {
            return false;
        }
        AcademiaPlan other = (AcademiaPlan) object;
        if ((this.idAcademiaPlan == null && other.idAcademiaPlan != null) || (this.idAcademiaPlan != null && !this.idAcademiaPlan.equals(other.idAcademiaPlan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AcademiaPlan[ idAcademiaPlan=" + idAcademiaPlan + " ]";
    }
    
}
