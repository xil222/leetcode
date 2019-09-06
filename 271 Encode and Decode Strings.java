public class Codec {
    //I think there are some issues with this problem by default empty arrayList
    //will be converted to "" for s. And will give a default term for decode
    //so we can only iterate array.length - 1

    // Double hashing trick, hash a character ',' to ',,'
    // then add ' , ' to split all strings
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuffer out = new StringBuffer();
        for (String s : strs)
            out.append(s.replace("#", "##")).append(" # ");
        return out.toString();
    }

    // Just reverse what have been done in the encoding process
    // first split by " , " --> then readd replace ,, with ,
    // add back to result arrayList
    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List strs = new ArrayList();
        String[] array = s.split(" # ", -1);
        for (int i=0; i<array.length-1; ++i)
            strs.add(array[i].replace("##", "#"));
        return strs;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));