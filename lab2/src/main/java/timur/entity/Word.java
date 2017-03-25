package timur.entity;

import java.util.ArrayList;
import java.util.List;

public class Word implements PartOfSentence, Comparable<Word> {

    private long id;
    private List<MyChar> chars;
    private boolean flag;

    public Word(List<MyChar> chars) {
        this.chars = chars;
    }


    public long getId() {

        return id;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int compareTo(Word o) {

        return toString().compareTo(o.toString());
    }

    @Override
    public String toString() {
        StringBuilder res  = new StringBuilder();
        for (MyChar l : chars)
            res.append(l.toString());
        return res.toString();
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        long result = 1;
        result = prime * result + id;
        result = prime * result + ((chars == null) ? 0 : chars.hashCode());
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
        Word other = (Word) obj;
        if (id != other.id)
            return false;
        if (chars == null) {
            if (other.chars != null)
                return false;
        } else if (!chars.equals(other.chars))
            return false;
        return true;
    }
}
