public class AkunBank {
    private String nomorRekening;
    private double saldo;
    private double totalTransferHariini;

    public AkunBank(String nomorRekening, double saldo, double totalTransferHariini){
        this.nomorRekening = nomorRekening;
        this.saldo = saldo;
        this.totalTransferHariini = 0;
    }
    public void tarikTunai(double nominal)throws SaldoTidakMencukupiException{
        if(nominal > this.saldo){
            double kekurangan = nominal - this.saldo;
            throw new SaldoTidakMencukupiException("Transaksi gagal: saldo akun tidak mencukupi untuk penarikan tunai ", kekurangan);
        }
        this.saldo -= nominal;
        System.out.println("Tarik tunai berhasil : Rp" + nominal + "| sisa saldo : Rp" + this.saldo);
    }
    public void transfer(AkunBank tujuan, double nominal)throws BatasTransferHarianException, SaldoTidakMencukupiException{
        if(this.totalTransferHariini + nominal > 10000000){
            throw new BatasTransferHarianException("Transaksi gagal : Akumulasi transfer amda hari ini telah melampaui limit harian (10.000.000).");
        }

        if(nominal > this.saldo){
            double kekurangan  = nominal - this.saldo;
            throw new SaldoTidakMencukupiException("Transaksi Gagal: Saldo akun tidak mencukupi untuk melakukan transfer.", kekurangan);   
         }
         this.saldo -= nominal;
         tujuan.saldo += nominal;
         this.totalTransferHariini += nominal;
         
         System.out.println("Transfer berhasil ke Rekening " + tujuan.nomorRekening + " sebesar Rp" + nominal);
        System.out.println("Sisa Saldo: Rp" + this.saldo + " | Akumulasi Transfer Hari Ini: Rp" + this.totalTransferHariini);
    }
}
