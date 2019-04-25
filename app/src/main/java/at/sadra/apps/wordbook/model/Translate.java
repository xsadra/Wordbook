package at.sadra.apps.wordbook.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Translate {
    private LanguageType language;
    private String word;
}
