
public class SingleNumber {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[] test = {4,2,3,2,3};
    System.out.println(singleNumber(test));
    System.out.println(4 ^ 4);
  }

  public static int singleNumber(int A[]) {
    int result = A[0];
    for (int i = 1; i < A.length; i++) {
      result = result ^ A[i];
      System.out.println("result is " + result);
    }
    return result;
  }

  // public static int singleNumber(int[] nums) {
  //   //we need to implement a tree-time counter(base 3) that if a bit appears three time ,it will be zero.
  //     //#curent  income  ouput
  //     //# ab      c/c       ab/ab
  //     //# 00      1/0       01/00
  //     //# 01      1/0       10/01
  //     //# 10      1/0       00/10
  //     // a=~abc+a~b~c;
  //     // b=~a~bc+~ab~c;
  //     int a=0;
  //     int b=0;
  //     for(int c:nums){
  //         int ta=(~a&b&c)|(a&~b&~c);
  //         b=(~a&~b&c)|(~a&b&~c);
  //         a=ta;
  //     }
  //     //we need find the number that is 01,10 => 1, 00 => 0.
  //     return a|b;
  //
  // }

}
