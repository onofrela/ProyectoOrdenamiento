package sort;
import java.util.List;

public class CountingSort implements StrategySort {
    @Override
    public void Ordenar(List<Integer> lista) {
        if (lista.isEmpty())
            return;

        int max = lista.stream().max(Integer::compare).orElse(0);
        int min = lista.stream().min(Integer::compare).orElse(0);
        int rango = max - min + 1;

        int[] conteo = new int[rango];
        int[] ordenado = new int[lista.size()];

        for (int num : lista)
            conteo[num - min]++;

        for (int i = 1; i < rango; i++)
            conteo[i] += conteo[i - 1];

        for (int i = lista.size() - 1; i >= 0; i--) {
            ordenado[conteo[lista.get(i) - min] - 1] = lista.get(i);
            conteo[lista.get(i) - min]--;
        }

        for (int i = 0; i < lista.size(); i++)
            lista.set(i, ordenado[i]);
    }
}