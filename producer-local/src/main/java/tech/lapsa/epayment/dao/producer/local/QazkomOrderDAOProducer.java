package tech.lapsa.epayment.dao.producer.local;

import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

import tech.lapsa.epayment.dao.EJBViaCDI;
import tech.lapsa.epayment.dao.QazkomOrderDAO;
import tech.lapsa.epayment.dao.QazkomOrderDAO.QazkomOrderDAOLocal;

@Dependent
public class QazkomOrderDAOProducer {

    @EJB
    private QazkomOrderDAOLocal ejb;

    @Produces
    @EJBViaCDI
    public QazkomOrderDAO getEjb() {
	return ejb;
    }
}
