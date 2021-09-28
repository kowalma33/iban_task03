package main;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.dir") + "\\src\\main\\ibans";
        Scanner in = new Scanner(Path.of(path), StandardCharsets.UTF_8);
        in.useDelimiter("\n");
        System.out.println(System.getProperty("user.dir"));
        Map<Character,Integer> mapOfLetters = new HashMap<>();
        Character[] Letters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','R','S','T','U','W','X','Y','Z'};
        for(int i =0; i<Letters.length; i++) {
            mapOfLetters.put(Letters[i],i+10);
        }
        while (in.hasNext()) {
            String message = in.next();
            Iban ibanObject = new Iban(message);
            ibanObject = Iban.clean(ibanObject);
            ibanObject = Iban.checkNumberOfChar(ibanObject);
            ibanObject = Iban.checkIban(ibanObject,mapOfLetters);
            Iban.printIban(ibanObject);


        }

    }
}
