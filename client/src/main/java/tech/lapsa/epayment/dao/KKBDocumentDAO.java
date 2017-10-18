package tech.lapsa.epayment.dao;

import javax.ejb.Local;

import com.lapsa.kkb.core.KKBDocument;

@Local
public interface KKBDocumentDAO extends KKBGeneralDocumentDAO<KKBDocument> {
}
