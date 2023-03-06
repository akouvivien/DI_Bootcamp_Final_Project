package com.example.ApiProject.repository;
import com.example.ApiProject.model.EtablissementCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtablissementRepository extends JpaRepository<EtablissementCategory,Long> {
}
