package com.Kuis02.daftarfilm;
public class DaftarFilm23 {
    Node23 head;
    Node23 tail;
    int size;
    public DaftarFilm23() {
        head = null;
        tail = null;
        size = 0;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public void addLast(int idFilm, String judulFilm, double ratingFilm) {
        if (isEmpty()) {
            head = tail = new Node23(null, idFilm, judulFilm, ratingFilm, null);
        } else {
            Node23 newNode = new Node23(tail, idFilm, judulFilm, ratingFilm, null);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    public void addFirst(int idFilm, String judulFilm, double ratingFilm) {
        if (isEmpty()) {
            head = tail = new Node23(null, idFilm, judulFilm, ratingFilm, null);
        } else {
            Node23 newNode = new Node23(null, idFilm, judulFilm, ratingFilm, head);
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }
    public void add(int index, int idFilm, String judulFilm, double ratingFilm) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("INDEX : " + index + ", SIZE : " + size);
        }
    
        if (index == 0) {
            addFirst(idFilm, judulFilm, ratingFilm);
        } else if (index == size) {
            addLast(idFilm, judulFilm, ratingFilm);
        } else {
            Node23 current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Node23 newNode = new Node23(current, idFilm, judulFilm, ratingFilm, current.next);
            current.next.prev = newNode;
            current.next = newNode;
            size++;
        }
    }        
    public int size(int size) {
        return size;
    }
    public void print() {
        int idFilmWidth = 23;
        int judulFilmWidth = 28;
        int ratingFilmWidth = 24;
        if (!isEmpty()) {
            Node23 tmp = head;
            System.out.println("\n+-----------------------+----------------------------+------------------------+");
            System.out.println("|        ID FILM        |         JUDUL FILM         |       RATING FILM      |");
            System.out.println("+-----------------------+----------------------------+------------------------+");
            while (tmp != null) {
                System.out.println("|" + padRight(" " + (tmp.idFilm) + " ", idFilmWidth) + "|" + padRight(" " + (tmp.judulFilm).toUpperCase() + " ", judulFilmWidth) + "|" + padRight(" " + (tmp.ratingFilm) + " ", ratingFilmWidth) + "|");
                System.out.println("+-----------------------+----------------------------+------------------------+");
                tmp = tmp.next;
            }
        }else {
            System.out.println("\nDAFTAR KOSONG");
        }
    }
    // Metode untuk mengisi spasi ke kanan
    public static String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }
    public String removeFirst() {
        if (isEmpty()) {
            System.out.println("\nDAFTAR KOSONG");
            return null;
        } else {
            String judulFilm = head.judulFilm;
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            size--;
            return judulFilm;
        }
    }
    public String removeLast() {
        if (isEmpty()) {
            System.out.println("\nDAFTAR KOSONG");
            return null;
        } else {
            String judulFilm = tail.judulFilm;
            if (head == tail) {
                head = tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
            size--;
            return judulFilm;
        }
    }
    public String remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("INDEX : " + index + ", SIZE : " + size);
        }
    
        if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node23 current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            String judulFilm = current.judulFilm;
            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
            return judulFilm;
        }
    }
    public String cariFilmBerdasarkanId(int idFilm) {
        int idFilmWidth = 23;
        int judulFilmWidth = 28;
        int ratingFilmWidth = 24;
        Node23 tmp = head;
        while (tmp != null) {
            if (tmp.idFilm == idFilm) {
                System.out.println("\n+-----------------------+----------------------------+------------------------+");
                System.out.println("|        ID FILM        |         JUDUL FILM         |       RATING FILM      |");
                System.out.println("+-----------------------+----------------------------+------------------------+");
                String result = "|" + padRight(" " + tmp.idFilm + " ", idFilmWidth) + 
                                "|" + padRight(" " + tmp.judulFilm.toUpperCase() + " ", judulFilmWidth) + 
                                "|" + padRight(" " + tmp.ratingFilm + " ", ratingFilmWidth) + "|";
                System.out.println(result);
                System.out.println("+-----------------------+----------------------------+------------------------+");
                return result;
            }
            tmp = tmp.next;
        }
        String result = "\nFILM DENGAN ID " + idFilm + " TIDAK DITEMUKAN";
        System.out.println(result);
        return result;
    }
    public void urutFilmBerdasarkanRatingDESC() {
        if (isEmpty()) {
            return;
        }
        boolean swapped;
        do {
            Node23 current = head;
            Node23 previous = null;
            Node23 next = head.next;
            swapped = false;
            while (next != null) {
                if (current.ratingFilm < next.ratingFilm) {
                    swapped = true;
                    if (previous != null) {
                        Node23 temp = next.next;
                        previous.next = next;
                        next.next = current;
                        current.next = temp;
                    } else {
                        Node23 temp = next.next;
                        head = next;
                        next.next = current;
                        current.next = temp;
                    }
                    previous = next;
                    next = current.next;
                } else {
                    previous = current;
                    current = next;
                    next = next.next;
                }
            }
        } while (swapped);
    }
    public void urutFilmBerdasarkanRatingASC() {
        if (isEmpty()) {
          return;
        }
        boolean swapped;
        do {
          swapped = false;
          Node23 current = head;
          Node23 previous = null;
          Node23 next = head.next;
          while (next != null) {
            if (current.ratingFilm > next.ratingFilm) {
              swapped = true;
              if (previous != null) {
                Node23 temp = next.next;
                previous.next = next;
                next.next = current;
                current.next = temp;
              } else {
                Node23 temp = next.next;
                head = next;
                next.next = current;
                current.next = temp;
              }
            } else {
              previous = current;
            }
            current = next;
            next = next.next;
          }
        } while (swapped);
    }
}