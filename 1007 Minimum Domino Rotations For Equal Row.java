//This problem is a direct Math problem.
//we just got dice A and B, even if one of them all As
//the other one all Bs, there is only two solution,
//choose the more optimal one
//so just iterate through the array, check how many dices
//have full coverage
//if 0 --> just return -1
//if 1 just count on two sides
//if 2, well same for both number regarding min steps

//O(n) time complexity
//it is two pass
class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        boolean[] fullCover = new boolean[6];
        Arrays.fill(fullCover, true);
        int count = 6;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < 6; j++) {
                if (fullCover[j]) {
                    if (A[i]-1 != j && B[i]-1 != j) {
                        fullCover[j] = false;
                        count--;
                    }
                }
                if (count == 0) {
                    return -1;
                }
            }
        }

        //two options convert A to B or B to A
        int num = findNumber(fullCover);
        return Math.min(getNum(A,num), getNum(B,num));
    }

    private int findNumber(boolean[] fullCover) {
        for (int i = 0; i < 6; i++) {
            if (fullCover[i]) {
                return i + 1;
            }
        }
        return -1;
    }

    //number of steps to make all arr number as index
    private int getNum(int[] arr, int index) {
        int step = 0;
        for (int item: arr) {
            if (item != index) {
                step++;
            }
        }
        return step;
    }
}


//O(n) time complexity, one pass
class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int[] Acount = new int[6];
        int[] Bcount = new int[6];
        int[] dup = new int[6];

        for (int i = 0; i < A.length; i++) {
            Acount[A[i]-1]++;
            Bcount[B[i]-1]++;
            if (A[i] == B[i]) {
                dup[A[i]-1]++;
            }
        }

        for (int i = 0; i < 6; i++) {
            if (Acount[i] + Bcount[i] - dup[i] == A.length) {
                return Math.min(Acount[i], Bcount[i]) - dup[i];
            }
        }
        return -1;
    }

}

