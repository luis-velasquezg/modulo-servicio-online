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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "aeropuertos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aeropuertos.findAll", query = "SELECT a FROM Aeropuertos a")
    , @NamedQuery(name = "Aeropuertos.findByIdAeropuerto", query = "SELECT a FROM Aeropuertos a WHERE a.idAeropuerto = :idAeropuerto")
    , @NamedQuery(name = "Aeropuertos.findByNombre", query = "SELECT a FROM Aeropuertos a WHERE a.nombre = :nombre")})
public class Aeropuertos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAeropuerto")
    private Integer idAeropuerto;
    @Size(max = 128)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "ciudad", referencedColumnName = "idCiudad")
    @ManyToOne
    private Ciudad ciudad;
    @OneToMany(mappedBy = "aeropuerto")
    private List<Vuelo> vueloList;

    public Aeropuertos() {
    }

    public Aeropuertos(Integer idAeropuerto) {
        this.idAeropuerto = idAeropuerto;
    }

    public Integer getIdAeropuerto() {
        return idAeropuerto;
    }

    public void setIdAeropuerto(Integer idAeropuerto) {
        this.idAeropuerto = idAeropuerto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    @XmlTransient
    public List<Vuelo> getVueloList() {
        return vueloList;
    }

    public void setVueloList(List<Vuelo> vueloList) {
        this.vueloList = vueloList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAeropuerto != null ? idAeropuerto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aeropuertos)) {
            return false;
        }
        Aeropuertos other = (Aeropuertos) object;
        if ((this.idAeropuerto == null && other.idAeropuerto != null) || (this.idAeropuerto != null && !this.idAeropuerto.equals(other.idAeropuerto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Aeropuertos[ idAeropuerto=" + idAeropuerto + " ]";
    }
    
}
