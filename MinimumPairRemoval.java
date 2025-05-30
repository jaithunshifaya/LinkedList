import java.util.ArrayList;
import java.util.List;

class Solution {
    public int minimumPairRemoval(int[] nums) {
        int ops = 0;
        
        
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        while (!isNonDecreasing(list)) {
            int minSum = Integer.MAX_VALUE;
            int minIndex = -1;
            
            
            for (int i = 0; i < list.size() - 1; i++) {
                int sum = list.get(i) + list.get(i + 1);
                if (sum < minSum) {
                    minSum = sum;
                    minIndex = i;
                }
            }
            
            
            int mergedValue = list.get(minIndex) + list.get(minIndex + 1);
            list.set(minIndex, mergedValue);
            list.remove(minIndex + 1);
            
            ops++;
        }
        
        return ops;
    }
    
    
    private boolean isNonDecreasing(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
}
