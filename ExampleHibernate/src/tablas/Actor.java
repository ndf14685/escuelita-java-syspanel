package tablas;
// Generated 16/08/2018 17:29:45 by Hibernate Tools 5.1.0.Alpha1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Actor generated by hbm2java
 */

@Entity
@Table(name="actor")

public class Actor implements java.io.Serializable {

	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="nombre")
	private String nombre;
	private Set actorPeliculas = new HashSet(0);

	public Actor() {
	}

	public Actor(String nombre, Set actorPeliculas) {
		this.nombre = nombre;
		this.actorPeliculas = actorPeliculas;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set getActorPeliculas() {
		return this.actorPeliculas;
	}

	public void setActorPeliculas(Set actorPeliculas) {
		this.actorPeliculas = actorPeliculas;
	}

}
