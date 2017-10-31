package tech.lapsa.epayment.dao.beans;

import javax.ejb.Stateless;

import tech.lapsa.epayment.dao.QazkomOrderDAO;
import tech.lapsa.epayment.domain.QazkomOrder;

@Stateless
public class QazkomOrderDAOBean extends ABaseDAO<QazkomOrder, Integer> implements QazkomOrderDAO {

    public QazkomOrderDAOBean() {
	super(QazkomOrder.class);
    }
}
