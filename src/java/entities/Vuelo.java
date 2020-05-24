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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author COMPUTADOR
 */
@Entity
@Table(name = "vuelo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vuelo.findAll", query = "SELECT v FROM Vuelo v")
    , @NamedQuery(name = "Vuelo.findByIdVuelo", query = "SELECT v FROM Vuelo v WHERE v.idVuelo = :idVuelo")
    , @NamedQuery(name = "Vuelo.findByFechaSalida", query = "SELECT v FROM Vuelo v WHERE v.fechaSalida = :fechaSalida")
    , @NamedQuery(name = "Vuelo.findByFechaLlegada", query = "SELECT v FROM Vuelo v WHERE v.fechaLlegada = :fechaLlegada")
    , @NamedQuery(name = "Vuelo.findByAsientosDisponibles", query = "SELECT v FROM Vuelo v WHERE v.asientosDisponibles = :asientosDisponibles")})
public class Vuelo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVuelo")
    private Integer idVuelo;
    @Column(name = "fechaSalida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSalida;
    @Column(name = "fechaLlegada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaLlegada;
    @Column(name = "asientosDisponibles")
    private Integer asientosDisponibles;
    @OneToMany(mappedBy = "vuelo")
    private List<Tiquetevuelo> tiquetevueloList;
    @JoinColumn(name = "aeropuerto", referencedColumnName = "idAeropuerto")
    @ManyToOne
    private Aeropuertos aeropuerto;
    @JoinColumn(name = "avion", referencedColumnName = "idAvion")
    @ManyToOne
    private Avion avion;
    @JoinColumn(name = "ciudadDestino", referencedColumnName = "idCiudad")
    @ManyToOne
    private Ciudad ciudadDestino;
    @JoinColumn(name = "ciudadOrigen", referencedColumnName = "idCiudad")
    @ManyToOne
    private Ciudad ciudadOrigen;

    public Vuelo() {
    }

    public Vuelo(Integer idVuelo) {
        this.idVuelo = idVuelo;
    }

    public Integer getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(Integer idVuelo) {
        this.idVuelo = idVuelo;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Integer getAsientosDisponibles() {
        return asientosDisponibles;
    }

    public void setAsientosDisponibles(Integer asientosDisponibles) {
        this.asientosDisponibles = asientosDisponibles;
    }

    @XmlTransient
    public List<Tiquetevuelo> getTiquetevueloList() {
        return tiquetevueloList;
    }

    public void setTiquetevueloList(List<Tiquetevuelo> tiquetevueloList) {
        this.tiquetevueloList = tiquetevueloList;
    }

    public Aeropuertos getAeropuerto() {
        return aeropuerto;
    }

    public void setAeropuerto(Aeropuertos aeropuerto) {
        this.aeropuerto = aeropuerto;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Ciudad getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(Ciudad ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public Ciudad getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(Ciudad ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVuelo != null ? idVuelo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vuelo)) {
            return false;
        }
        Vuelo other = (Vuelo) object;
        if ((this.idVuelo == null && other.idVuelo != null) || (this.idVuelo != null && !this.idVuelo.equals(other.idVuelo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Vuelo[ idVuelo=" + idVuelo + " ]";
    }
    
}
