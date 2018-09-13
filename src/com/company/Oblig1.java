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
     * Oppgave /
     * @param s
     * @param t
     * @return Returns a String which is the result of combining String s and String t.
     */
    public static String flett(String s, String t){
        int a = 0;
        int length;
        String flett = "";
        if(s.length() > t.length()){
            length = s.length();
        }else{
            length = t.length();
        }
        while(a < length){
            if(a < s.length()) {
                if(!(s.length() == 0)) {
                    flett += s.charAt(a);
                }
            }
            if(a < t.length()) {
                if(!(t.length()==0)) {
                    flett += t.charAt(a);
                }
            }
            a++;
        }
        return flett;
    }

}
