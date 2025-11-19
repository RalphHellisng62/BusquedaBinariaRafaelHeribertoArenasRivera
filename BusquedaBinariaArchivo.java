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

             // Guardarlos en archivo nuevo
            escribirArchivo(numeros, archivoSalida);
            System.out.println("\n📁 Archivo generado exitosamente: " + archivoSalida);

            // Búsqueda binaria
            Scanner sc = new Scanner(System.in);
            System.out.print("\n🔎 Ingresa un número a buscar: ");
            int numeroBuscado = sc.nextInt();
    }
}
