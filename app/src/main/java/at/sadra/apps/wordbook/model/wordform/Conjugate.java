package at.sadra.apps.wordbook.model.wordform;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Conjugate {
    private String ich;
    private String du;
    private String erSieEs;
    private String wir;
    private String ihr;
    private String sie;
}
