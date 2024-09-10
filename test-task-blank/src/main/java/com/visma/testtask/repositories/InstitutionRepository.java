package com.visma.testtask.repositories;

import com.visma.testtask.dto.InstitutionDto;
import com.visma.testtask.InstitutionStatus;
import com.visma.testtask.entities.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {

    @Query("SELECT new com.visma.testtask.dto.InstitutionDto(i.name, i.regNum, i.regDate, ct.text) " +
            "FROM Institution i " +
            "JOIN i.type ct " +
            "WHERE ct.language = :lang " +
            "AND (:status IS NULL OR i.status = :status)")
    List<InstitutionDto> findInstitutions(@Param("lang") String lang,
                                          @Param("status") InstitutionStatus status);
}
