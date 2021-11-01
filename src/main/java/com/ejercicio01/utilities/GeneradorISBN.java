/*
    ~ INFO SACADA DE www.isbn.org.ar ~

El ISBN se compone actualmente de trece dígitos agrupados en cinco elementos, que deben estar separados por guiones de la siguiente manera:

• Prefijo Internacional 978
• Identificador del país, región o área idiomática 950
• Prefijo del editor 0000
• Identificador de título o publicación 00
• Dígito de control 0
ISBN: 978-950-0000-00-0
 */
package com.ejercicio01.utilities;


public class GeneradorISBN {

    public String isbnRandom() {

        // Generamos 4 grupos de números aleatoreos
        // Grupo 0: 978 para todos
        // Grupo 1: 3 dígitos
        // Grupo 2: 4 dígitos
        // Grupo 3: 2 dígitos
        // Grupo 4: 1 dígito        
        int grupo4 = (int) (Math.random() * (9 - 1) + 1);

        String isbn = 978 + "-" + grupo1() + "-" + grupo2() + "-" + grupo4;
        return isbn;

    }

    public String grupo1() {

        String grupoA;
        int grupo1 = (int) (Math.random() * (999 - 1) + 1);
        if (grupo1 < 10) {
            grupoA = "00" + grupo1;
        } else if (grupo1 > 9 & grupo1 < 100) {
            grupoA = "0" + grupo1;
        } else {
            grupoA = String.valueOf(grupo1);
        }
        return grupoA;
    }

    public String grupo2() {

        String grupoB;
        int grupo2 = (int) (Math.random() * (9999 - 1) + 1);

        if (grupo2 <= 9) {
            grupoB = "000" + grupo2;
        } else if (grupo2 >= 10 & grupo2 <= 99) {
            grupoB = "00" + grupo2;
        } else if (grupo2 >= 100 & grupo2 <= 999) {
            grupoB = "0" + grupo2;
        } else {
            grupoB = String.valueOf(grupo2);
        }
        return grupoB;
    }

    public String grupo3() {
        String grupoC;
        int grupo3 = (int) (Math.random() * (99 - 1) + 1);

        if (grupo3 < 10) {
            grupoC = "0" + grupo3;
        } else {
            grupoC = String.valueOf(grupo3);
        }
        return grupoC;

    }

}
