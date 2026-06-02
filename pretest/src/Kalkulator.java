import java.util.Scanner;
import java.util.InputMismatchException;

public class Kalkulator {
    private int pembilang;
    private int penyebut;
    private double hasil;

    public void jalankan() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Masukkan angka pertama (pembilang): ");
            pembilang = scanner.nextInt();

            System.out.print("Masukkan angka kedua (penyebut): ");
            penyebut = scanner.nextInt();

            if (penyebut == 0) {
                throw new ArithmeticException("/ by zero");
            }

            hasil = (double) pembilang / penyebut;
            System.out.println("Hasil pembagian: " + hasil);

        } catch (ArithmeticException e) {
            System.out.println("Pesan Peringatan: Kesalahan aritmatika, tidak dapat membagi angka dengan nol!");
        } catch (InputMismatchException e) {
            System.out.println("Pesan Peringatan: Input harus berupa angka bulat! Huruf atau karakter non-numerik tidak diizinkan.");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
            System.out.println("Proses kalkulasi selesai dan resource memori telah dibersihkan.");
        }
    }
}