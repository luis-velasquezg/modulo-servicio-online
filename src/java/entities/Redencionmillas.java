/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author COMPUTADOR
 */
@Entity
@Table(name = "redencionmillas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Redencionmillas.findAll", query = "SELECT r FROM Redencionmillas r")
    , @NamedQuery(name = "Redencionmillas.findByIdRedencionMillas", query = "SELECT r FROM Redencionmillas r WHERE r.idRedencionMillas = :idRedencionMillas")
    , @NamedQuery(name = "Redencionmillas.findByFechaRedencion", query = "SELECT r FROM Redencionmillas r WHERE r.fechaRedencion = :fechaRedencion")
    , @NamedQuery(name = "Redencionmillas.findBySaldoMIllas", query = "SELECT r FROM Redencionmillas r WHERE r.saldoMIllas = :saldoMIllas")})
public class Redencionmillas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRedencionMillas")
    private Integer idRedencionMillas;
    @Column(name = "fechaRedencion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRedencion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "saldoMIllas")
    private Double saldoMIllas;
    @JoinColumn(name = "usuarioRedime", referencedColumnName = "idUsuario")
    @ManyToOne
    private Usuario usuarioRedime;

    public Redencionmillas() {
    }

    public Redencionmillas(Integer idRedencionMillas) {
        this.idRedencionMillas = idRedencionMillas;
    }

    public Integer getIdRedencionMillas() {
        return idRedencionMillas;
    }

    public void setIdRedencionMillas(Integer idRedencionMillas) {
        this.idRedencionMillas = idRedencionMillas;
    }

    public Date getFechaRedencion() {
        return fechaRedencion;
    }

    public void setFechaRedencion(Date fechaRedencion) {
        this.fechaRedencion = fechaRedencion;
    }

    public Double getSaldoMIllas() {
        return saldoMIllas;
    }

    public void setSaldoMIllas(Double saldoMIllas) {
        this.saldoMIllas = saldoMIllas;
    }

    public Usuario getUsuarioRedime() {
        return usuarioRedime;
    }

    public void setUsuarioRedime(Usuario usuarioRedime) {
        this.usuarioRedime = usuarioRedime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRedencionMillas != null ? idRedencionMillas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Redencionmillas)) {
            return false;
        }
        Redencionmillas other = (Redencionmillas) object;
        if ((this.idRedencionMillas == null && other.idRedencionMillas != null) || (this.idRedencionMillas != null && !this.idRedencionMillas.equals(other.idRedencionMillas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Redencionmillas[ idRedencionMillas=" + idRedencionMillas + " ]";
    }
    
}
