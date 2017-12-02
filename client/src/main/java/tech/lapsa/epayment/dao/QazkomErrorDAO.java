package tech.lapsa.epayment.dao;

import javax.ejb.Local;

import tech.lapsa.epayment.domain.QazkomError;
import tech.lapsa.patterns.dao.GeneralDAO;

@Local
public interface QazkomErrorDAO extends GeneralDAO<QazkomError, Integer> {
}
