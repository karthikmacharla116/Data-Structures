Problem Link: https://leetcode.com/problems/minimum-common-value/description/?envType=daily-question&envId=2024-03-09

class MinCommonValue {
    public int getCommon(int[] a, int[] b) {
        int i=0;
        int j=0;
        
        while(i<a.length && j<b.length){
            if(a[i]==b[j])
            return a[i];
            else if(a[i]>b[j]){
                j++;
            }else{
                i++;
            }
        }
        return -1;
        
    }
}
