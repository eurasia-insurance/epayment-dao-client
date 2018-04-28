package tech.lapsa.epayment.dao;

import javax.ejb.Local;
import javax.ejb.Remote;

import tech.lapsa.epayment.domain.Bank;
import tech.lapsa.java.commons.exceptions.IllegalArgument;
import tech.lapsa.patterns.dao.GeneralDAO;
import tech.lapsa.patterns.dao.NotFound;

public interface BankDAO extends GeneralDAO<Bank, Integer>, EJBConstants {

    public static final String BEAN_NAME = "BankDAOBean";

    @Local
    public interface BankDAOLocal extends BankDAO {
    }

    @Remote
    public interface BankDAORemote extends BankDAO {
    }

    Bank getByCode(String code) throws IllegalArgument, NotFound;
    
    Bank getByBIN(String bin) throws IllegalArgument, NotFound;

    boolean isUniqueCode(String code) throws IllegalArgument;
}
