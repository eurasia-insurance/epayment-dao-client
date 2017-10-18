package tech.lapsa.epayment.dao;

import java.util.List;

import com.lapsa.kkb.core.KKBDocument;
import com.lapsa.kkb.core.KKBOrder;

import tech.lapsa.patterns.dao.GeneralDAO;

public interface KKBGeneralDocumentDAO<T extends KKBDocument> extends GeneralDAO<T, Integer> {

    List<T> findByOrder(KKBOrder order);
}
