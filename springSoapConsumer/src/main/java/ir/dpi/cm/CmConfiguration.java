package ir.dpi.cm;

import org.apache.commons.lang.ArrayUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.WebServiceClientException;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.context.MessageContext;

/**
 * Author: <a href="mailto:k1.tehrani@gmail.com">Kayvan Tehrani</a>
 *
 * Description: <the description of the class for java doc by those that might use it, please use html if possible>
 */
@Configuration
public class CmConfiguration {

  private static final Logger log = LogManager.getLogger(CmConfiguration.class);

  @Bean
  public Jaxb2Marshaller marshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    // this package must match the package in the <generatePackage> specified in
    // pom.xml
    marshaller.setContextPath("ir.dpi.shaparak.settlement.proxy.model");
    return marshaller;
  }

  @Bean
  public CmClient cmClient(Jaxb2Marshaller marshaller) {
    CmClient client = new CmClient();
    client.setDefaultUri("http://10.10.15.196:9091/cmservices");
    client.setMarshaller(marshaller);
    client.setUnmarshaller(marshaller);
    client.setInterceptors(enrichInterceptors(client.getInterceptors()));
    return client;
  }

  private ClientInterceptor[] enrichInterceptors(ClientInterceptor[] interceptors) {
    interceptors = (ClientInterceptor[]) ArrayUtils.add(interceptors, new ClientInterceptor() {
      @Override
      public boolean handleRequest(MessageContext messageContext) throws WebServiceClientException {
        return true;
      }

      @Override
      public boolean handleResponse(MessageContext messageContext)
          throws WebServiceClientException {
        return true;
      }

      @Override
      public boolean handleFault(MessageContext messageContext) throws WebServiceClientException {
        return true;
      }

      @Override
      public void afterCompletion(MessageContext messageContext, Exception ex)
          throws WebServiceClientException {
//        HttpUrlConnection connection = (HttpUrlConnection) TransportContextHolder.getTransportContext().getConnection();
//
//        String requestHeaders = "";
//        for(Header header : ;) {
//          requestHeaders += header.getName() + ": " + header.getValue() + "; ";
//        }
//        connection.getConnection().getHeaderFields().forEach(log::trace);

//        String responseHeaders = "";
//        for(Header header : connection.getHttpResponse().getAllHeaders()) {
//          responseHeaders += header.getName() + ": " + header.getValue() + "; ";
//        }

//        System.out.println("Request HTTP Headers : "+requestHeaders);
//        System.out.println("Response HTTP Headers : "+responseHeaders);
      }
    });
    return interceptors;
  }

}