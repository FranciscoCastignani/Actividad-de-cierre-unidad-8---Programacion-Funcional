package caso_practico_4;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Empleado {
    private String nombre;
    private String departamento;
    private Double salario;
    private int edad;
}
