package sv.edu.ues.fia.eisi.me19027parcial02.Clases;


public class Conductor {
    private String licencia,nombre,estadoCivil,tipoLicencia;
    private int edad;

    public Conductor() {
    }

    public Conductor(String licencia, String nombre, String estadoCivil, String tipoLicencia, int edad) {
        this.licencia = licencia;
        this.nombre = nombre;
        this.estadoCivil = estadoCivil;
        this.tipoLicencia = tipoLicencia;
        this.edad = edad;
    }

    public String getlicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getTipoLicencia() {
        return tipoLicencia;
    }

    public void setTipoLicencia(String tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}

