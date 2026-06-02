import java.io.FileNotFoundException;

public class sistemAkademik {
    public void gabungKelas(String kodeKelas, int koutaTersedia)throws KelasPenuhException{
        if(koutaTersedia <= 0){
            throw new KelasPenuhException("kesalahan: kelas "+ kodeKelas + "sudah penuh");
        }
        System.out.println("Berhasil gabung ke kelas " + kodeKelas);
    }
    public void cetakDokumen(String namaFile)throws FileNotFoundException{
        if(!namaFile.equals("krs_valid.txt")){
            throw new FileNotFoundException("File " + namaFile + "tidak ditemukan atau tidak valid untuk dicetak");
        }
        System.out.println("Dokumen KRS (" + namaFile + ") berhasil dicetak");
    }
}
