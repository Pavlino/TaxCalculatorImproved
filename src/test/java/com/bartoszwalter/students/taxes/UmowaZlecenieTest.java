package com.bartoszwalter.students.taxes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UmowaZlecenieTest {

    private UmowaZlecenie umowaZlecenie;

    @Before
    public void setUp() throws Exception {
        umowaZlecenie = new UmowaZlecenie(1000);
    }

    @Test
    public void testObliczWynagrodzenie() throws Exception {
        umowaZlecenie.obliczWynagrodzenie();
        assertEquals(728.239, umowaZlecenie.getWynagrodzenie(), 0.001);
    }

    @Test
    public void testObliczSkladkiSpoleczne() throws Exception {
        umowaZlecenie.obliczWartoscSkladekSpolecznych();
        assertEquals(97.60, umowaZlecenie.getSkladkaEmerytalna(), 0.001);
        assertEquals(15.00, umowaZlecenie.getSkladkaRentowa(), 0.001);
        assertEquals(24.50, umowaZlecenie.getSkladkaChorobowa(), 0.001);
    }

    @Test
    public void testObliczPodstaweSkladekZdrowotnych() throws Exception {
        umowaZlecenie.obliczWartoscSkladekSpolecznych();
        umowaZlecenie.obliczPodstaweSkladkiZdrowotnej();
        assertEquals(862.9, umowaZlecenie.getPodstawaSkladkiZdrowotnej() ,0.001);
    }

    @Test
    public void testObliczSkladkiZdrowotne() throws Exception {
        umowaZlecenie.obliczWartoscSkladekSpolecznych();
        umowaZlecenie.obliczPodstaweSkladkiZdrowotnej();
        umowaZlecenie.obliczWartoscSkladekZdrowotnych();
        assertEquals(77.661, umowaZlecenie.getSkladkaZdrowotna() ,0.001);
        assertEquals(66.87474999999999, umowaZlecenie.getSkladkaZdrowotnaOdliczona() ,0.001);
    }

    @Test
    public void testObliczPodstaweOpodatkowania() throws Exception {
        umowaZlecenie.obliczWynagrodzenie();
        assertEquals(690.0, umowaZlecenie.getPodstawaOpodatkowania(), 0.001);
    }

    @Test
    public void testObliczZaliczkeNaPodstaweOpodatkowania() throws Exception {
        umowaZlecenie.obliczWynagrodzenie();
        assertEquals(124.2, umowaZlecenie.getZaliczkaNaPodatekDochodowy(), 0.001);
    }

    @Test
    public void testObliczPodatekPotracony() throws Exception {
        umowaZlecenie.obliczWynagrodzenie();
        assertEquals(124.2, umowaZlecenie.getPotraconyPodatekDochodowy(), 0.001);
    }

    @Test
    public void testObliczZaliczkeDoUrzeduSkarbowego() throws Exception {
        umowaZlecenie.obliczWynagrodzenie();
        assertEquals(57, umowaZlecenie.getZaliczkaDoUrzeduSkarbowego(), 0.001);
    }
}