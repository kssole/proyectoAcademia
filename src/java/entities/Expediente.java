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
@Table(name = "expediente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Expediente.findAll", query = "SELECT e FROM Expediente e"),
    @NamedQuery(name = "Expediente.findByIdExpediente", query = "SELECT e FROM Expediente e WHERE e.idExpediente = :idExpediente"),
    @NamedQuery(name = "Expediente.findByPuedeInscribir", query = "SELECT e FROM Expediente e WHERE e.puedeInscribir = :puedeInscribir"),
    @NamedQuery(name = "Expediente.findByEstadoAcademico", query = "SELECT e FROM Expediente e WHERE e.estadoAcademico = :estadoAcademico")})
public class Expediente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_expediente")
    private Integer idExpediente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "puede_inscribir")
    private String puedeInscribir;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "estado_academico")
    private String estadoAcademico;
    @JoinColumn(name = "id_nivel_aprobado", referencedColumnName = "id_nivel_aprobado")
    @ManyToOne(optional = false)
    private NivelAprobado idNivelAprobado;
    @JoinColumn(name = "id_academia_plan", referencedColumnName = "id_academia_plan")
    @ManyToOne(optional = false)
    private AcademiaPlan idAcademiaPlan;
    @JoinColumn(name = "id_estudiantes", referencedColumnName = "id_estudiantes")
    @ManyToOne(optional = false)
    private Estudiantes idEstudiantes;

    public Expediente() {
    }

    public Expediente(Integer idExpediente) {
        this.idExpediente = idExpediente;
    }

    public Expediente(Integer idExpediente, String puedeInscribir, String estadoAcademico) {
        this.idExpediente = idExpediente;
        this.puedeInscribir = puedeInscribir;
        this.estadoAcademico = estadoAcademico;
    }

    public Integer getIdExpediente() {
        return idExpediente;
    }

    public void setIdExpediente(Integer idExpediente) {
        this.idExpediente = idExpediente;
    }

    public String getPuedeInscribir() {
        return puedeInscribir;
    }

    public void setPuedeInscribir(String puedeInscribir) {
        this.puedeInscribir = puedeInscribir;
    }

    public String getEstadoAcademico() {
        return estadoAcademico;
    }

    public void setEstadoAcademico(String estadoAcademico) {
        this.estadoAcademico = estadoAcademico;
    }

    public NivelAprobado getIdNivelAprobado() {
        return idNivelAprobado;
    }

    public void setIdNivelAprobado(NivelAprobado idNivelAprobado) {
        this.idNivelAprobado = idNivelAprobado;
    }

    public AcademiaPlan getIdAcademiaPlan() {
        return idAcademiaPlan;
    }

    public void setIdAcademiaPlan(AcademiaPlan idAcademiaPlan) {
        this.idAcademiaPlan = idAcademiaPlan;
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
        hash += (idExpediente != null ? idExpediente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Expediente)) {
            return false;
        }
        Expediente other = (Expediente) object;
        if ((this.idExpediente == null && other.idExpediente != null) || (this.idExpediente != null && !this.idExpediente.equals(other.idExpediente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Expediente[ idExpediente=" + idExpediente + " ]";
    }
    
}
