package org.yoonchan;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@Getter
@Setter
@ToString
public class Address {
    private int streetNo;
    private String street;
    private String city;
    private Province province;
    private String postalCode;
}
