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

    private void getKwotaDochodu() {
        System.out.print("Podaj kwotę dochodu: ");
        try {
            kwotaDochodu = Double.parseDouble(bufferedReader.readLine());
        } catch (IOException e) {
            System.out.println("Niepoprawna kwota dochodu.");
        }
    }

    private void getTypUmowy() {
        System.out.print("Typ umowy: (P)raca, (Z)lecenie: ");
        try {
            typUmowy = bufferedReader.readLine().charAt(0);
        } catch (IOException e) {
            System.out.println("Niepoprawny typ umowy.");
        }
    }

    public void zbierzDane() {
        getTypUmowy();
        getKwotaDochodu();
    }

    public Umowa przekazDane() throws IOException {
        Umowa umowa;
        if (typUmowy == 'P') {
            umowa = new UmowaOPrace(kwotaDochodu);
        } else if (typUmowy == 'Z') {
            umowa = new UmowaZlecenie(kwotaDochodu);
        } else {
            throw new IOException("Niepoprawny typ umowy");
        }
        return umowa;
    }

    public void setTypUmowy(char typUmowy) {
        this.typUmowy = typUmowy;
    }

    public void setKwotaDochodu(double kwotaDochodu) {
        this.kwotaDochodu = kwotaDochodu;
    }
}
