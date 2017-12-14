package tech.lapsa.epayment.dao.beans;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import tech.lapsa.epayment.dao.QazkomPaymentDAO.QazkomPaymentDAOLocal;
import tech.lapsa.epayment.dao.QazkomPaymentDAO.QazkomPaymentDAORemote;
import tech.lapsa.epayment.domain.QazkomPayment;
import tech.lapsa.epayment.domain.QazkomPayment_;
import tech.lapsa.java.commons.exceptions.IllegalArgument;
import tech.lapsa.java.commons.function.MyStrings;
import tech.lapsa.patterns.dao.NotFound;

@Stateless
public class QazkomPaymentDAOBean extends ABaseDAO<QazkomPayment, Integer>
	implements QazkomPaymentDAOLocal, QazkomPaymentDAORemote {

    public QazkomPaymentDAOBean() {
	super(QazkomPayment.class);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public QazkomPayment getByNumber(final String number) throws IllegalArgument, NotFound {
	try {
	    return _getByNumber(number);
	} catch (IllegalArgumentException e) {
	    throw new IllegalArgument(e);
	}
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public boolean isUniqueNumber(final String number) throws IllegalArgument {
	return _isUniqueNumber(number);
    }

    // PRIVATE

    private QazkomPayment _getByNumber(final String number) throws IllegalArgumentException, NotFound {
	MyStrings.requireNonEmpty(number, "number");

	final CriteriaBuilder cb = em.getCriteriaBuilder();
	final CriteriaQuery<QazkomPayment> cq = cb.createQuery(QazkomPayment.class);
	final Root<QazkomPayment> root = cq.from(QazkomPayment.class);
	cq.select(root) //
		.where(cb.equal(root.get(QazkomPayment_.orderNumber), number));

	final TypedQuery<QazkomPayment> q = em.createQuery(cq);
	return signleResult(q);
    }

    private boolean _isUniqueNumber(final String number) {
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
