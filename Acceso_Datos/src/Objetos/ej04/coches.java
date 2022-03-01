package Objetos.ej04;

import java.io.ObjectOutput;
import java.io.Serializable;

public class coches implements Serializable {

    private String matricula;
    private String marca;
    private String modelo;
    private int tamanhoDeposito;
    private double precio;

    //  getters y setters


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

    // constructor

    public coches(String matricula, String marca, String modelo, int tamanhoDeposito, double precio) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.tamanhoDeposito = tamanhoDeposito;
        this.precio = precio;
    }

    // toString


    @Override
    public String toString() {
        return "coches{" +
                "matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", tamanhoDeposito=" + tamanhoDeposito +
                ", precio=" + precio +
                '}';
    }
}
