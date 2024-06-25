package com.Kuis02.pinjambuku;
import java.io.*;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.*;
public class PinjamBuku23 {
    
    // Method untuk mencetak daftar buku dari "database.txt"
    public void daftarBuku() throws IOException {
        FileReader fileInput;
        BufferedReader bufferInput;
        try {
            fileInput = new FileReader("database.txt");
            bufferInput = new BufferedReader(fileInput);
        } catch (Exception e){
            System.err.println("Database Tidak ditemukan");
            return;
        }
        String message = "DAFTAR BUKU";
        System.out.printf("\n%53s", message);
        System.out.println("\n+------------------------------------------+--------------------------------+------------------+");
        System.out.println("|               JUDUL BUKU                 |          NAMA PENULIS          |   TAHUN TERBIT   |");
        System.out.println("+------------------------------------------+--------------------------------+------------------+");
        String data = bufferInput.readLine();
        while(data != null) {
            StringTokenizer stringToken = new StringTokenizer(data, ",");
            System.out.printf("| %-41s", stringToken.nextToken());
            System.out.printf("|%-32s", stringToken.nextToken());
            System.out.printf("|%-18s|", stringToken.nextToken());
            System.out.println();
            data = bufferInput.readLine();
        }
        System.out.println("+------------------------------------------+--------------------------------+------------------+");
        bufferInput.close();
        fileInput.close();
    }

    // Method untuk mencetak daftar buku dari "sorted_database_by_title.txt"
    public static void urutBukuAbjad() throws IOException {
        FileReader fileInput;
        BufferedReader bufferInput;
        try {
            fileInput = new FileReader("sorted_database_by_title.txt");
            bufferInput = new BufferedReader(fileInput);
        } catch (Exception e){
            System.err.println("Database Tidak ditemukan");
            return;
        }
        String message = "DAFTAR BUKU";
        System.out.printf("\n%53s", message);
        System.out.println("\n+------------------------------------------+--------------------------------+------------------+");
        System.out.println("|               JUDUL BUKU                 |          NAMA PENULIS          |   TAHUN TERBIT   |");
        System.out.println("+------------------------------------------+--------------------------------+------------------+");
        String data = bufferInput.readLine();
        while(data != null) {
            StringTokenizer stringToken = new StringTokenizer(data, ",");
            System.out.printf("| %-41s", stringToken.nextToken());
            System.out.printf("|%-32s", stringToken.nextToken());
            System.out.printf("|%-18s|", stringToken.nextToken());
            System.out.println();
            data = bufferInput.readLine();
        }
        System.out.println("+------------------------------------------+--------------------------------+------------------+");
        bufferInput.close();
        fileInput.close();
    }

    // Method untuk mencetak daftar buku dari "sorted_database_by_year.txt"
    public static void urutBukuTahun() throws IOException {
        FileReader fileInput;
        BufferedReader bufferInput;
        try {
            fileInput = new FileReader("sorted_database_by_year.txt");
            bufferInput = new BufferedReader(fileInput);
        } catch (Exception e){
            System.err.println("Database Tidak ditemukan");
            return;
        }
        String message = "DAFTAR BUKU";
        System.out.printf("\n%53s", message);
        System.out.println("\n+------------------------------------------+--------------------------------+------------------+");
        System.out.println("|               JUDUL BUKU                 |          NAMA PENULIS          |   TAHUN TERBIT   |");
        System.out.println("+------------------------------------------+--------------------------------+------------------+");
        String data = bufferInput.readLine();
        while(data != null) {
            StringTokenizer stringToken = new StringTokenizer(data, ",");
            System.out.printf("| %-41s", stringToken.nextToken());
            System.out.printf("|%-32s", stringToken.nextToken());
            System.out.printf("|%-18s|", stringToken.nextToken());
            System.out.println();
            data = bufferInput.readLine();
        }
        System.out.println("+------------------------------------------+--------------------------------+------------------+");
        bufferInput.close();
        fileInput.close();
    }

