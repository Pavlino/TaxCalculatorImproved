package com.bartoszwalter.students.taxes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class TaxCalculator {
	
	public static double podstawa = 0;
	public static char umowa = ' ';
	// składki na ubezpieczenia społeczne
	public static double s_emerytalna = 0; // 9,76% podstawyy
	public static double s_rentowa = 0; // 1,5% podstawy
	public static double u_chorobowe = 0; // 2,45% podstawy
	// składki na ubezpieczenia zdrowotne
	public static double kosztyUzyskania = 111.25; 
	public static double s_zdrow1 = 0; // od podstawy wymiaru 9%
	public static double s_zdrow2 = 0; // od podstawy wymiaru 7,75 %
	public static double zaliczkaNaPod = 0; // zaliczka na podatek dochodowy 18%
	public static double kwotaZmiejsz = 46.33; // kwota zmienjszająca podatek 46,33 PLN
	public static double zaliczkaUS = 0;
	public static double zaliczkaUS0 = 0;

	public static void main(String[] args) {
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			System.out.print("Podaj kwotę dochodu: ");	
			podstawa = Double.parseDouble(br.readLine());
			
			System.out.print("Typ umowy: (P)raca, (Z)lecenie: ");
			umowa = br.readLine().charAt(0);
			
		} catch (Exception ex) {
			System.out.println("Błędna kwota");
			System.err.println(ex);
			return;
		}
		
		DecimalFormat df00 = new DecimalFormat("#.00");
		DecimalFormat df = new DecimalFormat("#");
		
		if (umowa == 'P') {
			double oPodstawa = obliczonaPodstawa(podstawa);
			obliczUbezpieczenia(oPodstawa);
			double podstawaOpodat = oPodstawa - kosztyUzyskania;
			double podstawaOpodat0 = Double.parseDouble(df.format(podstawaOpodat));
			obliczPodatek(podstawaOpodat0);
			double podatekPotracony = zaliczkaNaPod - kwotaZmiejsz;
			obliczZaliczke();
			zaliczkaUS0 = Double.parseDouble(df.format(zaliczkaUS));
			double wynagrodzenie = podstawa - ((s_emerytalna + s_rentowa + u_chorobowe) + s_zdrow1 + zaliczkaUS0);

		} else if (umowa == 'Z') {
			double oPodstawa = obliczonaPodstawa(podstawa);
			obliczUbezpieczenia(oPodstawa);
			kwotaZmiejsz = 0;
			kosztyUzyskania = (oPodstawa * 20) / 100;
			double podstawaOpodat = oPodstawa - kosztyUzyskania;
			double podstawaOpodat0 = Double.parseDouble(df.format(podstawaOpodat));
			obliczPodatek(podstawaOpodat0);
			double podatekPotracony = zaliczkaNaPod;
			obliczZaliczke();
			zaliczkaUS0 = Double.parseDouble(df.format(zaliczkaUS));
			double wynagrodzenie = podstawa
					- ((s_emerytalna + s_rentowa + u_chorobowe) + s_zdrow1 + zaliczkaUS0);
		} else {
			System.out.println("Nieznany typ umowy!");
		}
	}

	public static void obliczZaliczke() {
		zaliczkaUS = zaliczkaNaPod - s_zdrow2 - kwotaZmiejsz;
	}

	public static void obliczPodatek(double podstawa) {
		zaliczkaNaPod = (podstawa * 18) / 100;
	}

	public static double obliczonaPodstawa(double podstawa) {
		s_emerytalna = (podstawa * 9.76) / 100;
		s_rentowa = (podstawa * 1.5) / 100;
		u_chorobowe = (podstawa * 2.45) / 100;
		return (podstawa - s_emerytalna - s_rentowa - u_chorobowe);
	}

	public static void obliczUbezpieczenia(double podstawa) {
		s_zdrow1 = (podstawa * 9) / 100;
		s_zdrow2 = (podstawa * 7.75) / 100;
	}
}
