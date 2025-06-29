import java.util.*;

class TicTacToe{
	
	static char[][] board;
	
	public TicTacToe() {
		board = new char[3][3];
		initBoard();
	}
	
      static void initBoard() {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				board[i][j]=' ';
			}
		}
	}
	static void dispBoard() {
		System.out.println("----------");
		for(int i=0;i<board.length;i++) {
			System.out.print("|");
			
			for(int j=0;j<board[i].length;j++) {
				System.out.print(board[i][j]+" |");
			}
			System.out.println();
			System.out.println("----------");
		}
	}
	
	static void putMark(int row,int col,char mark) {
		if(row>=0&&row<=2&&col>=0&&col<=2) {
		board[row][col]= mark;
	}
		else {
			System.out.println("invalid position");
		}
	}
	
	static boolean checkColWin() {
		for(int j=0;j<board.length;j++) {
			if(board[0][j]!=' ' && board[0][j]==board[1][j] && board[1][j]==board[2][j]) {
				return true;
			}
		}
		return false;
	}
	
	static boolean checkRowWin() {
		for(int i=0;i<board.length;i++) {
			if(board[i][0]!=' ' && board[i][0]==board[i][1] && board[i][1]==board[i][2]) {
				return true;
			}
		}
		return false;
	}
	
	static boolean checkDiagWin() {
			if(board[0][0]!=' ' && board[0][0]==board[1][1] && board[1][1]==board[2][2])
			{
				return true;
			}
			if(board[0][2]!=' ' && board[0][2]==board[1][1] && board[1][1]==board[2][0])
			 {
				 return true;
			 }
		return false;
	}
	
	static boolean checkDraw() {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				if(board[i][j]==' ') {
					return false;
				}
			}
		}
		return true;
	}
}

abstract class Player{
	String name;
	char mark;
	abstract void makeMove();
	boolean isValid(int row,int col) {
		if(row>=0&&row<=2&&col>=0&&col<=2) {
			if(TicTacToe.board[row][col]==' ') {
				return true;
			}
		}
		System.out.println("Incorrect Position");
		return false;
	}
}


class HumanPlayer extends Player{
	
	
	public HumanPlayer(String name,char mark) {
		this.name=name;
		this.mark=mark;
	}
	
	Scanner s=new Scanner(System.in);
	int row;
	int col;
	
	void makeMove() {
		
		do
		{
			System.out.println("Enter row and column");
			row=s.nextInt();
			col=s.nextInt();
		}while(!isValid(row,col));
		
		TicTacToe.putMark(row, col, mark);
	}
}

class AIPlayer extends Player{
	
	public AIPlayer(String name,char mark) {
		this.name=name;
		this.mark=mark;
	}
	
	Random r=new Random();
	int row;
	int col;
	
	void makeMove() {
		
		do
		{
			System.out.println("Enter row and column");
			row=r.nextInt(3);
			col=r.nextInt(3);
		}while(!isValid(row,col));
		
		TicTacToe.putMark(row, col, mark);
	}
}

class LaunchGame {
    public static void main(String[]args) {
         TicTacToe t = new TicTacToe();
         
         HumanPlayer p1=new HumanPlayer("Abhi",'o');
         AIPlayer p2=new AIPlayer("AI Bot",'x');
         Player p;
         
         p=p1;
         while(true){
         System.out.println(p.name+"'s turn");
         p.makeMove();
   	     TicTacToe.dispBoard();
        		 
                 if(TicTacToe.checkRowWin()||TicTacToe.checkColWin()||TicTacToe.checkDiagWin()){
                  System.out.println(p.name+ " has won");
            	   break;
            	   }
                 else if(TicTacToe.checkDraw()) {System.out.println("Game Drawn"); break;}
                 else {
                	 if(p==p1){
                		 p=p2;
                	 }
                	 else {
                		 p=p1;
                	 }
                 }
        	 }
    }
}
