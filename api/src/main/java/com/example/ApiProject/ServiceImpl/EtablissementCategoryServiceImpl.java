package com.example.ApiProject.serviceImpl;

import com.example.ApiProject.Dto.EtablissementCategoryDto;
import com.example.ApiProject.Model.EtablissementCategory;
import com.example.ApiProject.Repository.EtablissementRepository;
import com.example.ApiProject.Service.EtablissementCategoryService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EtablissementCategoryServiceImpl implements EtablissementCategoryService {

    @Autowired
    EtablissementRepository etablissementRepo;
    @Override
    public EtablissementCategory CreateEtablissementCategory(EtablissementCategoryDto etablissementCategoryDto) {

        EtablissementCategory addEtablissementCategories = new EtablissementCategory();

        addEtablissementCategories.setCategory(etablissementCategoryDto.getCategory());

        etablissementRepo.save(addEtablissementCategories);

        return addEtablissementCategories;
    }

    @Override
    public EtablissementCategory UpdateEtablissementCategoryId(Long id, EtablissementCategoryDto etablissementCategoryDto) {

        EtablissementCategory etablissementCategoryToUpdate = etablissementRepo.findById(id).orElse(null);

        if(etablissementCategoryToUpdate !=null){

            BeanUtils.copyProperties(etablissementRepo, etablissementCategoryToUpdate, "id");

            etablissementRepo.save(etablissementCategoryToUpdate);
        }
        return etablissementRepo.save(etablissementCategoryToUpdate);
    }

    @Override
    public void deleteEtablissementCategoryId(Long id) {

        etablissementRepo.deleteById(id);

    }

    @Override
    public Optional<EtablissementCategory> getEtablissementCategoryId(Long id) {

        return etablissementRepo.findById(id);

    }

    @Override
    public List<EtablissementCategory> getEtablissementCategories() {

        return etablissementRepo.findAll();

    }

    @Override
    public void deleteEtablissementCategories() {

        etablissementRepo.deleteAll();

    }
}
