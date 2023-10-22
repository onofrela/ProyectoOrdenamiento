package sort;
import java.util.List;

public class RadixSort implements StrategySort {
    @Override
    public void Ordenar(List<Integer> lista) {
        if (lista.isEmpty()) {
            return;
        }

        int max = lista.stream().max(Integer::compare).orElse(0);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            conteoingSort(lista, exp);
        }
    }

    private void conteoingSort(List<Integer> lista, int exp) {
        int n = lista.size();
        int[] ordenado = new int[n];
        int[] conteo = new int[10];

        for (int i = 0; i < n; i++) {
            conteo[(lista.get(i) / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            conteo[i] += conteo[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            ordenado[conteo[(lista.get(i) / exp) % 10] - 1] = lista.get(i);
            conteo[(lista.get(i) / exp) % 10]--;
        }

        for (int i = 0; i < n; i++) {
            lista.set(i, ordenado[i]);
        }
    }
}