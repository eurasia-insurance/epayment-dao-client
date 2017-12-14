package tech.lapsa.epayment.dao;

import javax.ejb.Local;
import javax.ejb.Remote;

import tech.lapsa.epayment.domain.Invoice;
import tech.lapsa.epayment.domain.QazkomOrder;
import tech.lapsa.java.commons.exceptions.IllegalArgument;
import tech.lapsa.patterns.dao.GeneralDAO;
import tech.lapsa.patterns.dao.NotFound;

public interface QazkomOrderDAO extends GeneralDAO<QazkomOrder, Integer> {

    @Local
    public interface QazkomOrderDAOLocal extends QazkomOrderDAO {
    }

    @Remote
    public interface QazkomOrderDAORemote extends QazkomOrderDAO {
    }

    QazkomOrder getByNumber(String number) throws IllegalArgument, NotFound;

    boolean isValidUniqueNumber(String number);

    QazkomOrder getLatestForInvoice(Invoice forInvoice) throws IllegalArgument, NotFound;
}
