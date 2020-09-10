package com.bupt.trainbookingsystem.service.imp;

import com.bupt.trainbookingsystem.annotation.Operation;
import com.bupt.trainbookingsystem.annotation.OperationLogDetail;
import com.bupt.trainbookingsystem.dao.OrdinaryUserRepository;
import com.bupt.trainbookingsystem.entity.OrdinaryUserEntity;
import com.bupt.trainbookingsystem.enums.OperationType;
import com.bupt.trainbookingsystem.enums.OperationUnit;
import com.bupt.trainbookingsystem.service.OrdinaryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdinaryUserServiceImp implements OrdinaryUserService {
    @Autowired
    OrdinaryUserRepository ordinaryUserRepository;

    @OperationLogDetail(detail = "通过账号登录",level = 3,operationType = OperationType.SELETE,operationUnit = OperationUnit.USER)
    @Override
    public OrdinaryUserEntity checkuser(String name, String password) {
        OrdinaryUserEntity ordinaryuser=ordinaryUserRepository.TrygetUser(name,password);
        return ordinaryuser;
    }

    @Override
    public OrdinaryUserEntity getuser(String username) {
        OrdinaryUserEntity ordinaryuser=ordinaryUserRepository.finduserbyname(username);
        return ordinaryuser;
    }

    @Override
    public List<OrdinaryUserEntity> findAll() {
        return ordinaryUserRepository.findAll();
    }

    @Override
    public void deleteOrdinaryUserEntityById(int id) {
        ordinaryUserRepository.deleteOrdinaryUserEntityById(id);
    }

    @Override
    public OrdinaryUserEntity findOrdinaryUserEntityById(int id) {
        return ordinaryUserRepository.findOrdinaryUserEntityById(id);
    }

    @Override
    public List<OrdinaryUserEntity> findOrdinaryUserEntitiesByNameContaining(String s) {
        return ordinaryUserRepository.findOrdinaryUserEntitiesByNameContaining(s);
    }

    @Override
    public OrdinaryUserEntity updateUserById(String name, String password, String person_id, Byte is_student, Byte credit, int id) {
        ordinaryUserRepository.updateUserById(name, password, person_id, is_student, credit, id);
        return ordinaryUserRepository.findOrdinaryUserEntityById(id);
    }

    @Override
    @Operation(value ="注册" ,level = 4,operationType = OperationType.INSERT,operationUnit = OperationUnit.USER)
    public void createOrdinaryUserEntity(OrdinaryUserEntity userEntity){
        ordinaryUserRepository.save(userEntity);
    }

    @Operation(value ="修改个人信息" ,level = 4,operationType = OperationType.UPDATE,operationUnit = OperationUnit.USER)
    @Override
    public void edituinfo(String phonenum, String name) {
        ordinaryUserRepository.updatebynames(phonenum,name);
    }


}
