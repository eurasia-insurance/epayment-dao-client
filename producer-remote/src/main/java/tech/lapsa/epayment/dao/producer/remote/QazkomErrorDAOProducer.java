package tech.lapsa.epayment.dao.producer.remote;

import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

import tech.lapsa.epayment.dao.EJBViaCDI;
import tech.lapsa.epayment.dao.QazkomErrorDAO;
import tech.lapsa.epayment.dao.QazkomErrorDAO.QazkomErrorDAORemote;

@Dependent
public class QazkomErrorDAOProducer {

    @EJB
    private QazkomErrorDAORemote ejb;

    @Produces
    @EJBViaCDI
    public QazkomErrorDAO getEjb() {
	return ejb;
    }
}
