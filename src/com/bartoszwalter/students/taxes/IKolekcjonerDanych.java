package com.bartoszwalter.students.taxes;

import java.io.IOException;

public interface IKolekcjonerDanych {
    void zbierzDane();
    Umowa przekazDane() throws IOException;
}
