package com.Kuis02.daftarfilm;
public class Node23 {
    int idFilm;
    String judulFilm;
    double ratingFilm;
    Node23 prev, next;
    Node23(Node23 prev, int idFilm, String judulFilm, double ratingFilm,Node23 next) {
        this.prev = prev;
        this.idFilm = idFilm;
        this.judulFilm = judulFilm;
        this.ratingFilm = ratingFilm;
        this.next = next;
    }
}