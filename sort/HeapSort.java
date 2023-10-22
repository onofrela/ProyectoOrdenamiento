package sort;
import java.util.List;

public class HeapSort implements StrategySort {
    @Override
    public void Ordenar(List<Integer> lista) {
        int n = lista.size();

        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(lista, n, i);

        for (int i = n - 1; i > 0; i--) {
            int aux = lista.get(0);
            lista.set(0, lista.get(i));
            lista.set(i, aux);
            heapify(lista, i, 0);
        }
    }

    private void heapify(List<Integer> lista, int n, int i) {
        int maxHeapify = i;
        int izq = 2 * i + 1;
        int der = 2 * i + 2;

        if (izq < n && lista.get(izq) > lista.get(maxHeapify)) {
            maxHeapify = izq;
        }

        if (der < n && lista.get(der) > lista.get(maxHeapify)) {
            maxHeapify = der;
        }

        if (maxHeapify != i) {
            int cambio = lista.get(i);
            lista.set(i, lista.get(maxHeapify));
            lista.set(maxHeapify, cambio);
            heapify(lista, n, maxHeapify);
        }
    }
}