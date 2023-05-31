package app;

import com.example.DisplayLocales;
import com.example.Info;
import com.example.SetLocale;

import java.util.Locale;
import java.util.Scanner;

public class LocaleExplore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DisplayLocales displayLocales = new DisplayLocales();
        SetLocale setLocale = new SetLocale();
        Info info = new Info(Locale.getDefault());

        while (true) {
            System.out.print("Input command: ");
            String command = scanner.nextLine();

            if (command.equalsIgnoreCase("displaylocales")) {
                displayLocales.displayAllLocales();
            } else if (command.equalsIgnoreCase("setlocale")) {
                System.out.print("Enter language tag: ");
                String languageTag = scanner.nextLine();
                setLocale.setCurrentLocale(languageTag);
                info = new Info(Locale.getDefault());
            } else if (command.equalsIgnoreCase("info")) {
                info.displayInfo();
            } else if (command.equalsIgnoreCase("exit")) {
                System.out.println("Exiting Locale Explore...");
                break;
            } else {
                System.out.println("Unknown command. Please try again.");
            }

            System.out.println();
        }

        scanner.close();
    }
}


