package tech.lapsa.epayment.dao.beans;

import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.lapsa.kkb.core.KKBDocument;
import com.lapsa.kkb.core.KKBDocument_;
import com.lapsa.kkb.core.KKBOrder;

import tech.lapsa.epayment.dao.KKBGeneralDocumentDAO;

public abstract class AKKBGeneralDocumentDAO<T extends KKBDocument> extends AEntityManagerDAO<T, Integer>
	implements KKBGeneralDocumentDAO<T> {

    public AKKBGeneralDocumentDAO(Class<T> entityClass) {
	super(entityClass);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<T> findByOrder(KKBOrder order) {
	// SELECT e
	// FROM KKBDocument e
	// WHERE e.order = :order
	// ORDER BY e.created

	CriteriaBuilder cb = em.getCriteriaBuilder();
	CriteriaQuery<T> cq = cb.createQuery(entityClass);
	Root<T> root = cq.from(entityClass);
	cq.select(root)
		.where(
			cb.equal(root.get(KKBDocument_.order), order))
		.orderBy(cb.asc(root.get(KKBDocument_.created)));

	TypedQuery<T> q = em.createQuery(cq);
	return resultListNoCached(q);
    }
}
