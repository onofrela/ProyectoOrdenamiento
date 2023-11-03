import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import sort.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>();
        StrategySort strategySort = new BubbleSort(); // Estrategia de ordenamiento inicial
        String algoritmoOrdenamiento = "Bubble Sort";

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n\n------------------------------------------------------");
            System.out.println("Algoritmo de ordenamiento usado: " + algoritmoOrdenamiento);
            imprimirLista(lista);
            System.out.println("Menú:");
            System.out.println("1. Renovar una lista");
            System.out.println("2. Añadir elementos a la lista");
            System.out.println("3. Añadir elementos aleatorios a la lista");
            System.out.println("4. Borrar un rango de índices de elementos");
            System.out.println("5. Borrar un elemento");
            System.out.println("6. Cambiar de estrategia de ordenamiento");
            System.out.println("7. Ordenar");
            System.out.println("8. Desordenar");
            System.out.println("9. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    lista = new ArrayList<>();
                    break;
                case 2:
                    System.out.print("Ingrese un elemento: ");
                    int elemento = scanner.nextInt();
                    lista.add(elemento);
                    break;
                case 3:
                    System.out.print("Ingrese la cantidad de elementos aleatorios a agregar: ");
                    int cantidad = scanner.nextInt();
                    addRandomElements(lista, cantidad);
                    break;
                case 4:
                    System.out.print("Ingrese el índice de inicio del rango: ");
                    int inicio = scanner.nextInt();
                    System.out.print("Ingrese el índice de fin del rango: ");
                    int fin = scanner.nextInt();
                    borrarRango(lista, inicio, fin);
                    break;
                case 5:
                    System.out.print("Ingrese el índice del elemento a borrar: ");
                    int indice = scanner.nextInt();
                    if (indice >= 0 && indice < lista.size()) {
                        lista.remove(indice);
                    } else {
                        System.out.println("Índice fuera de rango.");
                    }
                    break;
                    case 6:
                    System.out.println("Selecciona una estrategia de ordenamiento:");
                    System.out.println("1. Bubble Sort");
                    System.out.println("2. Counting Sort");
                    System.out.println("3. Heap Sort");
                    System.out.println("4. Insertion Sort");
                    System.out.println("5. Merge Sort");
                    System.out.println("6. Quick Sort");
                    System.out.println("7. Radix Sort");
                    int estrategia = scanner.nextInt();
                    switch (estrategia) {
                        case 1:
                            strategySort = new BubbleSort();
                            algoritmoOrdenamiento = "Bubble Sort";
                            break;
                        case 2:
                            strategySort = new CountingSort();
                            algoritmoOrdenamiento = "Counting Sort";
                            break;
                        case 3:
                            strategySort = new HeapSort();
                            algoritmoOrdenamiento = "Heap Sort";
                            break;
                        case 4:
                            strategySort = new InsertionSort();
                            algoritmoOrdenamiento = "Insertion Sort";
                            break;
                        case 5:
                            strategySort = new MergeSort();
                            algoritmoOrdenamiento = "Merge Sort";
                            break;
                        case 6:
                            strategySort = new QuickSort();
                            algoritmoOrdenamiento = "Quick Sort";
                            break;
                        case 7:
                            strategySort = new RadixSort();
                            algoritmoOrdenamiento = "Radix Sort";
                            break;
                        default:
                            System.out.println("Estrategia de ordenamiento no válida.");
                            break;
                    }
                    break;
                case 7:
                    if (!lista.isEmpty()) {
                        long startTime = System.nanoTime();
                        strategySort.Ordenar(lista);
                        long endTime = System.nanoTime();
                        System.out.println("Lista ordenada con " + algoritmoOrdenamiento);
                        System.out.println("Tiempo de ordenamiento: " + (endTime - startTime) + " ns");
                    } else {
                        System.out.println("La lista está vacía.");
                    }
                    break;
                case 8:
                    shuffleList(lista);
                    System.out.println("Lista desordenada.");
                    break;
                case 9:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void addRandomElements(List<Integer> lista, int cantidad) {
        Random random = new Random();
        for (int i = 0; i < cantidad; i++) {
            lista.add(random.nextInt(100)); // Genera números aleatorios del 0 al 99
        }
    }

    private static void shuffleList(List<Integer> lista) {
        Random random = new Random();
        for (int i = lista.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = lista.get(i);
            lista.set(i, lista.get(j));
            lista.set(j, temp);
        }
    }
    
    private static void borrarRango(List<Integer> lista, int inicio, int fin) {
        if (inicio >= 0 && fin < lista.size() && inicio <= fin) {
            for (int i = fin; i >= inicio; i--) {
                lista.remove(i);
            }
            System.out.println("Rango de índices borrado.");
        } else {
            System.out.println("Rango de índices no válido.");
        }
    }

    private static void imprimirLista(List<Integer> lista) {
        System.out.print("Lista: ");
        for (int elemento : lista) {
            System.out.print(elemento + " ");
        }
        System.out.println(); // Salto de línea al final
    }

}
