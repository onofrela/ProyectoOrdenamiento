package sort;
import java.util.List;

public class QuickSort implements StrategySort {
    @Override
    public void Ordenar(List<Integer> lista) {
        quickSort(lista, 0, lista.size() - 1);
    }

    private void quickSort(List<Integer> lista, int menor, int mayor) {
        if (menor < mayor) {
            int pivote = partition(lista, menor, mayor);

            quickSort(lista, menor, pivote - 1);
            quickSort(lista, pivote + 1, mayor);
        }
    }

    private int partition(List<Integer> lista, int menor, int mayor) {
        int pivot = lista.get(mayor);
        int i = menor - 1;

        for (int j = menor; j < mayor; j++) {
            if (lista.get(j) < pivot) {
                i++;
                int temp = lista.get(i);
                lista.set(i, lista.get(j));
                lista.set(j, temp);
            }
        }

        int temp = lista.get(i + 1);
        lista.set(i + 1, lista.get(mayor));
        lista.set(mayor, temp);

        return i + 1;
    }
}