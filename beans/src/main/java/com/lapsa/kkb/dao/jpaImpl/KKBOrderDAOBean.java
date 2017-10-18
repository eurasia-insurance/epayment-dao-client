package com.lapsa.kkb.dao.jpaImpl;

import javax.ejb.Singleton;

import com.lapsa.kkb.core.KKBOrder;
import com.lapsa.kkb.dao.KKBOrderDAO;

@Singleton
public class KKBOrderDAOBean extends AEntityManagerDAO<KKBOrder, String> implements KKBOrderDAO {

    public KKBOrderDAOBean() {
	super(KKBOrder.class);
    }
}
