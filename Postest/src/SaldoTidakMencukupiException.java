public class SaldoTidakMencukupiException extends Exception {
    private double nominalKurang;

    public SaldoTidakMencukupiException(String pesan, double nominalKurang) {
        super(pesan);
        this.nominalKurang = nominalKurang;
    }

    public double getNominalKurang() {
        return this.nominalKurang;
    }
}