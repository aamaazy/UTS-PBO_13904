package UTS_PBO_13904;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Menu Program Mahasiswa");
            System.out.println("[1] Tambah Mahasiswa");
            System.out.println("[2] Lihat Mahasiswa");
            System.out.println("[3] Keluar Dari Program");
            System.out.println("----------------------");
            System.out.print("Pilih Menu = ");
            int pilih = scanner.nextInt();
            scanner.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("Masukan Jumlah Mahasiswa Yang Akan Diinput = ");
                    int jumlahMahasiswa = scanner.nextInt();
                    scanner.nextLine();

                    for (int i = 0; i < jumlahMahasiswa; i++) {
                        System.out.println("\nMahasiswa ke - " + (i + 1));

                        System.out.print("NIM Mahasiswa      = ");
                        String nim = scanner.nextLine();

                        System.out.print("Nama Mahasiswa     = ");
                        String nama = scanner.nextLine();

                        System.out.print("Mahasiswa Semester = ");
                        int semester = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Umur Mahasiswa     = ");
                        int usia = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Jumlah mata kuliah = ");
                        int jumlahMatkul = scanner.nextInt();
                        scanner.nextLine();

                        String[] krs = new String[jumlahMatkul];
                        int[] nilai = new int[jumlahMatkul];

                        for (int j = 0; j < jumlahMatkul; j++) {
                            System.out.print("  - Nama Mata kuliah " + (j + 1) + "  = ");
                            krs[j] = scanner.nextLine();

                            System.out.print("  - Nilai Mata kuliah " + (j + 1) + " = ");
                            nilai[j] = scanner.nextInt();
                            scanner.nextLine();
                        }

                        System.out.println("Pilih Golongan Mahasiswa");
                        System.out.println("[1] Mahasiswa Baru");
                        System.out.println("[2] Mahasiswa Lulus");
                        System.out.println("[3] Mahasiswa Transfer");
                        System.out.println("[4] Mahasiswa Aktif");
                        System.out.println("------------------------");
                        int golonganMahasiswa = scanner.nextInt();
                        scanner.nextLine();

                        if (golonganMahasiswa == 1) {
                            System.out.print("Asal Sekolah Mahasiswa = ");
                            String asalSekolah = scanner.nextLine();

                            System.out.print("Ikut OSPEK (ya/tidak)  = ");
                            String ikutOspek = scanner.nextLine();

                            daftarMahasiswa.add(
                                    new MahasiswaBaru(nim, nama, semester, usia, krs, asalSekolah, nilai, ikutOspek));
                        } else if (golonganMahasiswa == 2) {
                            System.out.print("Tahun Wisuda Mahasiswa = ");
                            int tahunWisuda = scanner.nextInt();
                            scanner.nextLine();

                            System.out.print("Jumlah IPK Mahasiswa   = ");
                            float ipk = scanner.nextFloat();
                            scanner.nextLine();

                            System.out.print("Ikut Wisuda (ya/tidak) = ");
                            String ikutWisuda = scanner.nextLine();

                            daftarMahasiswa.add(new MahasiswaLulus(nim, nama, semester, usia, krs, tahunWisuda, ipk,
                                    nilai, ikutWisuda));
                        } else if (golonganMahasiswa == 3) {
                            System.out.print("Asal Sekolah Mahasiswa    = ");
                            String asalSekolah = scanner.nextLine();

                            System.out.print("Asal UniversitasMahasiswa = ");
                            String asalUniversitas = scanner.nextLine();

                            daftarMahasiswa.add(new MahasiswaTransfer(nim, nama, semester, usia, krs, asalSekolah,
                                    asalUniversitas, nilai));
                        } else if (golonganMahasiswa == 4) {

                            System.out.print("Masukan Jumlah Absensi = ");
                            int absen = scanner.nextInt();
                            System.out.print("Batas Absensi Mahasiswa = ");
                            int batasAbsen = scanner.nextInt();

                            if (absen > batasAbsen) {
                                System.out.println("Mahasiswa Aktif");
                            } else {
                                System.out.println("\n Mahasiswa Tidak Aktif");
                            }

                        }

                        else {
                            System.out.println("Tipe mahasiswa tidak valid.");
                        }
                    }
                    break;

                case 2:
                    // Output data mahasiswa
                    System.out.println("\nDaftar Mahasiswa");
                    for (Mahasiswa mhs : daftarMahasiswa) {
                        mhs.infoMahasiswa();
                        mhs.infoKrsMahasiswa();

                        int[] nilai = mhs.getNilai();
                        double rataRataNilai = 0.0;

                        System.out.print("Nilai: ");
                        for (int i = 0; i < nilai.length; i++) {
                            System.out.print(nilai[i] + " ");
                            rataRataNilai += nilai[i];
                        }

                        if (nilai.length > 0) {
                            rataRataNilai /= nilai.length;
                        }

                        String rataRataFormat = String.format("%.1f", rataRataNilai);
                        System.out.println("\nRata - Rata Nilai Mahasiswa =  " + rataRataFormat);

                    }
                    break;

                case 3:
                    // Keluar dari program
                    isRunning = false;
                    break;
                default:
                    System.out.println("Menu tidak ada.");
            }
        }

        System.out.println("Terima Kasih Telah Menggunakan Program ini.");
    }
}