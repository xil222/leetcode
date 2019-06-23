import java.util.*;

//method 1 use two pointers 4ms 33.82%
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {

        //initialize two indexes for A, B
        int indexA = 0;
        int indexB = 0;

        //use a List to store all the elements inside
        List<Integer> intersect = new ArrayList<>();
        while (indexA < A.length && indexB < B.length) {
            if (A[indexA][1] == B[indexB][1]) {
                intersect.add(Math.max(A[indexA][0], B[indexB][0]));
                intersect.add(A[indexA][1]);
                indexA++;
                indexB++;
            } else if (A[indexA][1] < B[indexB][1]) {
                if (A[indexA][1] >= B[indexB][0]) {
                    intersect.add(Math.max(A[indexA][0], B[indexB][0]));
                    intersect.add(A[indexA][1]);
                }
                indexA++;
            } else {
                if (A[indexA][0] <= B[indexB][1]) {
                    intersect.add(Math.max(A[indexA][0], B[indexB][0]));
                    intersect.add(B[indexB][1]);
                }
                indexB++;
            }
        }

        int[][] result = new int[intersect.size()/2][2];
        for (int i = 0; i < result.length; i++){
            result[i][0] = intersect.get(2*i);
            result[i][1] = intersect.get(2*i+1);
        }
        return result;
    }
}



//use an improved approach
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {

        //initialize two indexes for A, B
        int indexA = 0;
        int indexB = 0;

        //use a List to store all the elements inside
        List<Integer> intersect = new ArrayList<>();
        while (indexA < A.length && indexB < B.length) {
            int left = Math.max(A[indexA][0], B[indexB][0]);
            int right = Math.min(A[indexA][1], B[indexB][1]);

            if (right >= left) {
                intersect.add(left);
                intersect.add(right);
            }
            if (A[indexA][1] == right) indexA++;
            if (B[indexB][1] == right) indexB++;
        }

        int[][] result = new int[intersect.size()/2][2];
        for (int i = 0; i < result.length; i++){
            result[i][0] = intersect.get(2*i);
            result[i][1] = intersect.get(2*i+1);
        }
        return result;
    }
}