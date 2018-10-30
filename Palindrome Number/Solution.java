class Solution {
    public boolean isPalindrome(int x) {
        //check for negative number and number starting with zero
        if (x < 0 || (x%10 == 0 && x!= 0)){
            return false;
        }
        
        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
   
        if(x == revertedNumber || x == revertedNumber/10)    
          return true;   
        else    
          return false; 
    }
}
