import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyGame {
    public static final String BLANK_SPACE = "\\s+";

    public String getResult(String sentence){

        if (sentence.split(BLANK_SPACE).length==1) {
            return sentence + " 1";
        }
        try {
            List<WordInfo> wordFrequencies = calculateWordFrequency(sentence);
            return consolidateWordFrequencies(wordFrequencies);
        } catch (Exception e) {
            return "Calculate Error";
        }
    }

    private List<WordInfo> calculateWordFrequency(String sentence) {
        List<String> words = Arrays.asList(sentence.split(BLANK_SPACE));
        List<String> distinctWords = words.stream().distinct().collect(Collectors.toList());

        List<WordInfo> wordInfos = new ArrayList<>();
        distinctWords.forEach(distinctWord -> {
            int count = (int) words.stream().filter(word -> word.equals(distinctWord)).count();
            WordInfo wordInfo = new WordInfo (distinctWord, count);
            wordInfos.add(wordInfo);
        });
        return wordInfos;
    }

    private String consolidateWordFrequencies(List<WordInfo> wordFrequencies) {
        return wordFrequencies
                .stream()
                .sorted((firstWord, secondWord) -> secondWord.getWordCount() - firstWord.getWordCount())
                .map(word -> word.getWord() + " " + word.getWordCount())
                .collect(Collectors.joining("\n"));
    }
}
