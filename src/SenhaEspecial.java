import java.util.ArrayList;
import java.util.List;
public class SenhaEspecial {
    public static List<String> caracteresFaltando(String senha) {
        List<String> faltando = new ArrayList<>();

        boolean Maiuscula = false;
        boolean Minuscula = false;
        boolean Numero = false;
        boolean Especial = false;

        String caractereEspeciais = "!@#$%^&*()-+";

        for (char c : senha.toCharArray()) {
            if (Character.isUpperCase(c)) {
                Maiuscula = true;
            } else if (Character.isLowerCase(c)) {
                Minuscula = true;
            } else if (Character.isDigit(c)) {
                Numero = true;
            } else if (caractereEspeciais.contains(String.valueOf(c))) {
                Especial = true;
            }
        }

        if (!Maiuscula) {
            faltando.add("Maiúscula");
        }
        if (!Minuscula) {
            faltando.add("Minúscula");
        }
        if (!Numero) {
            faltando.add("Número");
        }
        if (!Especial) {
            faltando.add("Caractere Especial");
        }
        if (senha.length() < 6) {
            faltando.add("Comprimento Mínimo de 6 caracteres");
        }
        return faltando;
    }

    public static void main(String[] args) {
        String senha = "Ya3";
        List<String> caracteresFaltando = caracteresFaltando(senha);

        if (caracteresFaltando.isEmpty()) {
            System.out.println("A senha atende aos critérios.");
        } else {
            System.out.println("A senha está faltando os seguintes critérios:");
            for (String criterio : caracteresFaltando) {
                System.out.println(criterio);
            }
        }
    }
}