package tech.lapsa.epayment.dao;

import javax.ejb.Local;

import tech.lapsa.epayment.domain.QazkomOrder;
import tech.lapsa.patterns.dao.GeneralDAO;

@Local
public interface QazkomOrderDAO extends GeneralDAO<QazkomOrder, Integer> {
}
