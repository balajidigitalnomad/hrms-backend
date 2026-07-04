package com.app.hrms.service;

import com.app.hrms.dto.DesignationDto;
import com.app.hrms.entity.Designation;
import com.app.hrms.exception.ResourceNotFoundException;
import com.app.hrms.mapper.DesignationMapper;
import com.app.hrms.repository.DesignationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DesignationServiceImpl implements DesignationService {
    private final DesignationRepository designationRepository;
    private final DesignationMapper designationMapper;

    @Override
    public DesignationDto createDesignation(DesignationDto designationDto) {
        return designationMapper.toDto(designationRepository.save(designationMapper.toEntity(designationDto)));
    }

    @Override
    public DesignationDto updateDesignationById(Long id, DesignationDto designationDto) {
        Designation designation = designationRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Designation not found with id", id));
        designationMapper.updateEntity(designationDto, designation);
        return designationMapper.toDto(designationRepository.save(designation));
    }

    @Override
    public DesignationDto getDesignationById(Long id) {
        Designation designation = designationRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Designation not found with id", id));
        return designationMapper.toDto(designation);
    }

    @Override
    public List<DesignationDto> getAllDesignations(){
        return designationRepository.findAll().stream().map(designationMapper::toDto).toList();
    }

    @Override
    public void deleteDesignationById(Long id) {
        designationRepository.deleteById(id);
    }

}
