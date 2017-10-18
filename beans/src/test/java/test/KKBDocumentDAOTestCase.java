package test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.lapsa.kkb.core.KKBDocument;
import com.lapsa.kkb.core.KKBOrder;
import com.lapsa.kkb.core.KKBPaymentRequestDocument;
import com.lapsa.kkb.dao.KKBDocumentDAO;
import com.lapsa.kkb.dao.KKBOrderDAO;

import tech.lapsa.patterns.dao.NotFound;

public class KKBDocumentDAOTestCase extends ConstructorMethods {

    @Inject
    private KKBDocumentDAO documentDAO;

    @Inject
    private KKBOrderDAO orderDAO;

    private static final String CREATE_AND_SAVE_REQUEST_CONTENT = "<xml></xml>";

    @Test
    public void testCreateAndSave_Request() throws NotFound {
	KKBPaymentRequestDocument request = newRequest(CREATE_AND_SAVE_REQUEST_CONTENT);
	request = (KKBPaymentRequestDocument) documentDAO.save(request);
	assertThat(request.getId(), allOf(not(nullValue()), greaterThan(0)));

	KKBDocument testRequest = documentDAO.getById(request.getId());
	assertThat(testRequest, allOf(not(nullValue()), instanceOf(KKBPaymentRequestDocument.class)));
	assertThat(testRequest.getContent(), is(CREATE_AND_SAVE_REQUEST_CONTENT));
    }

    private static final String CREATE_SAVE_AND_ATTACH_TO_ORDER_REQUEST_CONTENT = "<xml></xml>";

    @Test
    public void testCreateSaveAndAttachToOrder() throws NotFound {

	KKBPaymentRequestDocument request = newRequest(CREATE_SAVE_AND_ATTACH_TO_ORDER_REQUEST_CONTENT);
	request = (KKBPaymentRequestDocument) documentDAO.save(request);
	assertThat(request.getId(), allOf(not(nullValue()), greaterThan(0)));
	assertThat(request.getOrder(), nullValue());

	String orderId = genOrderId();
	KKBOrder order = newOrder(orderId);
	order = orderDAO.save(order);

	order.setLastRequest(request);
	order = orderDAO.save(order);

	KKBDocument testRequest = documentDAO.getById(request.getId());
	assertThat(testRequest, allOf(not(nullValue()), instanceOf(KKBPaymentRequestDocument.class)));
	assertThat(testRequest.getOrder(), not(nullValue()));
	assertThat(testRequest.getOrder().getId(), is(orderId));
    }

    @Test
    public void testFindByOrder() throws NotFound {
	String orderId = genOrderId();
	KKBOrder order = newOrder(orderId);

	// first check
	attachNewRequest(order);
	attachNewResponse(order);
	attachNewCart(order);
	order = orderDAO.save(order);
	List<KKBDocument> docs1 = documentDAO.findByOrder(order);
	assertThat(docs1, allOf(not(nullValue()), hasSize(3)));
	assertThat(docs1, containsInAnyOrder(order.getLastCart(), order.getLastRequest(), order.getLastResponse()));

	// second check
	attachNewRequest(order);
	attachNewResponse(order);
	attachNewCart(order);
	order = orderDAO.save(order);
	List<KKBDocument> docs2 = documentDAO.findByOrder(order);
	assertThat(docs2, allOf(not(nullValue()), hasSize(6)));

	assertThat(docs2, allOf(not(nullValue()),
		containsInAnyOrder(order.getLastCart(), order.getLastRequest(), order.getLastResponse(), docs1.get(0),
			docs1.get(1), docs1.get(2))));
    }

}
