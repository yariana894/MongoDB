package z_EXAMENES.ExGrupoJueves.Ej2;

import java.io.*;

public class Articulo implements Serializable {
    private static final long serialVersionUID = 1L;
    private int codigo;
    private String descripcion;
    private double pvp;
    private int stock;
    private int stockMinimo;

    public Articulo() {
        super();
    }

    public Articulo(int codigo, String descripcion, double pvp, int stock, int stockMinimo) {
        super();
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

    public boolean buscarArticulo(int codigo, File f) {
        boolean sw = false; // false no existe

        FileInputStream fis = null;
        ObjectInputStream entrada = null;

        try {
            fis = new FileInputStream(f);
            entrada = new ObjectInputStream(fis);
            Articulo articulo = new Articulo();

            while (true && !sw) { //mientras haya registros y no lo haya encontrado
                articulo = (Articulo) entrada.readObject();
                // comprobamos si el registro leido es igual al que buscamos
                if (articulo.getCodigo() == codigo) {
                    sw = true;  //articulo encontrado
                }

            }// fin del while

        } catch (FileNotFoundException fnf) {
            System.out.println(fnf.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe.getMessage());
        } catch (EOFException eof) {
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } finally {
            try {
                entrada.close();
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        }
        return sw;
    }
}
