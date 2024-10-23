package pe.edu.cibertec.dswii_ef_soap_penanectar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
public class GeneroWsdlConfig {
    @Bean(name = "generos")
    public DefaultWsdl11Definition generoWsdl11Definition(XsdSchema generoEsquema){
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("GenerosPort");
        wsdl11Definition.setLocationUri("/ws/generos");
        wsdl11Definition.setTargetNamespace("http://www.cibertec.edu.pe/ws/objects");
        wsdl11Definition.setSchema(generoEsquema);
        return wsdl11Definition;
    }
    @Bean
    public XsdSchema generoEsquema(){
        return new SimpleXsdSchema(
                new ClassPathResource("xsd/genero.xsd"));
    }
}
