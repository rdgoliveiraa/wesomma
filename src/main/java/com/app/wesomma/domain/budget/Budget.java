package com.app.wesomma.domain.budget;

import com.app.wesomma.domain.group.Family;
import com.app.wesomma.domain.income.Income;
import com.app.wesomma.domain.person.User;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "BUDGET")
public class Budget {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;
	
	private Double expectedValue;

	private Double realizedValue;
	
	private Boolean reminder;

	private Boolean open;
	
	private Date period;

	public Budget(){}

	public Budget(String name, Double expectedValue, Double realizedValue, Boolean open, Family family, User user){
		this.name = name;
		this.expectedValue = expectedValue;
		this.realizedValue = realizedValue;
		this.open = open;
		this.family = family;
		this.user = user;
	}
	
	@ManyToOne
	@JoinColumn(name = "family_id")
	private Family family;
	
	@OneToOne
	private User user;

	@OneToMany(mappedBy = "budget", targetEntity = BudgetCategory.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<BudgetCategory> budgetCategories;

	@OneToMany
	@Column(name = "id_income")
	private List<Income> incomes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getExpectedValue() {
		return expectedValue;
	}

	public void setExpectedValue(Double expectedValue) {
		this.expectedValue = expectedValue;
	}

	public Boolean getReminder() {
		return reminder;
	}

	public void setReminder(Boolean reminder) {
		this.reminder = reminder;
	}

	public Date getPeriod() {
		return period;
	}

	public void setPeriod(Date period) {
		this.period = period;
	}

	public List<BudgetCategory> getBudgetCategories() {
		return budgetCategories;
	}

	public void setBudgetCategories(List<BudgetCategory> budgetCategories) {
		this.budgetCategories = budgetCategories;
	}

	public List<Income> getIncomes() {
		return incomes;
	}

	public void setIncomes(List<Income> incomes) {
		this.incomes = incomes;
	}


	public Double getRealizedValue() {
		return realizedValue;
	}

	public void setRealizedValue(Double realizedValue) {
		this.realizedValue = realizedValue;
	}

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public Family getFamily() { return family;	}

	public void setFamily(Family family) { this.family = family; }

	public User getUser() { return user; 	}

	public void setUser(User user) { this.user = user; }

	public Boolean isOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}
}
