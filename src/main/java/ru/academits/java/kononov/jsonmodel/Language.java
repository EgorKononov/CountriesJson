package ru.academits.java.kononov.jsonmodel;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Language {
    private String iso639_1;
    private String iso639_2;
    private String name;
    private String nativeName;
}
