package com.example.ApiProject.Service;

import com.example.ApiProject.Dto.MunicipalityDto;
import com.example.ApiProject.model.Municipality;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MunicipalityService {

    Municipality createMunicipality(MunicipalityDto municipalityDto);

    Municipality updateMunicipality (Long id, MunicipalityDto municipalityDto);


    void deleteMunicipalityId(Long id);

    Optional<Municipality> getMunicipalityId(Long id);

    List<Municipality> getMunicipalities();

    void deleteMunicipalities();
}

