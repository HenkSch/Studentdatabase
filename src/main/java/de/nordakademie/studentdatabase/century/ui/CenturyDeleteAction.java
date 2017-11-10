package de.nordakademie.studentdatabase.century.ui;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.studentdatabase.century.service.CenturyService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Henk Schuhmann on 023, 23.10.2017.
 */
public class CenturyDeleteAction extends ActionSupport {

    private final CenturyService centuryService;
    private Long id;

    @Autowired
    public CenturyDeleteAction(CenturyService centuryService) {
        this.centuryService = centuryService;
    }

    public String deleteCentury() {
        centuryService.deleteBy(this.id);
        return SUCCESS;
    }

    @Override
    public void validate() {
        if (centuryService.isUsed(this.id)) {
            addActionError(getText("century.deleteError"));
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
