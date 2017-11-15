package tech.lapsa.epayment.dao;

import java.util.Optional;

import javax.ejb.Local;

import tech.lapsa.epayment.domain.Invoice;
import tech.lapsa.epayment.domain.QazkomOrder;
import tech.lapsa.patterns.dao.GeneralDAO;
import tech.lapsa.patterns.dao.NotFound;
import tech.lapsa.patterns.dao.TooMuchFound;

@Local
public interface QazkomOrderDAO extends GeneralDAO<QazkomOrder, Integer> {

    QazkomOrder getByNumber(String number) throws IllegalArgumentException, NotFound;

    default Optional<QazkomOrder> optionalByNumber(String number) throws IllegalArgumentException {
	try {
	    return Optional.of(getByNumber(number));
	} catch (NotFound e) {
	    return Optional.empty();
	}
    }

    default boolean isUniqueNumber(String number) {
	try {
	    getByNumber(number);
	    return false;
	} catch (TooMuchFound e) {
	    return false;
	} catch (NotFound e) {
	    return true;
	}
    }

    QazkomOrder getLatestForInvoice(Invoice forInvoice) throws IllegalArgumentException, NotFound;

    default Optional<QazkomOrder> optionalLatestForInvoice(Invoice forInvoice) {
	try {
	    return Optional.of(getLatestForInvoice(forInvoice));
	} catch (NotFound e) {
	    return Optional.empty();
	}
    }
}
