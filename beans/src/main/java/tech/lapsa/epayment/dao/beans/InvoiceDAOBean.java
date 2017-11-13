package tech.lapsa.epayment.dao.beans;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import tech.lapsa.epayment.dao.InvoiceDAO;
import tech.lapsa.epayment.domain.Invoice;
import tech.lapsa.epayment.domain.Invoice_;
import tech.lapsa.java.commons.function.MyStrings;
import tech.lapsa.patterns.dao.NotFound;
import tech.lapsa.patterns.dao.TooMuchFound;

@Stateless
public class InvoiceDAOBean extends ABaseDAO<Invoice, Integer> implements InvoiceDAO {

    public InvoiceDAOBean() {
	super(Invoice.class);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Invoice getByNumber(String number) throws IllegalArgumentException, NotFound, TooMuchFound {
	MyStrings.requireNonEmpty(number, "number");

	CriteriaBuilder cb = em.getCriteriaBuilder();
	CriteriaQuery<Invoice> cq = cb.createQuery(Invoice.class);
	Root<Invoice> root = cq.from(Invoice.class);
	cq.select(root) //
		.where(cb.equal(root.get(Invoice_.number), number));

	TypedQuery<Invoice> q = em.createQuery(cq);
	return signleResultNoCached(q);
    }
}
