package pe.edu.cibertec.dswii_ef_soap_penanectar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
public class UsuarioWsdlConfig {
    @Bean(name = "usuarios")
    public DefaultWsdl11Definition usuarioWsdl11Definition(XsdSchema usuarioEsquema){
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("UsuariosPort");
        wsdl11Definition.setLocationUri("/ws/usuarios");
        wsdl11Definition.setTargetNamespace("http://www.cibertec.edu.pe/ws/objects");
        wsdl11Definition.setSchema(usuarioEsquema);
        return wsdl11Definition;
    }
    @Bean
    public XsdSchema usuarioEsquema(){        
        return new SimpleXsdSchema(
                new ClassPathResource("xsd/usuario.xsd"));
    }
}
