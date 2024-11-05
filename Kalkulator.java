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
     * @param angka1 Bilangan pertama
     * @param angka2 Bilangan kedua
     * @return Hasil penjumlahan angka1 dan angka2
     */
    public double tambah(double angka1, double angka2) {
        return angka1 + angka2;
    }

    /**
     * Mengurangi bilangan kedua dari bilangan pertama.
     *
     * @param angka1 Bilangan pertama
     * @param angka2 Bilangan kedua
     * @return Hasil pengurangan angka1 dan angka2
     */
    public double kurang(double angka1, double angka2) {
        return angka1 - angka2;
    }

    /**
     * Mengalikan dua bilangan.
     *
     * @param angka1 Bilangan pertama
     * @param angka2 Bilangan kedua
     * @return Hasil perkalian angka1 dan angka2
     */
    public double kali(double angka1, double angka2) {
        return angka1 * angka2;
    }

    /**
     * Membagi bilangan pertama dengan bilangan kedua.
     *
     * @param angka1 Bilangan pertama
     * @param angka2 Bilangan kedua
     * @return Hasil pembagian angka1 dengan angka2
     * @throws ArithmeticException jika angka2 adalah nol
     */
    public double bagi(double angka1, double angka2) {
        if (angka2 == 0) {
            throw new ArithmeticException("Pembagian dengan nol tidak diizinkan.");
        }
        return angka1 / angka2;
    }

    /**
     * Program utama untuk menjalankan kalkulator dengan input manual dan perulangan.
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
            double angka1 = scanner.nextDouble();

            System.out.print("Masukkan bilangan kedua: ");
            double angka2 = scanner.nextDouble();

            double hasil = 0;

            switch (pilihan) {
                case 1:
                    hasil = kalkulator.tambah(angka1, angka2);
                    break;
                case 2:
                    hasil = kalkulator.kurang(angka1, angka2);
                    break;
                case 3:
                    hasil = kalkulator.kali(angka1, angka2);
                    break;
                case 4:
                    try {
                        hasil = kalkulator.bagi(angka1, angka2);
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
