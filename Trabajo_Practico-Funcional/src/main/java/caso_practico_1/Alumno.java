package caso_practico_1;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Alumno {
    private String nombre;
    private int nota;
    private String curso;
}
