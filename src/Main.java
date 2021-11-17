import java.util.ArrayList;
import java.util.List;
import java.time.Clock;
import java.time.Duration;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Clock baseClock = Clock.systemUTC();

        System.out.println("inicio: " + baseClock.instant());

        Scanner scan = new Scanner(System.in).useDelimiter("\n");

        List<Pais> paises = new ArrayList();

        paises.add(new Pais(1, "Argentina", 54));
        paises.add(new Pais(2, "Brasil", 55));
        paises.add(new Pais(3, "Chile", 56));
        paises.add(new Pais(4, "Bolivia", 591));

        List<Integer> codigos = paises.stream().map(pais -> pais.getCodigo())
                .collect(Collectors.toList());

        for (Integer codigo : codigos) {
            System.out.println(codigo);
        }

        System.out.println("Ingrese código de area del país a buscar: ");
        Integer codigoBuscar = scan.nextInt();

        Pais pais = paises.stream().filter(p -> p.getCodigo() == codigoBuscar)
                .findFirst().orElse(null);

        if (pais != null) {
            System.out.println("El país con código de area " + codigoBuscar + " es " +
                    pais.getNombre() + ".");
        } else {
            System.out.println("El código de area no corresponde a ningún país en la lista.");
        }

        System.out.println("final:" + baseClock.instant());

    }
}
