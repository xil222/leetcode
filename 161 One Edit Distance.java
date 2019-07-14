class Solution {
    //this problem is looking for exactly one distance
    //99%, time complexity is O(min(n,m))
    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        int i = 0;
        while (i < Math.min(s.length(),t.length())) {
            if (s.charAt(i) == t.charAt(i)) i++;
            else break;
        }
        if (i == s.length() && i == t.length()) {
            return false;
        }

        return isSame(s, t, i, i+1) || isSame(s, t, i+1, i) || isSame(s, t, i+1, i+1);
    }

    private boolean isSame(String s, String t, int a, int b) {
        //first check corner case
        if (a == s.length() && b == t.length()) {
            return true;
        } else if (a == s.length() || b == t.length()) {
            return false;
        }
        while (a < s.length() && b < t.length()) {
            if (s.charAt(a) != t.charAt(b)) {
                return false;
            }
            a++;
            b++;
        }
        if (a == s.length() && b == t.length()) {
            return true;
        }
        return false;
    }
}

class Solution {
    //this problem is looking for exactly one distance
    public boolean isOneEditDistance(String s, String t) {
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) // s has the same length as t, so the only possibility is replacing one char in s and t
                    return s.substring(i + 1).equals(t.substring(i + 1));
                else if (s.length() < t.length()) // t is longer than s, so the only possibility is deleting one char from t
                    return s.substring(i).equals(t.substring(i + 1));
                else // s is longer than t, so the only possibility is deleting one char from s
                    return t.substring(i).equals(s.substring(i + 1));
            }
        }
        //All previous chars are the same, the only possibility is deleting the end char in the longer one of s and t
        return Math.abs(s.length() - t.length()) == 1;
    }
}

//second time
class Solution {
    public boolean isOneEditDistance(String s, String t) {
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length())
                    return s.substring(i + 1).equals(t.substring(i + 1));
                else if (s.length() < t.length())
                    return s.substring(i).equals(t.substring(i + 1));
                else
                    return s.substring(i + 1).equals(t.substring(i));
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
    }
}

//if allow distance 0/1
class Solution {
    public boolean isOneEditDistance(String s, String t) {
        //just add a condition of two strings are the same at the beginning
        if (s.equals(t)) {
            return true;
        }
        //later on, all the same thing
    }
}

//the most safeway is using dynamic programming, O(mn) time complexity
//i think the distance 2,3,N is not that good

