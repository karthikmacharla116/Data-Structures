package dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Using Trie Data Structure
 */
public class DesignSearchAutoCompletionSystem {

    public static void main(String[] args) {
        String[] sentences = {"i love you", "island", "i ronman", "i love leetcode"};
        int[] times = {5, 3, 2, 2};
        SearchAutoCompletion searchAutoCompletion = new SearchAutoCompletion(sentences, times);
        List<String> resForI = searchAutoCompletion.input('i');
        List<String> resForI2 = searchAutoCompletion.input(' ');
        List<String> resForI3 = searchAutoCompletion.input('l');
        System.out.println(resForI);
        System.out.println(resForI2);
        System.out.println(resForI3);
    }

}

class SearchAutoCompletion {
    private String[] sentences;
    private int[] times;
    private StringBuilder searchChars;
    public Node root;

    public SearchAutoCompletion(String[] sentences, int[] times) {
        this.sentences = sentences;
        this.times = times;
        this.searchChars = new StringBuilder();
        this.root = new Node();
        this.insert(sentences);
    }

    /**
     * returns the top 3 hot sentences as suggestion for search
     */
    public List<String> input(char ch) {
        searchChars.append(ch);
        return searchRecommendations(searchChars.toString());
    }

    private List<String> searchRecommendations(String search) {
        Node node = root;
        List<Integer> resultIncices;
        //Step 1: Start searching the trie for the input string characters
        for (int i = 0;i < search.length();i++) {
            if(!node.containsKey(search.charAt(i))) {
                break;
            }
            node = node.get(search.charAt(i));
        }
        resultIncices = node.getSentenceIndices();
        System.out.println("search results for "+search +" "+resultIncices);

        return sortSearchResultsByTimes(resultIncices);
    }

    /**
     * Sorting the result strings based on max search times
     * If two strings have same maxTime, then sorting by lexicographical order
     * Using MinHeap DataStructure
     */
    private List<String> sortSearchResultsByTimes(List<Integer> resultIncices) {
        List<String> searchResultsList = new ArrayList<>();

        PriorityQueue<Integer> hotSentencesHeap = new PriorityQueue<>((i1, i2) -> {
            if(times[i1] == times[i2])
                return sentences[i2].compareTo(sentences[i1]);
            return Integer.compare(times[i1], times[i2]);
        });

        for(Integer index : resultIncices) {
            hotSentencesHeap.add(index);
            if(hotSentencesHeap.size() > 3) {
                hotSentencesHeap.poll();
            }
        }
        int index = hotSentencesHeap.size();
        System.out.println("Heap "+ hotSentencesHeap);
        while(index >= 0 && !hotSentencesHeap.isEmpty()) {
            searchResultsList.add(0, sentences[hotSentencesHeap.poll()]);
            index--;
        }

        return searchResultsList;
    }

    private void insert(String[] sentences) {
        Node node;
        for(int sentenceIndex = 0;sentenceIndex < sentences.length;sentenceIndex++) {
            node = root;
            for(int i = 0;i < sentences[sentenceIndex].length();i++) {
                char ch = sentences[sentenceIndex].charAt(i);
                if(!node.containsKey(ch) ) {
                    node.addNode(ch, new Node());
                }
                node = node.get(ch);
                node.addSentenceIndex(sentenceIndex);
            }
        }
    }
}

class Node {
    private Node[] link;
    private List<Integer> sentenceIndices;

    public Node() {
        this.link = new Node[27];
        this.sentenceIndices = new ArrayList<>();
    }

    public boolean containsKey(char ch) {
        if(ch == ' ')
            return this.link[26] != null;
        return this.link[ch - 'a'] != null;
    }

    public void addNode(char ch, Node node) {
        if (ch == ' ') {
            this.link[26] = node;
        } else {
            this.link[ch - 'a'] = node;
        }
    }

    public void addSentenceIndex(int sentenceIndex) {
        this.sentenceIndices.add(sentenceIndex);
    }

    public List<Integer> getSentenceIndices() {
        return this.sentenceIndices;
    }

    @Override
    public String toString() {
        return "Node{" +
                "link=" + Arrays.toString(link) +
                ", sentenceIndices=" + sentenceIndices +
                '}';
    }

    public Node get(char ch) {
        if(ch == ' ')
            return this.link[26];
        return this.link[ch - 'a'];
    }
}
/**
 * console output:
 * search results for i [0, 1, 2, 3]
 * Heap [3, 0, 1]
 * search results for i  [0, 2, 3]
 * Heap [2, 0, 3]
 * search results for i l [0, 3]
 * Heap [3, 0]
 * [i love you, island, i love leetcode]
 * [i love you, i love leetcode, i ronman]
 * [i love you, i love leetcode]
 */
