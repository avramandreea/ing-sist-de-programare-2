package lab2;
import java.util.HashSet;
import java.util.Set;


public class Activitate {
    private String nume;
    private Profesor coordonator;
    private Set<Elev> participanti;

    public Activitate(String nume, Profesor coordonator) {
        this.nume = nume;
        this.coordonator = coordonator;
        this.participanti = new HashSet<>();
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Profesor getCoordinator() {
        return coordonator;
    }

    public void setCoordinator(Profesor coordonator) {
        this.coordonator = coordonator;
    }

    public Set<Elev> getParticipanti() {
        return new HashSet<>(participanti);
    }

    public void inscriereElev(Elev elev) {
        if (participanti.add(elev)) {
            elev.adaugaActivitate(nume);
            System.out.println("Elevul " + elev.getNume() + " a fost inscris la activitatea '" + nume + "'");
        } else {
            System.out.println("Elevul " + elev.getNume() + " este deja inscris la activitatea '" + nume + "'");
        }
    }

    public void eliminareElev(Elev elev) {
        if (participanti.remove(elev)) {
            elev.eliminaActivitate(nume);
            System.out.println("Elevul " + elev.getNume() + " a fost eliminat din activitatea '" + nume + "'");
        } else {
            System.out.println("Elevul " + elev.getNume() + " nu participa la activitatea '" + nume + "'");
        }
    }

    public int getNumarParticipanti() {
        return participanti.size();
    }

    @Override
    public String toString() {
        return "Activitate nume='" + nume + "', coordonator=" + coordonator +
                ", participanti=" + participanti.size() ;
    }
}
