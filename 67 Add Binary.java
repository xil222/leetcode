//beats 61.12% time complexity
class Solution {
    public String addBinary(String a, String b) {
        int preSum = 0;
        int sum = 0;
        String result = "";
//        int firstOneofA = a.indexOf('1');
//        int firstOneofB = b.indexOf('1');
//
//        if (firstOneofA != -1) {
//            a = a.substring(firstOneofA);
//        }
//
//        if (firstOneofB != -1) {
//            b = b.substring(firstOneofB);
//        }

        int indexA = a.length() - 1;
        int indexB = b.length() - 1;

        while (indexA >= 0 && indexB >= 0) {
            sum = a.charAt(indexA) - '0' + b.charAt(indexB) - '0' + preSum;
            preSum = sum / 2;
            sum = sum % 2;
            result = Integer.toString(sum) + result;
            indexA--;
            indexB--;
        }

        while (indexA >= 0) {
            sum = a.charAt(indexA) - '0' + preSum;
            preSum = sum / 2;
            sum = sum % 2;
            result = Integer.toString(sum) + result;
            indexA--;
        }

        while (indexB >= 0) {
            sum = b.charAt(indexB) - '0' + preSum;
            preSum = sum / 2;
            sum = sum % 2;
            result = Integer.toString(sum) + result;
            indexB--;
        }

        if (preSum == 1) {
            result = '1' + result;
        }

        return result;
    }
}

//more convenient beats 100%
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        int preSum = 0;

        while (indexA >= 0 || indexB >= 0) {
            int sum = preSum;
            if (indexA >= 0) sum += a.charAt(indexA--) - '0';
            if (indexB >= 0) sum += b.charAt(indexB--) - '0';
            sb.append(sum % 2);
            preSum = sum / 2;
        }

        //only need to care preSum
        if (preSum == 1) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}