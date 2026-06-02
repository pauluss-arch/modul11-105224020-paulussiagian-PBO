public class Mahasiswa {
    private int sksMaksimal;
    private int sisaSks;

    public Mahasiswa(int sisaSksAwal){
        this.sisaSks = sisaSksAwal;
    }
    public void setSksMaksimal(int sks){
        if(sks<2 || sks >24){
            throw new IllegalArgumentException("kesalahan sistem : Batas SKS tidak valid (harus antara 2 - 24 SKS)");
        }
        this.sksMaksimal = sks;
        System.out.println("Batas SKS maksimal Berhasil di atur ke : " + this.sksMaksimal);
    }
    public void ambilMataKuliah(String namaMatkul, int bebanSks){
        if(bebanSks > sisaSks){
            throw new SksTidakCukupException("Kesalahan : SKS Tidak cukup untuk menganbil " + namaMatkul + "(dibutuhkan: " + bebanSks + ",sisa: " + sisaSks + ")");
        }
        sisaSks -= bebanSks;
        System.out.println("Berhasil mengambil mata kuliah " + namaMatkul + ". Sisa SKS Anda saat ini: " + sisaSks);
    }

}
