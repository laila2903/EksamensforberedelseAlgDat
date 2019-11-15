public enum Måned {

    JAN (1,"Januar"),
    FEB(2,"Februar"),
    MAR (3,"Mars"),
    APR(4,"April"),
    MAI(5,"Mai"),
    JUN(6,"Juni"),
    JUL(7,"Juli"),
    AUG(8,"August"),
    SEP(9,"September"),
    OKT(10,"Oktober"),
    NOV(11,"November"),
    DES(12,"Desember");

    private final int mndnr;
    private final String fulltnavn;

    private Måned (int mndnr, String fulltnavn ){
        this.mndnr = mndnr;
        this.fulltnavn = fulltnavn;
    }







}
