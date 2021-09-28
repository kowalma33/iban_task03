package main;

import java.math.BigInteger;
import java.util.Map;

public class Iban {

    public String iban;
    public boolean flag;

    public Iban(String iban) {
        this.iban = iban;
        this.flag = false;
    }

    public static void printIban(Iban iban) {
        System.out.println("++++++++++++++++++");
        String flag = "Incorrect";
        if (iban.flag == true) {
            flag = "Correct";
        }
        System.out.println("Iban: " + iban.iban + " is " + flag);
    }

    static public Iban clean(Iban ibanObject) {
        String cleanIban = ibanObject.iban.replaceAll("[^a-zA-Z0-9]", "");
        ibanObject.iban = cleanIban.toUpperCase();
        return ibanObject;
    }

    static public Iban checkNumberOfChar(Iban ibanObject) {

        if (ibanObject.iban.length() >= 14 & ibanObject.iban.length() <= 34) {
            ibanObject.flag = true;
        } else {
            ibanObject.flag = false;
        }

        return ibanObject;
    }

    static public Iban checkIban(Iban ibanObject, Map hashMap) {
        if (ibanObject.flag == true) {
            String tmp = ibanObject.iban;
            tmp = transferChar(tmp);
            tmp = replaceChar(tmp, hashMap);
            ibanObject.flag = countSum(tmp);

        }
        return ibanObject;
    }

    static private String transferChar(String iban) {
        String begining = iban.substring(0, 4);
        String end = iban.substring(4, iban.length());
        return end + begining;
    }

    static private String replaceChar(String iban, Map hashMap) {
        String tmp = "";
        Object tmpNumber = 0;
        for (int i = 0; i < iban.length(); i++) {
            tmpNumber = hashMap.getOrDefault(iban.charAt(i),'0');
            if(tmpNumber.equals('0')){ tmp = tmp + iban.charAt(i);
            } else { tmp = tmp + tmpNumber; }
        }
        return tmp;
    }

    private static boolean countSum(String iban) {

        BigInteger number = new BigInteger(iban);
        BigInteger div = new BigInteger("97");
        BigInteger one = new BigInteger("1");
        if (number.mod(div).equals(one)) {
            return true;
        } else {
            return false;
        }

    }

}
