package cool.mipsgen;

public class CustomSTValue {
    final String value;

    public CustomSTValue(final String value) {
        this.value = value;
    }

    public String getLower() {
        return this.value.toLowerCase();
    }

    @Override
    public String toString() {
        return this.value.toString();
    }
}
