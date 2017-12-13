package tech.lapsa.epayment.dao.producer.remote;

import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

import tech.lapsa.epayment.dao.EJBViaCDI;
import tech.lapsa.epayment.dao.InvoiceDAO;
import tech.lapsa.epayment.dao.InvoiceDAO.InvoiceDAORemote;

@Dependent
public class InvoiceDAOProducer {

    @EJB
    private InvoiceDAORemote ejb;

    @Produces
    @EJBViaCDI
    public InvoiceDAO getEjb() {
	return ejb;
    }
}
