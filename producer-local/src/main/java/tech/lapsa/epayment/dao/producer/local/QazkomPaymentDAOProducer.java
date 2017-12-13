package tech.lapsa.epayment.dao.producer.local;

import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

import tech.lapsa.epayment.dao.EJBViaCDI;
import tech.lapsa.epayment.dao.QazkomPaymentDAO;
import tech.lapsa.epayment.dao.QazkomPaymentDAO.QazkomPaymentDAOLocal;

@Dependent
public class QazkomPaymentDAOProducer {

    @EJB
    private QazkomPaymentDAOLocal ejb;

    @Produces
    @EJBViaCDI
    public QazkomPaymentDAO getEjb() {
	return ejb;
    }
}
