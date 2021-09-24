package test;

import main.Iban;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class MainTest {

    @Test
    public void testCheckNumberOfChar() {
        Iban testIban = new Iban("PL10105000997603123456789123");
        testIban = Iban.checkNumberOfChar(testIban);
        assertEquals(true, testIban.flag);
    }

    @Test
    public void testClean() {
        Iban testIban = new Iban("Pl 8310101023000026139510000!");
        Iban correctIban = new Iban("PL8310101023000026139510000");
        testIban = Iban.clean(testIban);
        assertEquals(correctIban.iban, testIban.iban);
    }

    @Test
    public void testCheckIban() {
        Iban testIban = new Iban("PL10105000997603123456789123");
        testIban.flag = true;
        testIban = Iban.checkIban(testIban);
        assertEquals(true, testIban.flag);
    }


}




