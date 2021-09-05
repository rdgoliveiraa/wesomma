package com.app.wesomma.domain.group;


import com.app.wesomma.domain.person.User;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "FAMILY")
public class Family {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;

	@OneToOne
	private User leader;

	@OneToMany(cascade={CascadeType.ALL},mappedBy = "family")
	private List<User> users;


	public Family() {}

	public Family(Long id) {
		this.id = id;
	}

	public Family (Long id, String name, User leader, List<User> users) {
		this.id = id;
		this.name = name;
		this.leader = leader;
		this.users = users;
	}

	public Family(GroupDTO groupDTO) {
		if(groupDTO.getId() != null) {
			this.id = groupDTO.getId();
		}
		this.name = groupDTO.getName();
		this.leader = new User(groupDTO.getLeader());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUser(){ return users;}

	public void setPeople(List<User> users) {this.users = users;}

	public User getLeader() { return leader;}

	public void setLeader(User leader) {this.leader = leader;}

}
