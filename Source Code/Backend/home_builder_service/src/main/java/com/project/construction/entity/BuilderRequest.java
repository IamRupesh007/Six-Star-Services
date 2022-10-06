package com.project.construction.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "builder_request")
public class BuilderRequest {
	
	public BuilderRequest(Integer id, Date createDate, Date modifyDate, Status status, Date completionDate,
			EndUser customer, Builder builder) {
		super();
		this.id = id;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.status = status;
		this.completionDate = completionDate;
		this.customer = customer;
		this.builder = builder;
	}
	
	public BuilderRequest() {super();}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "create_date")
	private Date createDate;

	@Column(name = "modify_date")
	private Date modifyDate;

	@Enumerated(EnumType.STRING)
	private Status status;

	@Column(name = "completion_date")
	private Date completionDate;

	@ManyToOne
	@JoinColumn(name = "customer_user_id", referencedColumnName = "id")
	private EndUser customer;

	@ManyToOne
	@JoinColumn(name = "builder_id", referencedColumnName = "id")
	private Builder builder;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}

	public EndUser getCustomer() {
		return customer;
	}

	public void setCustomer(EndUser customer) {
		this.customer = customer;
	}

	public Builder getBuilder() {
		return builder;
	}

	public void setBuilder(Builder builder) {
		this.builder = builder;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.customer.getFirstName()+" "+this.builder.getBuilderName()+"'s request";
	}
	

}
