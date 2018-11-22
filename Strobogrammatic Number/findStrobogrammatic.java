public class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> res, cur;
        //chcek for n= 0 0r 1
        res = ((n&1)==1)?new ArrayList<String>(Arrays.asList("0", "1", "8")):new ArrayList<String>(Arrays.asList(""));
        if(n < 2)  return res;
        
        //check for n>=2
        for(int i = n; i > 1; i-=2){
            cur = res; //list
            res = new ArrayList<String>();
            for(String str: cur){
                if(i > 3){
                   res.add("0" + str + "0"); // 0 should not be the beginning number
                }
                res.add("1" + str + "1");
                res.add("6" + str + "9");
                res.add("9" + str + "6");
                res.add("8" + str + "8");
            } // for str
        } // for i
        return res;
    }
}
