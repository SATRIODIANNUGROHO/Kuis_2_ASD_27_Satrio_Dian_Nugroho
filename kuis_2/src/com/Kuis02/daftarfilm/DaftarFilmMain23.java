package com.Kuis02.daftarfilm;
import java.util.Scanner;
public class DaftarFilmMain23 {
    public static void main(String[] args) throws Exception {
        Scanner userInput = new Scanner(System.in);
        DaftarFilm23 ve = new DaftarFilm23();
        while (true) {
            int pilihan = Menu();
            if (pilihan == 1) {
                System.out.println("\n==================================================");
                String message = "TAMBAH DATA FILM";
                System.out.printf("|%32s                |", message);
                System.out.println("\n==================================================");
                System.out.print("\nID FILM\t\t : ");
                int idFilm = userInput.nextInt();
                System.out.print("\nJUDUL FILM\t : ");
                userInput.nextLine();
                String judulFilm = userInput.nextLine();
                System.out.print("\nRATING FILM\t : ");
                double ratingFilm = userInput.nextDouble();
                ve.addFirst(idFilm, judulFilm, ratingFilm);
            }else if (pilihan == 2) {
                System.out.println("\n==================================================");
                String message = "TAMBAH DATA FILM";
                System.out.printf("|%32s                |", message);
                System.out.println("\n==================================================");
                System.out.print("\nID FILM\t\t : ");
                int idFilm = userInput.nextInt();
                System.out.print("\nJUDUL FILM\t : ");
                userInput.nextLine();
                String judulFilm = userInput.nextLine();
                System.out.print("\nRATING FILM\t : ");
                double ratingFilm = userInput.nextDouble();
                ve.addLast(idFilm, judulFilm, ratingFilm);
            }else if (pilihan == 3) {
                System.out.println("\n==================================================");
                String message = "TAMBAH DATA FILM";
                System.out.printf("|%32s                |", message);;
                System.out.println("\n==================================================");
                System.out.print("\nID FILM\t\t : ");
                int idFilm = userInput.nextInt();
                System.out.print("\nJUDUL FILM\t : ");
                userInput.nextLine();
                String judulFilm = userInput.nextLine();
                System.out.print("\nRATING FILM\t : ");
                double ratingFilm = userInput.nextDouble();
                System.out.print("\nURUTAN FILM KE-  : ");
                int urutanFilm = userInput.nextInt();
                ve.add(urutanFilm ,idFilm, judulFilm, ratingFilm);
            }else if (pilihan == 4) {
                String removedName = ve.removeFirst();
                if (removedName != null) {
                    System.out.println("\n" + (removedName.toUpperCase()) + " TELAH DIHAPUS DARI DAFTAR");
                }
            }else if (pilihan == 5) {
                String removedName = ve.removeLast();
                if (removedName != null) {
                    System.out.println("\n" + (removedName.toUpperCase()) + " TELAH DIHAPUS DARI DAFTAR");
                }
            }else if (pilihan == 6) {
                System.out.print("\nMASUKKAN URUTAN FILM YANG INGIN DIHAPUS : ");
                int urutanFilm = userInput.nextInt();
                String removedName = ve.remove(urutanFilm);
                if (removedName != null) {
                    System.out.println("\n" + (removedName.toUpperCase()) + " TELAH DIHAPUS DARI DAFTAR");
                }
            }else if (pilihan == 7) {
                String message = "DAFTAR FILM LAYAR LEBAR";
                System.out.printf("\n%50s", message);
                ve.print();
            }else if (pilihan == 8) {
                System.out.print("\nMASUKKAN ID FILM : ");
                int idFilms = userInput.nextInt();
                ve.cariFilmBerdasarkanId(idFilms);
            }else if (pilihan == 9 ) {
                String message = "DAFTAR FILM BERDASARKAN RATING (ASC)";
                System.out.printf("\n%57s", message);
                ve.urutFilmBerdasarkanRatingASC();
                ve.print();
            }else if (pilihan == 10) {
                String message = "DAFTAR FILM BERDASARKAN RATING (DESC)";
                System.out.printf("\n%57s", message);
                ve.urutFilmBerdasarkanRatingDESC();
                ve.print();
            }else if (pilihan == 11) {
                break;
            }else {
                System.out.println("\nPILIHAN YANG ANDA MASUKKAN TIDAK TERSEDIA");
            }
        }
    }
    static int Menu() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("\n+------------------------------------------------+");
        String message = "DATA FILM LAYAR LEBAR";
        System.out.printf("|%35s             |", message);
        System.out.println("\n+------------------------------------------------+");
        System.out.println("| 1. Tambah Data Awal                            |");
        System.out.println("| 2. Tambah Data Akhir                           |");
        System.out.println("| 3. Tambah Data Pada Indeks Tertentu            |");
        System.out.println("| 4. Hapus Data Pertama                          |");
        System.out.println("| 5. Hapus Data Terakhir                         |");
        System.out.println("| 6. Hapus Data Tertentu                         |");
        System.out.println("| 7. Cetak Daftar Film                           |");
        System.out.println("| 8. Cari Film Berdasarkan ID                    |");
        System.out.println("| 9. Urutan Film Berdasarkan Rating (ASC)        |");
        System.out.println("| 10. Urutan Film Berdasarkan Rating (DESC)      |");
        System.out.println("| 11. Keluar                                     |");
        System.out.println("+------------------------------------------------+");
        System.out.print("\nMasukkan Pilihan Anda : ");
        int pilihan = userInput.nextInt();
        return pilihan;
    }
}