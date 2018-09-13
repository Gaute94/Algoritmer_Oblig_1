package com.company;

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
}
