class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        HashMap<Character, Integer> map =new HashMap<>();
        for(int i = 0 ; i < n; i++) {
            char c = s.charAt(i);
            map.put(c,i);
        }
        List<Integer> list = new ArrayList<>();
        int size = 0;
        int end = 0;
        for(int i = 0 ; i < n ; i++) {
            char c = s.charAt(i);
            end = Math.max(end, map.get(c));
            size++;
            if(i==end) {
                list.add(size);
                size=0;
            }
        }
        return list;
    }
}
