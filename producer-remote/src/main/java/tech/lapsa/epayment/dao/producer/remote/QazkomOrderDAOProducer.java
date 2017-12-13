package tech.lapsa.epayment.dao.producer.remote;

import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

import tech.lapsa.epayment.dao.EJBViaCDI;
import tech.lapsa.epayment.dao.QazkomOrderDAO;
import tech.lapsa.epayment.dao.QazkomOrderDAO.QazkomOrderDAORemote;

@Dependent
public class QazkomOrderDAOProducer {

    @EJB
    private QazkomOrderDAORemote ejb;

    @Produces
    @EJBViaCDI
    public QazkomOrderDAO getEjb() {
	return ejb;
    }
}
