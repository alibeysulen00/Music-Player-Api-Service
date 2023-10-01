package com.example.adayazilim.model.repository;

import com.example.adayazilim.model.entities.CalmaListeleri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CalmaListeleriRepo extends JpaRepository<CalmaListeleri, Integer> {


}
