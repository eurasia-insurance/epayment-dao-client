package tech.lapsa.epayment.dao;

import javax.ejb.Local;

import tech.lapsa.epayment.domain.Payment;
import tech.lapsa.patterns.dao.GeneralDAO;

@Local
public interface PaymentDAO extends GeneralDAO<Payment, Integer> {
}
