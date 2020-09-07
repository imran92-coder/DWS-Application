package com.db.awmd.challenge.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferDto {
    @NotNull
    @NotEmpty
    private String accountToId;
    @NotNull
    @NotEmpty
    private String accountFromId;
    @NotNull
    @Min(value = 1, message = "amount tranferred should not be zero")
    private BigDecimal amount;
	public String getAccountToId() {
		return accountToId;
	}
	public void setAccountToId(String accountToId) {
		this.accountToId = accountToId;
	}
	public String getAccountFromId() {
		return accountFromId;
	}
	public void setAccountFromId(String accountFromId) {
		this.accountFromId = accountFromId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
