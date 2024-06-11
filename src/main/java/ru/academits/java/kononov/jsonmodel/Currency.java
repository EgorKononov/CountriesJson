package ru.academits.java.kononov.jsonmodel;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Currency {
    private String code;
    private String name;
    private String symbol;
}
