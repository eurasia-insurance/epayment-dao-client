package test.dao;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import tech.lapsa.epayment.dao.InvoiceDAO;
import tech.lapsa.epayment.domain.Invoice;
import tech.lapsa.java.commons.function.MyNumbers;
import tech.lapsa.java.commons.logging.MyLogger;

public class InvoiceDAOTest extends ArquillianBaseTestCase {

    @Inject
    private InvoiceDAO dao;

    private static MyLogger logger = MyLogger.getDefault();

    @Test
    public void createNewTest() {
	logger.INFO.log("createNewTest()");
	Invoice entity = dao.save(EntitiesHelper.invoice());
	assertThat(entity, not(nullValue()));
	assertTrue(MyNumbers.positive(entity.getId()));
    }
}
