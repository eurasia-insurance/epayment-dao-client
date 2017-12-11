package tech.lapsa.epayment.dao.beans;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tech.lapsa.epayment.jpa.EpaymentConstants;
import tech.lapsa.patterns.dao.beans.AGeneralDAO;

public abstract class ABaseDAO<T extends Serializable, I extends Serializable> extends AGeneralDAO<T, I> {

    protected ABaseDAO(final Class<T> entityClazz) {
	super(entityClazz);
    }

    @PersistenceContext(unitName = EpaymentConstants.PERSISTENCE_UNIT_NAME)
    protected EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
	return em;
    }
}
