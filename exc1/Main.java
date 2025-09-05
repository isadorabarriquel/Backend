import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        exercicio1();
        exercicio2();
        exercicio3();
        exercicio4();
        exercicio5();
        exercicio6();
        exercicio7();
    }

    static void exercicio1(){
        System.out.println("Bem-vindo ao Sistema de Geração de Jogadores!");
    }

    static void exercicio2(){
        String nome = "marina silva";
        String cargo = "Analista de sistemas";
        double salario = 4500.00;
        System.out.println("Nome: "+ nome);
        System.out.println("Cargo: "+ cargo);
        System.out.println("Salario: R$"+ salario);
    }

    static void exercicio3(){
        String produto = "marina silva";
        int codigo = 12345;
        double preco = 99.99;
        boolean promocao = true;
        System.out.println("Produto: "+ produto);
        System.out.println("Código: "+ codigo);
        System.out.println("Preço: R$"+ preco);
        System.out.println("Promoção: "+ promocao);
    }

    static void exercicio4(){
        Scanner sca = new Scanner(System.in);

        System.out.print("Digite o valor da compra: ");
        double valor = sca.nextDouble();

        if (valor >= 100){
            double desconto = valor - (valor * 0.10);
            System.out.println("Valor final com desconto: R$"+ desconto);
        }else{
            System.out.println("Valor final: R$"+ valor);
        }
        sca.close();
    }

    static void exercicio5(){
        Scanner sca = new Scanner(System.in);

        System.out.print("Digite a sua idade: ");
        int idade = sca.nextInt();
        String categoria = "";

        if (idade < 12){
            categoria = "Infantil";
        }else if (idade >= 12 && idade <= 17){
            categoria = "Adolescente";
        }else if (idade > 17){
            categoria = "Adulto";
        }else{
            System.out.println("Idade inválida. ");
        }
        System.out.println("Categoria: " + categoria);
        sca.close();
    }

    static void exercicio6(){
        double[] notas = {7, 8, 6, 9, 10};
        double soma = 0;

        for (int i = 0; i < notas.length; i++){
            System.out.println("Aluno: " + (i + 1) + ": " + notas[i]);
            soma += notas[i];
        }

        double media = soma / notas.length;
        System.out.println("\nMédia da turma: " + media );
    }

    static double calcularIMC(double peso, double altura){
        return peso / altura * altura;
    }
    static void exercicio7(){
        Scanner sca = new Scanner(System.in);

        System.out.print("Digite seu peso: ");
        double peso = sca.nextDouble();
        System.out.print("Digite sua altura: ");
        double altura = sca.nextDouble();

        double imc = calcularIMC(peso, altura);
        System.out.printf("Seu IMC é: " + imc);
        sca.close();
    }
    static void exercicio8(){
        Scanner sca = new Scanner(System.in);

        System.out.print("Digite nome do cliente: ");
        String nome = sca.nextLine();

        int espaco = nome.replace(" ", "").length();

        String maiusculo = nome.toUpperCase();

        boolean silva = nome.contains("Silva");

        System.out.println("Nome: " + espaco);
        System.out.println("Maiuscula: " + maiusculo);
        System.out.println("contem silva: " + silva);

        sca.close();
    }


}