package ar.edu.unju.edm.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table (name ="TURISTAS") 
public class Turista {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	@Column
	private String nombre;
	@Column
	private String Apellido; 
	@Column
	private String email; 
	@Column
	private String password; 
	@Column
	private String pais; 
	@Column
	private double localizacionLatitud;
	@Column
	private double localizacionLongitud;
	@Column
	private int puntos;
	
	@OneToMany(mappedBy = "turistaAutor", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Poi> pois;
	
	public Turista() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public double getLocalizacionLatitud() {
		return localizacionLatitud;
	}
	public void setLocalizacionLatitud(double localizacionLatitud) {
		this.localizacionLatitud = localizacionLatitud;
	}
	public double getLocalizacionLongitud() {
		return localizacionLongitud;
	}
	public void setLocalizacionLongitud(double localizacionLongitud) {
		this.localizacionLongitud = localizacionLongitud;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public List<Poi> getPois() {
		return pois;
	}

	public void setPois(List<Poi> pois) {
		this.pois = pois;
	}
	
}