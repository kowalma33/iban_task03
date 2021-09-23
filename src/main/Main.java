package main;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(Path.of("C:\\Users\\KOWALMA3\\Desktop\\task02\\iban\\src\\main\\ibans"), StandardCharsets.UTF_8);
        in.useDelimiter("\n");

       while (in.hasNext()) {
            String message = in.next();
            Iban ibanObject = new Iban(false,message);
            ibanObject = Iban.clean(ibanObject);
            ibanObject = Iban.checkNumberOfChar(ibanObject);
            ibanObject = Iban.checkIban(ibanObject);
            Iban.printIban(ibanObject);


        }

    }
}
