package at.sadra.apps.wordbook.model.wordform;

import lombok.Data;

@Data
public class Verb implements WordData{
    private Conjugate present;
    private Perfect Perfect;
    private Conjugate Imperfect;
    private Conjugate SubjunctiveI;
    private Conjugate SubjunctiveII;
    private Conjugate Imperative;
}
