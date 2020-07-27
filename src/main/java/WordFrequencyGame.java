import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.io.CharArrayWriter;

import java.time.LocalDateTime;

public class WordFrequencyGame {
    public String getResult(String inputStr) {

        String[] words = inputStr.split("\\s+");

        Map<String, Integer> wordsMap = getWordsMap(words);

        List<Input> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry :wordsMap.entrySet()) {
            Input input = new Input(entry.getKey(), entry.getValue());
            list.add(input);
        }
        list.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());

        StringJoiner joiner = new StringJoiner("\n");
        for (Input w : list) {
            String s = w.getValue() + " " + w.getWordCount();
            joiner.add(s);
        }
        return joiner.toString();
        
    }

    private Map<String, Integer> getWordsMap(String[] words) {
        Map<String,Integer> wordsMap = new HashMap<>();
        for( String word: words){
            if(wordsMap.containsKey(word)){
                wordsMap.put(word,wordsMap.get(word)+1);
            }else {
                wordsMap.put(word,1);
            }
        }
        return wordsMap;
    }

    private Map<String, List<Input>> getListMap(List<Input> inputList) {
        Map<String, List<Input>> map = new HashMap<>();
        for (Input input : inputList) {
//       map.computeIfAbsent(input.getValue(), k -> new ArrayList<>()).add(input);
            if (!map.containsKey(input.getValue())) {
                ArrayList arr = new ArrayList<>();
                arr.add(input);
                map.put(input.getValue(), arr);
            } else {
                map.get(input.getValue()).add(input);
            }
        }
        return map;
    }
}
