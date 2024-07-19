Problem Link: https://leetcode.com/problems/lucky-numbers-in-a-matrix/description/?envType=daily-question&envId=2024-07-19

class LuckyNumbers {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> lucky= new ArrayList<>();
        int min=Integer.MIN_VALUE;
        int max= Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j=0; j<matrix[0].length;j++){
                boolean isMin= minInRow(matrix[i][j], matrix[i]);
                boolean isMax= maxInColumn(matrix[i][j], matrix, j);
                if(isMin && isMax ){
                    lucky.add(matrix[i][j]);
                } 
            }
        }

        return lucky;  
    }

    public boolean minInRow(int n, int[] row){
        int min= row[0];
        for(int i=0;i<row.length;i++){
            if(row[i]<min){
                min=row[i];
            }
        }
        if(min==n){
            return true;
        }
        return false;
    }

    public boolean maxInColumn(int n, int[][] mat, int j){
        int max= Integer.MIN_VALUE;
        for(int i= 0;i<mat.length; i++){
            if(mat[i][j]>max){
                max= mat[i][j];
            } 
        }
        if(max==n){
            return true;
        }    
        return false;
    }
}
