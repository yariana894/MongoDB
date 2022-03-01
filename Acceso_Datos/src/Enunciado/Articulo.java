package Enunciado;

import java.io.Serializable;

public class Articulo implements Serializable {

    public int codigo;
    public String descripcion;
    public double pvp;
    public int stock;
    public int stockMinimo;

    public Articulo() {
        super();
    }

    public Articulo(int codigo, String descripcion, double pvp, int stock, int stockMinimo) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.pvp = pvp;
        this.stock = stock;
        this.stockMinimo = stockMinimo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPvp() {
        return pvp;
    }

    public void setPvp(double pvp) {
        this.pvp = pvp;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }


    @Override
    public String toString() {
        return "Articulo{" +
                "codigo=" + codigo +
                ", descripcion='" + descripcion + '\'' +
                ", pvp=" + pvp +
                ", stock=" + stock +
                ", stockMinimo=" + stockMinimo +
                '}';
    }
}
