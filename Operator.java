enum Operator {
    DIVISION("/"),
    MULTIPLICATION("*"),
    SUM("+"),
    SUBTRACTION("-"),

    REMINDER_OF_DIVISION("%");

    private String textValue;

    Operator(String textValue) {
        this.textValue = textValue;
    }

    public String getTextValue() {
        return this.textValue;
    }

    public static Operator fromString(String text) {
        for (Operator enumValue : values()) {
            if (enumValue.getTextValue().equals(text)) {
                return enumValue;
            }
        }
        throw new NumberFormatException("Некорректный оператор: " + text);
    }
}