package timur.entity;

public class MyChar {
    private static long counter;
    private long id;
    private char l;

    public MyChar(char l) {
        this.l = l;
        id = counter++;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.valueOf(l);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        long result = 1;
        result = prime * result + id;
        result = prime * result + l;
        return (int) result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        MyChar other = (MyChar) o;
        if (id != other.id)
            return false;
        if (l != other.l)
            return false;
        return true;
    }


}
