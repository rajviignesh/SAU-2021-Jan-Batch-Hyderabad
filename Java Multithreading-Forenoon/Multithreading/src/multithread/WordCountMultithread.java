package multithread;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WordCountMultithread {

    private static int NoOfTheads = 10;

    public static void main(String[] args) throws IOException, InterruptedException {

        Path path = Paths.get("words.txt");
        List<String> fileData = Files.readAllLines(path);

        long startTime = System.currentTimeMillis();
        int lines = fileData.size();
        int chunkSize = lines / NoOfTheads;
        int prevIndex = 0;

        List<CountThread> threads = new ArrayList<>();

        for (int i = 1; i < NoOfTheads; i++) {
            List<String> chuck = fileData.subList(prevIndex, chunkSize * i);
            threads.add(new CountThread(chuck));
            prevIndex = chunkSize * i;
        }
        List<String> chunk = fileData.subList(prevIndex, lines);
        threads.add(new CountThread(chunk));

        for (CountThread t : threads) {
            t.start();
        }
        for (CountThread t : threads) {
            t.join();
        }

        List<Integer> TotalCount = getCount(threads);
        long endTime = System.currentTimeMillis();
        System.out.println("It took " + (endTime - startTime) + " milliseconds");
        System.out.println("Count {Words, Sentences, Paragraphs} with " + NoOfTheads + " Thread(s) : " + TotalCount);
    }

    private static List<Integer> getCount(List<CountThread> threads) {
        List<Integer> count = new ArrayList<>();
        Integer TotalWordCount = 0;
        Integer TotalParaCount = 0;
        Integer TotalSentenceCount = 0;
        for (CountThread t : threads) {
            TotalWordCount += t.getWordCount();
            TotalSentenceCount += t.getSentenceCount();
            TotalParaCount += t.getParagraphCount();
        }
        count.add(TotalWordCount);
        count.add(TotalSentenceCount);
        count.add(TotalParaCount + 1);
        return count;
    }
}
