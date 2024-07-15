package com.developer.myproject.controller;

import com.developer.myproject.exception.ResourceNotFoundException;
import com.developer.myproject.model.Module;
import com.developer.myproject.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/modules")
public class ModuleController {

    @Autowired
    private ModuleRepository moduleRepository;

    @GetMapping
    public List<Module> getAllModules() {
        return moduleRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Module> getModuleById(@PathVariable Long id) {
        Module module = moduleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Module not found with id :" + id));
        return ResponseEntity.ok(module);
    }

    @PostMapping
    public Module createModule(@RequestBody Module module) {
        return moduleRepository.save(module);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Module> updateModule(@PathVariable Long id, @RequestBody Module moduleDetails) {
        Module module = moduleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Module not found with id :" + id));

        module.setName(moduleDetails.getName());
        module.setPassmark(moduleDetails.getPassmark());
        module.setOption(moduleDetails.getOption());
        module.setBhValue(moduleDetails.getBhValue());
        module.setEeCode(moduleDetails.getEeCode());

        Module updatedModule = moduleRepository.save(module);
        return ResponseEntity.ok(updatedModule);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteModule(@PathVariable Long id) {
        Module module = moduleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Module not found with id :" + id));

        moduleRepository.delete(module);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}


