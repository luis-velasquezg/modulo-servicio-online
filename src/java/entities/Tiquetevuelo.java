/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author COMPUTADOR
 */
@Entity
@Table(name = "tiquetevuelo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiquetevuelo.findAll", query = "SELECT t FROM Tiquetevuelo t")
    , @NamedQuery(name = "Tiquetevuelo.findByIdDetalleVuelo", query = "SELECT t FROM Tiquetevuelo t WHERE t.idDetalleVuelo = :idDetalleVuelo")
    , @NamedQuery(name = "Tiquetevuelo.findByImpuestos", query = "SELECT t FROM Tiquetevuelo t WHERE t.impuestos = :impuestos")
    , @NamedQuery(name = "Tiquetevuelo.findByFechaCompra", query = "SELECT t FROM Tiquetevuelo t WHERE t.fechaCompra = :fechaCompra")
    , @NamedQuery(name = "Tiquetevuelo.findByNumAsiento", query = "SELECT t FROM Tiquetevuelo t WHERE t.numAsiento = :numAsiento")
    , @NamedQuery(name = "Tiquetevuelo.findBySubtotal", query = "SELECT t FROM Tiquetevuelo t WHERE t.subtotal = :subtotal")
    , @NamedQuery(name = "Tiquetevuelo.findByMillasAcumuladas", query = "SELECT t FROM Tiquetevuelo t WHERE t.millasAcumuladas = :millasAcumuladas")
    , @NamedQuery(name = "Tiquetevuelo.findByBarcode", query = "SELECT t FROM Tiquetevuelo t WHERE t.barcode = :barcode")
    , @NamedQuery(name = "Tiquetevuelo.findByNumeroMaletas", query = "SELECT t FROM Tiquetevuelo t WHERE t.numeroMaletas = :numeroMaletas")
    , @NamedQuery(name = "Tiquetevuelo.findByPesoTotalMaletas", query = "SELECT t FROM Tiquetevuelo t WHERE t.pesoTotalMaletas = :pesoTotalMaletas")
    , @NamedQuery(name = "Tiquetevuelo.findByNumeroMaletasMano", query = "SELECT t FROM Tiquetevuelo t WHERE t.numeroMaletasMano = :numeroMaletasMano")
    , @NamedQuery(name = "Tiquetevuelo.findByPesoTotalMaletasMano", query = "SELECT t FROM Tiquetevuelo t WHERE t.pesoTotalMaletasMano = :pesoTotalMaletasMano")
    , @NamedQuery(name = "Tiquetevuelo.findByAbordado", query = "SELECT t FROM Tiquetevuelo t WHERE t.abordado = :abordado")})
public class Tiquetevuelo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDetalleVuelo")
    private Integer idDetalleVuelo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "impuestos")
    private BigDecimal impuestos;
    @Column(name = "fechaCompra")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCompra;
    @Column(name = "numAsiento")
    private Integer numAsiento;
    @Column(name = "subtotal")
    private BigDecimal subtotal;
    @Column(name = "millasAcumuladas")
    private Double millasAcumuladas;
    @Size(max = 128)
    @Column(name = "barcode")
    private String barcode;
    @Column(name = "numeroMaletas")
    private Integer numeroMaletas;
    @Column(name = "pesoTotalMaletas")
    private BigDecimal pesoTotalMaletas;
    @Column(name = "numeroMaletasMano")
    private Integer numeroMaletasMano;
    @Column(name = "pesoTotalMaletasMano")
    private BigDecimal pesoTotalMaletasMano;
    @Column(name = "abordado")
    private Boolean abordado;
    @JoinColumn(name = "clase", referencedColumnName = "idTipoClase")
    @ManyToOne
    private Tipoclase clase;
    @JoinColumn(name = "temporada", referencedColumnName = "idTemporada")
    @ManyToOne
    private Temporada temporada;
    @JoinColumn(name = "tipoTarjeta", referencedColumnName = "idTipoTarjeta")
    @ManyToOne
    private Tipotarjeta tipoTarjeta;
    @JoinColumn(name = "usuarioTiket", referencedColumnName = "idUsuario")
    @ManyToOne
    private Usuario usuarioTiket;
    @JoinColumn(name = "vuelo", referencedColumnName = "idVuelo")
    @ManyToOne
    private Vuelo vuelo;

    public Tiquetevuelo() {
    }

    public Tiquetevuelo(Integer idDetalleVuelo) {
        this.idDetalleVuelo = idDetalleVuelo;
    }

    public Integer getIdDetalleVuelo() {
        return idDetalleVuelo;
    }

    public void setIdDetalleVuelo(Integer idDetalleVuelo) {
        this.idDetalleVuelo = idDetalleVuelo;
    }

    public BigDecimal getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(BigDecimal impuestos) {
        this.impuestos = impuestos;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Integer getNumAsiento() {
        return numAsiento;
    }

    public void setNumAsiento(Integer numAsiento) {
        this.numAsiento = numAsiento;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public Double getMillasAcumuladas() {
        return millasAcumuladas;
    }

    public void setMillasAcumuladas(Double millasAcumuladas) {
        this.millasAcumuladas = millasAcumuladas;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Integer getNumeroMaletas() {
        return numeroMaletas;
    }

    public void setNumeroMaletas(Integer numeroMaletas) {
        this.numeroMaletas = numeroMaletas;
    }

    public BigDecimal getPesoTotalMaletas() {
        return pesoTotalMaletas;
    }

    public void setPesoTotalMaletas(BigDecimal pesoTotalMaletas) {
        this.pesoTotalMaletas = pesoTotalMaletas;
    }

    public Integer getNumeroMaletasMano() {
        return numeroMaletasMano;
    }

    public void setNumeroMaletasMano(Integer numeroMaletasMano) {
        this.numeroMaletasMano = numeroMaletasMano;
    }

    public BigDecimal getPesoTotalMaletasMano() {
        return pesoTotalMaletasMano;
    }

    public void setPesoTotalMaletasMano(BigDecimal pesoTotalMaletasMano) {
        this.pesoTotalMaletasMano = pesoTotalMaletasMano;
    }

    public Boolean getAbordado() {
        return abordado;
    }

    public void setAbordado(Boolean abordado) {
        this.abordado = abordado;
    }

    public Tipoclase getClase() {
        return clase;
    }

    public void setClase(Tipoclase clase) {
        this.clase = clase;
    }

    public Temporada getTemporada() {
        return temporada;
    }

    public void setTemporada(Temporada temporada) {
        this.temporada = temporada;
    }

    public Tipotarjeta getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(Tipotarjeta tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public Usuario getUsuarioTiket() {
        return usuarioTiket;
    }

    public void setUsuarioTiket(Usuario usuarioTiket) {
        this.usuarioTiket = usuarioTiket;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleVuelo != null ? idDetalleVuelo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiquetevuelo)) {
            return false;
        }
        Tiquetevuelo other = (Tiquetevuelo) object;
        if ((this.idDetalleVuelo == null && other.idDetalleVuelo != null) || (this.idDetalleVuelo != null && !this.idDetalleVuelo.equals(other.idDetalleVuelo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Tiquetevuelo[ idDetalleVuelo=" + idDetalleVuelo + " ]";
    }
    
}
