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
@Table(name = "tipotarjeta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipotarjeta.findAll", query = "SELECT t FROM Tipotarjeta t")
    , @NamedQuery(name = "Tipotarjeta.findByIdTipoTarjeta", query = "SELECT t FROM Tipotarjeta t WHERE t.idTipoTarjeta = :idTipoTarjeta")
    , @NamedQuery(name = "Tipotarjeta.findByDescripcion", query = "SELECT t FROM Tipotarjeta t WHERE t.descripcion = :descripcion")})
public class Tipotarjeta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoTarjeta")
    private Integer idTipoTarjeta;
    @Size(max = 128)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "tipoTarjeta")
    private List<Tiquetevuelo> tiquetevueloList;

    public Tipotarjeta() {
    }

    public Tipotarjeta(Integer idTipoTarjeta) {
        this.idTipoTarjeta = idTipoTarjeta;
    }

    public Integer getIdTipoTarjeta() {
        return idTipoTarjeta;
    }

    public void setIdTipoTarjeta(Integer idTipoTarjeta) {
        this.idTipoTarjeta = idTipoTarjeta;
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
        hash += (idTipoTarjeta != null ? idTipoTarjeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipotarjeta)) {
            return false;
        }
        Tipotarjeta other = (Tipotarjeta) object;
        if ((this.idTipoTarjeta == null && other.idTipoTarjeta != null) || (this.idTipoTarjeta != null && !this.idTipoTarjeta.equals(other.idTipoTarjeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Tipotarjeta[ idTipoTarjeta=" + idTipoTarjeta + " ]";
    }
    
}
