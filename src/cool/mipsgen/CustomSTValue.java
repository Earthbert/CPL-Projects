package cool.mipsgen;

public class CustomSTValue {
	final String value;

	public CustomSTValue(final String value) {
		this.value = value;
	}

	public String getLower() {
		return this.value.toLowerCase();
	}

	public Boolean isZero() {
		return "0".equals(this.value);
	}

	public String getInstruction() {
		return switch (this.value) {
            case "+" -> "add";
            case "-" -> "sub";
            case "*" -> "mul";
            case "/" -> "div";
            case "==" -> "beq";
            case "<" -> "blt";
            case "<=" -> "ble";
            default -> "";
        };
	}

	@Override
	public String toString() {
		return this.value.toString();
	}
}
