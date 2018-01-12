package tech.lapsa.epayment.dao;

import javax.ejb.Local;
import javax.ejb.Remote;

import tech.lapsa.epayment.domain.QazkomError;
import tech.lapsa.patterns.dao.GeneralDAO;

public interface QazkomErrorDAO extends GeneralDAO<QazkomError, Integer>, EJBConstants {

    public static final String BEAN_NAME = "QazkomErrorDAOBean";

    @Local
    public interface QazkomErrorDAOLocal extends QazkomErrorDAO {
    }

    @Remote
    public interface QazkomErrorDAORemote extends QazkomErrorDAO {
    }
}
