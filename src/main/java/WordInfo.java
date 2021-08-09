public class WordInfo {
    private String value;
    private int count;

    public WordInfo(String word, int count){
        this.value =word;
        this.count =count;
    }


    public String getWord() {
        return this.value;
    }

    public int getWordCount() {
        return this.count;
    }


}
