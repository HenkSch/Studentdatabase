package de.nordakademie.studentdatabase.century.ui;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.studentdatabase.century.model.Century;
import de.nordakademie.studentdatabase.century.service.CenturyService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by U555987 on 023, 23.10.2017.
 */
public class CenturyEditAction extends ActionSupport {

    private final CenturyService centuryService;
    private Century century;
    private Long id;

    @Autowired
    public CenturyEditAction(CenturyService centuryService) {
        this.centuryService = centuryService;
    }

    public String getAddForm() {
        return SUCCESS;
    }

    public String getEditForm() {
        century = centuryService.findOne(this.id);
        return SUCCESS;
    }

    public String saveCentury() {
        centuryService.create(this.century);
        return SUCCESS;
    }

    public String deleteCentury() {
        centuryService.deleteBy(this.id);
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
