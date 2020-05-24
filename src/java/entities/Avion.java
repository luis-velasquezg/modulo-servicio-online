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
@Table(name = "avion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Avion.findAll", query = "SELECT a FROM Avion a")
    , @NamedQuery(name = "Avion.findByIdAvion", query = "SELECT a FROM Avion a WHERE a.idAvion = :idAvion")
    , @NamedQuery(name = "Avion.findByMatricula", query = "SELECT a FROM Avion a WHERE a.matricula = :matricula")
    , @NamedQuery(name = "Avion.findByFabricante", query = "SELECT a FROM Avion a WHERE a.fabricante = :fabricante")
    , @NamedQuery(name = "Avion.findByModelo", query = "SELECT a FROM Avion a WHERE a.modelo = :modelo")
    , @NamedQuery(name = "Avion.findByNumeroAsientos", query = "SELECT a FROM Avion a WHERE a.numeroAsientos = :numeroAsientos")
    , @NamedQuery(name = "Avion.findByCapacidadCarga", query = "SELECT a FROM Avion a WHERE a.capacidadCarga = :capacidadCarga")})
public class Avion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAvion")
    private Integer idAvion;
    @Size(max = 64)
    @Column(name = "matricula")
    private String matricula;
    @Size(max = 128)
    @Column(name = "fabricante")
    private String fabricante;
    @Size(max = 64)
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "numeroAsientos")
    private Integer numeroAsientos;
    @Column(name = "capacidadCarga")
    private Integer capacidadCarga;
    @OneToMany(mappedBy = "avion")
    private List<Vuelo> vueloList;

    public Avion() {
    }

    public Avion(Integer idAvion) {
        this.idAvion = idAvion;
    }

    public Integer getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(Integer idAvion) {
        this.idAvion = idAvion;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getNumeroAsientos() {
        return numeroAsientos;
    }

    public void setNumeroAsientos(Integer numeroAsientos) {
        this.numeroAsientos = numeroAsientos;
    }

    public Integer getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(Integer capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
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
        hash += (idAvion != null ? idAvion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Avion)) {
            return false;
        }
        Avion other = (Avion) object;
        if ((this.idAvion == null && other.idAvion != null) || (this.idAvion != null && !this.idAvion.equals(other.idAvion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Avion[ idAvion=" + idAvion + " ]";
    }
    
}
