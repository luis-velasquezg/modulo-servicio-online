/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author COMPUTADOR
 */
@Entity
@Table(name = "temporada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Temporada.findAll", query = "SELECT t FROM Temporada t")
    , @NamedQuery(name = "Temporada.findByIdTemporada", query = "SELECT t FROM Temporada t WHERE t.idTemporada = :idTemporada")
    , @NamedQuery(name = "Temporada.findByDescripcion", query = "SELECT t FROM Temporada t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "Temporada.findByMesInicio", query = "SELECT t FROM Temporada t WHERE t.mesInicio = :mesInicio")
    , @NamedQuery(name = "Temporada.findByMesFin", query = "SELECT t FROM Temporada t WHERE t.mesFin = :mesFin")})
public class Temporada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTemporada")
    private Integer idTemporada;
    @Size(max = 128)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "mesInicio")
    @Temporal(TemporalType.DATE)
    private Date mesInicio;
    @Column(name = "mesFin")
    @Temporal(TemporalType.DATE)
    private Date mesFin;
    @OneToMany(mappedBy = "temporada")
    private List<Tiquetevuelo> tiquetevueloList;

    public Temporada() {
    }

    public Temporada(Integer idTemporada) {
        this.idTemporada = idTemporada;
    }

    public Integer getIdTemporada() {
        return idTemporada;
    }

    public void setIdTemporada(Integer idTemporada) {
        this.idTemporada = idTemporada;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getMesInicio() {
        return mesInicio;
    }

    public void setMesInicio(Date mesInicio) {
        this.mesInicio = mesInicio;
    }

    public Date getMesFin() {
        return mesFin;
    }

    public void setMesFin(Date mesFin) {
        this.mesFin = mesFin;
    }

    @XmlTransient
    public List<Tiquetevuelo> getTiquetevueloList() {
        return tiquetevueloList;
    }

    public void setTiquetevueloList(List<Tiquetevuelo> tiquetevueloList) {
        this.tiquetevueloList = tiquetevueloList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTemporada != null ? idTemporada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Temporada)) {
            return false;
        }
        Temporada other = (Temporada) object;
        if ((this.idTemporada == null && other.idTemporada != null) || (this.idTemporada != null && !this.idTemporada.equals(other.idTemporada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Temporada[ idTemporada=" + idTemporada + " ]";
    }
    
}
