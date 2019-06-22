import java.util.*;

class Solution {

    class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    //1st method use minheap, (n+k)logn 19ms
    public int[][] kClosest(int[][] points, int K) {

        //initialize a priorityQueue
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return a.x * a.x + a.y * a.y - b.x * b.x - b.y * b.y;
            }
        });

        for (int i = 0; i < points.length; i++) {
            pq.offer(new Pair(points[i][0], points[i][1]));
        }

        int size = Math.min(pq.size(), K);
        int[][] result = new int[size][2];

        for (int i = 0; i < size; i++) {
            Pair temp = pq.poll();
            result[cnt][0] = temp.x;
            result[cnt][1] = temp.y;
        }
        return result;
    }


    //2nd method use maxheap, (n+k)logk 27ms
    public int[][] kClosest(int[][] points, int K) {

        //initialize a priorityQueue of size k
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(K, new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return b.x * b.x + b.y * b.y - a.x * a.x - a.y * a.y;
            }
        });

        //greater than peek, just ignore
        //if smaller than peek, pop out the largest element then add in the new Pair
        for (int i = 0; i < points.length; i++) {
            if (i < K) {
                pq.offer(new Pair(points[i][0], points[i][1]));
            } else {
                int sum = points[i][0] * points[i][0] + points[i][1] * points[i][1];
                Pair top = pq.peek();
                int topVal = top.x * top.x + top.y * top.y;
                if (sum < topVal) {
                    pq.poll();
                    pq.offer(new Pair(points[i][0], points[i][1]));
                }
            }
        }

        int size = Math.min(pq.size(), K);
        int[][] result = new int[size][2];

        for (int i = 0; i < size; i++) {
            Pair temp = pq.poll();
            result[i][0] = temp.x;
            result[i][1] = temp.y;
        }
        return result;
    }

    //editted 2nd method 63ms
    public int[][] kClosest(int[][] points, int K) {
        //initialize PriorityQueue
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] + p1[1] * p1[1]);
        for (int[] temp : points) {
            pq.offer(temp);
            if (pq.size() > K) {
                pq.poll();
            }
        }

        int[][] res = new int[K][2];
        while (K > 0) {
            res[--K] = pq.poll();
        }
        return res;
    }

}