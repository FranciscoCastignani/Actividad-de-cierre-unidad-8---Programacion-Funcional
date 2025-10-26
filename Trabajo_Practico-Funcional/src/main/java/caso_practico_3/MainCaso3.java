package caso_practico_3;

import java.util.*;
import java.util.stream.Collectors;

public class MainCaso3 {
    public static void main(String[] args){
        List<Libro> libros = crearLibros();
        List<String> titulosLargos = libros.stream()
                .filter(libro -> libro.getPaginas() > 300)
                .map(Libro::getTitulo)
                .sorted()
                .collect(Collectors.toList());

        double promedioPaginas = libros.stream()
                .mapToInt(Libro::getPaginas)
                .average()
                .orElse(0.0);

        Map<String, Long> conteoLibrosPorAutor = libros.stream()
                .collect(Collectors.groupingBy(Libro::getAutor,Collectors.counting()));

        Optional<Libro> libroMasCaro = libros.stream()
                .max(Comparator.comparing(Libro::getPrecio));

        titulosLargos.forEach(System.out::println);
        System.out.println("El promedio de páginas es: " + promedioPaginas);
        System.out.println("Conteo por Autor: " + conteoLibrosPorAutor);
        if (libroMasCaro.isPresent()) {
            System.out.println("El libro mas caro es: " + libroMasCaro.get().getTitulo());
        } else {
            System.out.println("La lista de libros está vacía.");
        }
    }
    private static List<Libro> crearLibros(){
        Libro l1 = Libro.builder().titulo("titulo_a").autor("autor_a")
                .paginas(350).precio(110).build();
        Libro l2 = Libro.builder().titulo("titulo_b").autor("autor_a")
                .paginas(200).precio(210).build();
        Libro l3 = Libro.builder().titulo("titulo_c").autor("autor_a")
                .paginas(510).precio(420).build();
        Libro l4 = Libro.builder().titulo("titulo_d").autor("autor_b")
                .paginas(400).precio(300).build();
        Libro l5 = Libro.builder().titulo("titulo_e").autor("autor_b")
                .paginas(100).precio(254).build();
        Libro l6 = Libro.builder().titulo("titulo_f").autor("autor_c")
                .paginas(220).precio(165).build();
        Libro l7 = Libro.builder().titulo("titulo_g").autor("autor_c")
                .paginas(240).precio(120).build();
        Libro l8 = Libro.builder().titulo("titulo_h").autor("autor_c")
                .paginas(345).precio(145).build();
        Libro l9 = Libro.builder().titulo("titulo_i").autor("autor_c")
                .paginas(260).precio(50).build();
        Libro l10 = Libro.builder().titulo("titulo_j").autor("autor_a")
                .paginas(305).precio(100).build();
        return Arrays.asList(l1,l2,l3,l4,l5,l6,l7,l8,l9,l10);
    }
}
