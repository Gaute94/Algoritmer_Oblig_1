package com.company;

import java.util.NoSuchElementException;

public class Oblig1 {

    /**
     * Oppgave 2
     * @param a
     * @return Returns the amount of unique numbers in the array a.
     */
    public static int antallUlikeSortert(int[] a){
        int count = 1;
        if(a.length < 1){
            return 0;
        }
        if(a.length == 1){
            return 1;
        }
        for (int i = 0; i < a.length - 1; i++) {
            int number = a[i];
            if (number > a[i + 1]) {
                throw new IllegalStateException("Tabellen er ikke sortert.");
            }
            if (number != a[i + 1]) {
                count += 1;
            }
        }
        return count;
    }

    /**
     * Oppg. 4
     * Sorts the given array with all odd numbers in the left side sorted and all even numbers on the right side sorted.
     *
     * @param a The array
     * @return The sorted array
     */
    public static int[] delsortering(int[] a) {
        // empty array
        if (a.length <= 1)
            return a;

        int left = 0;
        int right = a.length - 1;
        while (true) {
            while (a[left] % 2 != 0 && left < right) left++;

            while (a[right] % 2 == 0 && right > left) right--;

            if (left >= right) break;

            // swap the who
            int tmp = a[left];
            a[left] = a[right];
            a[right] = tmp;
        }

        if (left != a.length - 1) {
            quickSort(a, 0, left - 1);
            quickSort(a, left, a.length - 1);
        } else {
            quickSort(a, 0, a.length - 1);
        }

        return a;
    }

    /**
     * QuickSort algorithm creates for task 4.
     * @param arr
     * @param low
     * @param high
     */
    private static void quickSort(int[] arr, int low, int high) {
        int left = low;
        int right = high;
        int pivot = arr[low + (high - low) / 2];
        while (left <= right) {
            while (arr[left] < pivot) left++;
            while (arr[right] > pivot) right--;
            if (left <= right) {

                // swap the two
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;

                // move cursors closer
                left++;
                right--;
            }
        }
        if (low < right) quickSort(arr, low, right);
        if (high > left) quickSort(arr, left, high);
    }

    /**
     * Oppg. 6
     * Rotate the array by r positions
     *
     * @param a The array
     * @param r The number of positions to rotate
     * @return The rotated array
     */
    public static char[] rotasjon(char[] a, int r) {

        char[] rotated = new char[a.length];

        for (int i = 0; i < a.length; i++) {
            int index = (i + r) % a.length;
            if (index < 0) index += a.length;
            rotated[index] = a[i];
        }

        System.arraycopy(rotated, 0, a, 0, a.length);

        return a;
    }

    /**
     * Oppgave 7
     * @param s
     * @param t
     * @return Returns a String which is the result of combining String s and String t.
     */
    public static String flett(String s, String t) {
        int length;
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        char[] flett = new char[sArray.length + tArray.length];
        if (s.length() > t.length()) {
            length = s.length();
        } else {
            length = t.length();
        }

        int flettetIndex = 0;
        for (int i = 0; i < length; i++) {
            if (i < s.length()) {
                flett[flettetIndex++] = sArray[i];
            }
            if (i < t.length()) {
                flett[flettetIndex++] = tArray[i];
            }
        }
        return new String(flett);
    }

    /**
     * Oppgave 7 del 2
     * @param s
     * @return Returns a String which is the result of combining all chars from all parameters s
     */
    public static String flett(String... s){
        String str = "";
        int max = 0;
        for(int k = 0; k < s.length; k++){
            if(s[k].length() > max){
                max = s[k].length();
            }
        }
        for(int i = 0; i < max; i++) {
            for(int j = 0; j < s.length; j++) {
                if(i < s[j].length()) {
                    str += s[j].charAt(i);
                }
            }
        }
        return str;
    }

    /**
     * Oppgave 8
     * @param a
     * @return Returns an array containing the indexes of the elements in the parameter "a" sorted by value
     *         from highest to lowest.
     */
    public static int[] indekssortering(int[] a) {
        int[] b = a.clone();
        int[] c = new int[a.length];

        //Sorts array b from highest to lowest
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (b[i] < b[j]) {
                    int temp = b[i];
                    b[i] = b[j];
                    b[j] = temp;
                }
            }
        }

        for (int k = 0; k < a.length; k++) {
            innerLoop:
            for (int l = 0; l < a.length; l++) {
                if (b[k] == a[l]) {

                    //Sjekker om indexen allerede er brukt for å takle situasjoner hvor arrayen inneholder like verdier.
                    for (int p = 0; p < k; p++) {
                        if (l == c[p]) {
                            continue innerLoop;
                        }
                    }
                    c[k] = l;
                    break;
                }
            }
        }
        return c;
    }

    /**
     * Oppg. 9
     * Returns the three smallest elements in the given array. The smallest in the
     * first index.
     *
     * @param a The array
     * @throws NoSuchElementException If the array has less than 3 elements
     */
    public static int[] tredjeMin(int[] a) {
        if (a.length < 3)
            throw new NoSuchElementException("The array needs to have at least 3 elements.");

        int small_1 = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[small_1] > a[i]) {
                small_1 = i;
            }
        }

        int small_2 = 0;
        if (small_2 == small_1) small_2++;
        for (int i = 0; i < a.length; i++) {
            if (a[small_2] > a[i] && small_1 != i) {
                small_2 = i;
            }
        }

        int small_3 = 0;
        if (small_3 == small_1) small_3++;
        if (small_3 == small_2) small_3++;
        if (small_3 == small_1) small_3++;
        for (int i = 0; i < a.length; i++) {
            if (a[small_3] > a[i] && small_1 != i && small_2 != i) {
                small_3 = i;
            }
        }

        return new int[]{small_1, small_2, small_3};
    }
}
