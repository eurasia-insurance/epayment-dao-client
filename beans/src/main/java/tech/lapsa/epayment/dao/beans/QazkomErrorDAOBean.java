package tech.lapsa.epayment.dao.beans;

import javax.ejb.Stateless;

import tech.lapsa.epayment.dao.QazkomErrorDAO;
import tech.lapsa.epayment.dao.QazkomErrorDAO.QazkomErrorDAOLocal;
import tech.lapsa.epayment.dao.QazkomErrorDAO.QazkomErrorDAORemote;
import tech.lapsa.epayment.domain.QazkomError;

@Stateless(name = QazkomErrorDAO.BEAN_NAME)
public class QazkomErrorDAOBean extends ABaseDAO<QazkomError, Integer>
	implements QazkomErrorDAOLocal, QazkomErrorDAORemote {

    public QazkomErrorDAOBean() {
	super(QazkomError.class);
    }
}
