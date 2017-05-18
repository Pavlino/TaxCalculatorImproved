package com.bartoszwalter.students.taxes;

public class UmowaOPrace extends Umowa {

    private static final double wartoscKosztowUzyskaniaPrzychodu = 111.25;
    private static final double miesiecznaKwotaWolnaOdPodatku = 46.33;

    public UmowaOPrace(double kwotaDochodu) {
        setKwotaDochodu(kwotaDochodu);
        setMiesiecznaKwotaWolnaOdPodatku(miesiecznaKwotaWolnaOdPodatku);
    }

    private void obliczPotraconyPodatekDochodowy() {
        setPotraconyPodatekDochodowy(getZaliczkaNaPodatekDochodowy() - miesiecznaKwotaWolnaOdPodatku);
    }

    private void obliczZaliczkeDoUrzeduSkarbowego() {
        double zaliczkaDoUrzeduSkarbowego = getZaliczkaNaPodatekDochodowy() - getSkladkaZdrowotnaOdliczona() - miesiecznaKwotaWolnaOdPodatku;
        zaliczkaDoUrzeduSkarbowego = zaokraglijDoCalkowitej(zaliczkaDoUrzeduSkarbowego);
        setZaliczkaDoUrzeduSkarbowego(zaliczkaDoUrzeduSkarbowego);
    }

    @Override
    public void obliczWynagrodzenie() {
        obliczWartoscSkladekSpolecznych();
        obliczPodstaweSkladkiZdrowotnej();
        obliczWartoscSkladekZdrowotnych();
        setKosztyUzyskaniaPrzychodu(wartoscKosztowUzyskaniaPrzychodu);
        obliczPodstaweOpodatkowania();
        obliczZaliczkeNaPodatekDochodowy();
        obliczPotraconyPodatekDochodowy();
        obliczZaliczkeDoUrzeduSkarbowego();
        obliczDochodNetto();
    }

    @Override
    public String getTypUmowy() {
        return "UMOWA O PRACĘ";
    }
}
