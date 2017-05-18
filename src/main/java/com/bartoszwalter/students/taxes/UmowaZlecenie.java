package com.bartoszwalter.students.taxes;

public class UmowaZlecenie extends Umowa {

	private static final double kosztyUzyskaniaPrzychoduProcent = 20;
    private static final double miesiecznaKwotaWolnaOdPodatku = 0;

	public UmowaZlecenie(double kwotaDochodu){
		setKwotaDochodu(kwotaDochodu);
        setMiesiecznaKwotaWolnaOdPodatku(miesiecznaKwotaWolnaOdPodatku);
	}

	private double obliczKosztyUzyskaniaPrzychodu() {
		return (getPodstawaSkladkiZdrowotnej() * kosztyUzyskaniaPrzychoduProcent) / 100;
	}

	private void obliczZaliczkeDoUrzeduSkarbowego() {
		double zaliczkaDoUrzeduSkarbowego = getZaliczkaNaPodatekDochodowy() - getSkladkaZdrowotnaOdliczona();
		zaliczkaDoUrzeduSkarbowego = zaokraglijDoCalkowitej(zaliczkaDoUrzeduSkarbowego);
		setZaliczkaDoUrzeduSkarbowego(zaliczkaDoUrzeduSkarbowego);
	}

	@Override
	public void obliczWynagrodzenie() {
		obliczWartoscSkladekSpolecznych();
		obliczPodstaweSkladkiZdrowotnej();
		obliczWartoscSkladekZdrowotnych();
		setKosztyUzyskaniaPrzychodu(obliczKosztyUzyskaniaPrzychodu());
		obliczPodstaweOpodatkowania();
		obliczZaliczkeNaPodatekDochodowy();
		setPotraconyPodatekDochodowy(getZaliczkaNaPodatekDochodowy());
		obliczZaliczkeDoUrzeduSkarbowego();
		obliczDochodNetto();
	}

	@Override
	public String getTypUmowy() {
		return "UMOWA ZLECENIE";
	}
}
