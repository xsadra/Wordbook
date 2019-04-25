package at.sadra.apps.wordbook.model.wordform;

import lombok.Data;

@Data
public class Noun implements WordData {
    private Article article;
    private String plural;
}
