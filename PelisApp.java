
import java.util.Scanner;

public class PelisApp {

    public static void main(String[] args) throws Exception{

        Scanner scanner = new Scanner(System.in);

        // Ingreso de datos
        System.out.print("¿Cuántas películas desea ingresar?: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Limpia el  buffer

        String[] titulos = new String[n];
        int[] añoDeLanzamiento = new int[n];
        String[] generos = new String[n];

        
        for (int i = 0; i < n; i++) {

            System.out.println("\nPelícula #" + (i + 1));

            System.out.print("Título: ");
            titulos[i] = scanner.nextLine();

            System.out.print("Año de lanzamiento: ");

            añoDeLanzamiento[i] = scanner.nextInt();

            scanner.nextLine(); // Limpia el buffer

            System.out.print("Género: ");
            generos[i] = scanner.nextLine();
        }

        // Ordena por año
        ordenarPorAño(titulos, añoDeLanzamiento, generos);

        // Mostrar lista ordenada final
        System.out.println("\nLista de películas ordenadas");
        for (int i = 0; i < n; i++) {

            System.out.println("Año de lanzamiento:" + añoDeLanzamiento[i] + " Título: " + titulos[i] + " Género: " + generos[i] + " ");
            System.out.println("Gracias por usar nuestra App de Cine - Copyright @JuanFcoGarciaS");
        
        }

        scanner.close();
    }

    // Comprobación de Arrays para ordenar por Años de Lanzamiento
    public static void ordenarPorAño(String[] titulos, int[] añoDeLanzamiento, String[] generos) {
        int n = añoDeLanzamiento.length;
        for (int i = 0; i < n - 1; i++) {

            for (int j = i + 1; j < n; j++) {

                if (añoDeLanzamiento[i] > añoDeLanzamiento[j]) {

                    // Intercambiar de posición los años
                    int datosAño = añoDeLanzamiento[i];
                    añoDeLanzamiento[i] = añoDeLanzamiento[j];
                    añoDeLanzamiento[j] = datosAño;

                    // Intercambiar de posición los títulos
                    String datosTitulo = titulos[i];
                    titulos[i] = titulos[j];
                    titulos[j] = datosTitulo;

                    // Intercambiar de posición los géneros
                    String datosGenero = generos[i];
                    generos[i] = generos[j];
                    generos[j] = datosGenero;
                }
            }
        }
    }
}
