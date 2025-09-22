// Author: A. Ikeji
// Class to illustrate the selection, insertion,
// bubble, quick, merge and shell sort algorithms.

public class sorter {

    private static int findmin (Object list[], int first, int last) {
        int i, minIndex;
        Comparable min = (Comparable)(list[first]);
        minIndex=first;
        for (i=first+1; i <= last; i++) {
            if (min.compareTo((Comparable)list[i]) > 0) {
                min = (Comparable)list[i];
                minIndex=i;
            }
        }
        return minIndex;
    }

    // Selection sort
    public static void ssort (Object list[], int sz) {
        int i, minIndex;
        for (i=0; i < sz-1;i++) {
            minIndex=findmin(list,i, sz-1);
            Object k=list[i];list[i]=list[minIndex];list[minIndex]=k;
        }
    }

    // Insertion sort
    public static void isort (Object list[], int sz) {
        int i, j; Object k;
        for (i=1; i < sz; i++) {
            k=list[i];
            for (j=i; j > 0; j--) {
                if (((Comparable)list[j-1]).compareTo(k) > 0) list[j]=list[j-1];
                else break;
            }
            list[j]=k;
        }
    }

    // Bubble sort
    public static void bsort (Object list[], int sz) {
        int i;
        boolean sorted;
        do {
            sorted = true;
            sz--;
            for (i=0; i < sz; i++) {
                if (((Comparable)list[i]).compareTo(list[i+1]) > 0) {
                    Object k=list[i];list[i]=list[i+1];list[i+1]=k;
                    sorted = false;
                }
            }
        } while (!sorted);
    }

    // Quick sort
    public static void qsort(Object list[], int first, int last) {
        int i, j, p; Object k;
        if (first < last) {
            p=first;  i=first+1; j=last;
            do {
                for ( ; (((Comparable)list[i]).compareTo(list[p])<=0) && (i<j); i++);
                for ( ; ((Comparable)list[j]).compareTo(list[p])>0; j--);
                if (i < j) {
                    k=list[i];list[i]=list[j];list[j]=k;
                }
            } while (i < j);
            k=list[p];list[p]=list[j];list[j]=k;
            qsort(list,first,j-1);
            qsort(list,j+1,last);
        }
    }

    // Merge sort
    private static void merge(Object L1[], int f, int L) {
        Object L2[] = new Object[L-f+1];
        int i,j,k,m;
        m = (f+L)/2; k=0; i=f; j=m+1;
        while ((i <= m) && (j <= L)){
            if (((Comparable)L1[i]).compareTo(L1[j]) <0) L2[k++]=L1[i++];
            else L2[k++]=L1[j++];
        }
        for ( ;i<=m; )L2[k++]=L1[i++];
        for ( ;j<=L; )L2[k++]=L1[j++];
        for ( ;k > 0; ) L1[L--]=L2[--k];
    }

    public static void msort(Object list[], int first, int last) {
        if (first < last) {
            msort(list,first, (first+last)/2);
            msort(list, (first+last)/2+1, last);
            merge(list,first,last);
        }
    }

    // Shell sort
    private static void shellsinsertionsort(Object L[], int n, int f, int k) {
        int i, j; Object p;
        for (i=k+f; i < n; i+=k) {
            p=L[i];
            for (j=i; j > f; j-=k) {
                if (((Comparable)L[j-k]).compareTo(p)>0) L[j] =L[j-k];
                else break;
            }
            L[j] = p;
        }
    }

    private static void shells_hk_sort(Object L[], int n, int k) {
        int i;
        for (i=0; i <k; i++) {
            shellsinsertionsort(L,n,i,k);
        }
    }

    public static void shsort(Object L[], int n) {
        int k;
        for (k=n/2; k > 0; k = k/2) {
            shells_hk_sort(L, n, k);
        }
    }
}

