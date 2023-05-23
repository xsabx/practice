package com.visma.testtask.api;

import com.visma.testtask.InstitutionStatus;
import com.visma.testtask.dto.InstitutionDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/institutions")
public class InstitutionController {

    /*
     *   ----------------------------------------------------------------------------------------------------------------
     *   |FRONT-END          |DATABASE                           |ADDITIONAL TASK
     *   ----------------------------------------------------------------------------------------------------------------
     *   |name               |institutions.name                  | -
     *   |regNum             |institutions.regNum                | -
     *   |regDate            |institutions.regDate               | -
     *   |type               |classifiers_translations.text      |atkarīgs no valodas
     *   ----------------------------------------------------------------------------------------------------------------
     */

    @GetMapping()
    public List<InstitutionDto> getInstitutions(@RequestParam("language") String lang,
                                                @RequestParam(value = "status", required = false) InstitutionStatus status) {

        /* RAKSTĀM KODU ŠEIT! */
        return new ArrayList<>();
    }
}
