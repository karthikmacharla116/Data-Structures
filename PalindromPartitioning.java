Problem Link: https://leetcode.com/problems/palindrome-partitioning/description/?envType=daily-question&envId=2024-05-22

class PalindromPartitioning {
    
    public List<List<String>> partition(String s) {
        
        List<List<String>> result = new ArrayList();

        helper(new ArrayList(), 0, s, result);
        return result;
    }

    void helper(List<String> list, int index, String str, List<List<String>> result) {
        if(index == str.length()) {
            result.add(new ArrayList(list));
            return;
        }

        for(int end = index;end<str.length();end++) {
            if(isPalindrom(index, end, str)) {
                list.add(str.substring(index, end+1));
                helper(list, end+1, str, result);
                list.remove(list.size()-1);
            }
        }

    }

    boolean isPalindrom(int start, int end, String str) {
        if(start > end)
            return true;
        
        if(str.charAt(start) != str.charAt(end))
            return false;
        return isPalindrom(start+1, end-1, str);
    }
}
