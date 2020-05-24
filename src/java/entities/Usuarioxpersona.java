/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author COMPUTADOR
 */
@Entity
@Table(name = "usuarioxpersona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarioxpersona.findAll", query = "SELECT u FROM Usuarioxpersona u")
    , @NamedQuery(name = "Usuarioxpersona.findByIdUsuarioxPersona", query = "SELECT u FROM Usuarioxpersona u WHERE u.idUsuarioxPersona = :idUsuarioxPersona")})
public class Usuarioxpersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUsuarioxPersona")
    private Integer idUsuarioxPersona;
    @JoinColumn(name = "persona", referencedColumnName = "idPersona")
    @ManyToOne
    private Persona persona;
    @JoinColumn(name = "usuario", referencedColumnName = "idUsuario")
    @ManyToOne
    private Usuario usuario;

    public Usuarioxpersona() {
    }

    public Usuarioxpersona(Integer idUsuarioxPersona) {
        this.idUsuarioxPersona = idUsuarioxPersona;
    }

    public Integer getIdUsuarioxPersona() {
        return idUsuarioxPersona;
    }

    public void setIdUsuarioxPersona(Integer idUsuarioxPersona) {
        this.idUsuarioxPersona = idUsuarioxPersona;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuarioxPersona != null ? idUsuarioxPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarioxpersona)) {
            return false;
        }
        Usuarioxpersona other = (Usuarioxpersona) object;
        if ((this.idUsuarioxPersona == null && other.idUsuarioxPersona != null) || (this.idUsuarioxPersona != null && !this.idUsuarioxPersona.equals(other.idUsuarioxPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Usuarioxpersona[ idUsuarioxPersona=" + idUsuarioxPersona + " ]";
    }
    
}
