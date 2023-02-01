package src;
public class mergeSort {


    private void merge(regInfo[] a, regInfo[] aux, int lo, int mid, int hi) {

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }

    }

    private void sort(regInfo[] a, regInfo[] aux, int lo, int hi) {
        if (hi <= lo)
            return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    public void sort(regInfo[] a) {
        regInfo[] aux = new regInfo[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    private boolean less(regInfo v, regInfo w) {
        return v.getTotalVistors() > w.getTotalVistors();
    }

}
