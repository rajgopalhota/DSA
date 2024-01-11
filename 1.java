class Raja{
    
    static int getSol(int sM, int nums[], int lS){
        
        for (int num : nums) {
            
            if (num >= lS + 1) {
                sM = num;
                break;
            }
            
        }

        return sM;
        
    }
    
    static class Utils{
        static int solvedByRaja(int lS, int cS, int nums[]){
            
            for (int i = 0; i < nums.length; i++) {
                
                if (i > 0 && nums[i] != nums[i - 1] + 1) cS = 0;

                cS += nums[i]; lS = Math.max(lS, cS);

            }

            int sM = lS + 1;

            return Raja.getSol(sM, nums, lS);
            
        }
    }
}

class Solution {
    public int missingInteger(int[] nums) {
        
        Arrays.sort(nums);

        return Raja.Utils.solvedByRaja(0, 0, nums);

    }
}