package tech.lapsa.epayment.dao.beans;

import javax.ejb.Stateless;

import tech.lapsa.epayment.dao.PaymentDAO;
import tech.lapsa.epayment.dao.PaymentDAO.PaymentDAOLocal;
import tech.lapsa.epayment.dao.PaymentDAO.PaymentDAORemote;
import tech.lapsa.epayment.domain.Payment;

@Stateless(name = PaymentDAO.BEAN_NAME)
public class PaymentDAOBean extends ABaseDAO<Payment, Integer> implements PaymentDAOLocal, PaymentDAORemote {

    public PaymentDAOBean() {
	super(Payment.class);
    }
}
