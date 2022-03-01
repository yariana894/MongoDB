package Objetos.Automoviles;

import java.io.Serializable;

public class Coches implements Serializable {
    String matricula;
    String marca;
    String modelo;
    int tamanhoDeposito;
    double precio;

    public Coches() {
        super();
    }

    public Coches(String matricula, String marca, String modelo, int tamanhoDeposito, double precio) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.tamanhoDeposito = tamanhoDeposito;
        this.precio = precio;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getTamanhoDeposito() {
        return tamanhoDeposito;
    }

    public void setTamanhoDeposito(int tamanhoDeposito) {
        this.tamanhoDeposito = tamanhoDeposito;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Coches{" +
                "matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", tamanhoDeposito=" + tamanhoDeposito +
                ", precio=" + precio +
                '}';
    }
}
