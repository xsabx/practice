package com.visma.testtask.service;

import com.visma.testtask.dto.InstitutionDto;
import com.visma.testtask.InstitutionStatus;
import com.visma.testtask.repositories.InstitutionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstitutionService {

    private final InstitutionRepository institutionRepository;

    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    public List<InstitutionDto> getInstitutions(String lang, InstitutionStatus status) {
        return institutionRepository.findInstitutions(lang, status);
    }
}
