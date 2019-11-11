import java.util.Arrays;
import java.util.NoSuchElementException;

public class kap1 {

    public static int min (int [] a){
        if(a.length<1){
            throw new NoSuchElementException("tabellen er tom!");
        }

        int m = 0;
        for(int i = 0; i<a.length; i++){
            if (a[i]<a[m]){
                m = i;
            }
        }
        return m;
    }

    public static int maks (int [] a){
        if(a.length<1){
            throw new NoSuchElementException("tabellen er tom!");
        }

        int m = 0;
        for(int i = 0; i<a.length; i++){
            if (a[i]>a[m]){
                m = i;
            }
        }
        return m;
    }

    public static int [] minmaks (int [] a){
        if(a.length<1){
            throw new NoSuchElementException("tabellen er tom!");
        }

        int m1 = min(a);
        int m2 = maks(a);

        int [] b = {m1,m2};

        return b;
    }

    public static long fak (int n){
        if (n == 0){
            return 1;
        }
        return n*fak(n-1);
    }

    public static int maks1(int[] a)  // versjon 3 av maks-metoden
    {
        int sist = a.length - 1;       // siste posisjon i tabellen
        int m = 0;                     // indeks til største verdi
        int maksverdi = a[0];          // største verdi
        int temp = a[sist];            // tar vare på siste verdi
        a[sist] = 0x7fffffff;          // legger tallet 2147483647 sist

        for (int i = 0; ; i++)         // i starter med 0
            if (a[i] >= maksverdi)       // denne blir sann til slutt
            {
                if (i == sist)             // sjekker om vi er ferdige
                {
                    a[sist] = temp;          // legger siste verdi tilbake
                    return temp >= maksverdi ? sist : m;   // er siste størst?
                }
                else
                {
                    maksverdi = a[i];        // maksverdi oppdateres
                    m = i;                   // m oppdateres
                }
            }
    } // maks

    /**
     * Hvis int [] a har kun en verdi vil outputen være null fordi for-løkken gå én gang siden sist er 0. Dermed returneres 0 som er posisjonen til den største. Hvis det er kun ett element, er det også størst.
     * Hvis int [] a er en tom array vil outputen være ArrayoutofBoundsException fordi det ikke finnes noe element med indeks lik 0. Dermed vil setningen int maksverdi = a[0] gi en ArrayIndexOutOfBoundsException.
     */

    public static void main(String[] args) {
        //int [] a = {8,4,17,10,6,20,1,11,15,3,18,9,2,7,19};
        int [] a = {};
        System.out.println(maks1(a));




    }

}
