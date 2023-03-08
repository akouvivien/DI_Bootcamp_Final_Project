package com.example.ApiProject.Service;

import com.example.ApiProject.Dto.EtablissementCategoryDto;
import com.example.ApiProject.Dto.HospitalDto;
import com.example.ApiProject.model.EtablissementCategory;
import com.example.ApiProject.model.Hospital;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface EtablissementCategoryService {

    EtablissementCategory CreateEtablissementCategory(EtablissementCategoryDto etablissementCategoryDto);

    EtablissementCategory UpdateEtablissementCategoryId(Long id, EtablissementCategoryDto etablissementCategoryDto);

    void deleteEtablissementCategoryId(Long id);

    Optional<EtablissementCategory> getEtablissementCategoryId(Long id);

    List<EtablissementCategory> getEtablissementCategories();

    void deleteEtablissementCategories();
}
