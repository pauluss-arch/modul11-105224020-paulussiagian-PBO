import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        ReservasiController controller = new ReservasiController();
        Scanner scanner = new Scanner(System.in);
        int menu = 0;

        System.out.println("  SELAMAT DATANG DI SISTEM JAVA EXPRESS  ");

        do {
            try {
                System.out.println("\n=== MENU UTAMA ===");
                System.out.println("1. Lihat Jadwal & Sisa Kursi");
                System.out.println("2. Pesan Tiket Kereta");
                System.out.println("3. Keluar Aplikasi");
                System.out.print("Pilih menu (1-3): ");
                
                menu = scanner.nextInt(); 
                scanner.nextLine();

                switch (menu){
                    case 1:
                        System.out.println("\n--- JADWAL KERETA JAVA EXPRESS ---");
                        System.out.printf("%-10s %-20s %-15s %-10s\n", "KODE", "NAMA KERETA", "RUTE", "SISA KURSI");
                        for (Kereta k : controller.getDaftarKereta()) {
                            System.out.printf("%-10s %-20s %-15s %-10d\n", 
                                k.getKodeKereta(), k.getNamaKereta(), k.getRute(), k.getSisaKursi());
                        }
                        break;

                    case 2:
                        System.out.println("\n--- FORMULIR RESERVASI TIKET ---");
                        System.out.print("Masukkan Kode Kereta (K01/K02): ");
                        String kode = scanner.nextLine().trim();
                        
                        System.out.print("Masukkan NIK Penumpang        : ");
                        String nik = scanner.nextLine().trim();
                        
                        System.out.print("Masukkan Nama Penumpang       : ");
                        String nama = scanner.nextLine().trim();
                        
                        System.out.print("Masukkan Jumlah Tiket         : ");
                        int jumlahTiket = scanner.nextInt(); 
                        scanner.nextLine();

                        controller.pesanTiket(kode, nik, nama, jumlahTiket);
                        break;

                    case 3:
                        break;

                    default:
                        System.out.println(" Pilihan menu tidak valid! Sila pilih angka 1 hingga 3.");
                }

            } catch (InputMismatchException e) {
                System.out.println(" ERROR INPUT: Harap masukkan angka saja!");
                scanner.nextLine();
            } catch (DataPenumpangTidakValidException e) {
                System.out.println(" MASALAH DATA: " + e.getMessage());
            } catch (RuteTidakDitemukanException e) {
                System.out.println(" MASALAH RUTE: " + e.getMessage());
            } catch (TiketHabisException e) {
                System.out.println(" MASALAH KETERSEDIAAN: " + e.getMessage());
                System.out.println("Detail Sisa -> Kereta: " + e.getNamaKereta() + " | Kursi Tersedia: " + e.getSisaKursi());
            } catch (Exception e) {
                System.out.println(" Terjadi gangguan pada sistem: " + e.getMessage());
            } finally {
                if (menu == 3){
                    System.out.println("Terima kasih telah menggunakan sistem JAVA EXPRESS!");
                    System.out.println("Sistem dimatikan secara aman. Sampai jumpa!");
                    scanner.close();
                }
            }
        } while (menu != 3);
    }
}