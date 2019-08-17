class Solution {
    Map<String, List<Integer>> map = new HashMap<>();
    //idea is split using operators
    //split into different parts at each operator
    public List<Integer> diffWaysToCompute(String input) {
        if (map.containsKey(input)) {
            return map.get(input);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                String p1 = input.substring(0, i);
                String p2 = input.substring(i + 1);
                List<Integer> part1 = diffWaysToCompute(p1);
                List<Integer> part2 = diffWaysToCompute(p2);
                for (Integer item1: part1) {
                    for (Integer item2: part2) {
                        int val = 0;
                        if (input.charAt(i) == '+') {
                            val = item1 + item2;
                        } else if (input.charAt(i) == '-') {
                            val = item1 - item2;
                        } else {
                            val = item1 * item2;
                        }
                        res.add(val);
                    }
                }
            }
        }

        //if res still has size 0. means input is number
        if (res.size() == 0) {
            res.add(Integer.valueOf(input));
        }
        map.put(input, res);
        return res;
    }
}