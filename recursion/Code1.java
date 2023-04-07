package recursion;

public class Code1 {
    public static void main(String[] args) {
        int result = factorial(4);
        printCharReverse("Computer");
        System.out.println(length("hey"));
        int[] a = {1,8,3,4,5,6};
        int b = findMax(a,0,5);
        System.out.println(b);
    }

    public static int func(int n){
        if(n<= 0) return 0 ;
        else {
            System.out.println("Hello...");
            return n + func(n-1);
        }
    }

    public static int factorial(int n) {
        if (n==1)
            return 1;
        else{
            return n*factorial(n-1);
        }
    }

    public static double power(double x, int n){
        if(n==0)
            return 1;
        else
            return x*power(x,n-1);
    }

    public static int fibonacci(int n){
        if(n<2)
            return n;
        else
            return factorial(n-1)+ factorial(n-2);
    }

    public static int gcd(int m,int n){
        if (n==0) return m;
        else
            return gcd(n,m%n);
    }

    public static int length(String str){
        if(str.equals("")) return 0;
        else return 1+length(str.substring(1));
    }

    public static void printCharReverse(String str){
        if(str.equals("")) return;
        else{
            printCharReverse(str.substring(1));
            System.out.print(str.charAt(0));
        }
    }

    public static int sum(int n, int[] data) {
        if(n<=0)
            return 0;
        else
            return sum(n-1,data) + data[n-1];
    }

    public static int findMax(int[] data, int begin, int end){
        if(begin== end) return data[begin];
        else
            return Math.max(data[begin],findMax(data,begin+1,end));
    }


}
