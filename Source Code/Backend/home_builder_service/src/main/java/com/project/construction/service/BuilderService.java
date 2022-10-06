package com.project.construction.service;

import com.project.construction.modal.BuilderModal;
import com.project.construction.modal.EndUserModal;

public interface BuilderService {

	public Integer createBuilder(BuilderModal builderModal, EndUserModal endUserModal, String password);
}
