import com.sap.gateway.ip.core.customdev.util.Message
import groovy.xml.XmlUtil

// Verifica se a string recebida tem formato de e-mail 

def Message processData(Message message) {
    // Obtém o conteúdo XML da mensagem
    def xmlString = message.getBody(String) // Certifique-se de que o corpo da mensagem seja tratado como String

    // Faz o parsing do XML
    def xml = new XmlSlurper().parseText(xmlString)

    // Acessar o campo "email" no XML
    def emailValue = xml.email.text() // Converte o valor do nó para uma String

    // Verificar se o campo "email" está no formato correto de um e-mail
    if (isValidEmail(emailValue)) {
        // Caso esteja no formato correto, o campo continua com o mesmo valor normalmente
        // Não fazemos nada e o XML não é modificado.
    } else {
        // Caso não esteja no formato correto, tornar o campo "email" em branco ("")
        xml.email = ""
    }

    // Converter o XML de volta para String
    def modifiedXmlString = groovy.xml.XmlUtil.serialize(xml)

    // Atualizar o conteúdo do corpo da mensagem com o XML modificado
    message.setBody(modifiedXmlString)

    return message
}

// Função para verificar se o valor passado é um endereço de e-mail válido
def boolean isValidEmail(String email) {
    // Expressão regular para validar o formato de um endereço de e-mail
    def emailPattern = /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/
    return email.matches(emailPattern)
}