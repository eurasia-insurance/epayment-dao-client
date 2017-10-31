package tech.lapsa.epayment.dao;

import javax.ejb.Local;

import tech.lapsa.epayment.domain.QazkomPayment;
import tech.lapsa.patterns.dao.GeneralDAO;

@Local
public interface QazkomPaymentDAO extends GeneralDAO<QazkomPayment, Integer> {
}
