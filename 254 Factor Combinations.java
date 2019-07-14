//method 1
class Solution {
    //traditional way, time exceeds, time complexity depends on value
    public List<List<Integer>> getFactors(int n) {
        //first step, get all its factors greater 1, smaller than n
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i * 2 <= n ; i++) {
            if (n % i == 0) {
                factors.add(i);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        //second step, use dfs to get the result
        dfs(result, temp, factors, 0, 1, n);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> temp, List<Integer> factors, int layer, int product, int res) {
        if (layer == factors.size()) {
            if (product == res && temp.size() > 0) {
                result.add(new ArrayList<>(temp));
            }
            return;
        }

        for (int i = 0; product * (int)Math.pow(factors.get(layer), i) <= res; i++) {
            for (int j = 0; j < i; j++) {
                temp.add(factors.get(layer));
            }
            dfs(result, temp, factors, layer + 1, product * (int)Math.pow(factors.get(layer), i), res);
            for (int j = 0; j < i; j++) {
                temp.remove(temp.size()-1);
            }
        }
    }
}

//method 2, a faster approach, only beats 14%
public List<List<Integer>> getFactors(int n) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    helper(result, new ArrayList<Integer>(), n, 2);
    return result;
}

public void helper(List<List<Integer>> result, List<Integer> item, int n, int start){
    if (n <= 1) {
        if (item.size() > 1) {
            result.add(new ArrayList<Integer>(item));
        }
        return;
    }

    for (int i = start; i <= n; ++i) {
        if (n % i == 0) {
            item.add(i);
            helper(result, item, n/i, i);
            item.remove(item.size()-1);
        }
    }
}

//method 3, optimize on the basis of method 2 beats 100%, saves a square
class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(result, new ArrayList<Integer>(), n, 2);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> item, int n, int lower) {
        //base case
        int limit = (int)Math.sqrt(n);
        for (int i = lower; i <= limit; i++) {
            if (n % i == 0) {
                item.add(i); //
                helper(result, item, n / i, i);
                item.add(n / i); // guarantees that total product is the target
                result.add(new ArrayList(item));
                item.remove(item.size()-1);
                item.remove(item.size()-1);
            }
        }
    }
}