    // Method untuk membaca data dari "database.txt"
    public static ArrayList<HashMap<String, String>> readData(String filename) {
        ArrayList<HashMap<String, String>> books = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                HashMap<String, String> book = new HashMap<>();
                book.put("Title", parts[0]);
                book.put("Author", parts[1]);
                book.put("Year", parts[2]);
                books.add(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }

    // Method untuk menulis data kembali ke dalam <nama file>.txt
    public static void tulisData(String filename, ArrayList<HashMap<String, String>> books) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (HashMap<String, String> book : books) {
                writer.println(book.get("Title") + ", " + book.get("Author") + ", " + book.get("Year"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method untuk menambah buku
    public void tambahBuku() throws IOException {
        FileWriter fileOutput = new FileWriter("database.txt", true);
        BufferedWriter bufferOutput = new BufferedWriter(fileOutput);
        Scanner userInput = new Scanner(System.in);
        System.out.print("\nMasukkan Judul Buku\t : ");
        String judulBuku = userInput.nextLine();
        System.out.print("Masukkan Penulis\t : ");
        String penulisBuku = userInput.nextLine();
        System.out.print("Masukkan Tahun Terbit\t : ");
        String tahunTerbit = userInput.nextLine();
        String[] kataKunci = {(judulBuku) + ", " + (penulisBuku) + ", " + (tahunTerbit)};
        System.out.println("\nKata Kunci : " + Arrays.toString(kataKunci));
        boolean tersedia = cekBukuDiDatabase(kataKunci, false);
        if (!tersedia) {
            System.out.println("\n+-------------------------------------------------------------+");
            System.out.println("|                          DATA BUKU                          |");
            System.out.println("+-------------------------------------------------------------+");
            System.out.printf("| Judul Buku   : %-45s|", judulBuku);
            System.out.printf("\n| Penulis      : %-45s|", penulisBuku);
            System.out.printf("\n| Tahun Terbit : %-45s|", tahunTerbit);
            System.out.println("\n+-------------------------------------------------------------+");
            bufferOutput.write((judulBuku) + ", " + (penulisBuku) + ", " + (tahunTerbit));
            bufferOutput.newLine();
            bufferOutput.flush();
        } 
        if (tersedia) {
            System.out.println("\nBuku Sudah Tersedia pada Database");
            cekBukuDiDatabase(kataKunci, true);
        }
        bufferOutput.close();
        fileOutput.close();
    }

    // Method untuk menghapus buku
    public void hapusBuku() throws IOException {
        File database = new File("database.txt");
        BufferedReader bufferedInput = new BufferedReader(new FileReader(database));
        File tempDB = new File("temporaryDatabase.txt");
        BufferedWriter bufferedOutput = new BufferedWriter(new FileWriter(tempDB));
        Scanner userInput = new Scanner(System.in);
        System.out.print("\nMasukkan Judul Buku yang ingin Dihapus : ");
        String judulBuku = userInput.nextLine();
        String data;
        boolean ditemukan = false;
        // Membaca file database dan menulis ke file sementara
        while ((data = bufferedInput.readLine()) != null) {
            String[] dataBuku = data.split(",");
            if (dataBuku[0].equalsIgnoreCase(judulBuku)) {
                ditemukan = true;
                System.out.println("\n+-------------------------------------------------------------+");
                System.out.println("|                          DATA BUKU                          |");
                System.out.println("+-------------------------------------------------------------+");
                System.out.printf("| Judul Buku   :  %-44s|%n", dataBuku[0]);
                System.out.printf("| Penulis      : %-45s|%n", dataBuku[1]);
                System.out.printf("| Tahun Terbit : %-45s|%n", dataBuku[2]);
                System.out.println("+-------------------------------------------------------------+");
                System.out.println("\nBuku Berhasil Dihapus");
            }else {
                if (dataBuku[0] != null) {
                    bufferedOutput.write(data);
                    bufferedOutput.newLine();
                }
                bufferedOutput.flush();
            }
        }
        if (!ditemukan) {
            System.out.println("\nJudul Buku Tidak Ditemukan Dalam Database");
        }
        bufferedInput.close();
        bufferedOutput.close();
        if (database.delete()) {
            if (tempDB.renameTo(database)) {
            } else {
                System.out.println("Gagal mengubah nama file temporaryDatabase.txt menjadi database.txt.");
            }
        } else {
            System.out.println("Gagal menghapus file database.txt.");
        }
    }
    
    // Method untuk mencari buku berdasarkan judul
    public void cariBuku() throws IOException {
        FileReader fileInput = new FileReader("database.txt");
        BufferedReader bufferInput = new BufferedReader(fileInput);
        Scanner userInput = new Scanner(System.in);
        System.out.println("\n+-----------------------------------+");
        System.out.println("|          CARI DATA BUKU           |");
        System.out.println("+-----------------------------------+");
        System.out.println("| 1. Cari Berdasarkan Judul Buku    |");
        System.out.println("| 2. Cari Berdasarkan Nama Penulis  |");
        System.out.println("+-----------------------------------+");
        System.out.print("Masukkan Pilihan Anda : ");
        int userOption = userInput.nextInt();
        userInput.nextLine();
        switch (userOption) {
            case 1:
                System.out.print("\nMasukkan Judul Buku   : ");
                String judulBuku = userInput.nextLine();
                String[] kataKunciBuku = {(judulBuku)};
                System.out.println("\nKata Kunci\t      : " + (Arrays.toString(kataKunciBuku)));
                boolean bukuTersedia = cekBukuDiDatabase(kataKunciBuku, false);
                if (bukuTersedia) {
                    System.out.println("\nBuku Ditemukan");
                    cekBukuDiDatabase(kataKunciBuku, true);
                }else {
                    System.out.println("\nBuku Tidak Ditemukan");
                }
                break;
            case 2:
                System.out.print("\nMasukkan Nama Penulis : ");
                String namaPenulis = userInput.nextLine();
                String[] kataKunciPenulis = {(namaPenulis)};
                System.out.println("\nKata Kunci\t      : " + (Arrays.toString(kataKunciPenulis)));
                boolean penulisTersedia = cekBukuDiDatabase(kataKunciPenulis, false);
                if (penulisTersedia) {
                    System.out.println("\nBuku Ditemukan");
                    cekBukuDiDatabase(kataKunciPenulis, true);
                }else {
                    System.out.println("\nBuku Tidak Ditemukan");
                }
                break;
            default:
                System.out.println("Pilihan Yang Anda Masukkan Tidak Tersedia");
                break;
        }
        fileInput.close();
        bufferInput.close();
    }

    // Method untuk meminjam buku
    public void pinjamBuku() throws IOException {
        BufferedReader bufferedInput = new BufferedReader(new FileReader("database.txt"));
        Scanner userInput = new Scanner(System.in);
        System.out.print("\nMasukkan Nama       : ");
        String namaPeminjam = userInput.nextLine();
        System.out.print("Masukkan Judul Buku : ");
        String judulBuku = userInput.nextLine();
        Date tanggalSekarang = new Date();
        DateFormatSymbols Symbols = new DateFormatSymbols(new Locale("id", "ID"));
        SimpleDateFormat formatTanggal = new SimpleDateFormat("EEEE, dd MMMM yyyy", Symbols);
        Calendar kalender = Calendar.getInstance();
        String data;
        boolean found = false;
        while ((data = bufferedInput.readLine()) != null) {
            String[] dataBuku = data.split(", ");
            if (dataBuku[0].equalsIgnoreCase(judulBuku)) {
                found = true;
                String message = "DATA PEMINJAM";
                kalender.add(Calendar.DATE, 21);
                System.out.printf("\n%38s\n", message);
                System.out.println("+-------------------------------------------------------------+");
                System.out.printf("| Nama Peminjam               : %-30s|\n", namaPeminjam);
                System.out.println("+-------------------------------------------------------------+");
                System.out.printf("| Judul Buku                  : %-30s|\n", dataBuku[0]);
                System.out.printf("| Penulis                     : %-30s|\n", dataBuku[1]);
                System.out.printf("| Tahun Terbit                : %-30s|\n", dataBuku[2]);
                System.out.println("+-------------------------------------------------------------+");
                System.out.printf("| Tanggal Pinjam              : %-30s|\n", formatTanggal.format(tanggalSekarang));
                System.out.println("| Maksimal Durasi Peminjaman  : 21 Hari (3 Minggu)            |");
                System.out.printf("| Maksimal Pengembalian       : %-30s|\n", formatTanggal.format(kalender.getTime()));
                System.out.println("+-------------------------------------------------------------+");
                kalender.add(Calendar.DATE, -21);
                riwayatPeminjaman(namaPeminjam, dataBuku[0], dataBuku[1], dataBuku[2]);
                break;
            }
        }
        if (!found) {
            System.out.println("\nBuku tidak ditemukan dalam database.");
        }
        bufferedInput.close();
    }

    // Method untuk menampilkan riwayat peminjaman
    public void tampilDaftarPinjam() throws IOException {
        BufferedReader bufferedInput = new BufferedReader(new FileReader("riwayat_peminjaman.txt"));
        String data;
        String message = "DAFTAR RIWAYAT PEMINJAMAN";
        System.out.printf("\n%79s\n", message);
        System.out.println("+--------------------------------+--------------------------------+--------------------------------+--------------------------------+");
        System.out.println("|         NAMA PEMINJAM          |           JUDUL BUKU           |          PENULIS BUKU          |          TAHUN TERBIT          |");
        System.out.println("+--------------------------------+--------------------------------+--------------------------------+--------------------------------+");
        while ((data = bufferedInput.readLine()) != null) {
            String[] dataPeminjam = data.split(", ");
            System.out.printf("| %-30s | %-30s | %-30s | %-30s |\n", dataPeminjam[0], dataPeminjam[1], dataPeminjam[2], dataPeminjam[3]);
        }
        System.out.println("+--------------------------------+--------------------------------+--------------------------------+--------------------------------+");
        bufferedInput.close();
    }

    // Method untuk membuat database daftar riwayat peminjaman
    public static void riwayatPeminjaman(String namaPeminjam, String judulBuku, String penulis, String tahunTerbit) throws IOException {
        BufferedWriter bufferedOutput = new BufferedWriter(new FileWriter("riwayat_peminjaman.txt", true));
        bufferedOutput.write(namaPeminjam + ", " + judulBuku + ", " + penulis + ", " + tahunTerbit);
        bufferedOutput.newLine();
        bufferedOutput.close();
    }

    // Method untuk mengecek buku di "database.txt"
    public static boolean cekBukuDiDatabase(String[] kataKunci, boolean tampilkan) throws IOException {
        FileReader fileInput = new FileReader("database.txt");
        BufferedReader bufferInput = new BufferedReader(fileInput);
        String data = bufferInput.readLine();
        boolean tersedia = false;
        if (tampilkan) {
            System.out.println("\n+------------------------------------------+--------------------------------+------------------+");
            System.out.println("|               JUDUL BUKU                 |          NAMA PENULIS          |   TAHUN TERBIT   |");
            System.out.println("+------------------------------------------+--------------------------------+------------------+");

        }
        while (data != null) {
            tersedia = true;
            for (String katakunci : kataKunci) {
                tersedia = tersedia && data.toLowerCase().contains(katakunci.toLowerCase());
            }
            if (tersedia) {
                if (tampilkan) {
                    StringTokenizer stringToken = new StringTokenizer(data, ",");
                    System.out.printf("| %-41s", stringToken.nextToken());
                    System.out.printf("|%-32s", stringToken.nextToken());
                    System.out.printf("|%-18s|", stringToken.nextToken());
                    System.out.println();
                } else {
                    break;
                }
            }
            data = bufferInput.readLine();
        }
        if (tampilkan) {
            System.out.println("+------------------------------------------+--------------------------------+------------------+");
        }
        fileInput.close();
        bufferInput.close();
        return tersedia;
    }

    // Method untuk menghapus file database
    public static void hapusFileDatabase() {
        File file1 = new File("riwayat_peminjaman.txt");
        File file2 = new File("sorted_database_by_title.txt");
        File file3 = new File("sorted_database_by_year.txt");
        file1.delete();
        file2.delete();
        file3.delete();
    }


}