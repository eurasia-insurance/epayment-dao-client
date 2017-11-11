package tech.lapsa.epayment.dao;

import javax.ejb.Local;

import tech.lapsa.epayment.domain.APayment;
import tech.lapsa.patterns.dao.GeneralDAO;

@Local
public interface PaymentDAO extends GeneralDAO<APayment, Integer> {
}
