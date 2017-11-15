package tech.lapsa.epayment.dao;

import java.util.Optional;

import javax.ejb.Local;

import tech.lapsa.epayment.domain.Invoice;
import tech.lapsa.patterns.dao.GeneralDAO;
import tech.lapsa.patterns.dao.NotFound;
import tech.lapsa.patterns.dao.TooMuchFound;

@Local
public interface InvoiceDAO extends GeneralDAO<Invoice, Integer> {

    Invoice getByNumber(String number) throws IllegalArgumentException, NotFound;

    default Optional<Invoice> optionalByNumber(String number) throws IllegalArgumentException {
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
}
