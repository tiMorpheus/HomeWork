package lab2;

import org.junit.Before;
import org.junit.Test;

import timur.entity.Sentence;
import timur.logic.Parser;
import timur.logic.Text;
import timur.reader.MyReader;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class Testing {

    List<Sentence> sentences;

    Text task2;

    @Before
    public void setUp() throws IOException {
        String text = MyReader.readFile("D:\\Text.txt");



        task2 = new Text();

        sentences = Parser.parse(text);


    }

    @Test
    public void test2(){
        task2.runTask(sentences);

        assertEquals(5, sentences.size());
    }


}
