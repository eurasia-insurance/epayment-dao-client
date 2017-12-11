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
    public QazkomOrder getByNumber(final String number) throws IllegalArgumentException, NotFound {
	MyStrings.requireNonEmpty(number, "number");

	final CriteriaBuilder cb = em.getCriteriaBuilder();
	final CriteriaQuery<QazkomOrder> cq = cb.createQuery(QazkomOrder.class);
	final Root<QazkomOrder> root = cq.from(QazkomOrder.class);
	cq.select(root) //
		.where(cb.equal(root.get(QazkomOrder_.orderNumber), number));

	final TypedQuery<QazkomOrder> q = em.createQuery(cq);
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

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public QazkomOrder getLatestForInvoice(final Invoice forInvoice) throws IllegalArgumentException, NotFound {
	MyObjects.requireNonNull(forInvoice, "forInvoice");

	final CriteriaBuilder cb = em.getCriteriaBuilder();
	final CriteriaQuery<QazkomOrder> cq = cb.createQuery(QazkomOrder.class);
	final Root<QazkomOrder> root = cq.from(QazkomOrder.class);
	cq.select(root) //
		.where(cb.equal(root.get(QazkomOrder_.forInvoice), forInvoice)) //
		.orderBy(cb.desc(root.get(QazkomOrder_.created)));

	return signleResult(em.createQuery(cq));
    }

}
