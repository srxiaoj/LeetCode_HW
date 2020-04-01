import java.util.HashMap;
import java.util.Map;

public class TinyUrl {

  private static final int URL_LENGTH = 7;

  public static void main(String[] args) {
    String url = "https://www.cnblogs.com/grandyang/p/7675140.html";
    System.out.println(longToShort(url));

    System.out.println(shortToLong(longToShort(url)));
  }


  static HashMap<String, Integer> long2short = new HashMap<String, Integer>();
  static HashMap<Integer, String> short2long = new HashMap<Integer, String>();
  static int COUNTER = 1;
  static String elements = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

  public static String longToShort(String url) {
    String shorturl = base10ToBase62(COUNTER);
    long2short.put(url, COUNTER);
    short2long.put(COUNTER, url);
    COUNTER++;
    return "http://tiny.url/" + shorturl;
  }

  public static String shortToLong(String url) {
    url = url.substring("http://tiny.url/".length());
    int n = base62ToBase10(url);
    return short2long.get(n);
  }

  public static int base62ToBase10(String s) {
    int n = 0;
    for (int i = 0; i < s.length(); i++) {
      n = n * 62 + convert(s.charAt(i));
    }
    return n;
  }

  public static int convert(char c) {
    if (c >= '0' && c <= '9') {
      return c - '0';
    }
    if (c >= 'a' && c <= 'z') {
      return c - 'a' + 10;
    }
    if (c >= 'A' && c <= 'Z') {
      return c - 'A' + 36;
    }
    return -1;
  }

  public static String base10ToBase62(int n) {
    StringBuilder sb = new StringBuilder();
    while (n != 0) {
      sb.insert(0, elements.charAt(n % 62));
      n /= 62;
    }
    while (sb.length() != 6) {
      sb.insert(0, '0');
    }
    return sb.toString();
  }

}
