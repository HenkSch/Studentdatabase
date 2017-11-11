package de.nordakademie.studentdatabase.century.ui;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.studentdatabase.century.model.Century;
import de.nordakademie.studentdatabase.century.service.CenturyService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Henk Schuhmann, Sarah Bruhn on 023, 23.10.2017.
 */
public class CenturyAddAction extends ActionSupport {

    private final CenturyService centuryService;
    private Century century;

    @Autowired
    public CenturyAddAction(CenturyService centuryService) {
        this.centuryService = centuryService;
    }

    public String getForm() {
        return SUCCESS;
    }


    public String createCentury() {
        centuryService.create(this.century);
        return SUCCESS;
    }

    @Override
    public void validate() {

    }

    public Century getCentury() {
        return century;
    }

    public void setCentury(Century century) {
        this.century = century;
    }

}
