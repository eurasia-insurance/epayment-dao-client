package tech.lapsa.epayment.dao.beans;

import javax.ejb.Stateless;

import tech.lapsa.epayment.dao.PaymentDAO;
import tech.lapsa.epayment.domain.Payment;

@Stateless
public class PaymentDAOBean extends ABaseDAO<Payment, Integer> implements PaymentDAO {

    public PaymentDAOBean() {
	super(Payment.class);
    }
}
