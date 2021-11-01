package com.javainuse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "partidos")
public class Partido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private Date fecha;
	@Column
	private Integer goles_local;
	@Column
	private Integer goles_visitante;
	@JoinColumn(name = "local", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Equipo local;
	@JoinColumn(name = "visitante", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Equipo visitante;
	@JoinColumn(name = "usuario", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private DAOUser usuario;


	/**
	 * @return the goles_local
	 */
	public Integer getGoles_local() {
		return goles_local;
	}

	/**
	 * @param goles_local the goles_local to set
	 */
	public void setGoles_local(Integer goles_local) {
		this.goles_local = goles_local;
	}

	/**
	 * @return the goles_visitante
	 */
	public Integer getGoles_visitante() {
		return goles_visitante;
	}

	/**
	 * @param goles_visitante the goles_visitante to set
	 */
	public void setGoles_visitante(Integer goles_visitante) {
		this.goles_visitante = goles_visitante;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
