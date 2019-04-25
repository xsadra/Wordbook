package at.sadra.apps.wordbook.model;

import androidx.annotation.Nullable;

import java.time.LocalDate;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DateInfo {
    private LocalDate createDate;
    @Nullable
    private LocalDate modifyDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateInfo dateInfo = (DateInfo) o;
        return createDate.equals(dateInfo.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createDate, modifyDate);
    }
}
