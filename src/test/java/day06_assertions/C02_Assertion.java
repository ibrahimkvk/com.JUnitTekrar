package day06_assertions;

import org.junit.Assert;
import org.junit.Test;

public class C02_Assertion {

    int P1Yas = 60;
    int P2Yas = 66;
    int P3Yas = 70;

    @Test
    public void test01() {
        //emeklilik yasi 65 olduguna gore P1 in emekli olamayacagini tetst et
        Assert.assertFalse(P1Yas>65);
    }
    @Test
    public void test02() {
        //emeklilik yasi 65 olduguna gore P2 in emekli olabilecegini test et
        Assert.assertTrue(P2Yas>65);
    } @Test
    public void test03() {
        //emeklilik yasi 65 olduguna gore P3 in emekli olabilecegini tetst et
        Assert.assertTrue("emeklilik yasi 65 oldugu icin emekli olabilir",P3Yas<65);
    } @Test
    public void test04() {
        //emeklilik yasi 65 olduguna gore P1 in emekli olamayacagini tetst et
        Assert.assertFalse(P1Yas>65);
    }
}
