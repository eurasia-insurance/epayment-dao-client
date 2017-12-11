package tech.lapsa.epayment.dao.beans;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import tech.lapsa.epayment.dao.InvoiceDAO.InvoiceDAOLocal;
import tech.lapsa.epayment.dao.InvoiceDAO.InvoiceDAORemote;
import tech.lapsa.epayment.domain.Invoice;
import tech.lapsa.epayment.domain.Invoice_;
import tech.lapsa.java.commons.function.MyStrings;
import tech.lapsa.patterns.dao.NotFound;

@Stateless
public class InvoiceDAOBean extends ABaseDAO<Invoice, Integer> implements InvoiceDAOLocal, InvoiceDAORemote {

    public InvoiceDAOBean() {
	super(Invoice.class);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Invoice getByNumber(final String number) throws IllegalArgumentException, NotFound {
	MyStrings.requireNonEmpty(number, "number");

	final CriteriaBuilder cb = em.getCriteriaBuilder();
	final CriteriaQuery<Invoice> cq = cb.createQuery(Invoice.class);
	final Root<Invoice> root = cq.from(Invoice.class);
	cq.select(root) //
		.where(cb.equal(root.get(Invoice_.number), number));

	final TypedQuery<Invoice> q = em.createQuery(cq);
	return signleResult(q);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public boolean isUniqueNumber(final String number) throws IllegalArgumentException {
	try {
	    getByNumber(number);
	    return false;
	} catch (final NotFound e) {
	    return true;
	}
    }
}
