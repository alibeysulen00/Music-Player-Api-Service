package com.example.adayazilim.model.repository;

import com.example.adayazilim.model.entities.Sanatcilar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface  SanatcilarRepo extends JpaRepository<Sanatcilar, Integer> {


}
