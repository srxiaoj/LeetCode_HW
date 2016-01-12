/**
 * Created by thanksgiving on 12/28/15.
 */
public class InterleavingPosAndNeg {
    public static void main(String[] args) {
        InterleavingPosAndNeg obj = new InterleavingPosAndNeg();
        int[] a = {-1, -2, -3, 4, 5, 6};
        int[] b = {28,2,-22,-27,2,9,-33,-4,-18,26,25,34,-35,-17,2,-2,32,35,-8};
        obj.rerange(a);
        obj.rerange(b);
        printArray(a);
        printArray(b);
    }
    public void rerange(int[] a) {
        int negCount = 0, posCount = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0) {
                negCount++;
            } else {
                posCount++;
            }
        }

        int i = 0, j = a.length - 1, k = a.length -1;
        if (negCount > posCount) {
            while (i < a.length) {
                if (i % 2 == 0) {
                    if (a[i] < 0) {
                        i++;
                    } else {
                        while (j > 0 && a[j] > 0) {
                            j--;
                        }
                        swap(a, i, j);
                        j = a.length - 1;
                    }
                }
                if (i % 2 != 0) {
                    if (i < a.length && a[i] > 0) {
                        i++;
                    } else if (i < a.length && a[i] < 0) {
                        while (k > 0 && a[k] < 0) {
                            k--;
                        }
                        swap(a, i, k);
                        k = a.length - 1;
                    }
                }
            }
        } else {
            while (i < a.length) {
                if (i % 2 == 0) {
                    if (a[i] > 0) {
                        i++;
                    } else {
                        while (j > 0 && a[j] < 0) {
                            j--;
                        }
                        swap(a, i, j);
                        j = a.length - 1;
                    }
                }
                if (i % 2 != 0) {
                    if (i < a.length && a[i] < 0) {
                        i++;
                    } else if (i < a.length && a[i] > 0) {
                        while (k > 0 && a[k] > 0) {
                            k--;
                        }
                        swap(a, i, k);
                        k = a.length - 1;
                    }
                }
            }
        }
    }
    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    //print array
    public static void printArray(int[] A)
    {
        for(int i = 0; i < A.length; i++)
        {
            if(i != A.length-1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("");
    }
}
