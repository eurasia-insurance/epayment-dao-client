package tech.lapsa.epayment.dao.beans;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import tech.lapsa.epayment.dao.QazkomPaymentDAO;
import tech.lapsa.epayment.domain.QazkomPayment;
import tech.lapsa.epayment.domain.QazkomPayment_;
import tech.lapsa.java.commons.function.MyStrings;
import tech.lapsa.patterns.dao.NotFound;
import tech.lapsa.patterns.dao.TooMuchFound;

@Stateless
public class QazkomPaymentDAOBean extends ABaseDAO<QazkomPayment, Integer> implements QazkomPaymentDAO {

    public QazkomPaymentDAOBean() {
	super(QazkomPayment.class);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public QazkomPayment getByNumber(String number) throws IllegalArgumentException, NotFound, TooMuchFound {
	MyStrings.requireNonEmpty(number, "number");

	CriteriaBuilder cb = em.getCriteriaBuilder();
	CriteriaQuery<QazkomPayment> cq = cb.createQuery(QazkomPayment.class);
	Root<QazkomPayment> root = cq.from(QazkomPayment.class);
	cq.select(root) //
		.where(cb.equal(root.get(QazkomPayment_.orderNumber), number));

	TypedQuery<QazkomPayment> q = em.createQuery(cq);
	return signleResultNoCached(q);
    }
}
