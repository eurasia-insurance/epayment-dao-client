package tech.lapsa.epayment.dao;

import javax.ejb.Local;
import javax.ejb.Remote;

import tech.lapsa.epayment.domain.Payment;
import tech.lapsa.patterns.dao.GeneralDAO;

public interface PaymentDAO extends GeneralDAO<Payment, Integer>, EJBConstants {

    @Local
    public interface PaymentDAOLocal extends PaymentDAO {
    }

    @Remote
    public interface PaymentDAORemote extends PaymentDAO {
    }
}
