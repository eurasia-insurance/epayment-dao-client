package tech.lapsa.epayment.dao.producer.local;

import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

import tech.lapsa.epayment.dao.EJBViaCDI;
import tech.lapsa.epayment.dao.PaymentDAO;
import tech.lapsa.epayment.dao.PaymentDAO.PaymentDAOLocal;

@Dependent
public class PaymentDAOProducer {

    @EJB
    private PaymentDAOLocal ejb;

    @Produces
    @EJBViaCDI
    public PaymentDAO getEjb() {
	return ejb;
    }
}
