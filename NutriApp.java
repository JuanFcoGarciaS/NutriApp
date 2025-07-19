import java.util.InputMismatchException;
import java.util.Scanner;

public class NutriApp{

    static String[] macroNutrientes = {"Proteína", "Grasa", "Carbohidrato" };

    static double[] gramos = new double[3];

    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);

        int cantidadIngredientes = (int) solicitarDato("¿Cuántos ingredientes va a ingresar?: ", leer);

        for (int i = 0; i < cantidadIngredientes; i++) {

            System.out.println("\nIngrediente número: " + (i + 1));

            double cantidadGramos = solicitarDato("Cantidad en gramos: ", leer);

            int grupoSeleccionado = seleccionarGrupo(leer);

            
            if (grupoSeleccionado >= 0 && grupoSeleccionado < gramos.length) {
                gramos[grupoSeleccionado] += cantidadGramos;
            } else {
                System.out.println("Error. Se ignora este ingrediente.");
            }
        }

        double calorias = calcularCalorias(gramos);

        mostrarResultados(gramos, calorias);

        leer.close();
    }

    // Método para pedir datos numéricos con validación
    public static double solicitarDato(String mensaje, Scanner leer) {
        double valor = 0;
        boolean entradaValida = false;
        while (!entradaValida) {

            try {
                System.out.print(mensaje);
                valor = leer.nextDouble();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Solo valores númericos.");
                leer.next(); // Limpiar el buffer
            }

        }
        return valor;
    }

    // Muestra una lista y pide seleccionar el macronutriente, con validación
    public static int seleccionarGrupo(Scanner leer) {
        System.out.println("Selecciona el grupo del nutriente:");
        for (int i = 0; i < macroNutrientes.length; i++) {

            System.out.println(i + " - " + macroNutrientes[i]);

        }

        int seleccion = -1;
        boolean entradaValida = false;
        while (!entradaValida) {

            try {
                System.out.print("Opción: ");
                seleccion = leer.nextInt();
                if (seleccion >= 0 && seleccion < macroNutrientes.length) {
                    entradaValida = true;
                } else {
                    System.out.println("Error: Selecciona un número válido entre 0 y " + (macroNutrientes.length - 1));
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número entero.");
                leer.next(); // Limpiar el buffer
            }

        }
        return seleccion;
    }

    // Calcula las calorías. Las proteinas y carbohidratos = 4 kcal * gramo y Grasa 9 kcal * gramo.
    public static double calcularCalorias(double[] gramos) {
        return (gramos[0] * 4) + (gramos[1] * 9) + (gramos[2] * 4);
    }

    // Imprime el resultado final y evalua si es saludable o no
    public static void mostrarResultados(double[] gramos, double calorias) {
        System.out.println("\n- Resultado Nutricional -");
        System.out.println("\n- Basado en una Dieta de 2000kcal, exceder este valor diario es un exceso nutricional - \n");
        for (int i = 0; i < macroNutrientes.length; i++) {
            System.out.printf("%s: %.2f g%n", macroNutrientes[i], gramos[i]);
        }
        System.out.printf("Total Calorías: %.2f kcal%n", calorias);

        if (calorias <= 2000 && gramos[0] >= 50) {
            System.out.println("Resultado: Nutricionalmente aceptable");
            System.out.println("Gracias por usar nuestra App Nutricional - Copyright @JuanFcoGarciaS");
        } else {
            System.out.println("Resultado: No es nutricionalmente aceptable");
            System.out.println("Gracias por usar nuestra App Nutricional - Copyright @JuanFcoGarciaS");
        }
    }
}