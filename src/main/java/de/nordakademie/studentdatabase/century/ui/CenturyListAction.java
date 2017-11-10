package de.nordakademie.studentdatabase.century.ui;

import com.opensymphony.xwork2.Action;
import de.nordakademie.studentdatabase.century.model.Century;
import de.nordakademie.studentdatabase.century.service.CenturyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Henk Schuhmann on 023, 23.10.2017.
 */
public class CenturyListAction implements Action {

    private final CenturyService centuryService;
    private List<Century> centuryList;

    @Autowired
    public CenturyListAction(CenturyService centuryService) {
        this.centuryService = centuryService;
    }

    @Override
    public String execute() throws Exception {
        centuryList = centuryService.findAll();
        return SUCCESS;
    }

    public List<Century> getCenturyList() {
        return centuryList;
    }
}
