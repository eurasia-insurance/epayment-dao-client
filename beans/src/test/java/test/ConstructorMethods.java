package test;

import java.time.Instant;
import java.util.UUID;

import com.lapsa.fin.FinCurrency;
import com.lapsa.kkb.core.KKBCartDocument;
import com.lapsa.kkb.core.KKBOrder;
import com.lapsa.kkb.core.KKBOrderItem;
import com.lapsa.kkb.core.KKBPaymentRequestDocument;
import com.lapsa.kkb.core.KKBPaymentResponseDocument;

public abstract class ConstructorMethods extends ArquillianBaseTestCase {

    protected String genOrderId() {
	UUID uuid = UUID.randomUUID();
	long lng = Math.abs(uuid.getLeastSignificantBits() / 10000);
	String id = String.format("%015d", lng);
	return id;
    }

    protected KKBOrder newOrder(String orderId) {
	KKBOrder order = new KKBOrder(orderId);
	order.setCurrency(FinCurrency.KZT);
	order.setCreated(Instant.now());

	KKBOrderItem item = new KKBOrderItem();
	item.setName("ПОЛИС ОС ГПО ВТС");
	item.setCost(500d);
	item.setQuantity(1);
	order.addItem(item);

	attachNewRequest(order);
	attachNewResponse(order);
	attachNewCart(order);

	return order;
    }

    protected KKBPaymentRequestDocument newRequest(String content) {
	KKBPaymentRequestDocument doc = new KKBPaymentRequestDocument();
	doc.setCreated(Instant.now());
	doc.setContent(content);
	return doc;
    }

    protected void attachNewRequest(KKBOrder order) {
	KKBPaymentRequestDocument request = newRequest("<xml></xml>");
	order.setLastRequest(request);
    }

    private KKBCartDocument newCart(String content) {
	KKBCartDocument doc = new KKBCartDocument();
	doc.setCreated(Instant.now());
	doc.setContent(content);
	return doc;
    }

    protected void attachNewCart(KKBOrder order) {
	KKBCartDocument cart = newCart("<xml></xml>");
	order.setLastCart(cart);
    }

    private KKBPaymentResponseDocument newResponse(String content) {
	KKBPaymentResponseDocument doc = new KKBPaymentResponseDocument();
	doc.setCreated(Instant.now());
	doc.setContent(content);
	return doc;
    }

    protected void attachNewResponse(KKBOrder order) {
	KKBPaymentResponseDocument response = newResponse("<xml></xml>");
	order.setLastResponse(response);
    }
}
