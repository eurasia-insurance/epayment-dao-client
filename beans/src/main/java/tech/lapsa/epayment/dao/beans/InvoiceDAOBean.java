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
import tech.lapsa.java.commons.exceptions.IllegalArgument;
import tech.lapsa.java.commons.function.MyStrings;
import tech.lapsa.patterns.dao.NotFound;

@Stateless
public class InvoiceDAOBean extends ABaseDAO<Invoice, Integer> implements InvoiceDAOLocal, InvoiceDAORemote {

    public InvoiceDAOBean() {
	super(Invoice.class);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Invoice getByNumber(final String number) throws IllegalArgument, NotFound {
	try {
	    return _getByNumber(number);
	} catch (IllegalArgumentException e) {
	    throw new IllegalArgument(e);
	}
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public boolean isValidUniqueNumber(final String number) {
	return _isValidUniqueNumber(number);
    }

    // PRIVATE

    private Invoice _getByNumber(final String number) throws IllegalArgumentException, NotFound {
	MyStrings.requireNonEmpty(number, "number");

	final CriteriaBuilder cb = em.getCriteriaBuilder();
	final CriteriaQuery<Invoice> cq = cb.createQuery(Invoice.class);
	final Root<Invoice> root = cq.from(Invoice.class);
	cq.select(root) //
		.where(cb.equal(root.get(Invoice_.number), number));

	final TypedQuery<Invoice> q = em.createQuery(cq);
	return signleResult(q);
    }

    private boolean _isValidUniqueNumber(final String number) {
	try {
	    _getByNumber(number);
	    return false;
	} catch (final NotFound e) {
	    return true;
	} catch (IllegalArgumentException e) {
	    return false;
	}
    }
}
