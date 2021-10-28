/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cesd
 */
@Entity
@Table(name = "partidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partidos.findAll", query = "SELECT p FROM Partidos p")
    , @NamedQuery(name = "Partidos.findById", query = "SELECT p FROM Partidos p WHERE p.id = :id")
    , @NamedQuery(name = "Partidos.findByFecha", query = "SELECT p FROM Partidos p WHERE p.fecha = :fecha")
    , @NamedQuery(name = "Partidos.findByGolesLocal", query = "SELECT p FROM Partidos p WHERE p.golesLocal = :golesLocal")
    , @NamedQuery(name = "Partidos.findByGolesVisitante", query = "SELECT p FROM Partidos p WHERE p.golesVisitante = :golesVisitante")})
public class Partidos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "goles_local")
    private int golesLocal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "goles_visitante")
    private int golesVisitante;
    @JoinColumn(name = "local", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Equipos local;
    @JoinColumn(name = "visitante", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Equipos visitante;
    @JoinColumn(name = "usuario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios usuario;

    public Partidos() {
    }

    public Partidos(Integer id) {
        this.id = id;
    }

    public Partidos(Integer id, Date fecha, int golesLocal, int golesVisitante) {
        this.id = id;
        this.fecha = fecha;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(int golesLocal) {
        this.golesLocal = golesLocal;
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(int golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    public Equipos getLocal() {
        return local;
    }

    public void setLocal(Equipos local) {
        this.local = local;
    }

    public Equipos getVisitante() {
        return visitante;
    }

    public void setVisitante(Equipos visitante) {
        this.visitante = visitante;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partidos)) {
            return false;
        }
        Partidos other = (Partidos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Partidos[ id=" + id + " ]";
    }
    
}
