package domain.tp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inscripcion {

    private List<Materia> materias;
    private Alumno alumno;

    public Inscripcion(Alumno alumno) {
        this.materias = new ArrayList<Materia>();
        this.alumno = alumno;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public void agregarMaterias(Materia... materias){
        Collections.addAll(this.materias,materias);
    }

    public Boolean aprobada(){//Comprobar que el alumno tiene aprobadas todas las correlativas de las materias que se quiere anotar
        List<Materia> materiasAprobadas = alumno.getMateriasAprobadas();

        return materias.stream()
                .allMatch(materia -> correlativasAprobadas(materia,materiasAprobadas));
    }

    private Boolean correlativasAprobadas(Materia materia, List<Materia> materiasAprobadas) {
        // Si no tiene correlativas, está aprobada automáticamente
        if (materia.getCorrelativas().isEmpty()) {
            return true;
        }

        // Verificar si todas las correlativas están aprobadas
        return materia.getCorrelativas().stream().allMatch(correlativa ->
                materiasAprobadas.contains(correlativa) && correlativasAprobadas(correlativa, materiasAprobadas)
        );
    }

}
