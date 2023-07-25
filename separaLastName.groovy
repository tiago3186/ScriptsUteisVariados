import com.sap.it.api.mapping.*;

// pega da segunda palavra em diante da string arg1 assumindo que é um sobrenome e retorna o sobrenome

def String sobrenomes(String arg1){
    String[] palavras = arg1.split("\\s+");
    if (palavras.length > 1) {
        StringBuilder sobrenomes = new StringBuilder();
        for (int i = 1; i < palavras.length; i++) {
            sobrenomes.append(palavras[i]);
            if (i < palavras.length - 1) {
                sobrenomes.append(" ");
            }
        }
        arg1 = sobrenomes.toString();
    } else {
        arg1 = "Error: Last name not provided";
    }
    return arg1;
}
