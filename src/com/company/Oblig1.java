package com.company;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Oblig1 {

    /**
     * Oppgave 1: Method for finging the max value in an array
     * @param a the passed array to search through
     * @return the maximum value in the passed array
     */
    public static int maks(int[] a) {

        if (a.length < 1) {
            throw new NoSuchElementException("Array can not be of length (elements) 0");
        }

        for (int i = 0; i < a.length -1; i++) {
            if (a[i] > a[i + 1]) {
                int temp = a[i];
                a[i] = a[i + 1];
                a[i +1] = temp;
            }
        }
        return a[a.length - 1];
    }

    public static int ombyttinger(int[] a) {

        int counter = 0;
        for (int i = 0; i < a.length -1; i++) {
            if (a[i] > a[i + 1]) {
                int temp = a[i];
                a[i] = a[i + 1];
                a[i +1] = temp;
                ++counter;
            }
        }
        return counter;
    }

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
     * Oppgave 3: Algorithm for finding how many unique value in an unsorted array
     * @param a subject array
     * @return the amount of unique values in the passed array
     */
    public static int antallUlikeUsortert(int[] a) {

        int counter = 0;

        boolean breakingpoint;
        for (int i = 0; i < a.length; i++) {

            breakingpoint = false;

            for (int k = 0; k < i; k++) {
                if (a[i] == a[k]) {
                    breakingpoint = true;
                }
            }

            if (!breakingpoint) {
                counter++;
            }
        }
        return counter;
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
     *  Oppgave 5
     */
    public static void rotasjon(char[] a) {
        for (int i = a.length-1; i >= 0; i--) {
            if (i != 0) {
                char temp = a[i-1];
                a[i-1] = a[i];
                a[i] = temp;
            }
        }
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

        int[] smallest = indekssortering(Arrays.copyOfRange(a, 0, 3));

        int smallestIndex0 = smallest[0];
        int smallestIndex1 = smallest[1];
        int smallestIndex2 = smallest[2];

        for(int i = 3; i < a.length; i++) {
            if(a[i] <= a[smallestIndex0]) {
                smallestIndex2 = smallestIndex1;
                smallestIndex1 = smallestIndex0;
                smallestIndex0 = i;
            } else if(a[i] <= a[smallestIndex1]) {
                smallestIndex2 = smallestIndex1;
                smallestIndex1 = i;
            } else if(a[i] < a[smallestIndex2]) {
                smallestIndex2 = i;
            }
        }

        int[] ret = new int[]{smallestIndex0, smallestIndex1, smallestIndex2};
        return ret;
    }

    public static final String ALL_UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅÃ\u0098\u0085"; // added special cases for wrong format ØÆÅ :o

    /**
     * Oppg. 10
     * Checks if every character from String a is contained in the String b, false if not.
     * If a is an empty String, true will always be returned.
     *
     * @param a The String a, must be uppercase
     * @param b The String b, must be uppercase
     * @return True if all letters of a is contained in the letter be, false if not
     */
    public static boolean inneholdt(String a, String b) {
        // an empty String is always contained in another String
        if (a.length() == 0) return true;

        // b cannot contain all characters of a if b is shorter
        if (a.length() > b.length()) return false;

        // map number of every character to the character
        int[] bCharacterMap = new int[ALL_UPPERCASE_CHARACTERS.length()];
        for (char bChar : b.toCharArray()) {
            int index = ALL_UPPERCASE_CHARACTERS.indexOf(bChar);
            if (index < 0)
                throw new IllegalArgumentException("This function only accepts uppercase characters! Found: " + bChar);
            bCharacterMap[index]++;
        }

        // loop through every character in the String a
        for (char aCurr : a.toCharArray()) {
            // subtract one from the charMap and check if less than 0
            if (--bCharacterMap[ALL_UPPERCASE_CHARACTERS.indexOf(aCurr)] < 0) {
                return false;
            }
        }

        // Return true if finished the loop without returning
        return true;
    }
}
