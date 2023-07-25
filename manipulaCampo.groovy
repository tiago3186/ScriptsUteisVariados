import com.sap.gateway.ip.core.customdev.util.Message
import groovy.xml.XmlUtil

// Manipula um message que chega como XML e o retorna após alterações
// Ex: root > nomedocampo

def Message processData(Message message) {
    // Obtém o conteúdo XML da mensagem
    def xmlString = message.getBody(String)

    // Faz o parsing do XML
    def xml = new XmlSlurper().parseText(xmlString)    

    // Altera o valor do campo para qualquer outra coisa
    xml.nomedocampo = "valor novo do campo"

    // Converter o XML de volta para String
    def modifiedXmlString = groovy.xml.XmlUtil.serialize(xml)

    // Atualizar o conteúdo do corpo da mensagem com o XML modificado
    message.setBody(modifiedXmlString)

    return message
}