// HRService.java
package com.example.placementmodule.service;

import com.example.placementmodule.model.HR;

import java.util.List;
import java.util.Optional;

public interface HRService {
    List<HR> getAllHRs();

    Optional<HR> getHRById(Long id);

    HR createHR(HR hr);

    HR updateHR(Long id, HR updatedHR);

    void deleteHR(Long id);
}
