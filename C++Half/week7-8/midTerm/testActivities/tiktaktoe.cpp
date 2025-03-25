#include <iostream>
using namespace std;
int checkWin(int board[][3]){
    for(int i=0;i<3;i++){
        if(board[i][0]==board[i][1] && board[i][1]==board[i][2]){
            if(board[i][0]==1){
                cout<<"Player1 wins\n";
                return 1;
            }
            else if(board[i][0]==2){
                cout<<"Player2 wins\n";
                return 1;
            }
        }
    }
    for(int i=0;i<3;i++){
        if(board[0][i]==board[1][i] && board[1][i]==board[2][i]){
            if(board[0][i]==1){
                cout<<"Player1 wins\n";
                return 1;
            }
            else if(board[0][i]==2){
                cout<<"Player2 wins\n";
                return 1;
            }
        }
    }
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            if(i=j){
                if((board[i][j]==board[i+1][j+1] && board[i+1][j+1]==board[i+2][j+2])||(board[i][j]==board[i+1][j-1] && board[i+1][j-1]==board[i+2][j-2])){
                    if(board[i][j]==1){
                        cout<<"Player1 wins\n";
                        return 1;
                    }
                    else if(board[i][j]==2){
                        cout<<"Player2 wins\n";
                        return 1;
                    }
                }
            }
        }
    }
    return 0;
}
void printBoard(int board[][3]){
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            if(board[i][j]==0){
                cout<<"- ";
            }
            else if(board[i][j]==1){
                cout<<"X ";
            }
            else{
                cout<<"O ";
            }
        }
        cout<<endl;
    }
}
int main(){
    int player1=1;
    int player2=2;
    int win=0;
    int row,col;
    bool valid=false;
    int board[3][3]={0};
    cout<<"Player1: X\nPlayer2: O\n";
    // Print the board
    printBoard(board);
    while(win!=1){
        // Player 1 Move
        cout<<"Player1 enter row and column:\n";
        valid = false;
        while(!valid){
            cout<<"Row: ";
            cin>>row;
            cout<<"Column: ";
            cin>>col;
            if(row<0||row>2||col<0||col>2){
                cout<<"Invalid move, try again\n";
                continue;
            }
            else if(board[row][col]==0){
                board[row][col]=player1;
                valid=true;
                break;
            }
            else{
                cout<<"Invalid move, try again\n";
                continue;
            }
        }
        //Print Board Check Win
        printBoard(board);
        win=checkWin(board);
        if(win==1){
            break;
        }
        cout<<"Player2 enter row and column:\n";
        valid=false;
        while((!valid)){
            cout<<"Row: ";
            cin>>row;
            cout<<"Column: ";
            cin>>col;
            if(row<0||row>2||col<0||col>2){
                cout<<"Invalid move, try again\n";
                continue;
            }
            else if(board[row][col]==0){
                board[row][col]=player2;
                valid=true;
                break;
            }
            else{
                cout<<"Invalid move, try again\n";
                continue;
            }
        }
        //Print Board Check Win
        printBoard(board);
        win=checkWin(board);
    }
    cout<<"Would you like to play again? (Y/N): ";
    char play;
    cin>>play;
    if(play=='Y'){
        main();
    }
    else{
        cout<<"Goodbye\n";
    }
}