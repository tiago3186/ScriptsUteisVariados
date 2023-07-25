import com.sap.it.api.mapping.*
import com.sap.gateway.ip.core.customdev.util.Message
import java.util.HashMap

// Exemplo básico de manipulação de uma string

def String customFunc(String arg1) {
   def arg1 = "L" + arg1
   return arg1
}
