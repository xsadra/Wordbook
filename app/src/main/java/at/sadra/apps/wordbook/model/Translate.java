package at.sadra.apps.wordbook.model;


import lombok.Data;

@Data
public class Translate {
    private LanguageType language;
    private String word;
}
