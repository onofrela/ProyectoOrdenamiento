package sort;
import java.util.List;
import java.util.ArrayList;

public class MergeSort implements StrategySort {
    @Override
    public void Ordenar(List<Integer> lista) {
        if (lista.size() > 1) {
            int mid = lista.size() / 2;
            List<Integer> izq = new ArrayList<>(lista.subList(0, mid));
            List<Integer> der = new ArrayList<>(lista.subList(mid, lista.size()));

            MergeSort mergeSort = new MergeSort();
            mergeSort.Ordenar(izq);
            mergeSort.Ordenar(der);

            int i = 0, j = 0, k = 0;

            while (i < izq.size() && j < der.size()) {
                if (izq.get(i) < der.get(j)) {
                    lista.set(k, izq.get(i));
                    i++;
                } else {
                    lista.set(k, der.get(j));
                    j++;
                }
                k++;
            }

            while (i < izq.size()) {
                lista.set(k, izq.get(i));
                i++;
                k++;
            }

            while (j < der.size()) {
                lista.set(k, der.get(j));
                j++;
                k++;
            }
        }
    }
}