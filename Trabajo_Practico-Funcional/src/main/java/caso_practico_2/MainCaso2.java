package caso_practico_2;

import caso_practico_1.Alumno;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainCaso2 {
    public static void main(String[] args){

        List<Producto> productos = crearProductos();

        List<Producto> productosMayor100 = productos.stream()
                .filter(p->p.getPrecio()>100)
                .sorted(Comparator.comparing(Producto::getPrecio).reversed())
                .collect(Collectors.toList());

        Map<String,Integer> catStock = productos.stream()
                .collect(Collectors.groupingBy(Producto::getCategoria,
                        Collectors.summingInt(Producto::getStock)));

        String cadenaProductos = productos.stream()
                .map(p-> "Nombre: "+p.getNombre() + " - Precio: "+p.getPrecio())
                .collect(Collectors.joining("; "));

        Double promedioPrecios = productos.stream()
                .mapToDouble(Producto::getPrecio)
                .average().orElse(0.0d);
        Map<String,Double> promedioPorCat = productos.stream()
                .collect(Collectors.groupingBy(Producto::getCategoria,Collectors.averagingDouble(Producto::getPrecio)));

        System.out.println(productosMayor100);
        System.out.println(catStock);
        System.out.println(cadenaProductos);
        System.out.println(promedioPrecios);
        System.out.println(promedioPorCat);
    }

    private static List<Producto> crearProductos(){
        Producto p1 = Producto.builder().nombre("producto1")
                .stock(10).categoria("A")
                .precio(101d).build();
        Producto p2 = Producto.builder().nombre("producto2")
                .stock(10).categoria("A")
                .precio(110d).build();
        Producto p3 = Producto.builder().nombre("producto3")
                .stock(10).categoria("B")
                .precio(94d).build();
        Producto p4 = Producto.builder().nombre("producto4")
                .stock(101).categoria("B")
                .precio(110d).build();
        Producto p5 = Producto.builder().nombre("producto5")
                .stock(103).categoria("B")
                .precio(10d).build();
        Producto p6 = Producto.builder().nombre("producto6")
                .stock(57).categoria("C")
                .precio(94d).build();

        return Arrays.asList(p1,p2,p3,p4,p5,p6);
    }

}
