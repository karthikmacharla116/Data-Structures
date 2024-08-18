Problem Link: https://leetcode.com/problems/ugly-number-ii/description/?envType=daily-question&envId=2024-08-18

class UglyNumberII {

    public int nthUglyNumber(int n) {
        TreeSet<Long> uglyNumbersSet = new TreeSet<>(); 
        uglyNumbersSet.add(1L); 

        Long currentUgly = 1L;
        for (int i = 0; i < n; i++) {
            currentUgly = uglyNumbersSet.pollFirst(); 

            uglyNumbersSet.add(currentUgly * 2);
            uglyNumbersSet.add(currentUgly * 3);
            uglyNumbersSet.add(currentUgly * 5);
        }

        return currentUgly.intValue(); 
    }
}
