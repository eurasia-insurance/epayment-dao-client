package tech.lapsa.epayment.dao.beans;

import javax.ejb.Stateless;

import tech.lapsa.epayment.dao.QazkomPaymentDAO;
import tech.lapsa.epayment.domain.QazkomPayment;

@Stateless
public class QazkomPaymentDAOBean extends ABaseDAO<QazkomPayment, Integer> implements QazkomPaymentDAO {

    public QazkomPaymentDAOBean() {
	super(QazkomPayment.class);
    }
}
