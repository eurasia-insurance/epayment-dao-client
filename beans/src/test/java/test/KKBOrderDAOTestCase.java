package test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.lapsa.kkb.core.KKBOrder;

import tech.lapsa.epayment.dao.KKBOrderDAO;
import tech.lapsa.patterns.dao.NotFound;

public class KKBOrderDAOTestCase extends ConstructorMethods {

    @Inject
    private KKBOrderDAO orderDAO;

    private static final String CREATE_AND_SAVE_ORDER_ID = "1000001";

    @Test
    public void testCreateAndSave() throws NotFound {
	KKBOrder order = newOrder(CREATE_AND_SAVE_ORDER_ID);
	order = orderDAO.save(order);

	KKBOrder testFind = orderDAO.getById(CREATE_AND_SAVE_ORDER_ID);
	assertThat(testFind, not(nullValue()));
	assertThat(testFind.getId(), allOf(not(nullValue()), is(CREATE_AND_SAVE_ORDER_ID)));
	assertThat(testFind.getAmount(), equalTo(500d));
    }

    private static final String CREATE_SAVE_AND_ADD_NEW_REQUEST_ORDER_ID = "1000002";
    private static final String CREATE_SAVE_AND_ADD_NEW_REQUEST_NEW_RESPONSE_CONTENT = "<xml2></xml2>";

    @Test
    public void testCreateSaveAndAddNewRequest() throws NotFound {
	KKBOrder order = newOrder(CREATE_SAVE_AND_ADD_NEW_REQUEST_ORDER_ID);
	order = orderDAO.save(order);

	attachNewResponse(order);
	order.getLastResponse().setContent(CREATE_SAVE_AND_ADD_NEW_REQUEST_NEW_RESPONSE_CONTENT);
	order = orderDAO.save(order);

	KKBOrder testFind = orderDAO.getById(order.getId());

	assertThat(testFind, not(nullValue()));
	assertThat(testFind.getLastResponse(), notNullValue());
	assertThat(testFind.getLastResponse().getContent(), is(CREATE_SAVE_AND_ADD_NEW_REQUEST_NEW_RESPONSE_CONTENT));

    }
}
