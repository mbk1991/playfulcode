import java.math.*;

public class Palindrome{
    public static void main(String[] args){
    	try{
            if(args[0].length() > 18){
                BigInteger input = new BigInteger(args[0]);
                gruenBurger(input);
         }else{
	    	gruenBurger(Long.parseLong(args[0]));
         }
    	}catch(Exception e){
    		System.out.println(e.getMessage());		
    	}
    }

    private static void gruenBurger(long num){
	    long reverseNum =  getReverseNum(num);
    	long ans = num + reverseNum;
    	System.out.println("num:" + num);
    	System.out.println("reverse num:" + reverseNum);
    	System.out.println("ans:" + ans);
    	if( isPalindrome(ans) ){
    		System.out.println("ans is Palindrome!!! : " + ans );	
    		System.out.println("---");
    	}else{
    		System.out.println("ans is not Palindrome. continue step... : " + ans );	
    		System.out.println("---");
    		gruenBurger(ans);
    	}
     }

    private static void gruenBurger(BigInteger num){
        BigInteger reverseNum = getReverseNum(num);
        BigInteger ans = num.add(reverseNum);
        System.out.println("num:" + num);
        System.out.println("reverse num:" + reverseNum);
        System.out.println("ans:" + ans);
        if( isPalindrome(ans) ){
            System.out.println("ans is Palindrome!!! : " + ans );
            System.out.println("---");
        }else{
            System.out.println("ans is not Palindrome. continue step... : " + ans );
            System.out.println("---");
            gruenBurger(ans);
        }
    }


    private static long getReverseNum(long num){
    	String strNum = num + "";
    	String strReverseNum = new StringBuilder(strNum).reverse().toString();
    	return Long.parseLong(strReverseNum);
     }

    private static BigInteger getReverseNum(BigInteger num){
        String strNum = num.toString();
        String strReverseNum =new StringBuilder(strNum).reverse().toString();
        return new BigInteger(strReverseNum);
    }

     private static boolean isPalindrome(long num){
    	String numStr = num + "";
    	int len = numStr.length();
    	int lastIdx = len - 1;
    	char[] numCharArray = numStr.toCharArray();
    	for(int i=0; i<len; i++){
    	    if(numCharArray[i] != numCharArray[lastIdx-i]){
    		return false;
    	    } 
    	}
    	return true;
     }

     private static boolean isPalindrome(BigInteger num){
        String numStr = num.toString();
        int len = numStr.length();
        int lastIdx = len - 1;
        char[] numCharArray = numStr.toCharArray();
        for(int i=0; i<len; i++){
            if(numCharArray[i] != numCharArray[lastIdx-i]){
                return false;
             }
         }
        return true;
    }
    
    
    private void testMethod(){
        Palindrome.class


    }
}
