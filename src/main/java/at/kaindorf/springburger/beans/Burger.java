package at.kaindorf.springburger.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Burger {
    private String name;
    private List<String> ingredients;

}
