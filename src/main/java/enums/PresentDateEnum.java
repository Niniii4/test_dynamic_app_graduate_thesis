package enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PresentDateEnum {

    PRESENT_DATE("presentDate");

    private final String text;

    @Override
    public String toString() {
        return text;
    }

}
