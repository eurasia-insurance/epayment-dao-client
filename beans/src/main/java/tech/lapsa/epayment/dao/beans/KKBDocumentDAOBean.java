package tech.lapsa.epayment.dao.beans;

import javax.ejb.Singleton;

import com.lapsa.kkb.core.KKBDocument;

import tech.lapsa.epayment.dao.KKBDocumentDAO;

@Singleton
public class KKBDocumentDAOBean extends AKKBGeneralDocumentDAO<KKBDocument>
	implements KKBDocumentDAO {

    public KKBDocumentDAOBean() {
	super(KKBDocument.class);
    }
}
