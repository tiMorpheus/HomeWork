package timur.logic;

import org.apache.log4j.Logger;
import timur.entity.Sentence;

import java.util.Collections;
import java.util.List;

public class Text {
    private  List<Sentence> sentences;
    private int counter = 0;
    public final static Logger LOGGER = Logger.getLogger(Text.class);


    public void runTask(List<Sentence> sentences) {
        this.sentences = sentences;
        sortByWordsAmount();
    }


    private void sortByWordsAmount() {

        LOGGER.trace("Text started to sort...");

        Collections.sort(sentences);
        for (Sentence s : sentences) {
            LOGGER.trace("sentence " + counter++ + ": \n" + s + "\n amount of words :" + s.getWords().size());
        }
    }
}
