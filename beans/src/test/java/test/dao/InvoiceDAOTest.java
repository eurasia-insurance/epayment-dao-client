package test.dao;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import tech.lapsa.epayment.dao.InvoiceDAO;
import tech.lapsa.epayment.domain.Invoice;
import tech.lapsa.java.commons.function.MyNumbers;

public class InvoiceDAOTest extends ArquillianBaseTestCase {

    @Inject
    private InvoiceDAO dao;

    @Test
    public void createNewTest() {
	Invoice entity = dao.save(EntitiesHelper.invoice());
	assertThat(entity, not(nullValue()));
	assertTrue(MyNumbers.positive(entity.getId()));
    }
}
