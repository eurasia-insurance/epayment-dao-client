package test.dao;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.lapsa.fin.FinCurrency;
import com.lapsa.international.localization.LocalizationLanguage;

import tech.lapsa.epayment.dao.InvoiceDAO;
import tech.lapsa.epayment.domain.Invoice;
import tech.lapsa.java.commons.function.MyNumbers;
import tech.lapsa.java.commons.logging.MyLogger;
import tech.lapsa.kz.taxpayer.TaxpayerNumber;

public class InvoiceDAOTest extends ArquillianBaseTestCase {

    @Inject
    private InvoiceDAO dao;

    private static MyLogger logger = MyLogger.getDefault();

    @Test
    public void createNewTest() {
	logger.INFO.log("createEntity(): Create entity");
	Invoice entity = dao.save(Invoice.builder() //
		.withCurrencty(FinCurrency.KZT) //
		.withConsumer("John Bull", "john.bull@mail.com", LocalizationLanguage.RUSSIAN,
			TaxpayerNumber.of("800225000319")) //
		.withExternalId("123") //
		.withItem("Apple iPhone X", 1, 1000d) //
		.withItem("Apple MacBook Pro", 1, 2000d) //
		.build());
	assertThat(entity, not(nullValue()));
	assertTrue(MyNumbers.positive(entity.getId()));
    }
}
