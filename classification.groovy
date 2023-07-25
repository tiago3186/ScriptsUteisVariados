import com.sap.it.api.mapping.*
import com.sap.gateway.ip.core.customdev.util.Message
import java.util.HashMap

// manipula uma string arg1 no mapeamento e define qual o resultado de saída

def String customFunc(String arg1) {
   if (arg1 >= "0" && arg1 <= "6") {
      arg1 += " Categoria 1"
   } else if (arg1 >= "7" && arg1 <= "8") {
      arg1 += " Categoria 2"
   } else if (arg1 >= "9" && arg1 <= "10") {
      arg1 += " Categoria 3"
   } else {
      arg1 += "Categoria inválida"
   }

   return arg1
}