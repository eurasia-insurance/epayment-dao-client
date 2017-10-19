package tech.lapsa.epayment.dao.beans;

import javax.ejb.Singleton;

import com.lapsa.kkb.core.KKBOrder;

import tech.lapsa.epayment.dao.KKBOrderDAO;

@Singleton
public class KKBOrderDAOBean extends ABaseDAO<KKBOrder, String> implements KKBOrderDAO {

    public KKBOrderDAOBean() {
	super(KKBOrder.class);
    }
}
