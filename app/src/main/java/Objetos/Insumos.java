package Objetos;

import java.util.Arrays;
import java.util.Objects;

public class Insumos {

    private int id;
    private String[] insumos = {"Loco","Mago","Sacerdotisa","Emperatriz"};
    private int numero[] = {0, 1, 2, 3 };
    private int posicion;

    public Insumos()
    {

    }

    public Insumos(int id, String[] insumos, int[] numero, int posicion) {
        this.id = id;
        this.insumos = insumos;
        this.numero = numero;
        this.posicion = posicion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getInsumos() {
        return insumos;
    }

    public void setInsumos(String[] insumos) {
        this.insumos = insumos;
    }

    public int[] getNumero() {
        return numero;
    }

    public void setNumero(int[] numero) {
        this.numero = numero;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Insumos insumos1 = (Insumos) o;
        return id == insumos1.id && posicion == insumos1.posicion && Arrays.equals(insumos, insumos1.insumos) && Arrays.equals(numero, insumos1.numero);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, posicion);
        result = 31 * result + Arrays.hashCode(insumos);
        result = 31 * result + Arrays.hashCode(numero);
        return result;
    }

    @Override
    public String toString() {
        return "Insumos{" +
                "id=" + id +
                ", insumos=" + Arrays.toString(insumos) +
                ", numero=" + Arrays.toString(numero) +
                ", posicion=" + posicion +
                '}';
    }
}
