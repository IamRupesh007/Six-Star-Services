package com.project.construction.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.construction.entity.Builder;
import com.project.construction.entity.EndUser;
import com.project.construction.modal.BuilderModal;
import com.project.construction.modal.EndUserModal;
import com.project.construction.repository.BuilderRepository;
import com.project.construction.repository.EndUserRepository;
import com.project.construction.service.BuilderService;
import com.project.construction.service.EndUserService;

@Service
public class BuilderServiceImpl implements BuilderService {
	
	@Autowired
	private EndUserService endUserService;

	@Autowired
	private EndUserRepository endUserRepository;
	
	@Autowired
	private BuilderRepository builderRepository;

	@Override
	public Integer createBuilder(BuilderModal builderModal, EndUserModal endUserModal, String password) {
		Integer id = endUserService.createUser(endUserModal, password);
		Optional<EndUser> opEn = endUserRepository.findById(id);
		EndUser user = null;
		if (opEn.isPresent()) {
			user = opEn.get();
		}
		Builder b = BuilderModal.getEntityFromModal(builderModal);
		b.setUser(user);
		
		return builderRepository.save(b).getId();
	}

}
