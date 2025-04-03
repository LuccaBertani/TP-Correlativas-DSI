package domain.tp;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests {

    @Test
    public void luccaCursaTPA(){

        Alumno lucca = new Alumno("Lucca");
        Materia fisicaII = new Materia("FisicaII");
        Materia tecnologiasParaLaAutomatizacion = new Materia("TecnologiasParaLaAutomatizacion");
        Inscripcion inscripcion = new Inscripcion(lucca);

        tecnologiasParaLaAutomatizacion .agregarCorrelativas(fisicaII);
        Materia amI = new Materia("Analisis Matematico I");
        Materia fisicaI = new Materia("Fisica I");
        fisicaII.agregarCorrelativas(amI,fisicaI);

        lucca.agregarMateriasAprobadas(amI,fisicaI,fisicaII);
        inscripcion.agregarMaterias(tecnologiasParaLaAutomatizacion);

        System.out.println(inscripcion.aprobada());

        Assertions.assertTrue(inscripcion.aprobada());
    }

}