package src.ecommerce.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import src.ecommerce.model.vo.ProdutoVO;

//banco de dados falso
 //Padrão Singleton: so pode existir um unico banco/instancia

public class BancoDeMemoria {

    //Cria uma variável estática e privada do mesmo tipo da classe
    //guarda a única instância
    //O 'static' -> todo mundo olha pro mesmo local na memoria
    private static BancoDeMemoria instanciaUnica;
    
    
    // lista que simula as tabelas do banco de dados
    // Vai guardar todos os produtos da loja na memória RAM.
    private List<ProdutoVO> tabelaProdutos;

    //O Construtor precisa ser PRIVADO
    //impede que alguém de fora dê um "new BancoDeMemoria()"
    private BancoDeMemoria() {
    	
    	tabelaProdutos = new ArrayList<>();
        
        tabelaProdutos.add(new ProdutoVO(1, "Livros - Clean Code", 120.00));
        tabelaProdutos.add(new ProdutoVO(2, "E-book - Clean Code", 85.00));
        tabelaProdutos.add(new ProdutoVO(3, "Livros - Box: O Senhor dos Anéis", 450.00));
        tabelaProdutos.add(new ProdutoVO(4, "E-book - Box: O Senhor dos Anéis", 45.00));
        tabelaProdutos.add(new ProdutoVO(5, "Livros - Arquitetura Limpa", 110.00));
        tabelaProdutos.add(new ProdutoVO(6, "E-Book - Arquitetura Limpa", 11.00));
        
        tabelaProdutos.add(new ProdutoVO(7, "Livros - Think Python", 110.00));
        tabelaProdutos.add(new ProdutoVO(8, "E-Book - Think Python", 11.00));
        tabelaProdutos.add(new ProdutoVO(9,  "Livros - Box: The Witcher", 200.00));
        tabelaProdutos.add(new ProdutoVO(10, "E-Book - Box: The Witcher", 25.00));
    	
    	String[] titleStarts = {
    	        "O Livro de",
    	        "Como Entender",
    	        "O Segredo da Vida Sobre",
    	        "Um Guia para Iniciantes Sobre",
    	        "A Arte de",
    	        "O Curioso Caso sobre",
    	        "101 Maneiras de Maestrar",
    	        "O Esquecido Mundo sobre",
    	        "Uma Introdução sobre",
    	        "Guia DEFINITIVO sobre"
    	    };

    	String[] ideas = {
    	        "Gatos",
    	        "Culinária",
    	        "Inteligência Artificial",
    	        "Viagem no Tempo",
    	        "Café",
    	        "Dragões",
    	        "Programação",
    	        "Jardinagem",
    	        "Exploração Interestelar",
    	        "Mistérios Antigos",
    	        "Video Games",
    	        "Filosofía",
    	        "Sobreviver uma Segunda-Feira",
    	        "a Internet",
    	        "Cultivo de Batata Doce",
    	        "Magía e Alquimia",
    	        "Cybersecurity",
    	        "Civilizações Perdidas",
    	        "Robôs",
    	        "GTA 6",
    	        "Física Quântica",
    	        "Glauber Pires"
    	    };
        
        Random random = new Random();

        int id = 11;
        int totalBooks = 20;  // Ser[a multiplicado por 2

        for (int i = 0; i < totalBooks; i++) {

            // Generate a random book title
            String title = titleStarts[random.nextInt(titleStarts.length)] + " " + ideas[random.nextInt(ideas.length)];

            // Generate a random e-book price
            double ebookPrice = 5 + (random.nextDouble() * 15);

            // Physical book costs 10 times more
            double physicalPrice = ebookPrice * 10;

            // Add physical edition
            tabelaProdutos.add(
                new ProdutoVO(
                    id++,
                    "Livros - " + title,
                    physicalPrice
                )
            );

            // Add digital edition
            tabelaProdutos.add(
                new ProdutoVO(
                    id++,
                    "E-book - " + title,
                    ebookPrice
                )
            );
        }
        
    }
    
    // Criar um método público estático 
    // fornece a única instância criada
    // metodo static pode ser acessado sem precisar criar a instancia antes
    public static BancoDeMemoria getInstance() {
        // Se a instância ainda não existir (primeira vez que alguém chama), cria uma
        if (instanciaUnica == null) {
            instanciaUnica = new BancoDeMemoria();
        }
        //UMA E APENAS UMA instância if + construtor privado garante isso
        //Se já existir, só devolve a que já estava pronta sem criar outra
        return instanciaUnica;
    }

    // devolve a lista de produtos
    public List<ProdutoVO> getTabelaProdutos() {
        return tabelaProdutos;
    }
}