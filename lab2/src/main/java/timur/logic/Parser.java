package timur.logic;

import timur.entity.PartOfSentence;
import timur.entity.Punctuation;
import timur.entity.Sentence;
import timur.entity.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Parser {
    public static List<Sentence> parse(String text) {
        List<Sentence> sentences = new ArrayList<Sentence>();
        List<PartOfSentence> parts = new ArrayList<PartOfSentence>();
        StringTokenizer st = new StringTokenizer(text, " \t\n\r:;.!?,/\\|\"\'",
                true);

        while (st.hasMoreTokens()) {
            String s = st.nextToken().trim();
            int size = s.length();
            if (size < 1)
                continue;
            if (size == 1) {
                switch (s.charAt(0)) {
                    case ' ':
                        continue;
                    case ',':
                    case ';':
                    case ':':
                    case '\'':
                    case '\"':
                        parts.add(new Punctuation(s.charAt(0)));
                        break;
                    case '.':
                    case '?':
                    case '!':
                        parts.add(new Punctuation(s.charAt(0)));
                        Sentence buf = new Sentence(parts);
                        if (buf.getWords().size() != 0) {
                            sentences.add(buf);
                            parts = new ArrayList<PartOfSentence>();
                        } else
                            parts.add(new Punctuation(s.charAt(0)));
                        break;
                    default:
                        parts.add(new Word(s.toCharArray()));
                }

            } else {
                parts.add(new Word(s.toCharArray()));
            }
        }
        return sentences;

    }

}