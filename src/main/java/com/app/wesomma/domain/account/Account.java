package com.app.wesomma.domain.account;

import com.app.wesomma.domain.institution.Institution;
import com.app.wesomma.domain.person.User;

import javax.persistence.*;

@Entity
@Table(name = "ACCOUNT")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String agency;
	
	private String number;
	
	private String name;
	
	private Double balance;
	
	@OneToOne
	private Institution institution;
	
	@OneToOne
	private AccountType accountType;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name = "joint_account")
	private boolean jointAccount;

	public Account() {}

	public Account(Integer id, String agency, String number, String name, Double balance, Institution institution, AccountType accountType, User user) {
		this.id = id;
		this.agency = agency;
		this.number = number;
		this.name = name;
		this.balance = balance;
		this.institution = institution;
		this.accountType = accountType;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isJointAccount() {
		return jointAccount;
	}

	public void setJointAccount(boolean jointAccount) {
		this.jointAccount = jointAccount;
	}
	
	
}
