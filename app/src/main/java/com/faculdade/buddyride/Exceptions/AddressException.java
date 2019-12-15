package com.faculdade.buddyride.Exceptions;

import com.faculdade.buddyride.Enums.EnumAddressException;

public class AddressException extends AbstractException {
    public AddressException(EnumAddressException code) {
        super(code);
    }
}
