package com.bartoszwalter.students.taxes;

public class Umowa {
	public double skladkaEmerytalna; 
	public double skladkaRentowa; 
	public double ubezpieczenieZdrowotne; 
	public double kosztyUzyskania = 111.25; 
	public double skladkaZdrototna9; 
	public double skladkaZdrowotna775; 
	public double zaliczkaPodatekDochodowy; 
	public double kwotaZmiejsz = 46.33; 
	public double zaliczkaUS;
	public double zaliczkaUSZaokroglona;
	
	public final double oprocentowieSkladkiEmerytalnej = 9.76;
	public final double oprocentowieSkladkiRentowej = 1.5;
	public final double oprocentowieUbezpieczenieZdrowotne = 2.45;
	public final double oprocentowieSkladkiZdrowotnej9= 9;
	public final double oprocentowieSkladkiZdrowotnej775= 9;
	public final double oprocentowieZaliczkaPodatekDochodowy= 9;
	
	public Umowa(double podstawa){
		skladkaEmerytalna = (podstawa * oprocentowieSkladkiEmerytalnej) / 100;
		skladkaRentowa = (podstawa * oprocentowieSkladkiRentowej) / 100;
		ubezpieczenieZdrowotne = (podstawa * oprocentowieUbezpieczenieZdrowotne) / 100;
		skladkaZdrototna9 = (podstawa * oprocentowieSkladkiZdrowotnej9) / 100;
		skladkaZdrowotna775 = (podstawa * oprocentowieSkladkiZdrowotnej775) / 100;
		zaliczkaPodatekDochodowy = (podstawa * oprocentowieZaliczkaPodatekDochodowy) / 100;
	}
	
	
}
