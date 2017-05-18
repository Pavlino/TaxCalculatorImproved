package com.bartoszwalter.students.taxes;

import java.text.DecimalFormat;

public abstract class Umowa {

	private static final double skladkaEmerytalnaPrcoent = 9.76;
	private static final double skladkaRentowaProcent = 1.5;
	private static final double skladkaChoroboweProcent = 2.45;
	private static final double skladkaZdrowotnaProcent = 9;
	private static final double skladkaZdrowotnaOdliczonaProcent = 7.75;
	private static final double zaliczkaNaPodatekDochodowyProcent = 18;

	private double kwotaDochodu;
	private double skladkaEmerytalna;
	private double skladkaRentowa;
	private double skladkaChorobowa;
	private double podstawaSkladkiZdrowotnej;
	private double skladkaZdrowotna;
	private double skladkaZdrowotnaOdliczona;
	private double podstawaOpodatkowania;
	private double zaliczkaNaPodatekDochodowy;
	private double potraconyPodatekDochodowy;
	private double zaliczkaDoUrzeduSkarbowego;
	private double wynagrodzenie;
	private double kosztyUzyskaniaPrzychodu;
	private double miesiecznaKwotaWolnaOdPodatku;

	protected void obliczWartoscSkladekSpolecznych() {
		skladkaEmerytalna = (kwotaDochodu * skladkaEmerytalnaPrcoent) / 100;
		skladkaRentowa = (kwotaDochodu * skladkaRentowaProcent) / 100;
		skladkaChorobowa = (kwotaDochodu * skladkaChoroboweProcent) / 100;
	}

	protected void obliczPodstaweSkladkiZdrowotnej() {
		podstawaSkladkiZdrowotnej = kwotaDochodu - skladkaEmerytalna - skladkaRentowa - skladkaChorobowa;
	}

	protected void obliczWartoscSkladekZdrowotnych() {
		skladkaZdrowotna = (podstawaSkladkiZdrowotnej * skladkaZdrowotnaProcent) / 100;
		skladkaZdrowotnaOdliczona = (podstawaSkladkiZdrowotnej * skladkaZdrowotnaOdliczonaProcent) / 100;
	}

	protected void obliczPodstaweOpodatkowania() {
		podstawaOpodatkowania = getPodstawaSkladkiZdrowotnej() - kosztyUzyskaniaPrzychodu;
		podstawaOpodatkowania = zaokraglijDoCalkowitej(podstawaOpodatkowania);
	}

	protected void obliczZaliczkeNaPodatekDochodowy() {
		zaliczkaNaPodatekDochodowy = (podstawaOpodatkowania * zaliczkaNaPodatekDochodowyProcent) / 100;
	}

	protected void obliczDochodNetto() {
		wynagrodzenie = kwotaDochodu - ((skladkaEmerytalna + skladkaRentowa + skladkaChorobowa) + skladkaZdrowotna + zaliczkaDoUrzeduSkarbowego);
	}

	protected void obliczWynagrodzenie() {
	}

	public String getTypUmowy() {
		return "Umowa";
	}

	public double getPodstawaSkladkiZdrowotnej() {
		return podstawaSkladkiZdrowotnej;
	}

	public void setKosztyUzyskaniaPrzychodu(double kosztyUzyskaniaPrzychodu) {
		this.kosztyUzyskaniaPrzychodu = kosztyUzyskaniaPrzychodu;
	}

	public double getKwotaDochodu() {
		return kwotaDochodu;
	}

	public void setKwotaDochodu(double kwotaDochodu) {
		this.kwotaDochodu = kwotaDochodu;
	}

	protected double getZaliczkaNaPodatekDochodowy() {
		return zaliczkaNaPodatekDochodowy;
	}

	protected void setPotraconyPodatekDochodowy(double potraconyPodatekDochodowy) {
		this.potraconyPodatekDochodowy = potraconyPodatekDochodowy;
	}

	protected double zaokraglijDoCalkowitej(double liczba) {
		DecimalFormat decimalFormat = new DecimalFormat("#");
		return Double.parseDouble(decimalFormat.format(liczba));
	}

	protected double getSkladkaZdrowotnaOdliczona() {
		return skladkaZdrowotnaOdliczona;
	}

	protected void setZaliczkaDoUrzeduSkarbowego(double zaliczkaDoUrzeduSkarbowego) {
		this.zaliczkaDoUrzeduSkarbowego = zaliczkaDoUrzeduSkarbowego;
	}

	protected double getSkladkaEmerytalna() {
		return skladkaEmerytalna;
	}

	protected double getSkladkaRentowa() {
		return skladkaRentowa;
	}

	protected double getSkladkaChorobowa() {
		return skladkaChorobowa;
	}

	protected static double getSkladkaZdrowotnaProcent() {
		return skladkaZdrowotnaProcent;
	}

	protected static double getSkladkaZdrowotnaOdliczonaProcent() {
		return skladkaZdrowotnaOdliczonaProcent;
	}

	protected static double getZaliczkaNaPodatekDochodowyProcent() {
		return zaliczkaNaPodatekDochodowyProcent;
	}

	protected double getSkladkaZdrowotna() {
		return skladkaZdrowotna;
	}

	protected double getZaliczkaDoUrzeduSkarbowego() {
		return zaliczkaDoUrzeduSkarbowego;
	}

	protected double getWynagrodzenie() {
		return wynagrodzenie;
	}

	protected double getKosztyUzyskaniaPrzychodu() {
		return kosztyUzyskaniaPrzychodu;
	}

	protected double getPodstawaOpodatkowania() {
		return podstawaOpodatkowania;
	}

	protected void setMiesiecznaKwotaWolnaOdPodatku(double miesiecznaKwotaWolnaOdPodatku) {
		this.miesiecznaKwotaWolnaOdPodatku = miesiecznaKwotaWolnaOdPodatku;
	}

	protected double getMiesiecznaKwotaWolnaOdPodatku() {
		return miesiecznaKwotaWolnaOdPodatku;
	}

	protected double getPotraconyPodatekDochodowy() {
		return potraconyPodatekDochodowy;
	}

}
