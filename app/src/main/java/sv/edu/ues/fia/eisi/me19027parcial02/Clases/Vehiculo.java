package sv.edu.ues.fia.eisi.me19027parcial02.Clases;

import java.util.Date;

public class Vehiculo {
    private String placa,Propietario,marca,color;
    private int anio;

    public Vehiculo() {
    }

    public Vehiculo(String placa, String propietario, String marca, String color, int anio) {
        this.placa = placa;
        Propietario = propietario;
        this.marca = marca;
        this.color = color;
        this.anio = anio;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getPropietario() {
        return Propietario;
    }

    public void setPropietario(String propietario) {
        Propietario = propietario;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAnio() { return anio;
    }

    public void setAnio(int anio) { this.anio = anio;
    }
}

