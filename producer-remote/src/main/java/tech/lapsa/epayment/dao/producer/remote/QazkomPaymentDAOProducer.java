package tech.lapsa.epayment.dao.producer.remote;

import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

import tech.lapsa.epayment.dao.EJBViaCDI;
import tech.lapsa.epayment.dao.QazkomPaymentDAO;
import tech.lapsa.epayment.dao.QazkomPaymentDAO.QazkomPaymentDAORemote;

@Dependent
public class QazkomPaymentDAOProducer {

    @EJB
    private QazkomPaymentDAORemote ejb;

    @Produces
    @EJBViaCDI
    public QazkomPaymentDAO getEjb() {
	return ejb;
    }
}
