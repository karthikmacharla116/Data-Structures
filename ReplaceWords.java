Problem Link: https://leetcode.com/problems/replace-words/description/?envType=daily-question&envId=2024-06-07

class ReplaceWords {
    public String replaceWords(List<String> dictionary, String sentence) {

        Collections.sort(dictionary, (s1,s2) -> Integer.compare(s1.length(), s2.length()));
        String[] sentences = sentence.split(" ");
        StringBuilder builder = new StringBuilder();

        boolean derivativeFound;
        for(String der: sentences) {
            derivativeFound = false;
            for(String root: dictionary) {
                if(der.startsWith(root)) {
                    builder.append(root+" ");
                    derivativeFound = true;
                    break;
                }
            }
            if(!derivativeFound) {
                builder.append(der+" ");
            }
            
        }
        return builder.toString().strip();

    }
}
