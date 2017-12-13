package tech.lapsa.epayment.dao.producer.local;

import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

import tech.lapsa.epayment.dao.EJBViaCDI;
import tech.lapsa.epayment.dao.QazkomErrorDAO;
import tech.lapsa.epayment.dao.QazkomErrorDAO.QazkomErrorDAOLocal;

@Dependent
public class QazkomErrorDAOProducer {

    @EJB
    private QazkomErrorDAOLocal ejb;

    @Produces
    @EJBViaCDI
    public QazkomErrorDAO getEjb() {
	return ejb;
    }
}
