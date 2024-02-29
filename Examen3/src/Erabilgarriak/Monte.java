package Erabilgarriak;

import java.util.Objects;

public class Monte {

	private String Nombre;
	private String Provincia;
	private int Altura;
	private String Coordenadas;
	private String Macizo;
	private String Ruta;
	
	
	@Override
	public int hashCode() {
		return Objects.hash(Nombre);
	}


	public Monte(String nombre, String provincia, int altura, String coordenadas, String macizo, String ruta) {
		Nombre = nombre;
		Provincia = provincia;
		Altura = altura;
		Coordenadas = coordenadas;
		Macizo = macizo;
		Ruta = ruta;
	}


	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public String getProvincia() {
		return Provincia;
	}


	public void setProvincia(String provincia) {
		Provincia = provincia;
	}


	public int getAltura() {
		return Altura;
	}


	public void setAltura(int altura) {
		Altura = altura;
	}


	public String getCoordenadas() {
		return Coordenadas;
	}


	public void setCoordenadas(String coordenadas) {
		Coordenadas = coordenadas;
	}


	public String getMacizo() {
		return Macizo;
	}


	public void setMacizo(String macizo) {
		Macizo = macizo;
	}


	public String getRuta() {
		return Ruta;
	}


	public void setRuta(String ruta) {
		Ruta = ruta;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Monte other = (Monte) obj;
		return Objects.equals(Nombre, other.Nombre);
	}


	@Override
	public String toString() {
		return "Monte [Nombre=" + Nombre + ", Provincia=" + Provincia + ", Altura=" + Altura + ", Coordenadas="
				+ Coordenadas + ", Macizo=" + Macizo + ", Ruta=" + Ruta + "]";
	}


	public Monte() {
	}

}