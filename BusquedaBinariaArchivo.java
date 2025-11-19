import java.util.Arrays;
import java.util.Scanner;

public class BusquedaBinariaArchivo {
    // Iniciamos con la construcción de un main

    public static void main(String[] args) {
        String archivoEntrada = "numeros.txt";
        String archivoSalida = "numeros_ordenados.txt";

        int[] numeros = leerArchivo(archivoEntrada);

        if (numeros != null) {
            System.out.println("numeros originales:");
            imprimirArray(numeros);

            // aqui se ordenaran los datos
            Arrays.sort(numeros);

            System.out.println("\n numeros ordenados:");
            imprimirArray(numeros);

             // aqui se guardan en un archivo nuevo
            escribirArchivo(numeros, archivoSalida);
            System.out.println("\n archivo generado exitosamente: " + archivoSalida);

            // aqui realiza la búsqueda binaria
            Scanner sc = new Scanner(System.in);
            System.out.print("\n ingresa un número a buscar: ");
            int numeroBuscado = sc.nextInt();

            int resultado = busquedaBinaria(numeros, numeroBuscado);

            if (resultado != -1) {
                System.out.println("el número " + numeroBuscado + " se encuentra en la posición (índice): " + resultado);
            } else {
                System.out.println("el número " + numeroBuscado + " no está en la lista.");
            }

            sc.close();
        } else {
            System.out.println("No se pudo leer el archivo.");
        }
    }
}
