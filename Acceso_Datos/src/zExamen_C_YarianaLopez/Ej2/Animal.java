package zExamen_C_YarianaLopez.Ej2;

import java.io.*;

public class Animal implements Serializable{
    private int codigo;
    private String especie;
    private String sexo;
    private int anhoNacimiento;
    private String paisOrigen;
    private String nbZoo;

    public Animal() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Animal(int codigo, String especie, String sexo, int anhoNacimiento, String paisOrigen, String nbZoo) {
        super();
        this.codigo = codigo;
        this.especie = especie;
        this.sexo = sexo;
        this.anhoNacimiento = anhoNacimiento;
        this.paisOrigen = paisOrigen;
        this.nbZoo = nbZoo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getAnhoNacimiento() {
        return anhoNacimiento;
    }

    public void setAnhoNacimiento(int anhoNacimiento) {
        this.anhoNacimiento = anhoNacimiento;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public String getNbZoo() {
        return nbZoo;
    }

    public void setNbZoo(String nbZoo) {
        this.nbZoo = nbZoo;
    }

    @Override
    public String toString() {
        return "Animal [codigo=" + codigo + ", especie=" + especie + ", sexo=" + sexo + ", anhoNacimiento="
                + anhoNacimiento + ", paisOrigen=" + paisOrigen + ", nbZoo=" + nbZoo + "]";
    }

    public void listadoCompleto(File f) {
        FileInputStream fis = null;
        ObjectInputStream entrada = null;

        try {
            fis = new FileInputStream(f);
            entrada = new ObjectInputStream(fis);
            Animal animal = new Animal();

            while (true) {
                animal = (Animal) entrada.readObject();
                System.out.println(animal.getCodigo() + "\t" + animal.getEspecie()
                        + "\t" + animal.getSexo() + "\t" + animal.getAnhoNacimiento() + "\t"
                        + animal.getPaisOrigen() + "\t" + animal.getNbZoo());
            }

        } catch (FileNotFoundException fnf) {
            System.out.println(fnf.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } finally {
            try {
                entrada.close();
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        }
    }

    public boolean buscarAnimal(int codigo, File f) {
        boolean sw = false;

        FileInputStream fis = null;
        ObjectInputStream entrada = null;

        try {
            fis = new FileInputStream(f);
            entrada = new ObjectInputStream(fis);
            Animal animal = new Animal();

            while (true && !sw) {
                animal = (Animal) entrada.readObject();
                if (animal.getCodigo() == codigo) {
                    sw = true;
                }
            }
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
