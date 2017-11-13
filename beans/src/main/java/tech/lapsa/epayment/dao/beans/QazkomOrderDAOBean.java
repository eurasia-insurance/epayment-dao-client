package tech.lapsa.epayment.dao.beans;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import tech.lapsa.epayment.dao.QazkomOrderDAO;
import tech.lapsa.epayment.domain.Invoice;
import tech.lapsa.epayment.domain.QazkomOrder;
import tech.lapsa.epayment.domain.QazkomOrder_;
import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.java.commons.function.MyStrings;
import tech.lapsa.patterns.dao.NotFound;
import tech.lapsa.patterns.dao.TooMuchFound;

@Stateless
public class QazkomOrderDAOBean extends ABaseDAO<QazkomOrder, Integer> implements QazkomOrderDAO {

    public QazkomOrderDAOBean() {
	super(QazkomOrder.class);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public QazkomOrder getByNumber(String number) throws IllegalArgumentException, NotFound, TooMuchFound {
	MyStrings.requireNonEmpty(number, "number");

	CriteriaBuilder cb = em.getCriteriaBuilder();
	CriteriaQuery<QazkomOrder> cq = cb.createQuery(QazkomOrder.class);
	Root<QazkomOrder> root = cq.from(QazkomOrder.class);
	cq.select(root) //
		.where(cb.equal(root.get(QazkomOrder_.orderNumber), number));

	TypedQuery<QazkomOrder> q = em.createQuery(cq);
	return signleResultNoCached(q);
    }

    @Override
    public QazkomOrder getLatestForInvoice(Invoice forInvoice) throws IllegalArgumentException, NotFound {
	MyObjects.requireNonNull(forInvoice, "forInvoice");

	CriteriaBuilder cb = em.getCriteriaBuilder();
	CriteriaQuery<QazkomOrder> cq = cb.createQuery(QazkomOrder.class);
	Root<QazkomOrder> root = cq.from(QazkomOrder.class);
	cq.select(root) //
		.where(cb.equal(root.get(QazkomOrder_.forInvoice), forInvoice)) //
		.orderBy(cb.desc(root.get(QazkomOrder_.created)));

	return signleResultNoCached(em.createQuery(cq).setMaxResults(1));
    }
}
