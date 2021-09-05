package com.app.wesomma.domain.goal;

import com.app.wesomma.domain.person.User;
import com.app.wesomma.domain.transaction.Transaction;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "GOAL")
public class Goal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne
	private GoalType goalType;

	private Double totalValue;
	
	private Double currentValue;
	
	private String description;
	
	@OneToMany
	private List<Transaction> transaction;

	@OneToOne
	private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public GoalType getGoalType() {
		return goalType;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public Double getCurrentValue() {
		return currentValue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getPerson() { return user; }

	public void setPerson(User user) { this.user = user; }

	public void setGoalType(GoalType goalType) {
		this.goalType = goalType;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public void setCurrentValue(Double currentValue) {
		this.currentValue = currentValue;
	}

	public List<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
