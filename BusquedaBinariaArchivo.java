import java.util.Arrays;

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
    }
}
