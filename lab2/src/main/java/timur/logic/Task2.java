package timur.logic;

import org.apache.log4j.Logger;
import timur.entity.Sentence;

import java.util.Collections;
import java.util.List;

public class Task2 {
    private  List<Sentence> sentences;
    private int counter = 0;
    public final static Logger LOGGER = Logger.getLogger(Task2.class);


    public void runTask(List<Sentence> sentences) {
        LOGGER.trace("Task2 started");

        this.sentences = sentences;
        LOGGER.trace(sentences.size());
        sortByWordsAmount();

        LOGGER.trace("Task2 finished");

    }


    private void sortByWordsAmount() {

        LOGGER.trace("Task2 started to sort...");

        Collections.sort(sentences);
        for (Sentence s : sentences) {
            LOGGER.trace("sentence " + counter++ + ": \n" + s + "\n amount of words :" + s.getWords().size());
        }
    }
}
