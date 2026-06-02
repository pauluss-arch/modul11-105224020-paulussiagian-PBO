import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        Scanner inputAdmin = new Scanner(System.in);
        
        System.out.println("=== INPUT KUOTA MATA KULIAH ===");
        int[] kuotaMatkul = new int[3];

        for (int i = 0; i < 4; i++) {
            try {
                System.out.print("Masukkan kuota untuk mata kuliah ke-" + (i + 1) + ": ");
                kuotaMatkul[i] = inputAdmin.nextInt();
                System.out.println("Kuota berhasil disimpan.");
            } catch (InputMismatchException e) {
                System.out.println("Error: Input kuota harus berupa angka!");
                inputAdmin.next(); 
                i--; 
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: Batas array terlampaui! Anda mencoba mengisi indeks ke-" + i + " pada array berukuran 3.");
            }
        }

        System.out.println("\n==========================================\n");

        System.out.println("=== VALIDASI MAHASISWA & SKS ===");
        Mahasiswa mhs = new Mahasiswa(10);

        try {
            mhs.setSksMaksimal(30);
        } catch (IllegalArgumentException e) {
            System.out.println("Tertangkap Error (Soal 2): " + e.getMessage());
        }

        try {
            mhs.ambilMataKuliah("Struktur Data Lanjutan", 12);
        } catch (SksTidakCukupException e) {
            System.out.println("Tertangkap Error (Soal 3): " + e.getMessage());
        }

        System.out.println("\n==========================================\n");

        System.out.println("=== OPERASIONAL KELAS & STRUK ===");
        sistemAkademik sa = new sistemAkademik();

        try {
            sa.gabungKelas("INF-301", 0);
        } catch (KelasPenuhException e) {
            System.out.println("Tertangkap Error (Soal 4): " + e.getMessage());
        }

        try {
            sa.cetakDokumen("krs_palsu.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Tertangkap Error (Soal 5): " + e.getMessage());
        } finally {
            System.out.println("Sesi Sistem Rencana Studi telah ditutup. Koneksi database diputuskan.");
        }
        
        inputAdmin.close();
    }
}