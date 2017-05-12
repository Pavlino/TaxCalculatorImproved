package com.bartoszwalter.students.taxes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KolekcjonerDanychKonsola implements IKolekcjonerDanych {

    private BufferedReader bufferedReader;
    private char typUmowy;
    private double kwotaDochodu;

    public KolekcjonerDanychKonsola() {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        bufferedReader = new BufferedReader(inputStreamReader);
    }

    public void getKwotaDochodu() {
        System.out.print("Podaj kwotę dochodu: ");
        try {
            kwotaDochodu = Double.parseDouble(bufferedReader.readLine());
        } catch (IOException e) {
            System.out.println("Niepoprawna kwota dochodu.");
        }
    }

    public void getTypUmowy() {
        System.out.print("Typ umowy: (P)raca, (Z)lecenie: ");
        try {
            typUmowy = bufferedReader.readLine().charAt(0);
        } catch (IOException e) {
            System.out.println("Niepoprawny typ umowy.");
        }
    }

    public void przekazDane() {
        //TODO: zwroc umowe do kalkulatora :(
        if (typUmowy == 'P') {
            UmowaOPrace umowaOPrace = new UmowaOPrace(kwotaDochodu);
        } else if (typUmowy == 'Z') {
            UmowaZlecenie umowaZlecenie = new UmowaZlecenie(kwotaDochodu);
        }
    }

}
