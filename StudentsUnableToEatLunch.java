Problem Link: https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/description/?envType=daily-question&envId=2024-04-08

class StudentsUnableToEatLunch {
    public int countStudents(int[] students, int[] sandwiches) {
        int circleStudentCount = 0;
        int squareStudentCount = 0;

        for (int student : students) {
            if (student == 0) {
                circleStudentCount++;
            } else {
                squareStudentCount++;
            }
        }

        for (int sandwich : sandwiches) {
            if (sandwich == 0 && circleStudentCount == 0) {
                return squareStudentCount;
            }
            if (sandwich == 1 && squareStudentCount == 0) {
                return circleStudentCount;
            }
            if (sandwich == 0) {
                circleStudentCount--;
            } else {
                squareStudentCount--;
            }
        }
        return 0;
    }
}
