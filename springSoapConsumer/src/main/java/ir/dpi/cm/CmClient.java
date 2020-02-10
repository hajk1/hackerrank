package ir.dpi.cm;

import ir.dpi.shaparak.settlement.proxy.model.DPIAchRequest;
import ir.dpi.shaparak.settlement.proxy.model.DPIPayaRequestMessage;
import ir.dpi.shaparak.settlement.proxy.model.DPIPayaRequestService;
import ir.dpi.shaparak.settlement.proxy.model.ObjectFactory;
import ir.dpi.shaparak.settlement.proxy.model.PayaFundTransfer;
import ir.dpi.shaparak.settlement.proxy.model.PayaFundTransferResponse;
import ir.dpi.shaparak.settlement.proxy.model.SignonRequest;
import ir.dpi.shaparak.settlement.proxy.model.SignonToken;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

/**
 * Author: <a href="mailto:k1.tehrani@gmail.com">Kayvan Tehrani</a>
 *
 * Description: <the description of the class for java doc by those that might use it, please use html if possible>
 */
public class CmClient extends WebServiceGatewaySupport {

  private static final Logger log = LogManager.getLogger(CmClient.class);

  public PayaFundTransferResponse insertPaya() {
    ObjectFactory factory = new ObjectFactory();

    DPIPayaRequestMessage dpiPayaRequestMessage = new DPIPayaRequestMessage();
    SignonRequest signonRequest = factory.createSignonRequest();
    SignonToken signonToken = factory.createSignonToken();
    signonToken.setUsername("ehsan1");
    signonToken.setCredential("5eSXF\\(sY!a:FW9d");
    signonRequest.setSignonToken(signonToken);
    signonRequest.setChannelCode("DPI");
    dpiPayaRequestMessage.setSignonRequest(signonRequest);
    PayaFundTransfer request = factory.createPayaFundTransfer();
    DPIPayaRequestService dpiPayaRequestService = new DPIPayaRequestService();
    dpiPayaRequestService.setTransactiontype("N");
    dpiPayaRequestService.setRequestUUID(String.valueOf(java.util.UUID.randomUUID()));
    DPIAchRequest dpiAchRequest = new DPIAchRequest();
    dpiAchRequest
        .setDebtorAccountNumber(factory.createDPIAchRequestDebtorAccountNumber("0102222633008"));
    dpiAchRequest.setDeptorAmount(factory.createDPIAchRequestDeptorAmount(1l));
    dpiAchRequest.setEquivalentAmount(factory.createDPIAchRequestEquivalentAmount(1l));
    dpiAchRequest.setChequeNumber(factory.createDPIAchRequestChequeNumber("0"));
    dpiAchRequest.setValueDate(factory.createDPIAchRequestValueDate("980405"));
    dpiAchRequest.setLanguageCode(factory.createDPIAchRequestLanguageCode("ف"));
    dpiAchRequest.setPrintId(factory.createDPIAchRequestPrintId("N"));
    dpiAchRequest.setChargeCode(factory.createDPIAchRequestChargeCode("خ"));
    dpiAchRequest.setRunDate(factory.createDPIAchRequestRunDate("980405"));
    dpiAchRequest.setCreditorBank(factory.createDPIAchRequestCreditorBank("17"));
    dpiAchRequest.setCreditorAccountNo(
        factory.createDPIAchRequestCreditorAccountNo("IR230170000000219910300000"));
    dpiPayaRequestService.setPayaRqData(dpiAchRequest);
    request.setDpiPayaRequestMessage(factory.createDPIPayaRequestMessage());
    request.getDpiPayaRequestMessage().setDpiPayaRqService(dpiPayaRequestService);
    dpiPayaRequestService.setPayaRqData(dpiAchRequest);
    dpiPayaRequestMessage.setDpiPayaRqService(dpiPayaRequestService);
    request.setDpiPayaRequestMessage(dpiPayaRequestMessage);

//    log.info("Requesting paya " + request);

    PayaFundTransferResponse response = (PayaFundTransferResponse) getWebServiceTemplate()
        .marshalSendAndReceive("http://10.10.15.196:9091/cmservices", request,
            new SoapActionCallback(
                "payaFundTransfer"));

    return response;
  }

}