import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.ClassNotFoundException;
public class SampleTest {
  @Test
  public void testMethod1() {
    int a = 5;
    int b = 3;
    assertEquals(8, a+b);
  }

  @Test
  public void testMethod2() {
    String str1 = "hello";
    String str2 = "hello";
    assertEquals(str1, str2);
  }
}