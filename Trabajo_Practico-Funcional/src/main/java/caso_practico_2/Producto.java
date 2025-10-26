package caso_practico_2;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Producto {
    private String nombre;
    private String categoria;
    private Double precio;
    private int stock;
}
