package ru.thuggeelya.server.data;

import jakarta.persistence.*;

@NamedNativeQuery(name = "Account.getBalance",
        query = "SELECT a.amount as amount FROM Account a WHERE id = :id",
        resultSetMapping = "Mapping.AccountDto")
@SqlResultSetMapping(name = "Mapping.AccountDto",
        classes = @ConstructorResult(
                targetClass = AccountDto.class,
                columns = {
                        @ColumnResult(name = "id", type = Long.class),
                        @ColumnResult(name = "amount", type = Long.class)
                }))
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "amount", nullable = false)
    private Long amount;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}