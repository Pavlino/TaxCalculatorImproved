package com.bartoszwalter.students.taxes;

import java.text.DecimalFormat;

public class PrezenterWynikowKonsola implements IPrezenterWynikow {

    private Umowa umowa;

    public PrezenterWynikowKonsola(Umowa umowa) {
        this.umowa = umowa;
    }

    private String zaokraglijDoDwochMiejsc(double liczba) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        return decimalFormat.format(liczba);
    }

    public void wyswietl() {
        System.out.println(umowa.getTypUmowy());
        System.out.println("Podstawa wymiaru składek " + umowa.getKwotaDochodu());
        System.out.println("Składka na ubezpieczenie emerytalne " + zaokraglijDoDwochMiejsc(umowa.getSkladkaEmerytalna()));
        System.out.println("Składka na ubezpieczenie rentowe    " + zaokraglijDoDwochMiejsc(umowa.getSkladkaRentowa()));
        System.out.println("Składka na ubezpieczenie chorobowe  " + zaokraglijDoDwochMiejsc(umowa.getSkladkaChorobowa()));
        System.out.println("Podstawa wymiaru składki na ubezpieczenie zdrowotne: " + umowa.getPodstawaSkladkiZdrowotnej());
        System.out.println("Składka na ubezpieczenie zdrowotne: " + Umowa.getSkladkaZdrowotnaProcent() + "% = "
                + zaokraglijDoDwochMiejsc(umowa.getSkladkaZdrowotna()) + " " + Umowa.getSkladkaZdrowotnaOdliczonaProcent() + "% = " + zaokraglijDoDwochMiejsc(umowa.getSkladkaZdrowotnaOdliczona()));
        System.out.println("Koszty uzyskania przychodu w stałej wysokości " + umowa.getKosztyUzyskaniaPrzychodu());
        System.out.println("Podstawa opodatkowania zaokrąglona " + umowa.getPodstawaOpodatkowania());
        System.out.println("Zaliczka na podatek dochodowy " + Umowa.getZaliczkaNaPodatekDochodowyProcent() + "% = " + umowa.getZaliczkaNaPodatekDochodowy());
        System.out.println("Kwota wolna od podatku = " + umowa.getMiesiecznaKwotaWolnaOdPodatku());
        System.out.println("Podatek potrącony = " + zaokraglijDoDwochMiejsc(umowa.getPotraconyPodatekDochodowy()));
        System.out.println("Zaliczka do urzędu skarbowego po zaokragleniu = " + umowa.getZaliczkaDoUrzeduSkarbowego());
        System.out.println();
        System.out.println("Pracownik otrzyma wynagrodzenie netto w wysokości = " + zaokraglijDoDwochMiejsc(umowa.getWynagrodzenie()));
    }

}
