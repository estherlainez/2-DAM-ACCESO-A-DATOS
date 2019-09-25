package practica2;
import java.io.Serializable;
public class DatosPersona implements Serializable {
	private String dni;
	private String nombre;
	private String apellidos;
	private String fechaN;
	private String telefono;
	
	DatosPersona(String d, String n, String a,String f,String t){
		this.dni=d;
		this.nombre=n;
		this.apellidos=a;
		this.fechaN=f;
		this.telefono=t;
		
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getFechaN() {
		return fechaN;
	}

	public void setFechaN(String fechaN) {
		this.fechaN = fechaN;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "DatosPersona [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fechaN=" + fechaN
				+ ", telefono=" + telefono + "]";
	}
	

}
