class Solution {
    class Info {
        int time;
        int amount;
        String city;
        public Info(int time, int amount, String city) {
            this.time = time;
            this.amount = amount;
            this.city = city;
        }
    }

    public List<String> invalidTransactions(String[] transactions) {

        //use hashMap
        //key: name, val: Info
        Map<String, List<Info>> map = new HashMap<>();
        List<String> res = new ArrayList<>();

        for (String t: transactions) {
            String[] info = t.split(",");
            if (!map.containsKey(info[0])) {
                map.put(info[0], new ArrayList<Info>());
            }
            map.get(info[0]).add(new Info(Integer.valueOf(info[1]), Integer.valueOf(info[2]), info[3]));
        }

        for (String t: transactions) {
            String[] info = t.split(",");
            if (Integer.valueOf(info[2]) > 1000) {
                res.add(t);
            } else {
                List<Info> lists = map.get(info[0]);
                for (int i = 0; i < lists.size(); i++) {
                    if (!lists.get(i).city.equals(info[3]) && (Math.abs(Integer.valueOf(info[1]) - lists.get(i).time) <= 60)) {
                        res.add(t);
                        break;
                    }
                }
            }
        }
        return res;
    }

}