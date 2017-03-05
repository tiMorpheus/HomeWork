package lab2;

import org.junit.Before;
import org.junit.Test;

import timur.entity.Sentence;
import timur.logic.Parser;
import timur.logic.Task1;
import timur.logic.Task2;
import timur.reader.MyReader;

import java.io.IOException;
import java.util.List;



public class Testing {

    static List<Sentence> sentences;
    Task1 task1;
    Task2 task2;

    @Before
    public void setUp() throws IOException {
        String text = MyReader.readFile("D:\\Text.txt");

        sentences = Parser.parse(text);

        task1 = new Task1();
        task2 = new Task2();


    }

    @Test
    public void test1(){
        task1.runTask(sentences);
    }

    @Test
    public void test2(){
        task2.runTask(sentences);
    }




}
