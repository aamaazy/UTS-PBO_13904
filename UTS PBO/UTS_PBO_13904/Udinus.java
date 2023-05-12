package UTS_PBO_13904;

import java.util.ArrayList;
import java.util.Scanner;

// Superclass (Class Mahasiswa)
class Mahasiswa {
    // Atribut
    String nim;
    String nama;
    int semester;
    int usia;
    String krs[];
    int[] nilai;

    // Constructor pembuat Objek dari Class Mahasiswa
    public Mahasiswa(String nim, String nama, int semester, int usia, String krs[], int[] nilai) {
        this.nim = nim;
        this.nama = nama;
        this.semester = semester;
        this.usia = usia;
        this.krs = krs;
        this.nilai = nilai;
    }

    // Method Fungi yang mengembalikan "return"
    public int[] getNilai() {
        return nilai;
    }

    // Method Prosedur
    public void setNilai(int[] nilai) {
        this.nilai = nilai;
    }

    // Method menghitung nilai rata - rata Mahasiswa
    public float hitungRataNilai(int[] nilai) {
        int total = 0;
        for (int i = 0; i < nilai.length; i++) {
            total += nilai[i];
        }
        return (float) total / nilai.length;
    }

    // Method infoMahasiswa
    public void infoMahasiswa() {
        System.out.println("NIM Mahasiswa       = " + nim);
        System.out.println("Nama Mahasiswa      = " + nama);
        System.out.println("Semester Mahasiswa  = " + semester);
        System.out.println("Usia Mahasiswa      = " + usia);
    }

    // Method infoKrsMahasiswa
    public void infoKrsMahasiswa() {
        System.out.println("KRS Mahasiswa     = ");
        for (int i = 0; i < krs.length; i++) {
            System.out.println("- " + krs[i]);
        }
    }
}

// Subclass (Class MahasiswaBaru)
class MahasiswaBaru extends Mahasiswa {
    // Atribut
    String asalSekolah;
    String ikutOspek;

    // Constructor pembuat Objek dari Class Mahasiswa
    public MahasiswaBaru(String nim, String nama, int semester, int usia, String[] krs, String asalSekolah, int[] nilai,
            String ikutOspek) {
        super(nim, nama, semester, usia, krs, nilai);
        this.asalSekolah = asalSekolah;
        this.ikutOspek = ikutOspek;
    }

    // Method Fungi yang mengembalikan "return"
    public boolean ikutOspek() {
        return true;
    }

    // Method infoMahasiswa
    public void infoMahasiswa() {
        super.infoMahasiswa();
        System.out.println("Asal Sekolah Mahasiswa      = " + asalSekolah);
        System.out.println("Apakah Mahasiswa Ikut OSPEK = " + ikutOspek);
    }
}

// Subclass (Class MahasiswaBaru)
class MahasiswaLulus extends Mahasiswa {
    // Atribut
    int tahunWisuda;
    float ipk;
    String ikutWisuda;

    // Constructor pembuat Objek dari Class Mahasiswa
    public MahasiswaLulus(String nim, String nama, int semester, int usia, String[] krs, int tahunWisuda, float ipk,
            int[] nilai, String ikutWisuda) {
        super(nim, nama, semester, usia, krs, nilai);
        this.tahunWisuda = tahunWisuda;
        this.ipk = ipk;
        this.ikutWisuda = ikutWisuda;
    }

    // Method Fungi yang mengembalikan "return"
    public String getIkutWisuda() {
        return ikutWisuda;
    }

    public boolean ikutWisuda() {
        return true;
    }

    // Method infoMahasiswa
    public void infoMahasiswa() {
        super.infoMahasiswa();
        System.out.println("Tahun Wisuda Mahasiswa = " + tahunWisuda);
        System.out.println("IPK Mahasiswa          = " + ipk);
        System.out.println("Ikut Mahasiwa Wisuda   = " + ikutWisuda);
    }
}

// Subclass (Class MahasiswaTransfer)
class MahasiswaTransfer extends MahasiswaBaru {
    // Atribut
    String asalSekolah;
    String asalUniversitas;
    boolean ikutOspek;

    // Constructor pembuat Objek dari Class Mahasiswa
    public MahasiswaTransfer(String nim, String nama, int semester, int usia, String[] krs, String asalSekolah,
            String asalUniversitas, int[] nilai) {
        super(nim, nama, semester, usia, krs, asalSekolah, nilai, asalUniversitas);
        this.asalSekolah = asalSekolah;
        this.asalUniversitas = asalUniversitas;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Apakah Mahasiswa Ikut OSPEK? (ya/tidak) = ");
        String jawaban = scanner.nextLine();
        this.ikutOspek = jawaban.equalsIgnoreCase("ya");
    }

    // Method Fungi yang mengembalikan "return"
    public String getAsalSekolah() {
        return asalSekolah;
    }

    // Method Fungi yang mengambalikan "return"
    public String getAsalUniversitas() {
        return asalUniversitas;
    }

    // Method Fungi yang mengambalikan "return"
    public boolean isIkutOspek() {
        return ikutOspek;
    }

    public void infoMahasiswa() {
        super.infoMahasiswa();
        System.out.println("Asal Sekolah Mahasiswa      = " + asalSekolah);
        System.out.println("Asal Universitas Mahasiswa  = " + asalUniversitas);
        System.out.println("Apakah Mahasiswa Ikut OSPEK = " + (ikutOspek ? "ya" : "tidak"));
    }
}

// Subclass (Class MahasiswaAktif)
class MahasiswaAktif extends Mahasiswa {
    Scanner input = new Scanner(System.in);
    int absen = 0;
    int batasAbsen = 14;

    // Constructor pembuat Objek dari Class Mahasiswa
    public MahasiswaAktif(String nim, String nama, int semester, int usia, String[] krs, int[] nilai, int absen,
            int batasAbsen) {
        super(nim, nama, semester, usia, krs, nilai);
        this.absen = absen;
        this.batasAbsen = batasAbsen;

    }
}