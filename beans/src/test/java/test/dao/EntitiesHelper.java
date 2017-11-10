package test.dao;

import com.lapsa.fin.FinCurrency;
import com.lapsa.international.localization.LocalizationLanguage;

import tech.lapsa.epayment.domain.Invoice;
import tech.lapsa.kz.taxpayer.TaxpayerNumber;

public final class EntitiesHelper {

    private EntitiesHelper() {
    }

    public static Invoice invoice() {
	return Invoice.builder() //
		.withCurrencty(FinCurrency.KZT) //
		.withConsumer("John Bull", "john.bull@mail.com", LocalizationLanguage.RUSSIAN,
			TaxpayerNumber.of("800225000319")) //
		.withExternalId("123") //
		.withItem("Apple iPhone X", 1, 1000d) //
		.withItem("Apple MacBook Pro", 1, 2000d) //
		.build();
    }
}
