import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
    // uso del bufer para leer los archivos
    public static int[] leerArchivo(String nombreArchivo) { 
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            int count = 0;

            // contara cuántos números hay
            while ((linea = br.readLine()) != null) {
                count++;
            }
            int[] numeros = new int[count];
            br.close();

            // lee nuevamente para almacenar
            BufferedReader br2 = new BufferedReader(new FileReader(nombreArchivo));
            int i = 0;
            while ((linea = br2.readLine()) != null) {
                numeros[i] = Integer.parseInt(linea.trim());
                i++;
            }
            br2.close();

            return numeros;
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return null;
        }
    }

    // construccion del método búsqueda binaria
    public static int busquedaBinaria(int[] arr, int dato) {
        int inicio = 0;
        int fin = arr.length - 1;

        while (inicio <= fin) {
            int mitad = inicio + (fin - inicio) / 2;  // Evita overflow

            if (arr[mitad] == dato) {
                return mitad;
            } else if (arr[mitad] < dato) {
                inicio = mitad + 1;
            } else {
                fin = mitad - 1;
            }
        }
        return -1; // No encontrado
    }


