package com.example.ApiProject.AppointementServiceImpl;

import com.example.ApiProject.Dto.ContryDto;
import com.example.ApiProject.Service.ContryService;
import com.example.ApiProject.model.City;
import com.example.ApiProject.model.Contry;
import com.example.ApiProject.repository.CityRepository;
import com.example.ApiProject.repository.ContryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ContryServiceImpl implements ContryService {

    @Autowired
    ContryRepository contryRepo;

    @Autowired
    CityRepository cityRepo;

    @Override
    public Contry createContry(ContryDto contryDto) {

        // create contry

        Contry addContry = new Contry();

        addContry.setName(contryDto.getName());

        contryRepo.save(addContry);


        return addContry;

    }

    @Override
    public Contry updateContry(Long id, ContryDto contryDto) {

        //selectionne le pays si il existe si oui enregistre les nouvelles modifications apportées

        Contry contryToUpdate = contryRepo.findById(id).orElse(null);

        if(contryToUpdate !=null){

            BeanUtils.copyProperties(contryRepo, contryToUpdate, "id");

            contryRepo.save(contryToUpdate);
        }
        return contryRepo.save(contryToUpdate);
    }

    @Override
    public void deleteContryId(Long id) {

        contryRepo.deleteById(id);

    }

    @Override
    public Optional<Contry> getContryId(Long id) {

        Optional<Contry> contryid = contryRepo.findById(id);

        return contryid;

    }

    @Override
    public List<Contry> getContries() {

        return contryRepo.findAll();

    }

    @Override

    public void deleteContries() {

         contryRepo.deleteAll();

    }
}
