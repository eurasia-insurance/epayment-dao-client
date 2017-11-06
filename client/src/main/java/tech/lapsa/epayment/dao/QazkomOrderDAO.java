package tech.lapsa.epayment.dao;

import java.util.Optional;

import javax.ejb.Local;

import tech.lapsa.epayment.domain.QazkomOrder;
import tech.lapsa.patterns.dao.GeneralDAO;
import tech.lapsa.patterns.dao.NotFound;
import tech.lapsa.patterns.dao.TooMuchFound;

@Local
public interface QazkomOrderDAO extends GeneralDAO<QazkomOrder, Integer> {
    QazkomOrder getByNumber(String number) throws NotFound, IllegalArgumentException, TooMuchFound;

    default Optional<QazkomOrder> optionalByNumber(String number) throws IllegalArgumentException, TooMuchFound {
	try {
	    return Optional.of(getByNumber(number));
	} catch (NotFound e) {
	    return Optional.empty();
	}
    }
}
