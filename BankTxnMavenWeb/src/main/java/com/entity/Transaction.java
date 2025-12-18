package com.entity;

import java.util.Date;

public class Transaction {

    private long id;
    private String corporateId;
    private String uniqueId;
    private String beneficiaryName;
    private String accountNumber;
    private String ifsc;
    private String bankName;
    private double amount;
    private String currency;
    private String transactionType;
    private String transactionStatus;
    private String channel;
    private String remarks;
    private String createdBy;
    private Date createdDate;
    private Date updatedDate;
	
    public Transaction() {

	}

	public Transaction(long id, String corporateId, String uniqueId, String beneficiaryName, String accountNumber,
			String ifsc, String bankName, double amount, String currency, String transactionType,
			String transactionStatus, String channel, String remarks, String createdBy, Date createdDate,
			Date updatedDate) {
		super();
		this.id = id;
		this.corporateId = corporateId;
		this.uniqueId = uniqueId;
		this.beneficiaryName = beneficiaryName;
		this.accountNumber = accountNumber;
		this.ifsc = ifsc;
		this.bankName = bankName;
		this.amount = amount;
		this.currency = currency;
		this.transactionType = transactionType;
		this.transactionStatus = transactionStatus;
		this.channel = channel;
		this.remarks = remarks;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCorporateId() {
		return corporateId;
	}

	public void setCorporateId(String corporateId) {
		this.corporateId = corporateId;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", corporateId=" + corporateId + ", uniqueId=" + uniqueId
				+ ", beneficiaryName=" + beneficiaryName + ", accountNumber=" + accountNumber + ", ifsc=" + ifsc
				+ ", bankName=" + bankName + ", amount=" + amount + ", currency=" + currency + ", transactionType="
				+ transactionType + ", transactionStatus=" + transactionStatus + ", channel=" + channel + ", remarks="
				+ remarks + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate
				+ "]";
	}
    
    


}
