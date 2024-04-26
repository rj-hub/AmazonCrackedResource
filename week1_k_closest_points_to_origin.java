class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];

            double xdiff = Math.pow(x-0,2);
            double ydiff = Math.pow(y-0,2);

            int diff = (int) Math.sqrt(xdiff+ydiff);
            Pair pair = new Pair(diff,i);
            pq.add(pair);

            if(pq.size() > k) {
                pq.poll();
            }
        }

        int[][] ans = new int[k][2];
        int index = 0;
        while(!pq.isEmpty()) {
            Pair pair = pq.poll();
            
            ans[index] = points[pair.index];
            index++;
        }

        return ans;
    }
}

class Pair implements Comparable<Pair> {
    int absdiff;
    int index;

    Pair(int d,int i) {
        this.absdiff = d;
        this.index = i;
    }

    public int compareTo(Pair o){
        if(absdiff == o.absdiff) {
            return index - o.index;
        } else {
            return o.absdiff - absdiff;
        }
    }
}
