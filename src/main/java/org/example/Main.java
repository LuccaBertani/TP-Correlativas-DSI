package org.example;

import domain.tp.Alumno;
import domain.tp.Inscripcion;
import domain.tp.Materia;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Alumno lucca = new Alumno("Lucca");
        Materia fisicaII = new Materia("FisicaII");
        Materia aura = new Materia("aura");
        Inscripcion inscripcion = new Inscripcion(lucca);

        aura.agregarCorrelativas(fisicaII);
        Materia amI = new Materia("Analisis Matematico I");
        Materia fisicaI = new Materia("Fisica I");
        fisicaII.agregarCorrelativas(amI,fisicaI);

        lucca.agregarMateriasAprobadas(amI,fisicaI,fisicaII);
        inscripcion.agregarMaterias(aura);

        System.out.println(inscripcion.aprobada());

    }
}