package tech.lapsa.epayment.dao;

import javax.ejb.Local;
import javax.ejb.Remote;

import tech.lapsa.epayment.domain.Invoice;
import tech.lapsa.epayment.domain.QazkomOrder;
import tech.lapsa.patterns.dao.GeneralDAO;
import tech.lapsa.patterns.dao.NotFound;

public interface QazkomOrderDAO extends GeneralDAO<QazkomOrder, Integer> {

    @Local
    public interface QazkomOrderDAOLocal extends QazkomOrderDAO {
    }

    @Remote
    public interface QazkomOrderDAORemote extends QazkomOrderDAO {
    }

    QazkomOrder getByNumber(String number) throws IllegalArgumentException, NotFound;

    boolean isUniqueNumber(String number) throws IllegalArgumentException;

    QazkomOrder getLatestForInvoice(Invoice forInvoice) throws IllegalArgumentException, NotFound;
}
