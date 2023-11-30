package day05_jUnit;

import org.junit.Ignore;
import org.junit.Test;

public class C01_Finished_MainMethod {
    @Test
    public void test01() {
        System.out.println("test1 calisti");
    }
    @Test @Ignore
    public void test02() {
        System.out.println("test2 calisti");
    } @Test
    public void test03() {
        System.out.println("test3 calisti");
    }

}
