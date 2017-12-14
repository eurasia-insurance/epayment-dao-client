package tech.lapsa.epayment.dao;

import javax.ejb.Local;
import javax.ejb.Remote;

import tech.lapsa.epayment.domain.Invoice;
import tech.lapsa.java.commons.exceptions.IllegalArgument;
import tech.lapsa.patterns.dao.GeneralDAO;
import tech.lapsa.patterns.dao.NotFound;

public interface InvoiceDAO extends GeneralDAO<Invoice, Integer> {

    @Local
    public interface InvoiceDAOLocal extends InvoiceDAO {
    }

    @Remote
    public interface InvoiceDAORemote extends InvoiceDAO {
    }

    Invoice getByNumber(String number) throws IllegalArgument, NotFound;

    boolean isValidUniqueNumber(String number);
}
