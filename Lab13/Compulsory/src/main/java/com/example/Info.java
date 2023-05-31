package com.example;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Info {
    private Locale locale;
    private ResourceBundle messages;

    public Info(Locale locale) {
        this.locale = locale;
        this.messages = ResourceBundle.getBundle("Messages", locale);
    }

    public void displayInfo() {
        String country = getCountryInfo();
        String language = locale.getDisplayLanguage();
        String currency = getCurrencyInfo();
        String weekdays = getWeekdaysInfo();
        String months = getMonthsInfo();
        String today = getFormattedDate();

        System.out.println(messages.getString("country") + ": " + country);
        System.out.println(messages.getString("language") + ": " + language);
        System.out.println(messages.getString("currency") + ": " + currency);
        System.out.println(messages.getString("weekdays") + ": " + weekdays);
        System.out.println(messages.getString("months") + ": " + months);
        System.out.println(messages.getString("today") + ": " + today);
    }

    private String getCountryInfo() {
        return locale.getDisplayCountry(locale);
    }


    private String getCurrencyInfo() {
        try {
            String currencyCode = Currency.getInstance(locale).getCurrencyCode();
            String currencySymbol = Currency.getInstance(locale).getSymbol();
            return currencyCode + " (" + currencySymbol + ")";
        } catch (IllegalArgumentException e) {
            return messages.getString("currency") + " " + messages.getString("not.available");
        }
    }

    private String getWeekdaysInfo() {
        DateFormatSymbols symbols = new DateFormatSymbols(locale);
        String[] weekdays = symbols.getWeekdays();
        StringBuilder weekdaysBuilder = new StringBuilder();

        for (int i = 1; i < weekdays.length; i++) {
            weekdaysBuilder.append(weekdays[i]);
            if (i < weekdays.length - 1) {
                weekdaysBuilder.append(", ");
            }
        }

        return weekdaysBuilder.toString();
    }

    private String getMonthsInfo() {
        DateFormatSymbols symbols = new DateFormatSymbols(locale);
        String[] months = symbols.getMonths();
        StringBuilder monthsBuilder = new StringBuilder();

        for (int i = 0; i < months.length; i++) {
            monthsBuilder.append(months[i]);
            if (i < months.length - 1) {
                monthsBuilder.append(", ");
            }
        }

        return monthsBuilder.toString();
    }

    private String getFormattedDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy", locale);
        return dateFormat.format(new Date());
    }
}
