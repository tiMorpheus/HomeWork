package timur.logic;

import org.apache.log4j.Logger;
import timur.entity.Sentence;
import timur.entity.Word;

import java.util.List;

public class Task1 {
    public final static Logger LOGGER = Logger.getLogger(Task1.class);

    private static List<Sentence> sentences;

    private static int max;
    private static Word mword;

    public void runTask(List<Sentence> sentences) {
        LOGGER.trace("Task 1 is started");
        this.sentences = sentences;

        foundSentences();

        System.out.println("max - " + max
                + ", mword - \"" + mword + "\"");


    }

    private void foundSentences() {
        for (int i = 0; i < sentences.size(); i++) {
            List<Word> words = sentences.get(i).getWords();
            for (Word w : words) {
                if (w.isFlag()) {
                    check(sentences.subList(i, sentences.size()), w);
                }
            }
        }
    }

    private void check(List<Sentence> s, Word word) {
        int counter = 0;
        Word buff = null;

        for (Sentence sentence : s) {
            for (Word w : sentence.getWords()) {
                LOGGER.trace("Checking  " + w + " and " + word);

                if (word.toString().equalsIgnoreCase(w.toString())) {
                    counter++;
                    w.setFlag(false);
                    buff = w;

                    LOGGER.trace("Added " + w);
                    continue;
                }
            }
            if (counter > max) {
                max = counter;
                mword = buff;
            }
        }
    }
}
