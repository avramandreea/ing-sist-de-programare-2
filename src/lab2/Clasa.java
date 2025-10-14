package lab2;
import java.util.ArrayList;
import java.util.List;

public  class Clasa {
    private int capacitate;
    private NumarClasa numar;
    private char litera;
    private List<Elev> elevi;

    public Clasa(int capacitate, NumarClasa numar, char litera) {
        this.capacitate = capacitate;
        this.numar = numar;
        this.litera = litera;
        this.elevi = new ArrayList<>();
    }

    public void adaugaElev(Elev elev) {
        if (elevi.size() < capacitate) {
            elevi.add(elev);
            System.out.println("Elevul " + elev.getNume() + " a fost adăugat în clasa " + numar + litera);
        } else {
            System.out.println("Clasa " + numar + litera + " este plină! Capacitate: " + capacitate);
        }
    }

    public void eliminaElev(Elev elev) {
        if (elevi.remove(elev)) {
            System.out.println("Elevul " + elev.getNume() + " a fost eliminat din clasa " + numar + litera);
        } else {
            System.out.println("Elevul nu a fost găsit în clasă.");
        }
    }

    public int getTotalElevi() {
        return elevi.size();
    }

    public int getCapacitate() {
        return capacitate;
    }

    public NumarClasa getNumar() {
        return numar;
    }

    public char getLitera() {
        return litera;
    }

    public List<Elev> getElevi() {
        return new ArrayList<>(elevi);
    }

    @Override
    public String toString() {
        return "Clasa " + numar + litera + " (Elevi: " + elevi.size() + "/" + capacitate + ")";
    }
}