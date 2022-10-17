package com.algodomain.repos;

import com.algodomain.models.DTC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DTCRepo extends JpaRepository<DTC, Integer> {
    @Query("SELECT d from DTC d where d.ProductCategory =:p_category")
    public DTC getDTCByCategory(@Param("p_category") String p_category);
}
