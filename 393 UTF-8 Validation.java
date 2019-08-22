class Solution {

    private int[] masks = {128, 64, 32, 16, 8};

    public boolean validUtf8(int[] data) {
        //the idea of this problem is only to check
        //each of the number is valid
        int len = data.length;
        for (int i = 0; i < data.length; i++) {
            int curr = data[i];
            int type = getType(curr);
            if (type == 0) {
                continue;
            } else if (type > 1 && i + type <= len) { //make sure length enough for descending
                //each type n followed by type n-1 auto just check first 2 bits
                while (type-- > 1) {
                    if (getType(data[++i]) != 1) {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
        return true;
    }

    //type 0,1,2,3,4
    private int getType(int num) {
        for (int i = 0; i < 5; i++) {
            if ((num & masks[i]) == 0) {
                return i;
            }
        }
        return -1;
    }
}