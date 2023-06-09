public class Tabuleiro {
    
    final int TAMANHO = 9;

    // Matriz de Casas
    Casa casas[][] = new Casa[9][9];

    //Construtor 
    public Tabuleiro(){
        for(int i = 0; i < TAMANHO; i++){
            for(int j = 0; j < TAMANHO; j++){
                casas[i][j] = new Casa();
            }
        }
    }

    public void inicializaJogadores(Jogador[] jogadores){
        for(int i = 0; i < 4; i++){
            this.casas[jogadores[i].linha][jogadores[i].coluna].jogadorEntra(jogadores[i]);
        }

    }

    public void atualizaJogador(Jogador J, int linhaEx, int colunaEx){
        this.casas[linhaEx][colunaEx].jogadorSai();
        this.casas[J.linha][J.coluna].jogadorEntra(J);
    }


    public void inicializaRestritos(Restrito[] restritos){
        for(int i = 0; i < 4; i++){
            this.casas[restritos[i].linha][restritos[i].coluna].restritoEntra(restritos[i]);
        }
    }

    public void inicializaFakes(Fake[] fakes){
        for(int i = 0; i < 6; i++){
            this.casas[fakes[i].linha][fakes[i].coluna].fakeEntra(fakes[i]);
        }
    }

    public void desenhaTabuleiro(){
        for(int i = 0; i < TAMANHO; i++){
            System.out.println(Cores.ANSI_WHITE + "+----+----+----+----+----+----+----+----+----+" + Cores.ANSI_RESET);
            for(int j = 0; j < TAMANHO; j++){
                System.out.print(Cores.ANSI_WHITE + "| " + Cores.ANSI_RESET);
                if(this.casas[i][j].J != null){
                    System.out.print(Cores.ANSI_GREEN + this.casas[i][j].J.nome + " " + Cores.ANSI_RESET);
                }else if(this.casas[i][j].R != null){
                    System.out.print(Cores.ANSI_WHITE + "XX " + Cores.ANSI_RESET);
                }
                else if(this.casas[i][j].F != null){
                    System.out.print(Cores.ANSI_RED + this.casas[i][j].F.nome + " " + Cores.ANSI_RESET);
                }
                else{
                    System.out.print("   ");
                }                    
            }
            System.out.print(Cores.ANSI_WHITE + "| " + Cores.ANSI_RESET);
            System.out.println();
        }
        System.out.println(Cores.ANSI_WHITE + "+----+----+----+----+----+----+----+----+----+" + Cores.ANSI_RESET);
    }
}
