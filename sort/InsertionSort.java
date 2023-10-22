package sort;
import java.util.List;

public class InsertionSort implements StrategySort {
    @Override
    public void Ordenar(List<Integer> lista) {
        int n = lista.size();
        for (int i = 1; i < n; i++) {
            int llave = lista.get(i);
            int j = i - 1;
            while (j >= 0 && lista.get(j) > llave) {
                lista.set(j + 1, lista.get(j));
                j--;
            }
            lista.set(j + 1, llave);
        }
    }
}