package caso_practico_4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainCaso4 {

    public static void main(String[] args){
        List<Empleado> empleados = crearEmpleados();

        List<Empleado> empleadosAltoSalario = empleados.stream()
                .filter(e -> e.getSalario() > 2000)
                .sorted(Comparator.comparing(Empleado::getSalario).reversed())
                .collect(Collectors.toList());

        double promedioSalario = empleados.stream()
                .mapToDouble(Empleado::getSalario)
                .average()
                .orElse(0.0);

        Map<String, Double> sumaSalariosPorDepto = empleados.stream()
                .collect(Collectors.groupingBy(Empleado::getDepartamento, Collectors.summingDouble(Empleado::getSalario)));

        List<String> nombresMasJovenes = empleados.stream()
                .sorted(Comparator.comparing(Empleado::getEdad))
                .limit(2)
                .map(Empleado::getNombre)
                .collect(Collectors.toList());

        System.out.println(empleadosAltoSalario);
        System.out.println(promedioSalario);
        System.out.println(sumaSalariosPorDepto);
        System.out.println(nombresMasJovenes);
    }
    private static List<Empleado> crearEmpleados(){
        Empleado e1 = Empleado.builder()
                .nombre("Ana Garcia").departamento("Ventas")
                .salario(2200.00).edad(30).build();

        Empleado e2 = Empleado.builder()
                .nombre("Juan Perez").departamento("IT")
                .salario(3500.50).edad(25).build();

        Empleado e3 = Empleado.builder()
                .nombre("Marta Lopez").departamento("Ventas")
                .salario(1800.75).edad(45).build();

        Empleado e4 = Empleado.builder()
                .nombre("Carlos Ruiz").departamento("Marketing")
                .salario(2800.00).edad(35).build();

        Empleado e5 = Empleado.builder()
                .nombre("Sofia Diaz").departamento("IT")
                .salario(4200.00).edad(22).build();

        Empleado e6 = Empleado.builder()
                .nombre("David Cruz").departamento("Marketing")
                .salario(2100.25).edad(50).build();

        Empleado e7 = Empleado.builder()
                .nombre("Elena Vazquez").departamento("Ventas")
                .salario(1950.00).edad(28).build();

        Empleado e8 = Empleado.builder()
                .nombre("Pedro Jimenez").departamento("IT")
                .salario(3800.00).edad(40).build();

        Empleado e9 = Empleado.builder()
                .nombre("Laura Ramos").departamento("RRHH")
                .salario(1500.00).edad(22).build();

        Empleado e10 = Empleado.builder()
                .nombre("Miguel Torres").departamento("Marketing")
                .salario(3100.50).edad(38).build();

        return Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);
    }
}
