public class Solution {
    public int strobogrammaticInRange(String low, String high) {
        int count = 0;
        for(int len = low.length(); len<=high.length(); len++){
            List<String> ls = compute(len, len);
            for(String s : ls){
                if((s.length() == low.length() && 
                    s.compareTo(low) < 0) || (s.length() == high.length() && 
                                             s.compareTo(high) > 0)){
                    continue;
                }
                count++;
            }
        }
        return count;
    }
    
    private List<String> compute(int cur, int max){
        if(cur == 0){
            return new ArrayList<String>(Arrays.asList(""));
        }
        if(cur == 1){
            return new ArrayList<String>(Arrays.asList("0", "1", "8"));
        }
        
        List<String> res = new ArrayList<String>();
        List<String> base = compute(cur-2, max);
        for(String s : base){
            if(cur != max){
                res.add("0" + s + "0");
            }
            res.add("1" + s + "1");
            res.add("8" + s + "8");
            res.add("6" + s + "9");
            res.add("9" + s + "6");
        }
        return res;
    }
}
