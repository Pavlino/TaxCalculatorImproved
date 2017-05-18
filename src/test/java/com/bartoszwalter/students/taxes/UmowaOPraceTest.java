package com.bartoszwalter.students.taxes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UmowaOPraceTest {

    private UmowaOPrace umowaOPrace;

    @Before
    public void setUp() throws Exception {
        umowaOPrace = new UmowaOPrace(1000);
    }

    @Test
    public void testObliczWynagrodzenie() throws Exception {
        umowaOPrace.obliczWynagrodzenie();
        assertEquals(763.24, umowaOPrace.getWynagrodzenie(), 0.001);
    }

    @Test
    public void testObliczSkladkiSpoleczne() throws Exception {
        umowaOPrace.obliczWartoscSkladekSpolecznych();
        assertEquals(97.60, umowaOPrace.getSkladkaEmerytalna(), 0.001);
        assertEquals(15.00, umowaOPrace.getSkladkaRentowa(), 0.001);
        assertEquals(24.50, umowaOPrace.getSkladkaChorobowa(), 0.001);
    }

    @Test
    public void testObliczPodstaweSkladekZdrowotnych() throws Exception {
        umowaOPrace.obliczWartoscSkladekSpolecznych();
        umowaOPrace.obliczPodstaweSkladkiZdrowotnej();
        assertEquals(862.9, umowaOPrace.getPodstawaSkladkiZdrowotnej() ,0.001);
    }

    @Test
    public void testObliczSkladkiZdrowotne() throws Exception {
        umowaOPrace.obliczWartoscSkladekSpolecznych();
        umowaOPrace.obliczPodstaweSkladkiZdrowotnej();
        umowaOPrace.obliczWartoscSkladekZdrowotnych();
        assertEquals(77.661, umowaOPrace.getSkladkaZdrowotna() ,0.001);
        assertEquals(66.87474999999999, umowaOPrace.getSkladkaZdrowotnaOdliczona() ,0.001);
    }

    @Test
    public void testObliczPodstaweOpodatkowania() throws Exception {
        umowaOPrace.obliczWynagrodzenie();
        assertEquals(752.0, umowaOPrace.getPodstawaOpodatkowania(), 0.001);
    }

    @Test
    public void testObliczZaliczkeNaPodstaweOpodatkowania() throws Exception {
        umowaOPrace.obliczWynagrodzenie();
        assertEquals(135.36, umowaOPrace.getZaliczkaNaPodatekDochodowy(), 0.001);
    }

    @Test
    public void testObliczPodatekPotracony() throws Exception {
        umowaOPrace.obliczWynagrodzenie();
        assertEquals(89.03, umowaOPrace.getPotraconyPodatekDochodowy(), 0.001);
    }

    @Test
    public void testObliczZaliczkeDoUrzeduSkarbowego() throws Exception {
        umowaOPrace.obliczWynagrodzenie();
        assertEquals(22, umowaOPrace.getZaliczkaDoUrzeduSkarbowego(), 0.001);
    }
}