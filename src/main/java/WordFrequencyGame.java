import java.util.*;
import java.util.stream.Collectors;

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

        return getFrequencyResult(list);

    }

    private String getFrequencyResult(List<Input> list) {

       return list.stream()
                .map(input -> String.format("%s %d",input.getValue(),input.getWordCount()))
                .collect(Collectors.joining("\n"));

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


}
