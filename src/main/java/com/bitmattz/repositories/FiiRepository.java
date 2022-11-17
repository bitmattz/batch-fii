package com.bitmattz.repositories;

import com.bitmattz.models.Fii;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FiiRepository extends JpaRepository<Fii,Integer> {

    @Query("from get_random_fii()")
    public String findRandomFiis();

//    @Query("from Fii where codigo = :cod")
//    public Fii findByCod(@Param("cod") String cod);

}
