/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author COMPUTADOR
 */
@Entity
@Table(name = "tipoclase")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoclase.findAll", query = "SELECT t FROM Tipoclase t")
    , @NamedQuery(name = "Tipoclase.findByIdTipoClase", query = "SELECT t FROM Tipoclase t WHERE t.idTipoClase = :idTipoClase")
    , @NamedQuery(name = "Tipoclase.findByDescripcion", query = "SELECT t FROM Tipoclase t WHERE t.descripcion = :descripcion")})
public class Tipoclase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoClase")
    private Integer idTipoClase;
    @Size(max = 128)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "clase")
    private List<Tiquetevuelo> tiquetevueloList;

    public Tipoclase() {
    }

    public Tipoclase(Integer idTipoClase) {
        this.idTipoClase = idTipoClase;
    }

    public Integer getIdTipoClase() {
        return idTipoClase;
    }

    public void setIdTipoClase(Integer idTipoClase) {
        this.idTipoClase = idTipoClase;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (idTipoClase != null ? idTipoClase.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoclase)) {
            return false;
        }
        Tipoclase other = (Tipoclase) object;
        if ((this.idTipoClase == null && other.idTipoClase != null) || (this.idTipoClase != null && !this.idTipoClase.equals(other.idTipoClase))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Tipoclase[ idTipoClase=" + idTipoClase + " ]";
    }
    
}
