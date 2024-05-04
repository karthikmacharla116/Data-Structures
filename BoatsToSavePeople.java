Problem Link: https://leetcode.com/problems/boats-to-save-people/description/?envType=daily-question&envId=2024-05-04

class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int left = 0, right = people.length - 1;

        int boats = 0;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++; 
            }
            right--; 
            boats++; 
        }

        return boats;
    }
}
