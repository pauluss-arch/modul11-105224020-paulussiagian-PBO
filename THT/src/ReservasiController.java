import java.util.ArrayList;
import java.util.List;

public class ReservasiController{
    private List<Kereta> daftarKereta;
    
    public ReservasiController(){
        daftarKereta = new ArrayList<>();
        initData(); 
    }
    private void initData(){
        daftarKereta.add(new Kereta("K01", "Argo Bromo", "JKT - SBY", 50));
        daftarKereta.add(new Kereta("K02", "Parahyangan", "JKT - BDG", 15));
    }
    public List<Kereta> getDaftarKereta(){
        return daftarKereta;
    }
    public void pesanTiket(String kodeKereta, String nik, String namaPenumpang, int jumlahTiket) 
            throws RuteTidakDitemukanException, TiketHabisException{
        
        if (nik.length() != 16 || !nik.matches("[0-9]+")){
            throw new DataPenumpangTidakValidException("Format NIK tidak valid! Harus tepat 16 digit angka.");
        }
        Kereta targetKereta = null;
        for (Kereta k : daftarKereta){
            if (k.getKodeKereta().equalsIgnoreCase(kodeKereta)){
                targetKereta = k;
                break;
            }
        }
        if (targetKereta == null){
            throw new RuteTidakDitemukanException("Kode kereta '" + kodeKereta + "' tidak ditemukan di sistem.");
        }
        if (jumlahTiket > targetKereta.getSisaKursi()){
            throw new TiketHabisException(targetKereta.getNamaKereta(), targetKereta.getSisaKursi());
        }

        targetKereta.kurangiKursi(jumlahTiket);
        System.out.println("🎉 RESERVASI TIKET BERHASIL!");
        System.out.println("Nama Penumpang : " + namaPenumpang + " (NIK: " + nik + ")");
        System.out.println("Kereta Api     : " + targetKereta.getNamaKereta() + " (" + targetKereta.getRute() + ")");
        System.out.println("Jumlah Bangku  : " + jumlahTiket + " kursi");
    }
}