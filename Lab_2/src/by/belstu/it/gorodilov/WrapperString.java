package by.belstu.it.gorodilov;

import java.util.Objects;

public class WrapperString {
    public String example;

    @Override
    public String toString() {
        return "WrapperString{" +
                "example='" + example + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WrapperString that = (WrapperString) o;
        return Objects.equals(example, that.example);
    }

    @Override
    public int hashCode() {
        return Objects.hash(example);
    }

    public WrapperString(String example) {
        this.example = example;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public void replace(char oldChar, char newChar) {
        example.replace(oldChar, newChar);
    }
}
