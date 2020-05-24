/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c")
    , @NamedQuery(name = "Categoria.findByIdCategorias", query = "SELECT c FROM Categoria c WHERE c.idCategorias = :idCategorias")
    , @NamedQuery(name = "Categoria.findByDescripcion", query = "SELECT c FROM Categoria c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "Categoria.findByNumeroMaletas", query = "SELECT c FROM Categoria c WHERE c.numeroMaletas = :numeroMaletas")
    , @NamedQuery(name = "Categoria.findByPesoMaletas", query = "SELECT c FROM Categoria c WHERE c.pesoMaletas = :pesoMaletas")
    , @NamedQuery(name = "Categoria.findByNumeroMaletasMano", query = "SELECT c FROM Categoria c WHERE c.numeroMaletasMano = :numeroMaletasMano")
    , @NamedQuery(name = "Categoria.findByPesoMaletasMano", query = "SELECT c FROM Categoria c WHERE c.pesoMaletasMano = :pesoMaletasMano")
    , @NamedQuery(name = "Categoria.findByMillasPorTrayecto", query = "SELECT c FROM Categoria c WHERE c.millasPorTrayecto = :millasPorTrayecto")})
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCategorias")
    private Integer idCategorias;
    @Size(max = 128)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "numeroMaletas")
    private Integer numeroMaletas;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pesoMaletas")
    private BigDecimal pesoMaletas;
    @Column(name = "numeroMaletasMano")
    private Integer numeroMaletasMano;
    @Column(name = "pesoMaletasMano")
    private BigDecimal pesoMaletasMano;
    @Column(name = "millasPorTrayecto")
    private Double millasPorTrayecto;
    @OneToMany(mappedBy = "categoria")
    private List<Usuario> usuarioList;

    public Categoria() {
    }

    public Categoria(Integer idCategorias) {
        this.idCategorias = idCategorias;
    }

    public Integer getIdCategorias() {
        return idCategorias;
    }

    public void setIdCategorias(Integer idCategorias) {
        this.idCategorias = idCategorias;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getNumeroMaletas() {
        return numeroMaletas;
    }

    public void setNumeroMaletas(Integer numeroMaletas) {
        this.numeroMaletas = numeroMaletas;
    }

    public BigDecimal getPesoMaletas() {
        return pesoMaletas;
    }

    public void setPesoMaletas(BigDecimal pesoMaletas) {
        this.pesoMaletas = pesoMaletas;
    }

    public Integer getNumeroMaletasMano() {
        return numeroMaletasMano;
    }

    public void setNumeroMaletasMano(Integer numeroMaletasMano) {
        this.numeroMaletasMano = numeroMaletasMano;
    }

    public BigDecimal getPesoMaletasMano() {
        return pesoMaletasMano;
    }

    public void setPesoMaletasMano(BigDecimal pesoMaletasMano) {
        this.pesoMaletasMano = pesoMaletasMano;
    }

    public Double getMillasPorTrayecto() {
        return millasPorTrayecto;
    }

    public void setMillasPorTrayecto(Double millasPorTrayecto) {
        this.millasPorTrayecto = millasPorTrayecto;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategorias != null ? idCategorias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.idCategorias == null && other.idCategorias != null) || (this.idCategorias != null && !this.idCategorias.equals(other.idCategorias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Categoria[ idCategorias=" + idCategorias + " ]";
    }
    
}
