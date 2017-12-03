package tech.lapsa.epayment.dao.beans;

import javax.ejb.Stateless;

import tech.lapsa.epayment.dao.QazkomErrorDAO;
import tech.lapsa.epayment.domain.QazkomError;

@Stateless
public class QazkomErrorDAOBean extends ABaseDAO<QazkomError, Integer> implements QazkomErrorDAO {

    public QazkomErrorDAOBean() {
	super(QazkomError.class);
    }
}
