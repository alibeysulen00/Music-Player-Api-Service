package com.example.adayazilim.model.repository;

import com.example.adayazilim.model.entities.Sanatcilar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface SanatcilarRepo extends JpaRepository<Sanatcilar, Integer> {


}
