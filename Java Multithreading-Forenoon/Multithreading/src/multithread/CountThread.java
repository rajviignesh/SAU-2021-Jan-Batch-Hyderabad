package multithread;

import java.util.List;

public class CountThread extends Thread {

    private List<String> str;
    int countWord = 0;
    int sentenceCount = 0;
    int paragraphCount = 0;

    CountThread(List<String> str){
        this.str = str;
    }

    @Override
    public void run(){
        for(String line : str){
            if(line.equals(""))
            {
                paragraphCount++;
            } else {
                String[] wordList = line.split("\\s+");
                countWord += wordList.length;
                String[] sentenceList = line.split("[!?.:]+");
                sentenceCount += sentenceList.length;
            }
        }
    }

    public int getWordCount(){
        return countWord;
    }
    public int getSentenceCount(){
        return sentenceCount;
    }
    public int getParagraphCount(){
        return paragraphCount;
    }

}
