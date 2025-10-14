package lab2;

public class Main {
    public static void main(String[] args) {

        Scoala scoala = new Scoala();

        Clasa clasa1A = new Clasa(25, NumarClasa.I, 'A');
        Clasa clasa1B = new Clasa(30, NumarClasa.I, 'B');
        Clasa clasa2A = new Clasa(28, NumarClasa.II, 'A');

        scoala.adaugaClasa("1A", clasa1A);
        scoala.adaugaClasa("1B", clasa1B);
        scoala.adaugaClasa("2B", clasa2A);

        Elev elev1 = new Elev("Pop Ion", Gen.Masculin);
        Elev elev2 = new Elev("Popescu Maria", Gen.Feminin);
        Elev elev3 = new Elev("Dumitrescu Ana", Gen.Feminin);
        Elev elev4 = new Elev("Muntean Mihai", Gen.Masculin);
        Elev elev5 = new Elev("Stanescu David", Gen.Masculin);
        Elev elev6 = new Elev("Popa Ana", Gen.Feminin);

        scoala.adaugaElevInClasa("1A", elev1);
        scoala.adaugaElevInClasa("1A", elev2);
        scoala.adaugaElevInClasa("1B", elev3);
        scoala.adaugaElevInClasa("1B", elev4);
        scoala.adaugaElevInClasa("2A", elev5);
        scoala.adaugaElevInClasa("2A", elev6);

        System.out.println("\n  ACTIVITĂȚI EXTRACURRICULARE  \n");

        Profesor profSport = new Profesor("Marin Constantin", "Sport");
        Profesor profMuzica = new Profesor("Vasilescu Diana", "Muzică");
        Profesor profInformatica = new Profesor("Radu Adrian", "Informatică");
        Profesor profArta = new Profesor("Cristea Ioana", "Artă");

        Activitate fotbal = new Activitate("Fotbal", profSport);
        Activitate cor = new Activitate("Cor", profMuzica);
        Activitate programare = new Activitate("Programare", profInformatica);
        Activitate pictura = new Activitate("Pictură", profArta);

        scoala.adaugaActivitate("Fotbal", fotbal);
        scoala.adaugaActivitate("Cor", cor);
        scoala.adaugaActivitate("Programare", programare);
        scoala.adaugaActivitate("Pictură", pictura);

        System.out.println("\n  Înscrieri la activități  \n");

        scoala.inscriereElevLaActivitate(elev1, "Fotbal");
        scoala.inscriereElevLaActivitate(elev1, "Programare");
        scoala.inscriereElevLaActivitate(elev2, "Cor");
        scoala.inscriereElevLaActivitate(elev2, "Pictură");
        scoala.inscriereElevLaActivitate(elev3, "Cor");
        scoala.inscriereElevLaActivitate(elev3, "Pictură");
        scoala.inscriereElevLaActivitate(elev4, "Fotbal");
        scoala.inscriereElevLaActivitate(elev4, "Programare");
        scoala.inscriereElevLaActivitate(elev5, "Programare");
        scoala.inscriereElevLaActivitate(elev5, "Fotbal");
        scoala.inscriereElevLaActivitate(elev5, "Cor");
        scoala.inscriereElevLaActivitate(elev6, "Pictură");

        System.out.println();
        scoala.inscriereElevLaActivitate(elev1, "Fotbal");

        scoala.afiseazaTopActivitati();

        scoala.afiseazaInformatii();

        System.out.println(" Eliminare elev din activitate \n");
        scoala.eliminareElevDinActivitate(elev5, "Cor");

        scoala.afiseazaTopActivitati();

        System.out.println(" Eliminare activitate \n");
        scoala.eliminaActivitate("Fotbal");

        scoala.afiseazaInformatii();

        System.out.println("Statistici finale:");
        System.out.println("Elevi cu cel puțin o activitate: " + scoala.getEleviCuActivitati());
    }
}