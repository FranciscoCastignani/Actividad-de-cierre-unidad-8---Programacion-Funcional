package caso_practico_1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainCaso1 {
    public static void main(String[] args){

        List<Alumno> alumnos = crearAlumnos();

        List<String> nombresAlumnosAprobados = alumnos.stream()
                .filter(p -> p.getNota() >= 7)
                .map(Alumno::getNombre)
                .collect(Collectors.toList());

        Double promedio = alumnos.stream()
                .mapToDouble(Alumno::getNota)
                .average().orElse(0);

        Map<String, List<Alumno>> alumnosPorCurso = alumnos.stream()
                .collect(Collectors.groupingBy(Alumno::getCurso));

        List<Integer> mejoresPromedios = alumnos.stream().map(Alumno::getNota)
                .sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());

        System.out.println(nombresAlumnosAprobados);
        System.out.println(promedio);
        System.out.println(alumnosPorCurso);
        System.out.println(mejoresPromedios);
    }

    private static List<Alumno> crearAlumnos(){

        Alumno a1 = Alumno.builder().curso("2k1")
                .nombre("alumno1").nota(10).build();
        Alumno a2 = Alumno.builder().curso("2k1")
                .nombre("alumno2").nota(7).build();
        Alumno a3 = Alumno.builder().curso("3k10")
                .nombre("alumno3").nota(2).build();
        Alumno a4 = Alumno.builder().curso("3k13")
                .nombre("alumno4").nota(5).build();
        Alumno a5 = Alumno.builder().curso("3k10")
                .nombre("alumno5").nota(4).build();
        Alumno a6 = Alumno.builder().curso("3k7")
                .nombre("alumno6").nota(6).build();
        Alumno a7 = Alumno.builder().curso("3k7")
                .nombre("alumno7").nota(10).build();
        return  Arrays.asList(a1, a2, a3, a4, a5, a6,a7);
    }

}
