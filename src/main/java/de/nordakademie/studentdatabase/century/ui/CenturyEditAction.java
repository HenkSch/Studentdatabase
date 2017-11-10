package de.nordakademie.studentdatabase.century.ui;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.studentdatabase.century.model.Century;
import de.nordakademie.studentdatabase.century.service.CenturyService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Henk Schuhmann on 023, 23.10.2017.
 */
public class CenturyEditAction extends ActionSupport {

    private final CenturyService centuryService;
    private Century century;
    private Long id;

    @Autowired
    public CenturyEditAction(CenturyService centuryService) {
        this.centuryService = centuryService;
    }


    public String getForm() {
        century = centuryService.findOne(this.id);
        return SUCCESS;
    }

    public String updateCentury() {
        centuryService.update(this.century);
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
