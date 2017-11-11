package tech.lapsa.epayment.dao.beans;

import javax.ejb.Stateless;

import tech.lapsa.epayment.dao.InvoiceDAO;
import tech.lapsa.epayment.domain.Invoice;

@Stateless
public class InvoiceDAOBean extends ABaseDAO<Invoice, Integer> implements InvoiceDAO {

    public InvoiceDAOBean() {
	super(Invoice.class);
    }
}
