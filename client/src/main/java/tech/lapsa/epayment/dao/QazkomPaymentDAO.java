package tech.lapsa.epayment.dao;

import javax.ejb.Local;
import javax.ejb.Remote;

import tech.lapsa.epayment.domain.QazkomPayment;
import tech.lapsa.java.commons.exceptions.IllegalArgument;
import tech.lapsa.patterns.dao.GeneralDAO;
import tech.lapsa.patterns.dao.NotFound;

public interface QazkomPaymentDAO extends GeneralDAO<QazkomPayment, Integer>, EJBConstants {

    public static final String BEAN_NAME = "QazkomPaymentDAOBean";

    @Local
    public interface QazkomPaymentDAOLocal extends QazkomPaymentDAO {
    }

    @Remote
    public interface QazkomPaymentDAORemote extends QazkomPaymentDAO {
    }

    QazkomPayment getByNumber(String number) throws IllegalArgument, NotFound;

    boolean isUniqueNumber(String number) throws IllegalArgument;
}
