package tech.lapsa.epayment.dao.beans;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import tech.lapsa.epayment.dao.QazkomOrderDAO.QazkomOrderDAOLocal;
import tech.lapsa.epayment.dao.QazkomOrderDAO.QazkomOrderDAORemote;
import tech.lapsa.epayment.domain.Invoice;
import tech.lapsa.epayment.domain.QazkomOrder;
import tech.lapsa.epayment.domain.QazkomOrder_;
import tech.lapsa.java.commons.exceptions.IllegalArgument;
import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.java.commons.function.MyStrings;
import tech.lapsa.patterns.dao.NotFound;

@Stateless
public class QazkomOrderDAOBean extends ABaseDAO<QazkomOrder, Integer>
	implements QazkomOrderDAOLocal, QazkomOrderDAORemote {

    public QazkomOrderDAOBean() {
	super(QazkomOrder.class);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public QazkomOrder getByNumber(final String number) throws IllegalArgument, NotFound {
	try {
	    return _getByNumber(number);
	} catch (final IllegalArgumentException e) {
	    throw new IllegalArgument(e);
	}
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public boolean isValidUniqueNumber(final String number) {
	return _isValidUniqueNumber(number);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public QazkomOrder getLatestForInvoice(final Invoice forInvoice) throws IllegalArgument, NotFound {
	try {
	    return _getLatestForInvoice(forInvoice);
	} catch (final IllegalArgumentException e) {
	    throw new IllegalArgument(e);
	}
    }

    // PRIVATE

    private QazkomOrder _getLatestForInvoice(final Invoice forInvoice) throws IllegalArgumentException, NotFound {
	MyObjects.requireNonNull(forInvoice, "forInvoice");

	final CriteriaBuilder cb = em.getCriteriaBuilder();
	final CriteriaQuery<QazkomOrder> cq = cb.createQuery(QazkomOrder.class);
	final Root<QazkomOrder> root = cq.from(QazkomOrder.class);
	cq.select(root) //
		.where(cb.equal(root.get(QazkomOrder_.forInvoice), forInvoice)) //
		.orderBy(cb.desc(root.get(QazkomOrder_.created)));

	return signleResult(em.createQuery(cq));
    }

    private QazkomOrder _getByNumber(final String number) throws IllegalArgumentException, NotFound {
	MyStrings.requireNonEmpty(number, "number");

	final CriteriaBuilder cb = em.getCriteriaBuilder();
	final CriteriaQuery<QazkomOrder> cq = cb.createQuery(QazkomOrder.class);
	final Root<QazkomOrder> root = cq.from(QazkomOrder.class);
	cq.select(root) //
		.where(cb.equal(root.get(QazkomOrder_.orderNumber), number));

	final TypedQuery<QazkomOrder> q = em.createQuery(cq);
	return signleResult(q);
    }

    private boolean _isValidUniqueNumber(final String number) {
	try {
	    _getByNumber(number);
	    return false;
	} catch (final NotFound e) {
	    return true;
	} catch (final IllegalArgumentException e) {
	    return false;
	}
    }
}
