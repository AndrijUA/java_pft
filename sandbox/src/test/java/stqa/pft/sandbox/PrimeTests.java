package stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Iwona Zajac on 05.04.2018.
 */
public class PrimeTests {

  @Test
  public void testPrime() {
    Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
  }

  @Test
  public void testNonPrime() {
    Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE - 2));
  }

  @Test
  public void testPrimeFast() {
    Assert.assertTrue(Primes.isPrimeFast(Integer.MAX_VALUE));
  }

  @Test
  public void testPrimeFastPlus() {
    Assert.assertTrue(Primes.isPrimeFastPlus(Integer.MAX_VALUE));
  }

  @Test(enabled = false)
  public void testPrimeWhile() {
    Assert.assertTrue(Primes.isPrimeWhile(Integer.MAX_VALUE));
  }

  @Test(enabled = false)
  public void testNonPrimeWhile() {
    Assert.assertFalse(Primes.isPrimeWhile(Integer.MAX_VALUE - 2));
  }

  @Test(enabled = false)
  public void testPrimeLong() {
    long n = Integer.MAX_VALUE;
    Assert.assertTrue(Primes.isPrime(n));
  }

  @Test(enabled = false)
  public void testNonPrimeLong() {
    long n = Integer.MAX_VALUE;
    Assert.assertFalse(Primes.isPrime(n - 2));
  }
}
