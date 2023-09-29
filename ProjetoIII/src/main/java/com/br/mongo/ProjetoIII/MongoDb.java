package com.br.mongo.ProjetoIII;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDb {
	
	 public static void main(String[] args) {
	        // Conectar ao MongoDB
	        MongoClient mongoClient = new MongoClient("localhost", 27017);
	        MongoDatabase database = mongoClient.getDatabase("recomendacao_filmes");
	        // Obter a coleção onde queremos inserir os dados
            MongoCollection<Document> collection = database.getCollection("filmes");
            
         // Inserir os dados semi-estruturados
            String[] dados = {
                    "Titulo, Ano, Avaliacao",
                    "Vermelho, Branco e Sangue Azul,(2023),7.1",
                    "Que Horas Eu Te Pego?,(2023),6.5",
                    "Maestro,(2023),NULL",
                    "Asteroid City,(2023),6.7",
                    "Branca de Neve e os Sete AnÃµes,(2024),NULL",
                    "A Pequena Sereia,(I) (2023),7.2",
                    "Felicidade para Principiantes,(2023),6.0",
                    "Belo Desastre,(2023),5.3",
                    "Minha Culpa,(2023),6.2",
                    "Rocky Aur Rani Kii Prem Kahaani,(2023),7.2",
                    "Meus Sogros TÃ£o pro Crime,(2023),5.4",
                    "Titanic,(1997),7.9",
                    "Scott Pilgrim Contra o Mundo,(2010),7.5",
                    "Love,(II) (2015),6.1",
                    "Orgulho & Preconceito,(2005),7.8",
                    "ContinÃªncia ao Amor,(2022),6.7",
                    "AtÃ© os Ossos,(2022),6.8",
                    "Miraculous: As Aventuras de Ladybug - O Filme,(2023),6.1",
                    "Cidade Perdida,(2022),6.1",
                    "Cinquenta Tons de Cinza,(2015),4.2",
                    "Forrest Gump: O Contador de Historias,(1994),8.8",
                    "La La Land: Cantando Estações,(2016),8.0",
                    "Passagens,(2023),7.1",
                    "Ghosted: Sem Resposta,(I) (2023),5.8",
                    "Vidas Passadas,(2023),8.2",
                    "Diário de uma Paixão,(2004),7.8",
                    "Adoráveis Mulheres,(2019),7.8",
                    "Um Lugar Bem Longe Daqui,(2022),7.2",
                    "Crepúsculo,(I) (2008),5.3",
                    "As Patricinhas de Beverly Hills,(1995),6.9",
                    "Satyaprem Ki Katha,(2023),7.4",
                    "Gênio Indomável,(1997),8.3",
                    "Thor: Amor e Trovão,(2022),6.2",
                    "10 Coisas que Eu Odeio em Você,(1999),7.3",
                    "Amor a Toda Prova,(2011),7.4",
                    "Drácula de Bram Stoker,(1992),7.4",
                    "After,(I) (2019),5.3",
                    "365 Dias,(2020),3.3",
                    "Amizade Colorida,(2011),6.5",
                    "A Princesa Prometida,(1987),8.0",
                    "She Came to Me,(2023),NULL",
                    "Lolita,(1997),6.8",
                    "Brilho Eterno de uma Mente sem Lembranças,(2004),8.3",
                    "Zoey 102,(2023),5.0",
                    "Amor à Queima Roupa,(1993),7.9",
                    "Um Principe em Nova York,(1988),7.1",
                    "Quero ser Grande,(1988),7.3",
                    "Esposa de Mentirinha,(2011),6.4",
                    "A Escolha Perfeita,(2012),7.1",
                    "Me Chame pelo Seu Nome,(2017),7.8"
            };
            
            for (String dado : dados) {
                String[] partes = dado.split(",");
                String titulo = partes[0].trim();
                String ano = partes[1].replace("(", "").replace(")", "").trim();
                String avaliacao = partes[2].trim();

                Document filme = new Document("titulo", titulo)
                        .append("ano", ano)
                        .append("avaliacao", avaliacao);

                collection.insertOne(filme);
            }

            // Fechar a conexão
            mongoClient.close();
        }
}