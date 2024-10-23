package pe.edu.cibertec.dswii_ef_soap_penanectar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
public class ContenidoWsdlConfig {
    @Bean(name = "contenidos")
    public DefaultWsdl11Definition contenidoWsdl11Definition(XsdSchema contenidoEsquema){
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ContenidosPort");
        wsdl11Definition.setLocationUri("/ws/contenidos");
        wsdl11Definition.setTargetNamespace("http://www.cibertec.edu.pe/ws/objects");
        wsdl11Definition.setSchema(contenidoEsquema);
        return wsdl11Definition;
    }
    @Bean
    public XsdSchema contenidoEsquema(){
        return new SimpleXsdSchema(
                new ClassPathResource("xsd/contenido.xsd"));
    }
}
