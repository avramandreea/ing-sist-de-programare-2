package lab2;

import java.util.HashMap;
import java.util.*;
import java.util.List;

 public class Scoala {
    private Map<String, Clasa> clase;
    private Map<String, Activitate> activitati;

    public Scoala() {
        this.clase = new HashMap<>();
        this.activitati = new HashMap<>();
    }


    public void adaugaClasa(String identificator, Clasa clasa) {
        clase.put(identificator, clasa);
        System.out.println("Clasa " + identificator + " a fost adăugată în școală.");
    }

    public void eliminaClasa(String identificator) {
        if (clase.remove(identificator) != null) {
            System.out.println("Clasa " + identificator + " a fost eliminată din școală.");
        } else {
            System.out.println("Clasa " + identificator + " nu există în școală.");
        }
    }

    public void adaugaElevInClasa(String identificator, Elev elev) {
        Clasa clasa = clase.get(identificator);
        if (clasa != null) {
            clasa.adaugaElev(elev);
        } else {
            System.out.println("Clasa " + identificator + " nu există în școală.");
        }
    }

    public void eliminaElevDupaNume(String nume) {
        boolean gasit = false;
        for (Clasa clasa : clase.values()) {
            List<Elev> elevi = clasa.getElevi();
            for (Elev elev : elevi) {
                if (elev.getNume().equals(nume)) {
                    clasa.eliminaElev(elev);
                    gasit = true;
                    break;
                }
            }
            if (gasit) break;
        }
        if (!gasit) {
            System.out.println("Elevul cu numele " + nume + " nu a fost găsit în nicio clasă.");
        }
    }


    public void adaugaActivitate(String numeActivitate, Activitate activitate) {
        activitati.put(numeActivitate, activitate);
        System.out.println("Activitatea '" + numeActivitate + "' a fost adăugată în școală.");
    }

    public void eliminaActivitate(String numeActivitate) {
        Activitate activitate = activitati.remove(numeActivitate);
        if (activitate != null) {

            for (Elev elev : activitate.getParticipanti()) {
                elev.eliminaActivitate(numeActivitate);
            }
            System.out.println("Activitatea '" + numeActivitate + "' a fost eliminată din școală.");
        } else {
            System.out.println("Activitatea '" + numeActivitate + "' nu există în școală.");
        }
    }

    public void inscriereElevLaActivitate(Elev elev, String numeActivitate) {
        Activitate activitate = activitati.get(numeActivitate);
        if (activitate != null) {
            activitate.inscriereElev(elev);
        } else {
            System.out.println("Activitatea '" + numeActivitate + "' nu există în școală.");
        }
    }

    public void eliminareElevDinActivitate(Elev elev, String numeActivitate) {
        Activitate activitate = activitati.get(numeActivitate);
        if (activitate != null) {
            activitate.eliminareElev(elev);
        } else {
            System.out.println("Activitatea '" + numeActivitate + "' nu există în școală.");
        }
    }

    public int getNumarClase() {
        return clase.size();
    }

    public int getTotalElevi() {
        int total = 0;
        for (Clasa clasa : clase.values()) {
            total += clasa.getTotalElevi();
        }
        return total;
    }

    public void afiseazaTopActivitati() {
        System.out.println("\n TOP ACTIVITĂȚI ");

        if (activitati.isEmpty()) {
            System.out.println("Nu există activități în școală.");
            System.out.println("\n");

            return;
        }

        List<Map.Entry<String, Activitate>> listaActivitati =
                new ArrayList<>(activitati.entrySet());

        listaActivitati.sort((a, b) ->
                Integer.compare(
                        b.getValue().getNumarParticipanti(),
                        a.getValue().getNumarParticipanti()
                )
        );

        int pozitie = 1;
        for (Map.Entry<String, Activitate> entry : listaActivitati) {
            Activitate act = entry.getValue();
            System.out.println(pozitie + ". " + act.getNume() +
                    " - " + act.getNumarParticipanti() + " participanți" +
                    " (Coordonator: " + act.getCoordinator().getNume() + ")");
            pozitie++;
        }
        System.out.println(" \n");
        System.out.println(" \n");
    }

    public int getEleviCuActivitati() {
        Set<Elev> eleviCuActivitati = new HashSet<>();

        for (Activitate activitate : activitati.values()) {
            eleviCuActivitati.addAll(activitate.getParticipanti());
        }

        return eleviCuActivitati.size();
    }

    public void afiseazaInformatii() {
        System.out.println("\n INFO ȘCOALĂ ");
        System.out.println("Număr total de clase: " + getNumarClase());
        System.out.println("Număr total de elevi: " + getTotalElevi());
        System.out.println("Număr total de activități: " + activitati.size());
        System.out.println("Elevi care participă la activități: " + getEleviCuActivitati());

        System.out.println("\nDetalii clase:");
        for (Map.Entry<String, Clasa> entry : clase.entrySet()) {
            Clasa clasa = entry.getValue();
            System.out.println("  " + entry.getKey() + " - " + clasa);
            for (Elev elev : clasa.getElevi()) {
                System.out.println("    - " + elev);
                if (elev.getNumarActivitati() > 0) {
                    System.out.println("      Activități: " + elev.getActivitati());
                }
            }
        }

        System.out.println("\nDetalii activități:");
        for (Map.Entry<String, Activitate> entry : activitati.entrySet()) {
            Activitate act = entry.getValue();
            System.out.println("  " + act);
            for (Elev elev : act.getParticipanti()) {
                System.out.println("    - " + elev.getNume());
            }
        }
        System.out.println("\n");
        System.out.println("\n");
    }

    public Elev cautaElevDupaNume(String nume) {
        for (Clasa clasa : clase.values()) {
            for (Elev elev : clasa.getElevi()) {
                if (elev.getNume().equals(nume)) {
                    return elev;
                }
            }
        }
        return null;
    }
}