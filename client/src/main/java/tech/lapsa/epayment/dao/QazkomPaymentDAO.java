package tech.lapsa.epayment.dao;

import javax.ejb.Local;
import javax.ejb.Remote;

import tech.lapsa.epayment.domain.QazkomPayment;
import tech.lapsa.patterns.dao.GeneralDAO;
import tech.lapsa.patterns.dao.NotFound;

public interface QazkomPaymentDAO extends GeneralDAO<QazkomPayment, Integer> {

    @Local
    public interface QazkomPaymentDAOLocal extends QazkomPaymentDAO {
    }

    @Remote
    public interface QazkomPaymentDAORemote extends QazkomPaymentDAO {
    }

    QazkomPayment getByNumber(String number) throws IllegalArgumentException, NotFound;

    boolean isUniqueNumber(String number) throws IllegalArgumentException;
}
