Problem Link: https://leetcode.com/problems/subsets/description/?envType=daily-question&envId=2024-05-21

class Subsets {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList();
        List<Integer> list = new ArrayList();

        subset(result, nums, 0, list);
        return result;
    }

    void subset(List<List<Integer>> result, int[] nums, int start, List<Integer> list) {
        if(start == nums.length) {
            result.add(new ArrayList(list));
            return;
        }
        
        subset(result, nums, start+1, list);
        list.add(nums[start]);
        subset(result, nums, start+1, list);
        list.remove(list.size()-1);
    }
}
