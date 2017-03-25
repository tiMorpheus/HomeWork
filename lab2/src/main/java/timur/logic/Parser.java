package timur.logic;

import org.apache.log4j.Logger;
import timur.entity.*;
import timur.reader.MyReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {


    public static List<Sentence> parse(String text){

        List<String> strings = parseToSentence(text);

        List<Sentence> sentences = new ArrayList<>();

        for (String sentence: strings){
            List<String> words = parseToWords(sentence);
            List<PartOfSentence> partOfSentences = new ArrayList<>();

            for (String word : words){

                char[] chars = parseToChars(word);
                List<MyChar> myChars = new ArrayList<>();
                for (char myChar: chars){
                    if (isPunctuation(myChar)){
                        partOfSentences.add(new Punctuation(myChar));
                    }
                    myChars.add(new MyChar(myChar));
                }

                partOfSentences.add(new Word(myChars));
            }

            sentences.add(new Sentence(partOfSentences));
        }

        return sentences;
    }

    public static List<String> parseToSentence(String text){
        List<String> strings = new ArrayList<>();

        Pattern p = Pattern.compile("[\"']?[A-Z][^.?!]+((?![.?!]['\"]?\\s[\"']?[A-Z][^.?!]).)+[.?!'\"]+");
        Matcher m = p.matcher(text);
        while (m.find()){
            strings.add(m.group());
        }
        return strings;
    }


    private static List<String> parseToWords(String sentence) {

        if (sentence == null) {
            throw new IllegalArgumentException();
        }

        String[] tempWords = sentence.split("\\s+");
        return Arrays.asList(tempWords);
    }

    private static char[] parseToChars(String word){
        if (word == null) {
            throw new IllegalArgumentException();
        }
        return word.toCharArray();
    }

    public static boolean isPunctuation(char symbol) {
        char [] punctuation = {'.' , ',' , ';' , ':', '?' , '!'};

        for (int i = 0; i < punctuation.length; i++){
            if(symbol == punctuation[i]){
                return true;
            }
        }
        return false;
    }
}