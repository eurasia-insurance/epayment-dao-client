package tech.lapsa.epayment.dao.beans;

import javax.ejb.Stateless;

import tech.lapsa.epayment.dao.PaymentDAO;
import tech.lapsa.epayment.domain.APayment;

@Stateless
public class PaymentDAOBean extends ABaseDAO<APayment, Integer> implements PaymentDAO {

    public PaymentDAOBean() {
	super(APayment.class);
    }
}
