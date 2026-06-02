public class Main {
    public static void main(String[] args) {
        AkunBank nasabah = new AkunBank("987654321", 12000000, 0);
        AkunBank rekeningTujuan = new AkunBank("123456789", 500000, 0);

        System.out.println("=== MEMULAI SIMULASI TRANSAKSI ATM DIGITAL ===\n");

        try {
            System.out.println("[Proses 1: Penarikan Tunai]");
            nasabah.tarikTunai(5000000);
            nasabah.tarikTunai(7000000); 

            System.out.println("\n[Proses 2: Percobaan Transfer Setelah Saldo Habis]");
            nasabah.transfer(rekeningTujuan, 2000000);

            System.out.println("\n[Proses 3: Percobaan Transfer Melebihi Batas Harian]");
            nasabah.transfer(rekeningTujuan, 11000000);

        } catch (SaldoTidakMencukupiException e) {
            System.out.println("\n[KATCH] " + e.getMessage());
            System.out.println("-> Anda kekurangan dana sebesar: Rp" + e.getNominalKurang());
        } catch (BatasTransferHarianException e) {
            System.out.println("\n[KATCH] " + e.getMessage());
        } finally {
            System.out.println("\n=== STRUK DIGITAL ===");
            System.out.println("Sesi transaksi ATM Anda telah diakhiri. Kartu dikeluarkan otomatis.");
        }
    }
}
