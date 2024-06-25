package com.Kuis02.pinjambuku;
import java.util.*;
import java.io.*;
public class PinjamBukuMain23 {
    public static void main(String[] args) throws Exception {
        PinjamBuku23 pb23 = new PinjamBuku23();
        boolean condition = true;
        while(condition) {
            OuterLoop:
            switch (menu()) {
                case 1:
                    pb23.daftarBuku();
                    break;
                case 2:
                    pb23.pinjamBuku();
                    break;
                case 3:
                    pb23.tampilDaftarPinjam();
                    break;
                case 4:
                    pb23.tambahBuku();
                    break;
                case 5:
                    pb23.daftarBuku();
                    pb23.hapusBuku();
                    break;
                case 6:
                    pb23.cariBuku();
                    break;
                case 7:
                    switch (menuNomor7()) {
                        case 1:
                            switch (ascendingOrDescending()) {
                                case 1:
                                    // Membaca data dari file "database.txt"
                                    ArrayList<HashMap<String, String>> books1 = pb23.readData("database.txt");

                                    // Mengurutkan data berdasarkan judul buku
                                    Collections.sort(books1, new Comparator<HashMap<String, String>>() {
                                        @Override
                                        public int compare(HashMap<String, String> book1, HashMap<String, String> book2) {
                                            return book1.get("Title").compareTo(book2.get("Title"));
                                        }
                                    });

                                    // Tulis kembali data yang telah diurutkan ke dalam "sorted_database_by_title.txt"
                                    pb23.tulisData("sorted_database_by_title.txt", books1);

                                    // Mencetak data dari file "sorted_database_by_title.txt"
                                    pb23.urutBukuAbjad();
                                    break OuterLoop;
                                case 2:
                                    // Membaca data dari file "database.txt"
                                    ArrayList<HashMap<String, String>> books2 = pb23.readData("database.txt");

                                    // Mengurutkan data berdasarkan judul buku
                                    Collections.sort(books2, new Comparator<HashMap<String, String>>() {
                                        @Override
                                        public int compare(HashMap<String, String> book1, HashMap<String, String> book2) {
                                            return book2.get("Title").compareTo(book1.get("Title"));
                                        }
                                    });

                                    // Tulis kembali data yang telah diurutkan ke dalam "sorted_database_by_title.txt"
                                    pb23.tulisData("sorted_database_by_title.txt", books2);

                                    // Mencetak data dari file "sorted_database_by_title.txt"
                                    pb23.urutBukuAbjad();
                                    break OuterLoop;
                                default:
                                    System.out.println("Pilihan Yang Anda Masukkan Tidak Tersedia");
                                    break;
                            }
                            break;
                        case 2:
                            switch (ascendingOrDescending()) {
                                case 1:
                                    // Membaca data dari file "database.txt"
                                    ArrayList<HashMap<String, String>> books1 = pb23.readData("database.txt");

                                    // Mengurutkan data berdasarkan tahun terbit 
                                    Collections.sort(books1, new Comparator<HashMap<String, String>>() {
                                        @Override
                                        public int compare(HashMap<String, String> book1, HashMap<String, String> book2) {
                                            int year1 = Integer.parseInt(book1.get("Year"));
                                            int year2 = Integer.parseInt(book2.get("Year"));
                                            return Integer.compare(year1, year2);
                                        }
                                    });

                                    // Tulis kembali data yang telah diurutkan ke dalam "sorted_database_by_year.txt"
                                    pb23.tulisData("sorted_database_by_year.txt", books1);

                                    // Mencetak data dari file "sorted_database_by_year.txt"
                                    pb23.urutBukuTahun();
                                    break OuterLoop;
                                case 2:
                                    // Membaca data dari file "database.txt"
                                    ArrayList<HashMap<String, String>> books2 = pb23.readData("database.txt");

                                    // Mengurutkan data berdasarkan tahun terbit 
                                    Collections.sort(books2, new Comparator<HashMap<String, String>>() {
                                        @Override
                                        public int compare(HashMap<String, String> book1, HashMap<String, String> book2) {
                                            int year1 = Integer.parseInt(book1.get("Year"));
                                            int year2 = Integer.parseInt(book2.get("Year"));
                                            return Integer.compare(year2, year1);
                                        }
                                    });

                                    // Tulis kembali data yang telah diurutkan ke dalam "sorted_database_by_year.txt"
                                    pb23.tulisData("sorted_database_by_year.txt", books2);

                                    // Mencetak data dari file "sorted_database_by_year.txt"
                                    pb23.urutBukuTahun();
                                    break OuterLoop;
                                default:
                                    System.out.println("Pilihan Yang Anda Masukkan Tidak Tersedia");
                                    break;
                            }
                            break;
                        default:
                            System.out.println("Pilihan Yang Anda Masukkan Tidak Tersedia");
                            break;
                    }
                case 8:
                    pb23.hapusFileDatabase();
                    System.exit(0);
                default:
                    System.out.println("Pilihan Yang Anda Masukkan Tidak Tersedia");
                    break;
            }
        }
    }

    // Method untuk mencetak menu utama dan menerima input user berupa integer
    public static int menu() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("\n+---------------------------+" + 
                            "\n|        PINJAM BUKU        |" +
                            "\n+---------------------------+" +
                            "\n| 1. Daftar Buku            |" +
                            "\n| 2. Pinjam Buku            |" + 
                            "\n| 3. Daftar Riwayat Pinjam  |" + 
                            "\n| 4. Tambah Buku            |" + 
                            "\n| 5. Hapus Buku             |" + 
                            "\n| 6. Cari Data Buku         |" + 
                            "\n| 7. Urutkan Data Buku      |" + 
                            "\n| 8. Keluar                 |" + 
                            "\n+---------------------------+");
        System.out.print("Masukkan Pilihan Anda : ");
        int userOption = userInput.nextInt();
        return userOption;
    }

    // Method untuk mencetak pilihan nomor 7
    public static int menuNomor7() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("\n+-----------------------------+" + 
                            "\n|        URUTKAN BUKU         |" + 
                            "\n+-----------------------------+" + 
                            "\n| 1. Berdasarkan Judul Buku   |" + 
                            "\n| 2. Berdasarkan Tahun Terbit |" + 
                            "\n+-----------------------------+");
        System.out.print("Masukkan Pilihan Anda : ");
        int userOption = userInput.nextInt();
        return userOption;
    }

    // Method untuk mencetak pilihan urutan ascending atau descending
    public static int ascendingOrDescending() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("\n+-----------------------------+" + 
                            "\n|      METODE PENGURUTAN      |" + 
                            "\n+-----------------------------+" + 
                            "\n| 1. Ascending                |" + 
                            "\n| 2. Descending               |" + 
                            "\n+-----------------------------+");
        System.out.print("Masukkan Pilihan Anda : ");
        int userOption = userInput.nextInt();
        return userOption;
    }

}