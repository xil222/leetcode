//beats 14.3% say length of string is n, O(n^3)
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return result;
        }

        dfs(num, "", target, result, 0, 0, 0);
        return result;
    }

    //pos represents the start position
    //pre represents total result
    //mult represents value for multiplication
    private void dfs(String num, String res, int target, List<String> result, int pos, long pre, long mult) {
        if (pos == num.length()) {
            if (pre == target) {
                result.add(new String(res));
            }
            return;
        }

        for (int i = pos; i < num.length(); i++) {
            //can't start with 0s
            if (i > pos && num.charAt(pos) == '0') {
                break;
            }

            long curr = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                dfs(num, Long.toString(curr), target, result, i + 1, curr, curr);
            } else {
                //plus
                dfs(num, res + '+' + Long.toString(curr), target, result, i + 1, pre + curr, curr);
                //minus
                dfs(num, res + '-' + Long.toString(curr), target, result, i + 1, pre - curr, -curr);
                //notice from k + b to k + b * a. (k + b) - b + b * a
                dfs(num, res + '*' + Long.toString(curr), target, result, i + 1, pre - mult + mult * curr, mult * curr);

            }
        }
    }
}

//change format a little bit beats 87.5%
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(result, num, target, sb, 0, 0, 0);
        return result;
    }

    private void dfs(List<String> result, String num, int target, StringBuilder sb, int pos, long pre, long mult) {
        if (pos == num.length()) {
            if (pre == target) {
                result.add(new String(sb));
            }
            return;
        }

        for (int i = pos; i < num.length(); i++) {
            if (num.charAt(pos) == '0' && i > pos) break;
            long currVal = Long.parseLong(num.substring(pos, i+1));
            int len = sb.length();
            if (pos == 0) {
                dfs(result, num, target, sb.append(currVal), i+1, currVal, currVal);
                sb.setLength(len);
            } else {
                dfs(result, num, target, sb.append('+').append(currVal), i+1, pre+currVal, currVal);
                sb.setLength(len);

                dfs(result, num, target, sb.append('-').append(currVal), i+1, pre-currVal, -currVal);
                sb.setLength(len);

                dfs(result, num, target, sb.append('*').append(currVal), i+1, pre-mult+mult*currVal, mult * currVal);
                sb.setLength(len);
            }
        }

    }

}



//This solution is not right
//there are several edge cases need to be thought about
//like don't take Integer, but take Long
//should think about the first * case
//we can't have string start with '0' but length more than 1
class Solution {
    public List<String> addOperators(String num, int target) {
        //for this problem, at each position, we can have split or no split
        //when have split we have 4 possibilities
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        //pre, startPos, endPos, target, num
        dfs(0, 0, 0, target, num, sb, result);
        return result;
    }

    private void dfs(int pre, int start, int end, int target, String num, StringBuilder sb, List<String> result) {
        if (end == num.length()-1) {
            if (pre + Integer.valueOf(num.substring(start)) == target) {
                result.add(sb.append("+"+ num.substring(start)).toString());
            }

            if (pre * Integer.valueOf(num.substring(start)) == target) {
                result.add(sb.append("*"+ num.substring(start)).toString());
            }

            if (pre - Integer.valueOf(num.substring(start)) == target) {
                result.add(sb.append("-"+ num.substring(start)).toString());
            }
            return;
        }

        //not use this digit
        dfs(pre, start, end + 1, target, num, sb, result);

        int currVal = Integer.valueOf(num.substring(start, end + 1));
        //use as
        dfs(pre + currVal, end + 1, end + 1, target, num, sb, result);
        sb = removeDigits(sb, end - start + 1);
        dfs(pre - currVal, end + 1, end + 1, target, num, sb, result);
        sb = removeDigits(sb, end - start + 1);
        dfs(pre * currVal, end + 1, end + 1, target, num, sb, result);
        sb = removeDigits(sb, end - start + 1);
    }

    private StringBuilder removeDigits(StringBuilder sb, int num) {
        for (int i = 0; i < num; i++) {
            sb.deleteCharAt(sb.length()-1);
        }
        return sb;
    }
}