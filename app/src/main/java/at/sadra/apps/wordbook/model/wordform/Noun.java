package at.sadra.apps.wordbook.model.wordform;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Noun implements WordData {
    private Article article;
    private String plural;
}
