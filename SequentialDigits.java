Problem Link: https://leetcode.com/problems/sequential-digits/description/?envType=daily-question&envId=2024-02-02

class SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {

        List<Integer> digits = new ArrayList();
        String str = "123456789";

        for(int i=0;i<str.length();i++) {
            for(int j=i+2;j<=str.length();j++) {
                int seq = Integer.parseInt(str.substring(i,j));
                if(seq >= low && seq <= high)
                    digits.add(seq);
            }
        }
        Collections.sort(digits);
        return digits;
    }
}
