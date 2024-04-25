package com.prueba.domain.service;

import com.prueba.domain.exeption.AdminIdNotFoundException;
import com.prueba.domain.exeption.AdminNotFoundException;
import com.prueba.domain.repository.AdminRepository;
import com.prueba.persistence.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class AdminService {
    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }


    public List<Admin> getAll() {
        return adminRepository.findAll();
    }


    public ResponseEntity<Admin> getById(Object id) {
        try{
            Long  newId = Long.parseLong(id.toString());
            Admin optionalAdmin = adminRepository.findById(newId)
                    .orElseThrow(() -> new AdminNotFoundException("Admin no encontrado"));
            return ResponseEntity.ok(optionalAdmin);

        }catch (NumberFormatException e){
            throw new AdminIdNotFoundException("Haz ingresado una letra u/o otro caracter diferente a un Número de tipo Long");
        }
    }


    public ResponseEntity<Admin> save(Admin adminSave) {
        adminRepository.save(adminSave);
        return ResponseEntity.ok(adminSave);
    }


    public ResponseEntity<Void> delete(Long id) {
        if (adminRepository.existsById(id)) {
            adminRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    public ResponseEntity<Admin> update(Object id, Admin adminUpdate) {
        try{
            Long newId = Long.parseLong(id.toString());
            Optional<Admin> optionalAdmin = adminRepository.findById(newId);
            if(optionalAdmin.isPresent()){

                Admin adminSend = optionalAdmin.get();
                adminSend.setUsername(adminUpdate.getUsername());
                adminSend.setPassword(adminUpdate.getPassword());
                adminSend.setToken(adminUpdate.getToken());
                adminRepository.save(adminSend);

                return ResponseEntity.ok(adminSend);
            } else {
                throw new AdminNotFoundException("Admin no encontrado por dicho ID para actualizar");
            }
        }catch (NumberFormatException e){
            throw new AdminIdNotFoundException("Haz ingresado una letra u/o otro caracter diferente a un Número de tipo Long");
        }
    }
}
