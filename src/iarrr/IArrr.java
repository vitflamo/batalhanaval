package iarrr;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.util.Random;

/*TRABALHO DE IA

IArrr - Inteligência Artificial Pirata

Professor - Edson Ceroni

Grupo:
@author Caio Henrique Barbosa
@author Leandro Torres Batista
@author Mariana Benigno Salvini
@author Vitor Francisco Lamounier

*/

public class IArrr {

    public static void main(String[] args) {

        //VARIAVEIS-------------------------------------------------------------
        //Valida o jogo
        int jogo = 1;
        System.out.print("IArrr: Olá, Sou a IArrr, a IA pirata que afundará seus navios!\n");
        
        //gerador de numeros aleatorios
        Random rand = new Random();
        System.out.print("IArrr: As escolhas que tomo são imprevisíveis, baseadas na minha intuição pirata!\n");
        
        //Simbologia   
        String agua = "~~~~~";
        String tiroagua = "XXXXX";
        String acerto = "+++++";
        String mow = "MOW";
        String brigue = "BRIG";
        
        String fragata = "FRAG";
        String escuna = "ESCU";
        String ilha = "ILHAS";

        //MAPAS-----------------------------------------------------------------
        //Dimensões x = colunas, y = linhas
        int x, y;
        
        //Criando mapa de posicionamento
        String[][] poshumano = new String[10][10];
        String[][] posia = new String[10][10];

        //Criando mapa de rastreamento
        String[][] rashumano = new String[10][10];
        String[][] rasia = new String[10][10];

        //POSICIONAMENTO--------------------------------------------------------
        //validação de posicionamento
        int humanook=0;
        int iaok=0;
        int naviospos=0;
        int posok=0;
        
        //embarcações para a ia posicionar
        int iae=4, iaf=3, iab=2, iam=1;

        //embarcações para o humano posicionar
        int e=4, f=3, b=2, m=1;
        
        //local do posicionamento
        String pos="", posa=""; 
        int posx=0, posy=0;
        
        //ATAQUE----------------------------------------------------------------
        //Validação de ataquesda ia
        int jogadaok=0;
        int combate=0;
        
        //Contagem de embarcações ainda de pé
        int conthumano=30;
        int contia=30;
        
        //local do ataque
        int rasx=0, rasy=0;
        
        //posição para o ataque
        String ras="", rasa="";
        
        //OPÇÕES----------------------------------------------------------------
        //Nomes possiveis para IA
        String[] pirata = {
            "Mary Read", 
            "Edward Tatch", 
            "Charles Vane",
            "William Kidd",
            "Jack Rackram",
            "Anne Bonny",
            "Holandês Voador"
        };
        
        //Nome das localidades
        String[] localidade = {
            "Nassau", 
            "Havana", 
            "Kingston"
        };
        
        //Navios que serão utilizados
        String[] navios = {
            "Escuna",
            "Fragata",
            "Brigue",
            "Man-of-War",
            "Deixar a IA posicionar meus navios"
        };

        //Direções para o posicionamento
        String[] direcoes = {
            "Leste (Direita)",
            "Oeste (Esquerda)",
            "Norte (Cima)",
            "Sul (Baixo)",
        };

        //tranforma o x de 0 a 9 em letras
        String[] conversor = {
            "A",
            "B",
            "C",
            "D",
            "F",
            "F",
            "G",
            "H",
            "I",
            "J",
        };
        
        //rendição
        String[] rendicao = {
            "Continuar",
            "Desistir"
        };
            
        //JOGO------------------------------------------------------------------
	while (jogo!=0){
            
            //Apresentação
            JOptionPane.showMessageDialog(
                null, 
                "Bem Vindo, Capitão! Sou o Oficial JP (Joptiono Panelson)! Temos uma missão para você!\n"
            );
            
            //Nome do Jogador
            String humano = JOptionPane.showInputDialog(
                null,
                "Primeiramente, por qual nome podemos chama-lo, Capitão?"
            );

            //Contexto
            JOptionPane.showMessageDialog(
                null, 
                " Certo Capitão " + humano + ", voltando a missão:"
                + "\nEsses ratos andaram saqueando nossas embarcações durante esse mês"
                + "\nArmamos uma emboscada para pegar apenas um dos piratas e seu bando"
                + "\nÉ nosso dever como a marinha capturar os piratas!"
            );
           
            System.out.print("\nIArrr: O Humano que tentará me capturar se chama " + humano);
            
            //Escolha do nome da IA
            int ia = JOptionPane.showOptionDialog(
                null,
                "JP: Qual dos Piratas deseja caçar primeiro?\n",
                "Confirmação",
                JOptionPane.WARNING_MESSAGE,
                0,
                null,
                pirata,
                pirata[0]
            );
            
            System.out.print(pirata[ia] + ": Meu nome de pirata será " + pirata[ia]);
            
            //Confirmação do nome do Jogador e IA
            JOptionPane.showMessageDialog(
                null,
                "Certo Cap. " + humano + " iremos caçar "+  pirata[ia] + "!"
            );
            
            //Preenche o mapa de posicionamento com ~ para simbolizar o mar
            for (y=0;y<10;y++){
                for (x=0;x<10;x++){
                    poshumano[x][y]= agua;
                    posia[x][y]= agua;
                }
            }

            //Escolha do local
            int local = JOptionPane.showOptionDialog(
                null,
                "Onde iremos montar nossa emboscada?\n",
                "Confirmação",
                JOptionPane.WARNING_MESSAGE,
                0,
                null,
                localidade,
                localidade[0]
            );

            System.out.print(pirata[ia] + ": Estarei viajando por " + localidade[local]);
            
            //Adicionando as ilhas
            switch (local) {
                case 0:
                    //Topo esquerdo
                    poshumano[0][0]= ilha;
                    poshumano[0][1]= ilha;
                    poshumano[1][0]= ilha;
                    poshumano[1][1]= ilha;
                    //topo direito
                    poshumano[0][8]= ilha;
                    poshumano[0][9]= ilha;
                    poshumano[1][8]= ilha;
                    poshumano[1][9]= ilha;
                    //fundo esquerdo
                    poshumano[8][0]= ilha;
                    poshumano[9][0]= ilha;
                    poshumano[8][1]= ilha;
                    poshumano[9][1]= ilha;
                    //fundo direito
                    poshumano[8][8]= ilha;
                    poshumano[8][9]= ilha;
                    poshumano[9][8]= ilha;
                    poshumano[9][9]= ilha;
                    //centro
                    poshumano[4][4]= ilha;
                    poshumano[4][5]= ilha;
                    poshumano[5][4]= ilha;
                    poshumano[5][5]= ilha;
                    break;
                case 1:
                    //Topo esquerdo
                    poshumano[0][0]= ilha;
                    poshumano[0][1]= ilha;
                    poshumano[1][0]= ilha;
                    poshumano[1][1]= ilha;
                    //topo centro
                    poshumano[0][4]= ilha;
                    poshumano[0][5]= ilha;
                    poshumano[1][4]= ilha;
                    poshumano[1][5]= ilha;
                    //topo direito
                    poshumano[0][8]= ilha;
                    poshumano[0][9]= ilha;
                    poshumano[1][8]= ilha;
                    poshumano[1][9]= ilha;
                    //centro esquerdo
                    poshumano[4][0]= ilha;
                    poshumano[5][0]= ilha;
                    poshumano[4][1]= ilha;
                    poshumano[5][1]= ilha;
                    //fundo esquerdo
                    poshumano[8][0]= ilha;
                    poshumano[9][0]= ilha;
                    poshumano[8][1]= ilha;
                    poshumano[9][1]= ilha;
                    break;
                case 2:
                    //topo centro
                    poshumano[0][4]= ilha;
                    poshumano[0][5]= ilha;
                    poshumano[1][4]= ilha;
                    poshumano[1][5]= ilha;
                    //topo direito
                    poshumano[0][8]= ilha;
                    poshumano[0][9]= ilha;
                    poshumano[1][8]= ilha;
                    poshumano[1][9]= ilha;
                    //centro esquerdo
                    poshumano[4][0]= ilha;
                    poshumano[5][0]= ilha;
                    poshumano[4][1]= ilha;
                    poshumano[5][1]= ilha;
                    //centro
                    poshumano[4][4]= ilha;
                    poshumano[4][5]= ilha;
                    poshumano[5][4]= ilha;
                    poshumano[5][5]= ilha;
                    //fundo esquerdo
                    poshumano[8][0]= ilha;
                    poshumano[9][0]= ilha;
                    poshumano[8][1]= ilha;
                    poshumano[9][1]= ilha;
                    break;
                default:
                    break;
            }//FIM DO POSICIONAMENTO DAS ILHAS
            
            //Passando as ilhas para os outros mapas
            for (y=0;y<10;y++){
                for (x=0;x<10;x++){
                    posia[x][y]= poshumano[x][y];
                    rasia[x][y]= poshumano[x][y];
                    rashumano[x][y]= poshumano[x][y];
                }
            }

            //FASE DE POSICIONAMENTO--------------------------------------------
            while (naviospos==0){
                
                
                //PARTE DA IA---------------------------------------------------
                while(iaok==0){
                    
                    System.out.print(pirata[ia] + ": Vou preparar meus navios!\n");
                    
                    //Cria o mapa de posicionamento para o ia
                    String mapaposia = "\tA\tB\tC\tD\tE\tF\tG\tH\tI\tJ\tK\n" + 1;
                    
                    switch (local) {
                        case 0:
                            //Topo esquerdo
                            posia[0][0]= ilha;
                            posia[0][1]= ilha;
                            posia[1][0]= ilha;
                            posia[1][1]= ilha;
                            //topo direito
                            posia[0][8]= ilha;
                            posia[0][9]= ilha;
                            posia[1][8]= ilha;
                            posia[1][9]= ilha;
                            //fundo esquerdo
                            posia[8][0]= ilha;
                            posia[9][0]= ilha;
                            posia[8][1]= ilha;
                            posia[9][1]= ilha;
                            //fundo direito
                            posia[8][8]= ilha;
                            posia[8][9]= ilha;
                            posia[9][8]= ilha;
                            posia[9][9]= ilha;
                            //centro
                            posia[4][4]= ilha;
                            posia[4][5]= ilha;
                            posia[5][4]= ilha;
                            posia[5][5]= ilha;
                            break;
                        case 1:
                            //Topo esquerdo
                            posia[0][0]= ilha;
                            posia[0][1]= ilha;
                            posia[1][0]= ilha;
                            posia[1][1]= ilha;
                            //topo centro
                            posia[0][4]= ilha;
                            posia[0][5]= ilha;
                            posia[1][4]= ilha;
                            posia[1][5]= ilha;
                            //topo direito
                            posia[0][8]= ilha;
                            posia[0][9]= ilha;
                            posia[1][8]= ilha;
                            posia[1][9]= ilha;
                            //centro esquerdo
                            posia[4][0]= ilha;
                            posia[5][0]= ilha;
                            posia[4][1]= ilha;
                            posia[5][1]= ilha;
                            //fundo esquerdo
                            posia[8][0]= ilha;
                            posia[9][0]= ilha;
                            posia[8][1]= ilha;
                            posia[9][1]= ilha;
                            break;
                        case 2:
                            //topo centro
                            posia[0][4]= ilha;
                            posia[0][5]= ilha;
                            posia[1][4]= ilha;
                            posia[1][5]= ilha;
                            //topo direito
                            posia[0][8]= ilha;
                            posia[0][9]= ilha;
                            posia[1][8]= ilha;
                            posia[1][9]= ilha;
                            //centro esquerdo
                            posia[4][0]= ilha;
                            posia[5][0]= ilha;
                            posia[4][1]= ilha;
                            posia[5][1]= ilha;
                            //centro
                            posia[4][4]= ilha;
                            posia[4][5]= ilha;
                            posia[5][4]= ilha;
                            posia[5][5]= ilha;
                            //fundo esquerdo
                            posia[8][0]= ilha;
                            posia[9][0]= ilha;
                            posia[8][1]= ilha;
                            posia[9][1]= ilha;
                            break;
                        default:
                            break;
                    }

                    //navio q a ia vai posicionar
                    int navio = rand.nextInt(4) + 0;

                    System.out.println("\nEscolhi o navio: " + navios[navio] + "\n"); 

                    ///ESCUNAS--------------------------------------------------
                    if (navio == 0 && iae>0){
                        posok=0;
                        
                        while(posok==0){

                            posok = 0;
                            
                            //posição q a ia escolhe
                            posx = rand.nextInt(9);
                            posy = rand.nextInt(9);

                            System.out.println("Escolhi a posição inicial: [" + conversor[posx] + (posy+1) + "]");

                            //Direção que a IA vai querer
                            int direcao = rand.nextInt(4);
                            System.out.println("Escolhi a direção: " + direcoes[direcao]);

                            if(direcao == 0 && posx <=8){
                                if(posia[posx][posy]==agua && posia[posx+1][posy]==agua){
                                    for (y=0;y<10;y++){
                                        for (x=0;x<10;x++){
                                            posia[posx][posy] = escuna + " " + iae;
                                            posia[posx+1][posy]= escuna + " " + iae;
                                        } 
                                    }
                                iae = iae-1;
                                posok = 1;
                                }
                            }else if(direcao == 1 && posx>=1){
                                if(posia[posx][posy]==agua && posia[posx-1][posy]==agua){
                                for (y=0;y<10;y++){
                                    for (x=0;x<10;x++){
                                        posia[posx][posy] = escuna + " " + iae;
                                        posia[posx-1][posy]= escuna + " " + iae;
                                    } 
                                }
                                iae = iae-1;
                                posok = 1;
                                }
                            }else if(direcao == 2 && posy >=1){
                                if(posia[posx][posy]==agua && posia[posx][posy-1]==agua){
                                    for (y=0;y<10;y++){
                                        for (x=0;x<10;x++){
                                            posia[posx][posy] = escuna + " " + iae;
                                            posia[posx][posy-1]= escuna + " " + iae;
                                        } 
                                    }
                                    iae = iae-1;
                                    posok = 1;
                                }
                            }else if(direcao == 3 && posy <=8){ 
                                if(posia[posx][posy]==agua && posia[posx][posy+1]==agua){
                                    for (y=0;y<10;y++){
                                        for (x=0;x<10;x++){
                                            posia[posx][posy] = escuna + " " + iae;
                                            posia[posx][posy+1]= escuna + " " + iae;
                                        } 
                                    }
                                    iae = iae-1;
                                    posok = 1;
                                }
                            }else{
                                posia[posx][posy] = agua;
                            }
                            
                            //ultimo navio?
                            if(iae==0 && iaf==0 && iab==0 && iam==0){
                                iaok=1;
                            }                  
                        } 
                        
                    //FRAGATA---------------------------------------------------
                    }else if(navio == 1 && iaf>0){         
                        posok=0;

                        while(posok==0){

                            posok = 0;
                            
                            //posição q a ia escolhe
                            posx = rand.nextInt(9);
                            posy = rand.nextInt(9);

                            System.out.println("Escolhi a posição inicial: [" + conversor[posx] + (posy+1) + "]");

                            //Direção que a IA vai querer
                            int direcao = rand.nextInt(4);
                            System.out.println("Escolhi a direção: " + direcoes[direcao]);

                            if(direcao == 0 && posx <=7){
                                if(posia[posx][posy]==agua && posia[posx+1][posy]==agua && posia[posx+2][posy] == agua){
                                for (y=0;y<10;y++){
                                    for (x=0;x<10;x++){
                                        posia[posx][posy] = fragata + " " + iaf;
                                        posia[posx+1][posy]= fragata + " " + iaf;
                                        posia[posx+2][posy]= fragata + " " + iaf;
                                    } 
                                }
                                iaf = iaf-1;
                                posok = 1;
                                }
                            }else if(direcao == 1 && posx >=2){ 
                                if(posia[posx][posy]==agua && posia[posx-1][posy]==agua && posia[posx-2][posy] == agua){
                                for (y=0;y<10;y++){
                                    for (x=0;x<10;x++){
                                        posia[posx][posy] = fragata + " " + iaf;
                                        posia[posx-1][posy]= fragata + " " + iaf;
                                        posia[posx-2][posy]= fragata + " " + iaf;

                                    } 
                                }
                                iaf = iaf-1;
                                posok = 1;
                                }
                            }else if(direcao == 2 && posy >=2){ 
                                if(posia[posx][posy]==agua && posia[posx][posy-1]==agua && posia[posx][posy-2] == agua){
                                for (y=0;y<10;y++){
                                    for (x=0;x<10;x++){
                                        posia[posx][posy] = fragata + " " + iaf;
                                        posia[posx][posy-1]= fragata + " " + iaf;
                                        posia[posx][posy-2]= fragata + " " + iaf;

                                    } 
                                }
                                iaf = iaf-1;
                                posok = 1;
                                }
                            }else if(direcao == 3 && posy <=7){ 
                                if(posia[posx][posy]==agua && posia[posx][posy+1]==agua && posia[posx][posy+2] == agua){
                                for (y=0;y<10;y++){
                                    for (x=0;x<10;x++){
                                        posia[posx][posy] = fragata + " " + iaf;
                                        posia[posx][posy+1]= fragata + " " + iaf;
                                        posia[posx][posy+2]= fragata + " " + iaf;
                                    } 
                                }
                                iaf = iaf-1;
                                posok = 1;
                                }
                            }
                            
                            //ultimo navio?
                            if(iae==0 && iaf==0 && iab==0 && iam==0){
                                iaok=1;
                            }
                        }   
                        
                    //BRIGUE----------------------------------------------------
                    }else if(navio==2 && iab>0){       

                        posok=0;

                        while(posok==0){

                            posok = 0;
                            
                            //posição q a ia escolhe
                            posx = rand.nextInt(9);
                            posy = rand.nextInt(9);

                            System.out.println("Escolhi a posição inicial: [" + conversor[posx] + (posy+1) + "]");

                            //Direção que a IA vai querer
                            int direcao = rand.nextInt(4);
                            System.out.println("Escolhi a direção: " + direcoes[direcao]);

                            if(direcao == 0 && posx <=6){ 
                                if(posia[posx][posy]==agua && posia[posx+1][posy]==agua && posia[posx+2][posy] == agua && posia[posx+3][posy] == agua){
                                for (y=0;y<10;y++){
                                    for (x=0;x<10;x++){
                                        posia[posx][posy] = brigue + " " + iab;
                                        posia[posx+1][posy]= brigue + " " + iab;
                                        posia[posx+2][posy]= brigue + " " + iab;
                                        posia[posx+3][posy]= brigue + " " + iab;
                                    } 
                                }
                                iab = iab-1;
                                posok = 1;
                                }
                            }else if(direcao == 1 && posx >= 3){ 
                                if(posia[posx][posy]==agua && posia[posx-1][posy]==agua && posia[posx-2][posy] == agua && posia[posx-3][posy] == agua){
                                for (y=0;y<10;y++){
                                    for (x=0;x<10;x++){
                                        posia[posx][posy] = brigue + " " + iab;
                                        posia[posx-1][posy]= brigue + " " + iab;
                                        posia[posx-2][posy]= brigue + " " + iab;
                                        posia[posx-3][posy]= brigue + " " + iab;

                                    } 
                                }
                                iab = iab-1;
                                posok = 1;
                                }
                            }else if(direcao == 2 && posy >= 3){ 
                                if(posia[posx][posy]==agua && posia[posx][posy-1]==agua && posia[posx][posy-2] == agua && posia[posx][posy-3] == agua){
                                for (y=0;y<10;y++){
                                    for (x=0;x<10;x++){
                                        posia[posx][posy] = brigue + " " + iab;
                                        posia[posx][posy-1]= brigue + " " + iab;
                                        posia[posx][posy-2]= brigue + " " + iab;
                                        posia[posx][posy-3]= brigue + " " + iab;

                                    } 
                                }
                                iab = iab-1;
                                posok = 1;
                                }
                            }else if(direcao == 3 && posy <=6){ 
                                if(posia[posx][posy]==agua && posia[posx][posy+1]==agua && posia[posx][posy+2] == agua && posia[posx][posy+3] == agua){
                                for (y=0;y<10;y++){
                                    for (x=0;x<10;x++){
                                        posia[posx][posy] = brigue + " " + iab;
                                        posia[posx][posy+1]= brigue + " " + iab;
                                        posia[posx][posy+2]= brigue + " " + iab;
                                        posia[posx][posy+3]= brigue + " " + iab;
                                    } 
                                }
                                iab = iab-1;
                                posok = 1;
                                }
                            }
                            
                            //ultimo navio?
                            if(iae==0 && iaf==0 && iab==0 && iam==0){
                                iaok=1;
                            }
                        }   
                    //MAN-O-WAR-------------------------------------------------   
                    }else if(navio==3 && iam>0){

                        posok=0;

                        while(posok==0){

                            posok = 0;
                            
                            //posição q a ia escolhe
                            posx = rand.nextInt(9);
                            posy = rand.nextInt(9);

                            System.out.println("Escolhi a posição inicial: [" + conversor[posx] + (posy+1) + "]");

                            //Direção que a IA vai querer
                            int direcao = rand.nextInt(4);
                            System.out.println("Escolhi a direção: " + direcoes[direcao]);

                            if(direcao == 0 && posx <=5){ 
                                if(posia[posx][posy]==agua && posia[posx+1][posy]==agua && posia[posx+2][posy] == agua && posia[posx+3][posy] == agua && posia[posx+4][posy] == agua){
                                for (y=0;y<10;y++){
                                    for (x=0;x<10;x++){
                                        posia[posx][posy] = mow + " " + iam;
                                        posia[posx+1][posy]= mow + " " + iam;
                                        posia[posx+2][posy]= mow + " " + iam;
                                        posia[posx+3][posy]= mow + " " + iam;
                                        posia[posx+4][posy]= mow + " " + iam;
                                    } 
                                }
                                iam = iam-1;
                                posok = 1;
                                }
                            }else if(direcao == 1 && posx >= 4){ 
                                if(posia[posx][posy]==agua && posia[posx-1][posy]==agua && posia[posx-2][posy] == agua && posia[posx-3][posy] == agua && posia[posx-4][posy] == agua){
                                for (y=0;y<10;y++){
                                    for (x=0;x<10;x++){
                                        posia[posx][posy] = mow + " " + iam;
                                        posia[posx-1][posy]= mow + " " + iam;
                                        posia[posx-2][posy]= mow + " " + iam;
                                        posia[posx-3][posy]= mow + " " + iam;
                                        posia[posx-4][posy]= mow + " " + iam;
                                    } 
                                }
                                iam = iam-1;
                                posok = 1;
                                }
                            }else if(direcao == 2 && posy >= 4){ 
                                if(posia[posx][posy]==agua && posia[posx][posy-1]==agua && posia[posx][posy-2] == agua && posia[posx][posy-3] == agua && posia[posx][posy-4] == agua){
                                for (y=0;y<10;y++){
                                    for (x=0;x<10;x++){
                                        posia[posx][posy] = mow + " " + iam;
                                        posia[posx][posy-1]= mow + " " + iam;
                                        posia[posx][posy-2]= mow + " " + iam;
                                        posia[posx][posy-3]= mow + " " + iam;
                                        posia[posx][posy-4]= mow + " " + iam;
                                    } 
                                }
                                iam = iam-1;
                                posok = 1;
                                }
                            }else if(direcao == 3 && posy <=5){ 
                                if(posia[posx][posy]==agua && posia[posx][posy+1]==agua && posia[posx][posy+2] == agua && posia[posx][posy+3] == agua && posia[posx][posy+4] == agua){
                                for (y=0;y<10;y++){
                                    for (x=0;x<10;x++){
                                        posia[posx][posy] = mow + " " + iam;
                                        posia[posx][posy+1]= mow + " " + iam;
                                        posia[posx][posy+2]= mow + " " + iam;
                                        posia[posx][posy+3]= mow + " " + iam;
                                        posia[posx][posy+4]= mow + " " + iam;
                                    } 
                                }
                                iam = iam-1;
                                posok = 1;
                                }
                            }
                            
                            //ultimo navio?
                            if(iae==0 && iaf==0 && iab==0 && iam==0){
                                iaok=1;
                            }
                        }
                    
                    }//FIM DOS NAVIOS-------------------------------------------
                    
                    mapaposia = "\tA\tB\tC\tD\tE\tF\tG\tH\tI\tJ\tK\n" + 1;

                        for (y=0;y<10;y++){
                            for (x=0;x<10;x++){
                                mapaposia = mapaposia + "\t" + posia[x][y];
                            }
                            mapaposia = mapaposia + "\n" + (y+2);
                        }
                        
                    System.out.println("\n" + mapaposia + "\n");
                    
                }//FIM DA PARTE DA IA-------------------------------------------
                
                System.out.println("\n" + humano + ", tente me pegar!\n");
                
                //PARTE DO HUMANO-----------------------------------------------
                while (humanook==0){
                        
                    //Cria o mapa de posicionamento para o humano
                    String mapaposhumano = "\tA\tB\tC\tD\tE\tF\tG\tH\tI\tJ\tK\n" + 1;

                    for (y=0;y<10;y++){
                        for (x=0;x<10;x++){
                            mapaposhumano = mapaposhumano + "\t" + poshumano[x][y];
                        }
                        mapaposhumano = mapaposhumano + "\n" + (y+2);
                    }

                    //ESCOLHA DO NAVIO------------------------------------------
                    int navio = JOptionPane.showOptionDialog(
                        null,
                        new JTextArea(
                            "Esta é a área que temos disponível:\n\n" + mapaposhumano 
                            + "\n\n E ainda temos que posicionar:\n"
                            + e + " escunas (2 Blocos)\n"
                            + f + " fragatas (3 Blocos)\n"
                            + b + " brigues (4 Blocos)\n"
                            + m + " Man-of-War (5 Blocos)\n"
                            + "\nQual navio deseja posicionar, Cpt." + humano + "?"
                        ),
                        "Vez de " + humano + " - Escolha do navio",
                        JOptionPane.PLAIN_MESSAGE,
                        0,
                        null,
                        navios,
                        navios[0]
                    );

                    //ESCUNA----------------------------------------------------
                    if (navio == 0 && e>0){
                        posok=0;

                        while(posok==0){

                            posok = 0;

                            pos = JOptionPane.showInputDialog(
                                null,
                                new JTextArea(
                                    "Esta é a área que temos disponível:\n\n" + mapaposhumano 
                                    + "\n\n Insira a posição inicial:\n"
                                    +  "\n\n Atenção! INSIRA A COLUNA (LETRA) E DEPOIS A LINHA (NUMERO) \n"
                                ),
                                "Posicionando Navio: " + navios[navio] + " (2 Blocos)", 
                                JOptionPane.PLAIN_MESSAGE
                            );

                            if (pos==null || pos.equals("")){
                                //automatico caso vazio
                                posx = rand.nextInt(9);
                                posy = rand.nextInt(9);
                            }else{
                                //tanto maiusculas quanto minusculas
                                pos = pos.toUpperCase();
                                //quebra a string
                                posa = pos.substring(0,1);
                            
                                if (null != posa)switch (posa) {
                                    case "A":
                                        posx = 0;
                                        break;
                                    case "B":
                                        posx = 1;
                                        break;
                                    case "C":
                                        posx = 2;
                                        break;
                                    case "D":
                                        posx = 3;
                                        break;
                                    case "E":
                                        posx = 4;
                                        break;
                                    case "F":
                                        posx = 5;
                                        break;
                                    case "G":
                                        posx = 6;
                                        break;
                                    case "H":
                                        posx = 7;
                                        break;
                                    case "I":
                                        posx = 8;
                                        break;
                                    case "J":
                                        posx = 9;
                                        break;
                                    default:
                                        break;
                                }
                            //pega o resto da string
                            posy = Integer.parseInt(pos.substring(1));
                            posy = posy - 1;
                            }
                            
                            mapaposhumano = "\tA\tB\tC\tD\tE\tF\tG\tH\tI\tJ\tK\n" + 1;

                            for (y=0;y<10;y++){
                                for (x=0;x<10;x++){
                                    mapaposhumano = mapaposhumano + "\t" + poshumano[x][y];
                                }
                                mapaposhumano = mapaposhumano + "\n" + (y+2);
                            }

                            int direcao = JOptionPane.showOptionDialog(
                                null,
                                new JTextArea(
                                    "Esta é a área que temos disponível:\n\n" + mapaposhumano 
                                    + "\n\n Escolha a Direção do navio:\n"
                                    ),
                                "Escolha da direcao",
                                JOptionPane.PLAIN_MESSAGE,
                                0,
                                null,
                                direcoes,
                                direcoes[0]
                            );

                            if(direcao == 0 && posx <=8){
                                if(poshumano[posx][posy]==agua && poshumano[posx+1][posy]==agua){
                                    for (y=0;y<10;y++){
                                        for (x=0;x<10;x++){
                                            poshumano[posx][posy] = escuna + " " + e;
                                            poshumano[posx+1][posy]= escuna + " " + e;
                                        } 
                                    }
                                e = e-1;
                                posok = 1;
                                }
                            }else if(direcao == 1 && posx>=1){
                                if(poshumano[posx][posy]==agua && poshumano[posx-1][posy]==agua){
                                for (y=0;y<10;y++){
                                    for (x=0;x<10;x++){
                                        poshumano[posx][posy] = escuna + " " + e;
                                        poshumano[posx-1][posy]= escuna + " " + e;
                                    } 
                                }
                                e = e-1;
                                posok = 1;
                                }
                            }else if(direcao == 2 && posy >=1){
                                if(poshumano[posx][posy]==agua && poshumano[posx][posy-1]==agua){
                                    for (y=0;y<10;y++){
                                        for (x=0;x<10;x++){
                                            poshumano[posx][posy] = escuna + " " + e;
                                            poshumano[posx][posy-1]= escuna + " " + e;
                                        } 
                                    }
                                    e = e-1;
                                    posok = 1;
                                }
                            }else if(direcao == 3 && posy <=8){ 
                                if(poshumano[posx][posy]==agua && poshumano[posx][posy+1]==agua){
                                    for (y=0;y<10;y++){
                                        for (x=0;x<10;x++){
                                            poshumano[posx][posy] = escuna + " " + e;
                                            poshumano[posx][posy+1]= escuna + " " + e;
                                        } 
                                    }
                                    e = e-1;
                                    posok = 1;
                                }
                            }else{
                                poshumano[posx][posy] = poshumano[posx][posy];
                            }
                            
                            //ultimo navio?
                            if(e==0 && f==0 && b==0 && m==0){
                                humanook = 1;
                            }
                        }    

                    //FRAGATA---------------------------------------------------
                    }else if(navio == 1 && f>0){

                        posok=0;

                        while(posok==0){

                            posok = 0;

                            pos = JOptionPane.showInputDialog(
                                null,
                                new JTextArea(
                                    "Esta é a área que temos disponível:\n\n" + mapaposhumano 
                                    + "\n\n Insira a posição inicial:\n"
                                    +  "\n\n Atenção! INSIRA A COLUNA (LETRA) E DEPOIS A LINHA (NUMERO) \n"
                                ),
                                "Posicionando Navio: " + navios[navio] + " (3 Blocos)", 
                                JOptionPane.PLAIN_MESSAGE
                            );

                            if (pos==null || pos.equals("")){
                                //automatico caso vazio
                                posx = rand.nextInt(9);
                                posy = rand.nextInt(9);
                            }else{
                                //tanto maiusculas quanto minusculas
                                pos = pos.toUpperCase();
                                //quebra a string
                                posa = pos.substring(0,1);
                            
                                if (null != posa)switch (posa) {
                                    case "A":
                                        posx = 0;
                                        break;
                                    case "B":
                                        posx = 1;
                                        break;
                                    case "C":
                                        posx = 2;
                                        break;
                                    case "D":
                                        posx = 3;
                                        break;
                                    case "E":
                                        posx = 4;
                                        break;
                                    case "F":
                                        posx = 5;
                                        break;
                                    case "G":
                                        posx = 6;
                                        break;
                                    case "H":
                                        posx = 7;
                                        break;
                                    case "I":
                                        posx = 8;
                                        break;
                                    case "J":
                                        posx = 9;
                                        break;
                                    default:
                                        break;
                                }
                            //pega o resto da string
                            posy = Integer.parseInt(pos.substring(1));
                            posy = posy - 1;
                            }

                            mapaposhumano = "\tA\tB\tC\tD\tE\tF\tG\tH\tI\tJ\tK\n" + 1;

                            for (y=0;y<10;y++){
                                for (x=0;x<10;x++){
                                    mapaposhumano = mapaposhumano + "\t" + poshumano[x][y];
                                }
                                mapaposhumano = mapaposhumano + "\n" + (y+2);
                            }

                            int direcao = JOptionPane.showOptionDialog(
                                null,
                                new JTextArea(
                                    "Esta é a área que temos disponível:\n\n" + mapaposhumano 
                                    + "\n\n Escolha a Direção do navio:\n"
                                    ),
                                "Escolha da direcao",
                                JOptionPane.PLAIN_MESSAGE,
                                0,
                                null,
                                direcoes,
                                direcoes[0]
                            );

                            if(direcao == 0 && posx <=7){
                                if(poshumano[posx][posy]==agua && poshumano[posx+1][posy]==agua && poshumano[posx+2][posy] == agua){
                                for (y=0;y<10;y++){
                                    for (x=0;x<10;x++){
                                        poshumano[posx][posy] = fragata + " " + f;
                                        poshumano[posx+1][posy]= fragata + " " + f;
                                        poshumano[posx+2][posy]= fragata + " " + f;
                                    } 
                                }
                                f = f-1;
                                posok = 1;
                                }
                            }else if(direcao == 1 && posx >=2){ 
                                if(poshumano[posx][posy]==agua && poshumano[posx-1][posy]==agua && poshumano[posx-2][posy] == agua){
                                for (y=0;y<10;y++){
                                    for (x=0;x<10;x++){
                                        poshumano[posx][posy] = fragata + " " + f;
                                        poshumano[posx-1][posy]= fragata + " " + f;
                                        poshumano[posx-2][posy]= fragata + " " + f;

                                    } 
                                }
                                f = f-1;
                                posok = 1;
                                }
                            }else if(direcao == 2 && posy >=2){ 
                                if(poshumano[posx][posy]==agua && poshumano[posx][posy-1]==agua && poshumano[posx][posy-2] == agua){
                                for (y=0;y<10;y++){
                                    for (x=0;x<10;x++){
                                        poshumano[posx][posy] = fragata + " " + f;
                                        poshumano[posx][posy-1]= fragata + " " + f;
                                        poshumano[posx][posy-2]= fragata + " " + f;

                                    } 
                                }
                                f = f-1;
                                posok = 1;
                                }
                            }else if(direcao == 3 && posy <=7){ 
                                if(poshumano[posx][posy]==agua && poshumano[posx][posy+1]==agua && poshumano[posx][posy+2] == agua){
                                for (y=0;y<10;y++){
                                    for (x=0;x<10;x++){
                                        poshumano[posx][posy] = fragata + " " + f;
                                        poshumano[posx][posy+1]= fragata + " " + f;
                                        poshumano[posx][posy+2]= fragata + " " + f;
                                    } 
                                }
                                f = f-1;
                                posok = 1;
                                }
                            }else{
                                poshumano[posx][posy] = poshumano[posx][posy];
                            }
                            //ultimo navio?
                            if(e==0 && f==0 && b==0 && m==0){
                                humanook = 1;
                            }
                        }   
                        
                    //BRIGUE----------------------------------------------------
                    }else if(navio==2 && b>0){
                        posok=0;

                        while(posok==0){

                            posok = 0;

                            pos = JOptionPane.showInputDialog(
                                null,
                                new JTextArea(
                                    "Esta é a área que temos disponível:\n\n" + mapaposhumano 
                                    + "\n\n Insira a posição inicial:\n"
                                    +  "\n\n Atenção! INSIRA A COLUNA (LETRA) E DEPOIS A LINHA (NUMERO) \n"
                                ),
                                "Posicionando Navio: " + navios[navio] + " (4 Blocos)", 
                                JOptionPane.PLAIN_MESSAGE
                            );

                            if (pos==null || pos.equals("")){
                                //automatico caso vazio
                                posx = rand.nextInt(9);
                                posy = rand.nextInt(9);
                            }else{
                                //tanto maiusculas quanto minusculas
                                pos = pos.toUpperCase();
                                //quebra a string
                                posa = pos.substring(0,1);
                            
                                if (null != posa)switch (posa) {
                                    case "A":
                                        posx = 0;
                                        break;
                                    case "B":
                                        posx = 1;
                                        break;
                                    case "C":
                                        posx = 2;
                                        break;
                                    case "D":
                                        posx = 3;
                                        break;
                                    case "E":
                                        posx = 4;
                                        break;
                                    case "F":
                                        posx = 5;
                                        break;
                                    case "G":
                                        posx = 6;
                                        break;
                                    case "H":
                                        posx = 7;
                                        break;
                                    case "I":
                                        posx = 8;
                                        break;
                                    case "J":
                                        posx = 9;
                                        break;
                                    default:
                                        break;
                                }
                            //pega o resto da string
                            posy = Integer.parseInt(pos.substring(1));
                            posy = posy - 1;
                            }

                            mapaposhumano = "\tA\tB\tC\tD\tE\tF\tG\tH\tI\tJ\tK\n" + 1;

                            for (y=0;y<10;y++){
                                for (x=0;x<10;x++){
                                    mapaposhumano = mapaposhumano + "\t" + poshumano[x][y];
                                }
                                mapaposhumano = mapaposhumano + "\n" + (y+2);
                            }

                            int direcao = JOptionPane.showOptionDialog(
                                null,
                                new JTextArea(
                                    "Esta é a área que temos disponível:\n\n" + mapaposhumano 
                                    + "\n\n Escolha a Direção do navio:\n"
                                    ),
                                "Escolha da direcao",
                                JOptionPane.PLAIN_MESSAGE,
                                0,
                                null,
                                direcoes,
                                direcoes[0]
                            );

                            if(direcao == 0 && posx <=6){ 
                                if(poshumano[posx][posy]==agua && poshumano[posx+1][posy]==agua && poshumano[posx+2][posy] == agua && poshumano[posx+3][posy] == agua){
                                for (y=0;y<10;y++){
                                    for (x=0;x<10;x++){
                                        poshumano[posx][posy] = brigue + " " + b;
                                        poshumano[posx+1][posy]= brigue + " " + b;
                                        poshumano[posx+2][posy]= brigue + " " + b;
                                        poshumano[posx+3][posy]= brigue + " " + b;
                                    } 
                                }
                                b = b-1;
                                posok = 1;
                                }
                            }else if(direcao == 1 && posx >= 3){ 
                                if(poshumano[posx][posy]==agua && poshumano[posx-1][posy]==agua && poshumano[posx-2][posy] == agua && poshumano[posx-3][posy] == agua){
                                for (y=0;y<10;y++){
                                    for (x=0;x<10;x++){
                                        poshumano[posx][posy] = brigue + " " + b;
                                        poshumano[posx-1][posy]= brigue + " " + b;
                                        poshumano[posx-2][posy]= brigue + " " + b;
                                        poshumano[posx-3][posy]= brigue + " " + b;

                                    } 
                                }
                                b = b-1;
                                posok = 1;
                                }
                            }else if(direcao == 2 && posy >= 3){ 
                                if(poshumano[posx][posy]==agua && poshumano[posx][posy-1]==agua && poshumano[posx][posy-2] == agua && poshumano[posx][posy-3] == agua){
                                for (y=0;y<10;y++){
                                    for (x=0;x<10;x++){
                                        poshumano[posx][posy] = brigue + " " + b;
                                        poshumano[posx][posy-1]= brigue + " " + b;
                                        poshumano[posx][posy-2]= brigue + " " + b;
                                        poshumano[posx][posy-3]= brigue + " " + b;

                                    } 
                                }
                                b = b-1;
                                posok = 1;
                                }
                            }else if(direcao == 3 && posy <=6){ 
                                if(poshumano[posx][posy]==agua && poshumano[posx][posy+1]==agua && poshumano[posx][posy+2] == agua && poshumano[posx][posy+3] == agua){
                                for (y=0;y<10;y++){
                                    for (x=0;x<10;x++){
                                        poshumano[posx][posy] = brigue + " " + b;
                                        poshumano[posx][posy+1]= brigue + " " + b;
                                        poshumano[posx][posy+2]= brigue + " " + b;
                                        poshumano[posx][posy+3]= brigue + " " + b;
                                    } 
                                }
                                b = b-1;
                                posok = 1;
                                }
                            }else{
                                poshumano[posx][posy] = poshumano[posx][posy];
                            }
                            //ultimo navio?
                            if(e==0 && f==0 && b==0 && m==0){
                                humanook = 1;
                            }
                        }   
                    
                    //MAN-O-WAR-------------------------------------------------
                    }else if(navio==3 && m>0){
                        
                        posok=0;

                        while(posok==0){

                            posok = 0;

                            pos = JOptionPane.showInputDialog(
                                null,
                                new JTextArea(
                                    "Esta é a área que temos disponível:\n\n" + mapaposhumano 
                                    + "\n\n Insira a posição inicial:\n"
                                    +  "\n\n Atenção! INSIRA A COLUNA (LETRA) E DEPOIS A LINHA (NUMERO) \n"
                                ),
                                "Posicionando Navio: " + navios[navio] + " (5 Blocos)", 
                                JOptionPane.PLAIN_MESSAGE
                            );
                            
                            if (pos==null || pos.equals("")){
                                //automatico caso vazio
                                posx = rand.nextInt(9);
                                posy = rand.nextInt(9);
                            }else{
                                //tanto maiusculas quanto minusculas
                                pos = pos.toUpperCase();
                                //quebra a string
                                posa = pos.substring(0,1);
                            
                                if (null != posa)switch (posa) {
                                    case "A":
                                        posx = 0;
                                        break;
                                    case "B":
                                        posx = 1;
                                        break;
                                    case "C":
                                        posx = 2;
                                        break;
                                    case "D":
                                        posx = 3;
                                        break;
                                    case "E":
                                        posx = 4;
                                        break;
                                    case "F":
                                        posx = 5;
                                        break;
                                    case "G":
                                        posx = 6;
                                        break;
                                    case "H":
                                        posx = 7;
                                        break;
                                    case "I":
                                        posx = 8;
                                        break;
                                    case "J":
                                        posx = 9;
                                        break;
                                    default:
                                        break;
                                }
                            //pega o resto da string
                            posy = Integer.parseInt(pos.substring(1));
                            posy = posy - 1;
                            }

                            mapaposhumano = "\tA\tB\tC\tD\tE\tF\tG\tH\tI\tJ\tK\n" + 1;

                            for (y=0;y<10;y++){
                                for (x=0;x<10;x++){
                                    mapaposhumano = mapaposhumano + "\t" + poshumano[x][y];
                                }
                                mapaposhumano = mapaposhumano + "\n" + (y+2);
                            }

                            int direcao = JOptionPane.showOptionDialog(
                                null,
                                new JTextArea(
                                    "Esta é a área que temos disponível:\n\n" + mapaposhumano 
                                    + "\n\n Escolha a Direção do navio:\n"
                                    ),
                                "Escolha da direcao",
                                JOptionPane.PLAIN_MESSAGE,
                                0,
                                null,
                                direcoes,
                                direcoes[0]
                            );

                            if(direcao == 0 && posx <=5){ 
                                if(poshumano[posx][posy]==agua && poshumano[posx+1][posy]==agua && poshumano[posx+2][posy] == agua && poshumano[posx+3][posy] == agua && poshumano[posx+4][posy] == agua){
                                for (y=0;y<10;y++){
                                    for (x=0;x<10;x++){
                                        poshumano[posx][posy] = mow + " " + m;
                                        poshumano[posx+1][posy]= mow + " " + m;
                                        poshumano[posx+2][posy]= mow + " " + m;
                                        poshumano[posx+3][posy]= mow + " " + m;
                                        poshumano[posx+4][posy]= mow + " " + m;
                                    } 
                                }
                                m = m-1;
                                posok = 1;
                                }
                            }else if(direcao == 1 && posx >= 4){ 
                                if(poshumano[posx][posy]==agua && poshumano[posx-1][posy]==agua && poshumano[posx-2][posy] == agua && poshumano[posx-3][posy] == agua && poshumano[posx-4][posy] == agua){
                                for (y=0;y<10;y++){
                                    for (x=0;x<10;x++){
                                        poshumano[posx][posy] = mow + " " + m;
                                        poshumano[posx-1][posy]= mow + " " + m;
                                        poshumano[posx-2][posy]= mow + " " + m;
                                        poshumano[posx-3][posy]= mow + " " + m;
                                        poshumano[posx-4][posy]= mow + " " + m;
                                    } 
                                }
                                m = m-1;
                                posok = 1;
                                }
                            }else if(direcao == 2 && posy >= 4){ 
                                if(poshumano[posx][posy]==agua && poshumano[posx][posy-1]==agua && poshumano[posx][posy-2] == agua && poshumano[posx][posy-3] == agua && poshumano[posx][posy-4] == agua){
                                for (y=0;y<10;y++){
                                    for (x=0;x<10;x++){
                                        poshumano[posx][posy] = mow + " " + m;
                                        poshumano[posx][posy-1]= mow + " " + m;
                                        poshumano[posx][posy-2]= mow + " " + m;
                                        poshumano[posx][posy-3]= mow + " " + m;
                                        poshumano[posx][posy-4]= mow + " " + m;
                                    } 
                                }
                                m = m-1;
                                posok = 1;
                                }
                            }else if(direcao == 3 && posy <=5){ 
                                if(poshumano[posx][posy]==agua && poshumano[posx][posy+1]==agua && poshumano[posx][posy+2] == agua && poshumano[posx][posy+3] == agua && poshumano[posx][posy+4] == agua){
                                for (y=0;y<10;y++){
                                    for (x=0;x<10;x++){
                                        poshumano[posx][posy] = mow + " " + m;
                                        poshumano[posx][posy+1]= mow + " " + m;
                                        poshumano[posx][posy+2]= mow + " " + m;
                                        poshumano[posx][posy+3]= mow + " " + m;
                                        poshumano[posx][posy+4]= mow + " " + m;
                                    } 
                                }
                                m = m-1;
                                posok = 1;
                                }
                            }else{
                                poshumano[posx][posy] = poshumano[posx][posy];
                            }                         
                            //ultimo navio?
                            if(e==0 && f==0 && b==0 && m==0){
                                humanook = 1;
                            }
                        }
                    
                    //IA POSICIONA O DO HUMANO----------------------------------
                    }else if(navio==4){

                        System.out.println("Seu preguiçoso!");
                        
                        //ia passa o posicionamento dela pro humano
                        for (y=0;y<10;y++){
                            for (x=0;x<10;x++){
                                poshumano[x][y] = posia[x][y];
                                posia[x][y] = rashumano[x][y];
                            } 
                        }
                        
                        //o posicionamento do humano é validado
                        humanook = 1;      
                        e=0;
                        f=0;
                        b=0;
                        m=0;
  
                        //ia precisa posicionar seus navios de novo
                        iaok=0;
                        iae=4;
                        iaf=3;
                        iab=2;
                        iam=1;
                        
                    }
                
                }//FIM DO POSICIONAMENTO DO HUMANO------------------------------
            
                //valida se todos os navios estão em prontos
                if(e==0 && f==0 && b==0 && m==0 && iae==0 && iaf==0 && iab==0 && iam==0){
                    naviospos=1;             
                    System.out.println("A batalha está para começar!");
                }
            
            }//FIM DOS DOIS POSICIONAMENTOS-------------------------------------
            
            //INTERSEÇÃO
            JOptionPane.showMessageDialog(
                null,
                "OK, Todos os navios estão prontos!\n"
                + "Atacaremos ao anoitecer!"
            );
            
            jogo = 0;

            //INICIO DO COMBATE-------------------------------------------------
            while(combate==0){
                
                String mapaposhumano = "\tA\tB\tC\tD\tE\tF\tG\tH\tI\tJ\tK\n" + 1;

                for (y=0;y<10;y++){
                    for (x=0;x<10;x++){
                        mapaposhumano = mapaposhumano + "\t" + poshumano[x][y];
                    }
                    mapaposhumano = mapaposhumano + "\n" + (y+2);
                }
                    
                String maparashumano = "\tA\tB\tC\tD\tE\tF\tG\tH\tI\tJ\tK\n" + 1;

                for (y=0;y<10;y++){
                    for (x=0;x<10;x++){
                        maparashumano = maparashumano + "\t" + rashumano[x][y];
                    }
                    maparashumano = maparashumano + "\n" + (y+2);
                }
                
                ras = JOptionPane.showInputDialog(
                    null,
                    new JTextArea(
                        "Este é nosso posicionamento:\n\n" + mapaposhumano 
                        + "\n\n Este é nosso rastreamento:\n" + maparashumano    
                        + "\n\n Onde deseja atirar, capitão?\n"
                        +  "\n\n Atenção! INSIRA A COLUNA (LETRA) E DEPOIS A LINHA (NUMERO) \n"
                    ),
                    "VEZ DE: " +  humano, 
                    JOptionPane.PLAIN_MESSAGE
                );

                if (ras==null || ras.equals("")){
                    //automatico caso vazio
                    rasx = rand.nextInt(9);
                    rasy = rand.nextInt(9);
                }else{
                    //tanto maiusculas quanto minusculas
                    ras = ras.toUpperCase();
                    //quebra a string
                    rasa = ras.substring(0,1);

                    if (null != rasa)switch (rasa) {
                        case "A":
                            rasx = 0;
                            break;
                        case "B":
                            rasx = 1;
                            break;
                        case "C":
                            rasx = 2;
                            break;
                        case "D":
                            rasx = 3;
                            break;
                        case "E":
                            rasx = 4;
                            break;
                        case "F":
                            rasx = 5;
                            break;
                        case "G":
                            rasx = 6;
                            break;
                        case "H":
                            rasx = 7;
                            break;
                        case "I":
                            rasx = 8;
                            break;
                        case "J":
                            rasx = 9;
                            break;
                        default:
                            break;
                    }
                    //pega o resto da string
                    posy = Integer.parseInt(pos.substring(1));
                    posy = posy - 1;
                }
  
                //O QUE O HUMANO ACERTOU----------------------------------------
                //AGUA
                if(posia[rasx][rasy]==agua){
                    
                    int rend = JOptionPane.showOptionDialog(
                        null,
                        "Não acertamos, capitão!",
                        "Detecção de Acerto",
                        JOptionPane.PLAIN_MESSAGE,
                        0,
                        null,
                        rendicao,
                        rendicao[0]
                    );

                    if(rend==1){
                        conthumano=0;
                    }

                    posia[rasx][rasy] = tiroagua ;
                    System.out.println("RÁ! Tiro na água!");

                    rashumano[rasx][rasy] = tiroagua;

                //ILHA
                }else if(posia[rasx][rasy]==ilha){

                    int rend = JOptionPane.showOptionDialog(
                        null,
                        "Acertamos parte do terreno!",
                        "Detecção de Acerto",
                        JOptionPane.PLAIN_MESSAGE,
                        0,
                        null,
                        rendicao,
                        rendicao[0]
                    );

                    if(rend==1){
                        conthumano=0;
                    }

                   System.out.println("Acertando as ilhas!? Está cego?");

                //NAVIO QUE JA TINHA SIDO ACERTADO
                }else if(posia[rasx][rasy]==acerto || poshumano[rasx][rasy] == tiroagua){
                    
                    int rend = JOptionPane.showOptionDialog(
                        null,
                        "Você já atirou aí, capitão!",
                        "Detecção de Acerto",
                        JOptionPane.PLAIN_MESSAGE,
                        0,
                        null,
                        rendicao,
                        rendicao[0]
                    );

                    if(rend==1){
                        conthumano=0;
                    }

                   System.out.println("Isso não faz sentido!");

                //NUMA EMBARCAÇÃO VÁLIDA
                }else{
                    
                    int rend = JOptionPane.showOptionDialog(
                        null,
                        "Boa Capitão " + humano 
                        + "\nAcertou o " + posia[rasx][rasy],
                        "Detecção de Acerto",
                        JOptionPane.PLAIN_MESSAGE,
                        0,
                        null,
                        rendicao,
                        rendicao[0]
                    );

                    if(rend==1){
                        conthumano=0;
                    }

                    System.out.println("Grrrr! acertou " + posia[rasx][rasy]);

                    contia = contia-1;
                    rashumano[rasx][rasy] = posia[rasx][rasy];
                    posia[rasx][rasy] = acerto ;
                } 
  
                //JOGADA DA IA -------------------------------------------------
                while(jogadaok==0){

                    rasx = rand.nextInt(9);
                    rasy = rand.nextInt(9);

                    System.out.println("Escolhi a posição inicial: [" + conversor[rasx] + "][" +(rasy+1) + "]");

                    //AGUA
                    if(poshumano[rasx][rasy]==agua){

                        JOptionPane.showMessageDialog(
                            null,
                            pirata[ia] + " Errou o tiro Capitão! [" + conversor[rasx] + "][" +(rasy+1) + "]"
                        );

                        rasia[rasx][rasy] = tiroagua ;
                        poshumano[rasx][rasy] = tiroagua;
                        System.out.println("Arrg! Errei!");
                        jogadaok = 1;

                    //ILHA
                    }else if(poshumano[rasx][rasy]==ilha){

                        System.out.println("Não, calma, aí não, tem uma ilha aí, hummmmm");

                    //NAVIO QUE JA TINHA SIDO ACERTADO
                    }else if(poshumano[rasx][rasy]==acerto || poshumano[rasx][rasy]==tiroagua){

                        System.out.println("Opa, ja tentei aqui, hummmmm");

                    //NUMA EMBARCAÇÃO VÁLIDA
                    }else{
                         
                        System.out.println("\nAcertei! \n");

                        JOptionPane.showMessageDialog(
                            null,
                            pirata[ia] + " atingiu " + poshumano[rasx][rasy]
                        );

                        conthumano = conthumano-1;
                        rasia[rasx][rasy] = acerto;
                        poshumano[rasx][rasy] = acerto ;
                        jogadaok = 1;

                    }//FIM DA ESCOLHA DA IA-------------------------------------

                }//JOGADA FOI VALIDADA       
 
                //IA vendo seu mapa de posicionamento
                String mapaposia = "Meu Posicionamento\n\tA\tB\tC\tD\tE\tF\tG\tH\tI\tJ\tK\n" + 1;

                for (y=0;y<10;y++){
                    for (x=0;x<10;x++){
                        mapaposia = mapaposia + "\t" + posia[x][y];
                    }
                    mapaposia = mapaposia + "\n" + (y+2);
                }

                System.out.println("\n" + mapaposia + "\n");
                    
                //IA vendo seu mapa de posicionamento
                String maparasia = "Meu Rastreamento\n\tA\tB\tC\tD\tE\tF\tG\tH\tI\tJ\tK\n" + 1;

                    for (y=0;y<10;y++){
                        for (x=0;x<10;x++){
                            maparasia = maparasia + "\t" + rasia[x][y];
                        }
                        maparasia = maparasia + "\n" + (y+2);
                    }

                System.out.println("\n" + maparasia + "\n");
                    
                //VALIDANDO VENCEDOR--------------------------------------------
                if(contia==0){
                    JOptionPane.showMessageDialog(
                        null,
                        "Vencemos!!!\nCapturamos " + pirata[ia]
                    );
                    
                    combate=1;
                    
                }else if (conthumano==0){
                    JOptionPane.showMessageDialog(
                        null,
                        "Recuar! Recuar!"
                    );

                    System.out.println("IArrr: HAHAHA!\nNUNCA ME PEGARÃO VIVO!");
                    combate=1;
                }else{
                    jogadaok=0;
                }//FIM DA VALIDAÇÃO DO VENCEDOR
       
            }//FIM DO COMBATE---------------------------------------------------
            
            if(conthumano==0){
                JOptionPane.showMessageDialog(
                    null,
                    "O VENCEDOR É " + pirata[ia]
                );
            }else if(contia==0){
                JOptionPane.showMessageDialog(
                    null,
                    "O VENCEDOR É " + humano
                );
            }
            
        }//FIM DO JOGO
    
    }//FIM DA FUNÇÃO MAIN

}//FIM DA CLASSE