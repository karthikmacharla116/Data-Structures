Problem Link: https://leetcode.com/problems/number-of-laser-beams-in-a-bank/description/?envType=daily-question&envId=2024-01-03

class LaserBeamsInBank {
  public int numberOfBeams(String[] bank) {
    int before = 0, result = 0;

    for (String str: bank) {
      int count = 0;
      for (int i = 0; i < str.length(); i++)
        if (str.charAt(i) == '1') {
          count++;
        }

      if (count > 0) {
        result += before * count;
        before = count;
      }
    }

    return result;
  }
}
