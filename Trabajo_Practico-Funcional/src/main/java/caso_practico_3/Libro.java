package caso_practico_3;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Libro {
    private String titulo;
    private String autor;
    private int paginas;
    private double precio;
}
