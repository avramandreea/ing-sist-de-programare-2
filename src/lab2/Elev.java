package lab2;
import java.util.HashSet;
import java.util.Set;

public class Elev {
    private String nume;
    private Gen gen;
    private Set<String> activitati;

    public Elev(String nume, Gen gen) {
        this.nume = nume;
        this.gen = gen;
        this.activitati = new HashSet<>();
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Gen getGen() {
        return gen;
    }

    public void setGen(Gen gen) {
        this.gen = gen;
    }

    public Set<String> getActivitati() {
        return new HashSet<>(activitati);
    }

    public void adaugaActivitate(String numeActivitate) {
        activitati.add(numeActivitate);
    }

    public void eliminaActivitate(String numeActivitate) {
        activitati.remove(numeActivitate);
    }

    public boolean participaLaActivitate(String numeActivitate) {
        return activitati.contains(numeActivitate);
    }

    public int getNumarActivitati() {
        return activitati.size();
    }

    @Override
    public String toString() {
        return "Elev nume='" + nume + "', gen=" + gen + ", activitati=" + activitati.size() ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Elev elev = (Elev) o;
        return nume.equals(elev.nume);
    }

    @Override
    public int hashCode() {
        return nume.hashCode();
    }
}


