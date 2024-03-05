package com.example.val_ex_training_spring.service;

import java.util.ArrayList;
import java.util.Optional;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.val_ex_training_spring.entity.RoleEntity;
import com.example.val_ex_training_spring.repository.RoleRepository;

@Service
public class RoleService {
    private final RoleRepository roleRepo;

    @Autowired
    public RoleService(RoleRepository rolerepos) {
        this.roleRepo=rolerepos;
    }


public boolean saveRole(RoleEntity role) 
{
    RoleEntity rolee=roleRepo.save(role);
    if (rolee!=null) {return true;}return false;
}

public boolean deleteRole(RoleEntity role)
{
    roleRepo.delete(role);
    if(roleRepo.findAll().contains(role)) {return false;}return true;

}

public Optional<RoleEntity> findById(Long id) 
{
    Optional<RoleEntity> role=roleRepo.findById(id);
    return role;

}
public List findAllRoles(){
    List roles=(List) roleRepo.findAll();
    return roles;
}
public void updateRole(Long id,String name,String description) 
{
    RoleEntity role=roleRepo.findById(id).orElseThrow();
    role.setDescription(description);
    role.setName(name);



}
}