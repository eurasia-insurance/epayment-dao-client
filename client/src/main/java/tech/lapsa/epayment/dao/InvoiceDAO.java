package tech.lapsa.epayment.dao;

import javax.ejb.Local;

import tech.lapsa.epayment.domain.Invoice;
import tech.lapsa.patterns.dao.GeneralDAO;

@Local
public interface InvoiceDAO extends GeneralDAO<Invoice, Integer> {
}
