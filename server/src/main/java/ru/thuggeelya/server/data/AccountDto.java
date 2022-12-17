package ru.thuggeelya.server.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class AccountDto implements Serializable {
    private final Long id;
    private final Long amount;
}
