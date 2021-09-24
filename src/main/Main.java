package main;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.dir") + "\\src\\main\\ibans";
        Scanner in = new Scanner(Path.of(path), StandardCharsets.UTF_8);
        in.useDelimiter("\n");
        System.out.println(System.getProperty("user.dir"));
        while (in.hasNext()) {
            String message = in.next();
            Iban ibanObject = new Iban(message);
            ibanObject = Iban.clean(ibanObject);
            ibanObject = Iban.checkNumberOfChar(ibanObject);
            ibanObject = Iban.checkIban(ibanObject);
            Iban.printIban(ibanObject);


        }

    }
}
