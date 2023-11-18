// HRServiceImpl.java
package com.example.placementmodule.service.impl;

import com.example.placementmodule.model.HR;
import com.example.placementmodule.repository.HRRepository;
import com.example.placementmodule.service.HRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HRServiceImpl implements HRService {

    private final HRRepository hrRepository;

    @Autowired
    public HRServiceImpl(HRRepository hrRepository) {
        this.hrRepository = hrRepository;
    }

    @Override
    public List<HR> getAllHRs() {
        return hrRepository.findAll();
    }

    @Override
    public Optional<HR> getHRById(Long id) {
        return hrRepository.findById(id);
    }

    @Override
    public HR createHR(HR hr) {
        return hrRepository.save(hr);
    }

    @Override
    public HR updateHR(Long id, HR updatedHR) {
        Optional<HR> existingHR = hrRepository.findById(id);

        if (existingHR.isPresent()) {
            HR hr = existingHR.get();
            // Update the fields you want to update
            if (updatedHR.getFirstName() != null) {
                hr.setFirstName(updatedHR.getFirstName());
            }

            if (updatedHR.getLastName() != null) {
                hr.setLastName(updatedHR.getLastName());
            }

            if (updatedHR.getEmail() != null) {
                hr.setEmail(updatedHR.getEmail());
            }

            // ... update other fields as needed

            return hrRepository.save(hr);
        } else {
            // Handle the case where the HR with the given id is not found
            return null; // You can throw an exception or handle it as appropriate for your application
        }
    }

    @Override
    public void deleteHR(Long id) {
        hrRepository.deleteById(id);
    }
}
