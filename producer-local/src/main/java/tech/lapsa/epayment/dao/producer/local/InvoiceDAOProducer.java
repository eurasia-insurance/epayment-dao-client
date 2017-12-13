package tech.lapsa.epayment.dao.producer.local;

import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

import tech.lapsa.epayment.dao.EJBViaCDI;
import tech.lapsa.epayment.dao.InvoiceDAO;
import tech.lapsa.epayment.dao.InvoiceDAO.InvoiceDAOLocal;

@Dependent
public class InvoiceDAOProducer {

    @EJB
    private InvoiceDAOLocal ejb;

    @Produces
    @EJBViaCDI
    public InvoiceDAO getEjb() {
	return ejb;
    }
}
