package at.kaindorf.springburger.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {
    private String id;
    private String name;
    private Type type;

    public static enum Type {
        PATTY, VEGGIE, CHEESE;
    }
}
