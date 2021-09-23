package test;

import main.Iban;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class MainTest {

    @Test
    public void testCheckNumberOfChar(){
        Iban testIban = new Iban(false,"PL10105000997603123456789123");
        Iban correctIban = new Iban(true,"PL10105000997603123456789123");
        testIban = Iban.checkNumberOfChar(testIban);
        assertEquals(correctIban.flag,testIban.flag);
    }
    @Test
    public void testClean(){
        Iban testIban = new Iban(false,"Pl 8310101023000026139510000!");
        Iban correctIban = new Iban(false,"PL8310101023000026139510000");
        testIban = Iban.clean(testIban);
        assertEquals(correctIban.iban,testIban.iban);
    }
    @Test
    public void testCheckIban(){
        Iban testIban = new Iban(true,"PL10105000997603123456789123");
        Iban correctIban = new Iban(true,"PL10105000997603123456789123");
        testIban = Iban.checkIban(testIban);
        assertEquals(correctIban.flag,testIban.flag);
    }


}




