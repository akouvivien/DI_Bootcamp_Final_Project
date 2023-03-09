package com.example.ApiProject.Service;

import com.example.ApiProject.Dto.EtablissementCategoryDto;
import com.example.ApiProject.Model.EtablissementCategory;
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
