package com.bupt.trainbookingsystem.service.imp;

import com.bupt.trainbookingsystem.dao.AdministratorRespository;
import com.bupt.trainbookingsystem.entity.AdministratorEntity;
import com.bupt.trainbookingsystem.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorServiceImp implements AdministratorService {
    @Autowired
    private AdministratorRespository administratorRespository;
    @Override
    public AdministratorEntity findAdministratorEntityByNameAndPassword(String name, String password) {
        return administratorRespository.findAdministratorEntityByNameAndPassword(name, password);
    }
}
