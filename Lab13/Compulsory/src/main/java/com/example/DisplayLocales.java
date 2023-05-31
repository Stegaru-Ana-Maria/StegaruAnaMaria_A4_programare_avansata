package com.example;

import java.util.Locale;

public class DisplayLocales {
    public void displayAllLocales() {
        Locale[] locales = Locale.getAvailableLocales();
        for (Locale locale : locales) {
            System.out.println(locale);
        }
    }
}
