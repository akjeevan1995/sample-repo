package testCode;

import org.junit.Test;
import static org.junit.Assert.*;

public class SampleTest {
	public int mentiod(int a, int b) {
		int c= a+b;
		return c;
	}
  @Test
  public void testMethod1() {
    int a = 5;
    int b = 3;
    
   int d= mentiod(a,b);
   System.out.println(d);
   
  }

  @Test
  public void testMethod2() {
    String str1 = "hello";
    String str2 = "hello";
    assertEquals(str1, str2);
  }
}