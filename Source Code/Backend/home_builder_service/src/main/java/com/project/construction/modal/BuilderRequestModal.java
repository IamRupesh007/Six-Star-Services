package com.project.construction.modal;

import java.sql.Date;

import com.project.construction.entity.BuilderRequest;
import com.project.construction.entity.Status;


public class BuilderRequestModal {
	
	public BuilderRequestModal() {
		super();
	}

	private Integer id;

	private Date createDate;

	private Date modifyDate;

	private Status status;

	private Date completionDate;

	private Integer customerId;

	private Integer builderId;

	public BuilderRequestModal(Integer id, Date createDate, Date modifyDate, Status status, Date completionDate,
			Integer customerId, Integer builderId) {
		super();
		this.id = id;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.status = status;
		this.completionDate = completionDate;
		this.customerId = customerId;
		this.builderId = builderId;
	}

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

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getBuilderId() {
		return builderId;
	}

	public void setBuilderId(Integer builderId) {
		this.builderId = builderId;
	}

	public static BuilderRequestModal getModalFromEntity(BuilderRequest builderRequestEntity) {
		return new BuilderRequestModal(builderRequestEntity.getId(), builderRequestEntity.getCreateDate(),
				builderRequestEntity.getModifyDate(), builderRequestEntity.getStatus(),
				builderRequestEntity.getCompletionDate(), builderRequestEntity.getCustomer().getId(),
				builderRequestEntity.getBuilder().getId());
	}

	public static BuilderRequest getEntityFromModal(BuilderRequestModal builderRequestModal) {
		return new BuilderRequest(builderRequestModal.getId(), builderRequestModal.getCreateDate(),
				builderRequestModal.getModifyDate(), builderRequestModal.getStatus(),
				builderRequestModal.getCompletionDate(), null, null);
	}

}
