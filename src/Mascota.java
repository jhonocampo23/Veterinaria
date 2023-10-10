import java.util.ArrayList;
import java.util.List;

class Mascota {
    private int codigoMascota;
    private String nombre;
    private int edad;
    private String cedulaDuenio;
    private List<Vacuna> vacunasAplicadas;

    public Mascota(int codigoMascota, String nombre, int edad, String cedulaDuenio) {
        this.codigoMascota = codigoMascota;
        this.nombre = nombre;
        this.edad = edad;
        this.cedulaDuenio = cedulaDuenio;
        this.vacunasAplicadas = new ArrayList<>();
    }

    public int getCodigoMascota() {
        return codigoMascota;
    }

    public void setCodigoMascota(int codigoMascota) {
        this.codigoMascota = codigoMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCedulaDuenio() {
        return cedulaDuenio;
    }

    public void setCedulaDuenio(String cedulaDuenio) {
        this.cedulaDuenio = cedulaDuenio;
    }

    public List<Vacuna> getVacunasAplicadas() {
        return vacunasAplicadas;
    }

    public void agregarVacunaAplicada(Vacuna vacuna) {
        vacunasAplicadas.add(vacuna);
    }
}