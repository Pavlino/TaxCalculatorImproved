package com.bartoszwalter.students.taxes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class TaxCalculator {

	public static void main(String[] args) {
		try {
			KolekcjonerDanychKonsola kolekcjonerDanychKonsola = new KolekcjonerDanychKonsola();
			kolekcjonerDanychKonsola.zbierzDane();
			Umowa umowa = kolekcjonerDanychKonsola.przekazDane();
			umowa.obliczWynagrodzenie();
			PrezenterWynikowKonsola prezenterWynikowKonsola = new PrezenterWynikowKonsola(umowa);
			prezenterWynikowKonsola.wyswietl();
		} catch (IOException e) {
			System.err.println(e.getMessage());
			return;
		}

	}
}
