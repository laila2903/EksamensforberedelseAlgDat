import sun.tools.jconsole.Tab;

import java.util.Arrays;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        //int[] a = Tabell.randPerm(100000);              // en tilfeldig tabell
        /*for (int k : a) System.out.print(k + " ");  // skriver ut a

        int m = Tabell.maks(a);   // finner posisjonen til største verdi

        System.out.println("\nStørste verdi ligger på plass " + m);

        skrivln(a,0,a.length);*/

        //int[] a = Tabell.randPerm(20); // tilfeldig permutasjon av 1 . . 20
        //System.out.println(Arrays.toString(a));
        //int [] b = Tabell.randPerm(20);
        //System.out.println(Arrays.toString(b));

        /*int [] d = {3,1,4,9,7,10,8,6,5,2};
        for(int i = 0; i<10;i++) {
            nestePermutasjon(d);
            System.out.println(Arrays.toString(d));
        }*/

        /*for (int i = 0; i < 10; i++)
        {
            int[] a = Tabell.randPerm(10);
            System.out.print(Tabell.utvalgssortering(a) + " ");
        }*/


        //int[] a = {1,3,4,4,5,7,7,7,7,8,9,10,10,12,15,15,15};  // Figur 1.3.5 a)
        //System.out.println(binærsøk2(a,15));

        /*int[] a = Tabell.randPerm(100000);
        System.out.println(Arrays.toString(a));
        int[] b = a.clone();
        System.out.println(Arrays.toString(b));

        long tid1 = System.currentTimeMillis();
        Tabell.utvalgssortering(a);
        tid1 = System.currentTimeMillis() - tid1;

        long tid2 = System.currentTimeMillis();
        Tabell.innsettingssortering(b);
        tid2 = System.currentTimeMillis() - tid2;

        System.out.println("Utvalgssortering: " + tid1);
        System.out.println("Innsettingssortering: " + tid2);*/

        //int[] a = {5,2,7,3,9,1,8,4,6};
       /* double[] d = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};
        String[] s = {"Sohil","Per","Thanh","Fatima","Kari","Jasmin"};
        char[] c = "JASMIN".toCharArray();
        Integer[] a = {5,2,7,3,9,1,8,4,6};

        int k = Tabell.maks(a);     // posisjonen til den største i a
        int l = Tabell.maks(d);     // posisjonen til den største i d
        int m = Tabell.maks(s);     // posisjonen til den største i s

        System.out.println(a[k] + "  " + d[l] + "  " + c[m]);*/

        /*Integer a = 50, b = 56;
        int retval = a.compareTo(b);
        System.out.println(retval);*/

        //String s = "C", t = "c";
        //System.out.println(s.compareTo(t));

        //System.out.println(Boolean.compare(false, true));

       /* String[] s = {"Per","Kari","Ole","Anne","Ali","Eva"};
        Tabell.innsettingssortering(s);
        System.out.println(Arrays.toString(s));  // [Ali, Anne, Eva, Kari, Ole, Per]*/

        //System.out.println(Integer.compare(-1, 1));
        //System.out.println(Integer.compareUnsigned(-1, 1));
        /*
         * Metodekallet Integer.compare(-1, 1); returnerer -1. Det er slik det skal være siden -1 er mindre 1. Men metodekallet Integer.compareUnsigned(-1, 1); returnerer 1.
         * Binærkoden til -1 har 32 1-biter. Men det er tallet 4294967295 når vi ser bort fra fortegn. Men 4294967295 er større enn 1. Dermed returnerer metoden 1.
         */

       /* Integer[] a = Tabell.randPermInteger(10);
        System.out.println(Arrays.toString(a));

        Tabell.innsettingssortering(a);
        System.out.println(Arrays.toString(a));*/

        /*double[] d = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};
        Double [] b = new Double[d.length];
        for (int i = 0; i<b.length; i++){
            b[i] = d[i];
        }
        System.out.println(Arrays.toString(b));
        innsettingssortering(b);
        System.out.println(Arrays.toString(b));*/

       Person[] p = new Person[5];                       // en persontabell
        p[0] = new Person("Kari", "Svendsen");            // Kari Svendsen
        p[1] = new Person("Boris", "Zukanovic");          // Boris Zukanovic
        p[2] = new Person("Ali", "Kahn");                 // Ali Kahn
        p[3] = new Person("Azra", "Zukanovic");           // Azra Zukanovic
        p[4] = new Person("Kari", "Pettersen");           // Kari Pettersen

        /*Student[] s = new Student[7];                             // en studenttabell
        s[0] = new Student("Kari","Svendsen", Studium.Data);      // Kari Svendsen
        s[1] = new Student("Boris","Zukanovic", Studium.IT);      // Boris Zukanovic
        s[2] = new Student("Ali","Kahn", Studium.Anvendt);        // Ali Kahn
        s[3] = new Student("Azra","Zukanovic", Studium.IT);       // Azra Zukanovic
        s[4] = new Student("Kari","Pettersen", Studium.Data);     // Kari Pettersen
        s[5] = new Student("Laila","Doudouh", Studium.Data);
        s[6] = new Student("Jawad","Essaouiqui", Studium.IT);*/


        /*class FornavnKomparator implements Komparator<Person>
        {
            public int compare(Person p1, Person p2)        // to personer
            {
                return p1.fornavn().compareTo(p2.fornavn());  // sammenligner fornavn
            }
        }

        Komparator<Person> c = new FornavnKomparator();   // en instans av klassen
        Tabell.innsettingssortering(p, c);                // se Programkode 1.4.6 b)

        System.out.println(Arrays.toString(p));           // Utskrift av tabellen p*/

        //Komparator<Person> c = (p1,p2) -> p1.fornavn().compareTo(p2.fornavn());
        //Tabell.innsettingssortering(p, (p1,p2) -> p1.fornavn().compareTo(p2.fornavn()));
        //System.out.println(Arrays.toString(p));           // Utskrift av tabellen p

        /*Tabell.innsettingssortering(s, (s1,s2) ->
                {
                    int k = s1.studium().compareTo(s2.studium());
                    return k != 0 ? k : s1.compareTo(s2);
                }
        );

        for (Student t : s) System.out.println(t);*/

        /*Tabell.innsettingssortering(s,
                (s1,s2) ->
                {
                    int k = s1.studium().compareTo(s2.studium());
                    if (k != 0) return k;
                    k = s1.fornavn().compareTo(s2.fornavn());
                    if (k != 0) return k;
                    return s1.etternavn().compareTo(s2.etternavn());
                }
        );

        for (Student t : s) System.out.println(t);*/

        //String[] s = {"Lars","Anders","Bodil","Kari","Per","Berit"};
        /*String[] s = {"21","18","8","13","20","6","16","25","3","10"};
        Tabell.innsettingssortering(s,
                (s1,s2) ->
                {
                   int k = s1.length() - s2.length();
                   if (k!=0) return k;
                   k = s1.compareTo(s2);
                   if(k!=0) return k;
                   return k;
                }
        );

        System.out.println(Arrays.toString(s));*/

        /*Komparator<Student> c = (s1,s2) ->
                {
                    int k = s1.studium().name().compareTo(s2.studium().name());
                    return k != 0 ? k : s1.compareTo(s2);
                };

        for (Studium s : Studium.values())
        {
            System.out.println(s.toString() + " (" + s.name() + ")");
        }*/

        /*Double[] d = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};
        Tabell.innsettingssortering(d,Komparator.naturligOrden());
        System.out.println(Arrays.toString(d));
        Tabell.innsettingssortering(d,Komparator.omvendtOrden());
        System.out.println(Arrays.toString(d));*/

        /*Boolean[] b = {false, true, true, false, false, true, false, true};
        Tabell.innsettingssortering(b,Komparator.naturligOrden());
        System.out.println(Arrays.toString(b));*/

        //Tabell.innsettingssortering(p,Komparator.orden(Person::etternavn));
        //System.out.println(Arrays.toString(p));

        /*String[] s = {"Lars","Anders","Bodil","Kari","Per","Berit"};
        //Tabell.innsettingssortering(s, Komparator.naturligOrden());
        Tabell.innsettingssortering(s, Komparator.orden(x -> -x.length()));  //returnerer navn sortert fra lengste string til korteste
        System.out.println(Arrays.toString(s));*/

        /*String [] g = {"21","18","8","13","20","6","16","25","3","10"};
        Tabell.innsettingssortering(g,Komparator.orden(String::length).deretter(x->x));
        System.out.println(Arrays.toString(g));*/


        //int [] a = Tabell.randPerm(10);
       //Tabell.kvikksortering(a);











    }

}
