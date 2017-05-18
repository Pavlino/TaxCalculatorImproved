package com.bartoszwalter.students.taxes;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class KolekcjonerDanychKonsolaTest {

    private KolekcjonerDanychKonsola kolekcjonerDanychKonsola;

    @Before
    public void setUp() throws Exception {
        kolekcjonerDanychKonsola = new KolekcjonerDanychKonsola();
    }

    @Test
    public void testPrzekazDane() throws Exception {
        kolekcjonerDanychKonsola.setKwotaDochodu(1000);
        kolekcjonerDanychKonsola.setTypUmowy('P');
        Umowa umowa = kolekcjonerDanychKonsola.przekazDane();
        assertEquals(umowa.getKwotaDochodu(), 1000, 0.001);
        assertEquals(umowa.getTypUmowy(), "UMOWA O PRACĘ");
    }

    @Test(expected = IOException.class)
    public void testPrzekazDaneNiepoprawne() throws Exception {
        kolekcjonerDanychKonsola.setKwotaDochodu(1000);
        kolekcjonerDanychKonsola.setTypUmowy('A');
        Umowa umowa = kolekcjonerDanychKonsola.przekazDane();
    }
}