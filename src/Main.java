public class Main {
    public static void main(String[] args) {
        User user = new User();
        boolean existe;

        // Chamando o método verificarUsuario com strings corretas
        existe = user.verificarUsuario("login", "senha");

        // Exibindo o resultado
        if (existe) {
            System.out.println("Usuário encontrado: " + user.nome);
        } else {
            System.out.println("Usuário não encontrado.");
        }
        System.out.println("Hello, World!");
    }
}