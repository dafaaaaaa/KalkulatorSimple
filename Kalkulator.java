import java.util.Scanner;

/**
 * Kalkulator adalah kelas sederhana yang menyediakan
 * operasi dasar aritmatika: penjumlahan, pengurangan,
 * perkalian, dan pembagian dengan input dari pengguna.
 */
public class Kalkulator {

    /**
     * Menjumlahkan dua bilangan.
     *
     * @param bilanganPertama Bilangan pertama
     * @param bilanganKedua Bilangan kedua
     * @return Hasil penjumlahan bilanganPertama dan bilanganKedua
     */
    public double tambah(double bilanganPertama, double bilanganKedua) {
        return bilanganPertama + bilanganKedua;
    }

    /**
     * Mengurangi bilangan kedua dari bilangan pertama.
     *
     * @param bilanganPertama Bilangan pertama
     * @param bilanganKedua Bilangan kedua
     * @return Hasil pengurangan bilanganPertama dan bilanganKedua
     */
    public double kurang(double bilanganPertama, double bilanganKedua) {
        return bilanganPertama - bilanganKedua;
    }

    /**
     * Mengalikan dua bilangan.
     *
     * @param bilanganPertama Bilangan pertama
     * @param bilanganKedua Bilangan kedua
     * @return Hasil perkalian bilanganPertama dan bilanganKedua
     */
    public double kali(double bilanganPertama, double bilanganKedua) {
        return bilanganPertama * bilanganKedua;
    }

    /**
     * Membagi bilangan pertama dengan bilangan kedua.
     *
     * @param bilanganPertama Bilangan pertama
     * @param bilanganKedua Bilangan kedua
     * @return Hasil pembagian bilanganPertama dengan bilanganKedua
     * @throws ArithmeticException jika bilanganKedua adalah nol
     */
    public double bagi(double bilanganPertama, double bilanganKedua) {
        if (bilanganKedua == 0) {
            throw new ArithmeticException("Pembagian dengan nol tidak diizinkan.");
        }
        return bilanganPertama / bilanganKedua;
    }

    /**
     * Program utama yang menyediakan antarmuka berbasis teks untuk pengguna
     * untuk memilih operasi dan memasukkan bilangan, serta menampilkan hasil operasi.
     *
     * @param args Argumen baris perintah (tidak digunakan)
     */
    public static void main(String[] args) {
        Kalkulator kalkulator = new Kalkulator();
        Scanner scanner = new Scanner(System.in);
        boolean keluar = false;

        while (!keluar) {
            System.out.println("Pilih operasi: 1. Tambah 2. Kurang 3. Kali 4. Bagi 5. Keluar");
            int pilihan = scanner.nextInt();

            if (pilihan == 5) {
                keluar = true;
                System.out.println("Keluar dari program.");
                continue;
            }

            System.out.print("Masukkan bilangan pertama: ");
            double bilanganPertama = scanner.nextDouble();

            System.out.print("Masukkan bilangan kedua: ");
            double bilanganKedua = scanner.nextDouble();

            double hasil = 0;

            // Mengeksekusi operasi sesuai dengan pilihan pengguna
            switch (pilihan) {
                case 1:
                    hasil = kalkulator.tambah(bilanganPertama, bilanganKedua);
                    break;
                case 2:
                    hasil = kalkulator.kurang(bilanganPertama, bilanganKedua);
                    break;
                case 3:
                    hasil = kalkulator.kali(bilanganPertama, bilanganKedua);
                    break;
                case 4:
                    try {
                        hasil = kalkulator.bagi(bilanganPertama, bilanganKedua);
                    } catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    continue;
            }

            System.out.println("Hasil: " + hasil);
        }

        scanner.close();
    }
}
