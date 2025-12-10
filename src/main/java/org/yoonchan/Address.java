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

    public Address(int streetNo, String street, String city, Province province, String postalCode) {
        if (!isPostalCodeValid(postalCode)) {
            this.streetNo = -1;
            this.street = null;
            this.city = null;
            this.province = null;
            this.postalCode = null;
        }

        this.streetNo = streetNo;
        this.street = street;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode.toUpperCase();
    }

    /**
     * Checks if a given postcode is valid.
     * The length of a postal code can only be 6.
     * The postcode must follow the format: 'CDCDCD', where C is a character and D is a digit.
     * (e.g. A1B2C3 -> true, AAB2C3 -> false)
     * @param postalCode The postal code to be checked.
     * @return Whether the postal code is valid.
     */
    public static boolean isPostalCodeValid(String postalCode) {
        if (postalCode == null || postalCode.length() != 6) {
            return false;
        }

        for (int i = 0; i < postalCode.length(); i++) {
            char c = postalCode.charAt(i);

            if (i % 2 == 0 && !Character.isLetter(c)) {
                return false;
            } else if (i % 2 == 1 && !Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
