class TicTacToe{
	static char [][] board;
	
	//constructor
	public TicTacToe(){
		board=new char [3][3];
		initboard();
	}
	
	
	//initialise board
	void initboard(){
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[i].length;j++){board[i][j]=' ';}
		}
	}
	
	//display board
	static void dispboard(){
	System.out.println("-------------");
	
	for(int i=0;i<board.length;i++){
		System.out.print("| ");
		for(int j=0;j<board[i].length;j++){
			System.out.print(board[i][j] + " | ");
		}
		System.out.println();
		System.out.println("-------------");
	}
	}
	
	//place mark
	static void placemark(int row,int col,char mark){
		if(i>=0 && i<=2 && j>=0 && j<=2){
		board[row][col] = mark;}
		else{System.out.println("invalid position");}
		}
		
		
	//checking win conditions
	static boolean checkcolwin(){
		for(int j=0;j<=2,j++){
			if(board[0][j]!=' ' && board[0][j]==board[1][j] && board[1][j]==board[2][j]){
			return true;}
			else{
			return false;}
		}
	}
	
	static boolean checkrowwin(){
		for(int i=0;i<=2,i++){
			if(board[i][0]!=' ' && board[i][0]==board[i][1] && board[i][1]==board[i][2]){
			return true;}
			else{
			return false;}
		}
	}
	
	static boolean checkdiagwin(){
		if(board[0][0]!=' ' && board[0][0]==board[1][1] && board[1][1]==board[2][2] 
		|| board[0][2]==board[1][1] && board[1][1]==board[2][0])
		{return true;}
		else
		{return false;}
		}	
}


class HumanPlayer
{
	String name;
	char mark;
	
	HumanPlayer(String name, char mark){
		this.name=name;
		this.mark=mark;
	}
	
	void MakeMove()
	{
		Scanner sc=new Scanner(System.in);
		int row;
		int col;
		do{
	    System.out.println("enter the row and column :");
		row=sc.nextInt();
		col=sc.nextInt();
		}while(!isValidMove(row,col));
		
		TicTacToe.placemark(row,col,mark);
	}
	
	
	boolean isValidMove(int row,int col){
		if(i>=0 && i<=2 && j>=0 && j<=2){
			if(TicTacToe.board[row][col]==' '){
				return true;
			}
		}
		return false;
	}
}


class LaunchGame{
	public static void main(String[]args){
		TicTacToe t= new TicTacToe();
		}
}