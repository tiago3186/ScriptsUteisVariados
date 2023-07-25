import com.sap.it.api.mapping.*
import com.sap.gateway.ip.core.customdev.util.Message
import java.util.HashMap

// Pega uma string no mapeamento e manipula o primeiro caracter

def String customFunc(String arg1) {
   def arg2 = arg1.replaceFirst('[^0-9]+', '')
   return arg2
}
