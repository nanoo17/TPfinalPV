package ar.edu.unju.edm.model;

import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Table (name ="POIS") 
@Component
public class Poi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer codigoPoi;
	@Column
	private String nombre;
	@Column
	private String descripcion;
	@Column
	private String etiqueta;
	@Column
	private String sitioWeb;
	@Column
	private String calle;
	@Column
	private int numeroCasa;
	@Column
	private String barrio;
	@Column
	private String localidad;
	@Column
	private int localizacionLatitud;
	@Column
	private int localizacionLongitud;
	@Column
	private byte[] fotografia;
	@Column(name = "imagen", columnDefinition = "LONGBLOB")
	private String imagen;
	
	@Column
	private byte[] fotografia2;
	@Column(name = "imagen2", columnDefinition = "LONGBLOB")
	private String imagen2;
	
	@Column
	private byte[] fotografia3;
	@Column(name = "imagen3", columnDefinition = "LONGBLOB")
	private String imagen3;
	
	
	@Column 
	private double valFinal = 0;
	
		@ManyToOne
	@JoinColumn(name = "idTurista")
	private Turista turistaAutor;
		
		@OneToMany(mappedBy= "otroPoi", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
		private List<Turista_Poi> turistaVal;
		
		
		
		
		
		
		
		
	
	
	public List<Turista_Poi> getTuristaVal() {
			return turistaVal;
		}

		public void setTuristaVal(List<Turista_Poi> turistaVal) {
			this.turistaVal = turistaVal;
		}

	public double getValFinal() {
		return valFinal;
	}

	public void setValFinal(double valFinal) {
		this.valFinal = valFinal;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public Poi() {
		// TODO Auto-generated constructor stub
	}

	



	

	

	public Poi(Integer codigoPoi, String nombre, String descripcion, String etiqueta, String sitioWeb, String calle,
			int numeroCasa, String barrio, String localidad, int localizacionLatitud, int localizacionLongitud,
			byte[] fotografia, String imagen, byte[] fotografia2, String imagen2, byte[] fotografia3, String imagen3,
			Turista turistaAutor) {
		super();
		this.codigoPoi = codigoPoi;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.etiqueta = etiqueta;
		this.sitioWeb = sitioWeb;
		this.calle = calle;
		this.numeroCasa = numeroCasa;
		this.barrio = barrio;
		this.localidad = localidad;
		this.localizacionLatitud = localizacionLatitud;
		this.localizacionLongitud = localizacionLongitud;
		this.fotografia = fotografia;
		this.imagen = imagen;
		this.fotografia2 = fotografia2;
		this.imagen2 = imagen2;
		this.fotografia3 = fotografia3;
		this.imagen3 = imagen3;
		this.turistaAutor = turistaAutor;
	}

	public byte[] getFotografia() {
		return fotografia;
	}

	public void setFotografia(byte[] fotografia) {
		this.fotografia = fotografia;
	}	
	
	public Integer getCodigoPoi() {
		return codigoPoi;
	}



	public void setCodigoPoi(Integer codigoPoi) {
		this.codigoPoi = codigoPoi;
	}

	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public String getEtiqueta() {
		return etiqueta;
	}



	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}



	public String getSitioWeb() {
		return sitioWeb;
	}



	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}



	public String getCalle() {
		return calle;
	}



	public void setCalle(String calle) {
		this.calle = calle;
	}



	public int getNumeroCasa() {
		return numeroCasa;
	}



	public void setNumeroCasa(int numeroCasa) {
		this.numeroCasa = numeroCasa;
	}



	public String getBarrio() {
		return barrio;
	}



	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}



	public String getLocalidad() {
		return localidad;
	}



	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}



	public int getLocalizacionLatitud() {
		return localizacionLatitud;
	}



	public void setLocalizacionLatitud(int localizacionLatitud) {
		this.localizacionLatitud = localizacionLatitud;
	}



	public int getLocalizacionLongitud() {
		return localizacionLongitud;
	}



	public byte[] getFotografia2() {
		return fotografia2;
	}

	public void setFotografia2(byte[] fotografia2) {
		this.fotografia2 = fotografia2;
	}

	public String getImagen2() {
		return imagen2;
	}

	public void setImagen2(String imagen2) {
		this.imagen2 = imagen2;
	}

	public byte[] getFotografia3() {
		return fotografia3;
	}

	public void setFotografia3(byte[] fotografia3) {
		this.fotografia3 = fotografia3;
	}

	public String getImagen3() {
		return imagen3;
	}

	public void setImagen3(String imagen3) {
		this.imagen3 = imagen3;
	}

	public void setLocalizacionLongitud(int localizacionLongitud) {
		this.localizacionLongitud = localizacionLongitud;
	}

	public Turista getTuristaAutor() {
		return turistaAutor;
	}

	public void setTuristaAutor(Turista turistaAutor) {
		this.turistaAutor = turistaAutor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((barrio == null) ? 0 : barrio.hashCode());
		result = prime * result + ((calle == null) ? 0 : calle.hashCode());
		result = prime * result + ((codigoPoi == null) ? 0 : codigoPoi.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((etiqueta == null) ? 0 : etiqueta.hashCode());
		result = prime * result + Arrays.hashCode(fotografia);
		result = prime * result + Arrays.hashCode(fotografia2);
		result = prime * result + Arrays.hashCode(fotografia3);
		result = prime * result + ((imagen == null) ? 0 : imagen.hashCode());
		result = prime * result + ((imagen2 == null) ? 0 : imagen2.hashCode());
		result = prime * result + ((imagen3 == null) ? 0 : imagen3.hashCode());
		result = prime * result + ((localidad == null) ? 0 : localidad.hashCode());
		result = prime * result + localizacionLatitud;
		result = prime * result + localizacionLongitud;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + numeroCasa;
		result = prime * result + ((sitioWeb == null) ? 0 : sitioWeb.hashCode());
		result = prime * result + ((turistaAutor == null) ? 0 : turistaAutor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Poi other = (Poi) obj;
		if (barrio == null) {
			if (other.barrio != null)
				return false;
		} else if (!barrio.equals(other.barrio))
			return false;
		if (calle == null) {
			if (other.calle != null)
				return false;
		} else if (!calle.equals(other.calle))
			return false;
		if (codigoPoi == null) {
			if (other.codigoPoi != null)
				return false;
		} else if (!codigoPoi.equals(other.codigoPoi))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (etiqueta == null) {
			if (other.etiqueta != null)
				return false;
		} else if (!etiqueta.equals(other.etiqueta))
			return false;
		if (!Arrays.equals(fotografia, other.fotografia))
			return false;
		if (!Arrays.equals(fotografia2, other.fotografia2))
			return false;
		if (!Arrays.equals(fotografia3, other.fotografia3))
			return false;
		if (imagen == null) {
			if (other.imagen != null)
				return false;
		} else if (!imagen.equals(other.imagen))
			return false;
		if (imagen2 == null) {
			if (other.imagen2 != null)
				return false;
		} else if (!imagen2.equals(other.imagen2))
			return false;
		if (imagen3 == null) {
			if (other.imagen3 != null)
				return false;
		} else if (!imagen3.equals(other.imagen3))
			return false;
		if (localidad == null) {
			if (other.localidad != null)
				return false;
		} else if (!localidad.equals(other.localidad))
			return false;
		if (localizacionLatitud != other.localizacionLatitud)
			return false;
		if (localizacionLongitud != other.localizacionLongitud)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (numeroCasa != other.numeroCasa)
			return false;
		if (sitioWeb == null) {
			if (other.sitioWeb != null)
				return false;
		} else if (!sitioWeb.equals(other.sitioWeb))
			return false;
		if (turistaAutor == null) {
			if (other.turistaAutor != null)
				return false;
		} else if (!turistaAutor.equals(other.turistaAutor))
			return false;
		return true;
	}


}