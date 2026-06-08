public class TiketHabisException extends Exception{
    private String namaKereta;
    private int sisaKursi;

    public TiketHabisException(String namaKereta, int sisaKursi){
        super("Tiket gagal dipesan! Kursi untuk kereta " + namaKereta + " tidak mencukupi.");
        this.namaKereta = namaKereta;
        this.sisaKursi = sisaKursi;   
    }
    public String getNamaKereta(){
        return namaKereta;
    }
    public int getSisaKursi(){
        return sisaKursi;
    }
}