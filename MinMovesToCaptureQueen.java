Problem Link: https://leetcode.com/problems/minimum-moves-to-capture-the-queen/

class MinMovesToCaptureQueen {
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {

        //Considering My Rook, and Queen are align Horizontally OR Vertically
        if(a==e || b==f) {
            if((a == e && c == a) && (d-b)*(d-f) < 0 ) return 2;
            if((d == f && b == d) && (c-a)*(c-e) < 0 ) return 2;
            return 1;
        }
        //Considering My Rook, Queen are align in diagonally
        if(Math.abs(c-e) == Math.abs(d-f)){
            if(Math.abs(a-c)==Math.abs(b-d) && (b-f)*(b-d) < 0 ) return 2;
            return 1;
        }
        return 2;
    }
}
