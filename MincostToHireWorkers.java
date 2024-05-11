Problem Link: https://leetcode.com/problems/minimum-cost-to-hire-k-workers/description/?envType=daily-question&envId=2024-05-11

class MincostToHireWorkers {
    class pair{
        int q;
        int w;
        double r;
        pair(int q,int w,double r){
            this.q=q;
            this.w=w;
            this.r=r;
        }
    }
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        
        int n=quality.length;
        pair[] arr=new pair[n];

        for(int i=0;i<n;i++){
            arr[i]=new pair(quality[i],wage[i],wage[i]/(double)quality[i]);
        }

        Arrays.sort(arr,new Comparator<pair>(){
            @Override
            public int compare(pair p,pair q){
                if(p.r<q.r) return -1;
                if(p.r>q.r) return 1;
                return 0;
            }
        });

        int sum=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->(b-a));
        for(int i=0;i<k;i++){
            pq.add(arr[i].q);
            sum+=arr[i].q;
        }

        double ans=(double)sum*arr[k-1].r;

        for(int i=k;i<n;i++){
            int temp=pq.poll();
            sum-=temp;
            sum=sum+arr[i].q;
            double curr= (double)sum*arr[i].r;

            ans=Math.min(ans,curr);
            pq.add(arr[i].q);
        }

        return ans;
    }
}
