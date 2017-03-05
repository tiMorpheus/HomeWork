package timur.entity;

import java.util.*;

public class Sentence implements Comparable<Sentence> {

    private long id;
    private List<PartOfSentence> parts;

    public Sentence(List<PartOfSentence> parts) {
        this.parts = parts;
    }

    public long getId() {
        return id;
    }

    public List<Word> getWords() {
        List<Word> words = new ArrayList<>();

        for (PartOfSentence p : parts) {
            if (p instanceof Word) {
                words.add((Word) p);
            }
        }

        return words;
    }


    @Override
    public int compareTo(Sentence o) {
        return getWords().size() - o.getWords().size();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < parts.size(); i++) {
            if (!(parts.get(i) instanceof Punctuation)) {
                res.append(" ");
            }
            res.append(parts.get(i).toString().trim());
        }

        return res.toString().trim();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        long result = 1;
        result = prime * result + id;
        result = prime * result + ((parts == null) ? 0 : parts.hashCode());
        return (int) result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Sentence other = (Sentence) obj;
        if (id != other.id)
            return false;
        if (parts == null) {
            if (other.parts != null)
                return false;
        } else if (!parts.equals(other.parts))
            return false;
        return true;
    }
}
