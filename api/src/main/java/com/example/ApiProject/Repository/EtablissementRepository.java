package com.example.ApiProject.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ApiProject.Model.EtablissementCategory;

@Repository
public interface EtablissementRepository extends JpaRepository<EtablissementCategory,Long> {
}
