package com.prueba.web.controller;

import com.prueba.domain.service.AdminService;
import com.prueba.persistence.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/register")
public class AdminController {
    private final AdminService adminInterface;

    @Autowired
    public AdminController(AdminService adminInterface) {
        this.adminInterface = adminInterface;
    }
    @GetMapping
    public List<Admin> getAllAdmins(){
        return adminInterface.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Object id) {
        return adminInterface.getById(id);
    }

    @PostMapping
    public ResponseEntity<Admin> saveAdmin(@RequestBody Admin adminSave) {
        return adminInterface.save(adminSave);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        return adminInterface.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Admin> updateAdmin( @PathVariable Object id, @RequestBody Admin adminUpdate) {
        return adminInterface.update(id, adminUpdate);
    }

}
