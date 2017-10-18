package com.lapsa.kkb.dao.jpaImpl;

import javax.ejb.Singleton;

import com.lapsa.kkb.core.KKBDocument;
import com.lapsa.kkb.dao.KKBDocumentDAO;

@Singleton
public class KKBDocumentDAOBean extends AKKBGeneralDocumentDAO<KKBDocument>
	implements KKBDocumentDAO {

    public KKBDocumentDAOBean() {
	super(KKBDocument.class);
    }
}
