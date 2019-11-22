import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Random;

public class Tabell {

    public static void bytt(int[] a, int i, int j)
    {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    public static void fratilKontroll(int tablengde, int fra, int til)
    {
        if (fra < 0)                                  // fra er negativ
            throw new ArrayIndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");

        if (til > tablengde)                          // til er utenfor tabellen
            throw new ArrayIndexOutOfBoundsException
                    ("til(" + til + ") > tablengde(" + tablengde + ")");

        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
    }

    public static void vhKontroll(int tablengde, int v, int h)
    {
        if (v < 0)
            throw new ArrayIndexOutOfBoundsException("v(" + v + ") < 0");

        if (h >= tablengde)
            throw new ArrayIndexOutOfBoundsException
                    ("h(" + h + ") >= tablengde(" + tablengde + ")");

        if (v > h + 1)
            throw new IllegalArgumentException
                    ("v = " + v + ", h = " + h);
    }

    public static int[] randPerm(int n)  // en effektiv versjon
    {
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k+1);        // en tilfeldig tall fra 0 til k
            bytt(a,k,i);                   // bytter om
        }

        return a;                        // permutasjonen returneres
    }

    public static void randPerm(int[] a)  // stokker om a
    {
        Random r = new Random();     // en randomgenerator

        for (int k = a.length - 1; k > 0; k--)
        {
            int i = r.nextInt(k + 1);  // tilfeldig tall fra [0,k]
            bytt(a,k,i);
        }
    }

    public static int maks(int[] a, int fra, int til)
    {
        fratilKontroll(a.length,fra,til);

        if (fra == til)
            throw new NoSuchElementException
                    ("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");

        if (a==null){
            throw new NullPointerException("Arrayet kan ikke være lik null!");
        }

        int m = fra;              // indeks til største verdi i a[fra:til>
        int maksverdi = a[fra];   // største verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++)
        {
            if (a[i] > maksverdi)
            {
                m = i;                // indeks til største verdi oppdateres
                maksverdi = a[m];     // største verdi oppdateres
            }
        }

        return m;  // posisjonen til største verdi i a[fra:til>
    }

    public static int maks(int[] a)  // bruker hele tabellen
    {
        return maks(a,0,a.length);     // kaller metoden over
    }

    public static int min (int [] a, int fra, int til){

        fratilKontroll(a.length,fra,til);

        if (fra == til)
            throw new NoSuchElementException
                    ("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");

        if (a==null){
            throw new NullPointerException("Arrayet kan ikke være lik null!");
        }

        int m = fra;
        int minverdi = a[fra];

        for (int i = fra+1; i<til; i++){
            if(a[i]<minverdi){
                m=i;
                minverdi = a[m];
            }
        }
        return m;
    }

    public static int min (int [] a){
        return min(a,0,a.length);
    }

    public static void bytt (char [] c, int i, int j){
        char temp = c[i];
        c[i] = c [j];
        c[j] = temp;
    }

    public static void skriv (int [] a, int fra, int til){
        fratilKontroll(a.length, fra, til);

        if (til - fra > 0) {
            System.out.print(a[fra]);
        }

        for (int i = fra + 1; i < til; i++) {
            System.out.print(" " + a[i]);
        }
    }

    public static void skriv (int [] a){
        skriv(a,0,a.length);
    }

    public static void skrivln (int [] a, int fra, int til){

        fratilKontroll(a.length,fra,til);

        for (int i = fra; i < til; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void skrivln (int [] a){
        skrivln(a,0,a.length);
    }

    public static int[] nestMaks1(int[] a)  // legges i class Tabell
    {
        int n = a.length;   // tabellens lengde

        if (n < 2) throw   // må ha minst to verdier!
                new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        /*int m = maks(a);  // m er posisjonen til tabellens største verdi

         bytt(a,0,m);

        int nm;           // nm skal inneholde posisjonen til nest største verdi

        if (m == 0)                            // den største ligger først
        {
            nm = maks(a, 1, n);                  // leter i a[1:n>
        }
        else if (m == n - 1)                   // den største ligger bakerst
        {
            nm = maks(a, 0, n - 1);              // leter i a[0:n-1>
        }
        else
        {
            int mv = maks(a, 0, m);              // leter i a[0:m>
            int mh = maks(a, m + 1, n);          // leter i a[m+1:n>
            nm = a[mh] > a[mv] ? mh : mv;        // hvem er størst?
        }

        return new int[] {m,nm};      // m i posisjon 0 , nm i posisjon 1*/

        /*int m = Tabell.maks(a);  // m er posisjonen til tabellens største verdi

        Tabell.bytt(a,0,m);  // bytter om slik at den største kommer forrest

        int k = Tabell.maks(a,1,a.length);

        if (k == m) {
            k = 0; // den nest største lå opprinnelig forrest
        }

        Tabell.bytt(a,0,m); // bytter tilbake

        return new int[] {m,k};*/

        int m = Tabell.maks(a);

        Tabell.bytt(a,a.length-1,m);

        int l = maks(a,0,a.length-1);

        if (l==m){
            l = a.length-1;
        }

        bytt(a,a.length-1,m);

        return new int [] {m,l};
    } // nestMaks

    public static void sortering(int [] a){

        for (int i = a.length; i>0; i--){
            int m = maks(a,0,i);
            bytt(a,i-1,m);
        }
    }

    public static int[] nestMaks(int[] a)   // en turnering
    {
        int n = a.length;                // for å forenkle notasjonen

        if (n < 2) // må ha minst to verdier!
            throw new IllegalArgumentException("a.length(" + n + ") < 2!");

        int[] b = new int[2*n];          // turneringstreet
        System.arraycopy(a,0,b,n,n);     // legger a bakerst i b

        for (int k = 2*n-2; k > 1; k -= 2)   // lager turneringstreet
            b[k/2] = Math.max(b[k],b[k+1]);

        int maksverdi = b[1], nestmaksverdi = Integer.MIN_VALUE;

        for (int m = 2*n - 1, k = 2; k < m; k *= 2)
        {
            int tempverdi = b[k+1];  // ok hvis maksverdi er b[k]
            if (maksverdi != b[k]) { tempverdi = b[k]; k++; }
            if (tempverdi > nestmaksverdi) nestmaksverdi = tempverdi;
        }

        return new int[] {maksverdi,nestmaksverdi}; // størst og nest størst

    } // nestMaks

    public static void kopier(int[] a, int i, int[] b, int j, int ant){
        for (int n = i + ant; i < n; ) {
            b[j++] = a[i++];
        }
    }

    public static void snu(int[] a, int v, int h)  // snur intervallet a[v:h]
    {
        while (v < h) bytt(a, v++, h--);
    }

    public static void snu(int[] a, int v)  // snur fra og med v og ut tabellen
    {
        snu(a, v, a.length - 1);
    }

    public static void snu(int[] a)  // snur hele tabellen
    {
        snu(a, 0, a.length - 1);
    }

    public static boolean nestePermutasjon(int[] a)
    {
        int i = a.length - 2;                    // i starter nest bakerst
        while (i >= 0 && a[i] > a[i + 1]) i--;   // går mot venstre
        if (i < 0) return false;                 // a = {n, n-1, . . . , 2, 1}

        int j = a.length - 1;                    // j starter bakerst
        while (a[j] < a[i]) j--;                 // stopper når a[j] > a[i]
        bytt(a,i,j); snu(a,i + 1);               // bytter og snur

        return true;                             // en ny permutasjon
    }

    public static int utvalgssortering(int[] a)
    {
        int antall = 0;
        for (int i = 0; i < a.length - 1; i++)
        {
            int m = min(a, i, a.length);  // posisjonen til den minste
            if (m != i) bytt(a, i, m);
            else antall++;
        }
        return antall;
    }

    public static void utvalgssortering1 (int [] a){

        long start = System.currentTimeMillis();
        for(int i = 0; i<a.length-1; i++){
           int min = i;
           for (int j = i+1; j<a.length; j++){
               if(a[j]<a[min]){
                      min = j;
               }
           }
           int temp = a[i];
           a[i] = a[min];
           a[min]=temp;
        }
        long end = System.currentTimeMillis();
        System.out.println("funksjonen bruker " +
                (end - start) + "ms");
    }

    public static void utvalgssortering (int[] a, int fra, int til){
        fratilKontroll(a.length,fra,til);
        for (int i = fra; i < til; i++)
            bytt(a, i, min(a, i, a.length));
    }

    public static int lineærsøk(int[] a, int verdi) // legges i class Tabell
    {
        if (a.length == 0 || verdi > a[a.length-1])
            return -(a.length + 1);  // verdi er større enn den største

        int i = 0;
        for( ; a[i] < verdi; i++);  // siste verdi er vaktpost
        return verdi == a[i] ? i : -(i + 1);   // sjekker innholdet i a[i]
    }

    public static int lineærsøkmotsattvei(int[] a, int verdi) //gir posisjon til den siste indeksen til en verdi som har flere forekomster k,.,m
    {
        if (a.length == 0 || verdi < a[0])
            return -1;  // verdi er mindre enn den største

        int i = a.length - 1; for( ; a[i] > verdi; i--);

        return verdi == a[i] ? i : -(i + 2);
    }

    public static int lineærsøk2(int[] a, int k, int verdi){

        if(k>a.length){
            throw new ArrayIndexOutOfBoundsException("Du har et hopp som er høyere enn selve tabellen!");
        }
        if(k<=0){
            throw new NoSuchElementException("Hoppet kan ikke være negativ eller lik 0!");
        }
        if (k < 1)
            throw new IllegalArgumentException("Må ha k > 0!");

        int j = k - 1;
        for (; j < a.length && verdi > a[j]; j += k);

        int i = j - k + 1;  // søker i a[j-k+1:j]
        for (; i < a.length && verdi > a[i]; i++);

        if (i < a.length && a[i] == verdi) return i;  // funnet
        else return -(i + 1);
    }

    /**public static int kvadratrotsøk(int[] a, int verdi)
    {
        return lineærsøk(a,(int)Math.sqrt(a.length),verdi);
    }*/

    public static int binærsøk(int[] a, int fra, int til, int verdi)
    {
        Tabell.fratilKontroll(a.length,fra,til);  // se Programkode 1.2.3 a)
        int v = fra, h = til - 1;  // v og h er intervallets endepunkter

        while (v <= h)    // fortsetter så lenge som a[v:h] ikke er tom
        {
            int m = (v + h)/2;      // heltallsdivisjon - finner midten
            int midtverdi = a[m];   // hjelpevariabel for midtverdien

            if (verdi == midtverdi) return m;          // funnet
            else if (verdi > midtverdi) v = m + 1;     // verdi i a[m+1:h]
            else  h = m - 1;                           // verdi i a[v:m-1]
        }

        return -(v + 1);    // ikke funnet, v er relativt innsettingspunkt
    }

    public static int binærsøk(int[] a, int verdi)  // søker i hele a
    {
        return binærsøk(a,0,a.length,verdi);  // bruker metoden over
    }

    // 2. versjon av binærsøk - returverdier som for Programkode 1.3.6 a)
    public static int binærsøk1(int[] a, int fra, int til, int verdi)
    {
        Tabell.fratilKontroll(a.length,fra,til);  // se Programkode 1.2.3 a)
        int v = fra, h = til - 1;    // v og h er intervallets endepunkter

        while (v <= h)  // fortsetter så lenge som a[v:h] ikke er tom
        {
            int m = (v + h)/2;     // heltallsdivisjon - finner midten
            int midtverdi = a[m];  // hjelpevariabel for  midtverdien

            if (verdi > midtverdi) v = m + 1;        // verdi i a[m+1:h]
            else if (verdi < midtverdi) h = m - 1;   // verdi i a[v:m-1]
            else return m;                           // funnet
        }

        return -(v + 1);   // ikke funnet, v er relativt innsettingspunkt
    }

    public static int binærsøk1(int[] a, int verdi)  // søker i hele a
    {
        return binærsøk1(a,0,a.length,verdi);  // bruker metoden over
    }

    // 3. versjon av binærsøk - returverdier som for Programkode 1.3.6 a)
    public static int binærsøk2(int[] a, int fra, int til, int verdi)
    {
        Tabell.fratilKontroll(a.length,fra,til);  // se Programkode 1.2.3 a)
        int v = fra, h = til - 1;  // v og h er intervallets endepunkter

        while (v < h)  // obs. må ha v < h her og ikke v <= h
        {
            int m = (v + h)/2;  // heltallsdivisjon - finner midten

            if (verdi > a[m]) v = m + 1;   // verdi må ligge i a[m+1:h]
            else  h = m;                   // verdi må ligge i a[v:m]
        }
        if (h < v || verdi < a[v]) return -(v + 1);  // ikke funnet
        else if (verdi == a[v]) return v;            // funnet
        else  return -(v + 2);                       // ikke funnet
    }

    public static int binærsøk2(int[] a, int verdi)  // søker i hele a
    {
        return binærsøk2(a,0,a.length,verdi);  // bruker metoden over
    }

    public static void innsettingssortering(int[] a)
    {
        for (int i = 1; i < a.length; i++)  // starter med i = 1
        {
            int verdi = a[i], j = i - 1;      // verdi er et tabellelemnet, j er en indeks
            for (; j >= 0 && verdi < a[j]; j--) a[j+1] = a[j];  // sammenligner og flytter
            a[j + 1] = verdi;                 // j + 1 er rett sortert plass
        }
    }

    public static void innsettingssorteringintervall(int[] a, int fra, int til)
    {
        fratilKontroll(a.length,fra,til);  // se Programkode 1.2.3 a)

        for (int i = fra + 1; i < til; i++)  // a[fra] er første verdi
        {
            int temp = a[i];  // flytter a[i] til en hjelpevariabel

            // verdier flyttes inntil rett sortert plass i a[fra:i> er funnet
            int j = i - 1;
            for (; j >= fra && temp < a[j]; j--) a[j + 1] = a[j];

            a[j + 1] = temp;  // verdien settes inn på rett sortert plass
        }
    }

    public static int maks(double[] a)     // legges i class Tabell
    {
        int m = 0;                           // indeks til største verdi
        double maksverdi = a[0];             // største verdi

        for (int i = 1; i < a.length; i++) if (a[i] > maksverdi)
        {
            maksverdi = a[i];     // største verdi oppdateres
            m = i;                // indeks til største verdi oppdaters
        }
        return m;     // returnerer posisjonen til største verdi
    }

    public static int maks(String[] a)    // legges i class Tabell
    {
        int m = 0;                          // indeks til største verdi
        String maksverdi = a[0];            // største verdi

        for (int i = 1; i < a.length; i++) if (a[i].compareTo(maksverdi) > 0)
        {
            maksverdi = a[i];  // største verdi oppdateres
            m = i;             // indeks til største verdi oppdaters
        }
        return m;  // returnerer posisjonen til største verdi
    }

    /**
     * Hvis to tegn sammenlignes ved hjelp av en logisk operator, er det tegnenes ascii-verdier som sammenlignes.
     * Det betyr at av to tegn er det "størst" som alfabetisk kommer sist av de to. En maks-metode for en char-tabell kan dermed lages slik:
     */

    public static int maks(char[] c)
    {
        int m = 0;                    // indeks til "største" tegn
        char maksverdi = c[0];        // "største" tegn

        for (int i = 1; i < c.length; i++) if (c[i] > maksverdi)
        {
            maksverdi = c[i];     // "største" tegn oppdateres
            m = i;                // indeks til "største" tegn oppdaters
        }
        return m;     // returnerer posisjonen til "største" tegn

    }

    public static int maks(Integer[] a)
    {
        int m = 0;
        Integer maksverdi = a[0];

        for (int i = 1; i < a.length; i++) if (a[i].compareTo(maksverdi)>0)
        {
            maksverdi = a[i];
            m = i;
        }
        return m;

    }

    public static int sammenlign(String s1, String s2)
    {
        int n1 = s1.length();    // lengden til s1
        int n2 = s2.length();    // lengden til s2

        int n = n1 < n2 ? n1 : n2;    // den minste av n1 og n2

        for (int i = 0; i < n; i++)
        {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if (c1 != c2) return c1 - c2;
        }
        return n1 - n2;
    }

    public static <T extends Comparable<? super T>> int maks(T[] a)
    {
        int m = 0;                     // indeks til største verdi
        T maksverdi = a[0];            // største verdi

        for (int i = 1; i < a.length; i++) if (a[i].compareTo(maksverdi) > 0)
        {
            maksverdi = a[i];  // største verdi oppdateres
            m = i;             // indeks til største verdi oppdaters
        }
        return m;  // returnerer posisjonen til største verdi
    } // maks

    public static <T extends Comparable<? super T>> void innsettingssortering(T[] a)
    {
        for (int i = 1; i < a.length; i++)  // starter med i = 1
        {
            T verdi = a[i];        // verdi er et tabellelemnet
            int  j = i - 1;        // j er en indeks
            // sammenligner og forskyver:
            for (; j >= 0 && verdi.compareTo(a[j]) < 0 ; j--) a[j+1] = a[j];

            a[j + 1] = verdi;      // j + 1 er rett sortert plass
        }
    }

    public static void skriv(Object[] a, int fra, int til){
        fratilKontroll(a.length,fra,til);

        if (til - fra > 0) {
            System.out.print(a[fra]);
        }

        for (int i = fra + 1; i < til; i++) {
            System.out.print(" " + a[i]);
        }
    }

    public static void skriv (Object[] a){
        skriv(a,0,a.length);
    }

    public static void skrivln (Object [] a, int fra, int til){

        fratilKontroll(a.length,fra,til);

        for (int i = fra; i < til; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void skrivln (Object [] a){
        skrivln(a,0,a.length);
    }

    public static void bytt(Object[] a, int i, int j)
    {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static Integer[] randPermInteger(int n)
    {
        Integer[] a = new Integer[n];               // en Integer-tabell
        Arrays.setAll(a, i -> i + 1);               // tallene fra 1 til n

        Random r = new Random();   // hentes fra  java.util

        for (int k = n - 1; k > 0; k--)
        {
            int i = r.nextInt(k+1);  // tilfeldig tall fra [0,k]
            bytt(a,k,i);             // bytter om
        }
        return a;  // tabellen med permutasjonen returneres
    }

    public static <T> void innsettingssortering(T[] a, Komparator<? super T> c)
    {
        for (int i = 1; i < a.length; i++)  // starter med i = 1
        {
            T verdi = a[i];        // verdi er et tabellelemnet
            int  j = i - 1;        // j er en indeks

            // sammenligner og forskyver:
            for (; j >= 0 && c.compare(verdi,a[j]) < 0 ; j--) a[j+1] = a[j];

            a[j + 1] = verdi;      // j + 1 er rett sortert plass
        }
    }

    public static <T> int maks(T[] a, Komparator<? super T> c)
    {
        return maks(a, 0, a.length, c);  // kaller metoden nedenfor
    }

    public static <T> int maks(T[] a, int fra, int til, Komparator<? super T> c)
    {
        fratilKontroll(a.length,fra,til);

        if (fra == til) throw new NoSuchElementException
                ("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");

        int m = fra;                // indeks til største verdi
        T maksverdi = a[fra];       // største verdi

        for (int i = fra + 1; i < til; i++)   // går gjennom intervallet
        {
            if (c.compare(a[i],maksverdi) > 0)  // bruker komparatoren
            {
                maksverdi = a[i];     // største verdi oppdateres
                m = i;                // indeks til største verdi oppdateres
            }
        }
        return m;                 // posisjonen til største verdi

    }  // maks

    public static int a (int n){

        if (n < 0) throw new IllegalArgumentException("n er negativ!");

        int x = 0, y =1, z=1;

        for (int i = 0; i<n; i++){
            z=2*y+3*x;
            x=y;
            y=z;
        }
        return z;
    }

    public static int tverrsum(int n){
        System.out.println("tverrsum(" + n + ") starter!");
        int sum = (n < 10) ? n : tverrsum(n / 10) + (n % 10);
        System.out.println("tverrsum(" + n + ") er ferdig!");
        return sum;
    }

    public static int sifferrot (int n){
        while (n >= 10) {
            n = tverrsum(n);
        }
        return n;
    }

    public static int kvadratsum (int n){
        if (n == 1) return 1;
        else return kvadratsum(n-1) + n*n;
    }
    // Formel:  n*(n + 1)*(2*n + 1)/6

    public static int sum (int k, int n){
        if (n == k) return n;
        int m = (n + k)/2;
        return sum(n,m) + sum(m+1,k);
    }

    public static int maks3(int[] a, int v, int h)
    {
        if (v == h) return v;
        int m = (v + h)/2;  // midten
        int mv = maks3(a,v,m);
        int mh = maks3(a,m+1,h);

        return a[mv] >= a[mh] ? mv : mh;
    }

    public static int maks4(int[] a)
    {
        return maks3(a,0,a.length-1);
    }

    public static int fakultet(int n)
    {
        return n < 2 ? 1 : fakultet(n-1)*n;
    }

    public static int fib(int n)         // det n-te Fibonacci-tallet
    {
        if (n <= 1) return n;              // fib(0) = 0, fib(1) = 1
        else return fib(n-1) + fib(n-2);   // summen av de to foregående
    }

    public static int euklid(int a, int b)
    {
        System.out.println("euklid(" + a + b + ") starter!");
        if (b == 0) return a;
        int r = a % b;            // r er resten
        System.out.println("euklid(" + a + b + ") er ferdig!");
        return euklid(b,r);       // rekursivt kall
    }

    public static void kvikksortering0(int[] a, int v, int h)
    {
        System.out.println("Kallet med [" + v + ":" + h + "] starter!");
        if (v >= h) return;   // tomt eller maks ett element
        int k = sParter0(a,v,h,(v + h)/2);   // se Programkode 1.3.9 f)
        kvikksortering0(a,v,k-1);
        kvikksortering0(a,k+1,h);
        System.out.println("Kallet med [" + v + ":" + h + "] er ferdig!");
    }

    public static void kvikksortering(int[] a) // sorterer hele tabellen
    {
        if (a.length > 1) kvikksortering0(a, 0, a.length - 1);
    }

    private static int sParter0(int[] a, int v, int h, int indeks)
    {
        bytt(a, indeks, h);           // skilleverdi a[indeks] flyttes bakerst
        int pos = parter0(a, v, h - 1, a[h]);  // partisjonerer a[v:h - 1]
        bytt(a, pos, h);              // bytter for å få skilleverdien på rett plass
        return pos;                   // returnerer posisjonen til skilleverdien
    }

    private static int parter0(int[] a, int v, int h, int skilleverdi)
    {
        while (true)                                  // stopper når v > h
        {
            while (v <= h && a[v] < skilleverdi) v++;   // h er stoppverdi for v
            while (v <= h && a[h] >= skilleverdi) h--;  // v er stoppverdi for h

            if (v < h) bytt(a,v++,h--);                 // bytter om a[v] og a[h]
            else  return v;  // a[v] er nåden første som ikke er mindre enn skilleverdi
        }
    }





    public static void main(String[] args) { }

}


