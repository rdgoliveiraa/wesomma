package com.app.wesomma.domain.budget;

import com.app.wesomma.domain.category.Category;

import javax.persistence.*;

@Entity
@Table(name = "BUDGET_CATEGORY")
public class BudgetCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Double expectedValue;

	private Double realizedValue;

	@OneToOne
	private Category category;

	@OneToOne
	private TypeBudget typeBudget;

	@ManyToOne
	@JoinColumn(name="budget_id")
	private Budget budget;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public Double getExpectedValue() {
		return expectedValue;
	}

	public void setExpectedValue(Double expectedValue) {
		this.expectedValue = expectedValue;
	}

	public Double getRealizedValue() {
		return realizedValue;
	}

	public void setRealizedValue(Double realizedValue) {
		this.realizedValue = realizedValue;
	}

	public Category getCategory() { return category; }

	public void setCategory(Category category) { this.category = category; }

	public Budget getBudget() {
		return budget;
	}

	public void setBudget(Budget budget) {
		this.budget = budget;
	}

	public TypeBudget getTypeBudget() {
		return typeBudget;
	}

	public void setTypeBudget(TypeBudget typeBudget) {
		this.typeBudget = typeBudget;
	}
}
