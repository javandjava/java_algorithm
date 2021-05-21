package com.istella.algoriathm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liunan13
 * @date 2021/5/21
 * @description
 */
public class IsValidSudoku {
    public static void main(String[] args){
        char[][] nums = {{'5','3','.','.','7','.','.','.','.'}
                        ,{'6','.','.','1','9','5','.','.','.'}
                        ,{'.','9','8','.','.','.','.','6','.'}
                        ,{'8','.','.','.','6','.','.','.','3'}
                        ,{'4','.','.','8','.','3','.','.','1'}
                        ,{'7','.','.','.','2','.','.','.','6'}
                        ,{'.','6','.','.','.','.','2','8','.'}
                        ,{'.','.','.','4','1','9','.','.','5'}
                        ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(nums));
    }

    public static boolean isValidSudoku(char[][] board) {
        int[][] xs=new int[9][9];
        int[][] ys=new int[9][9];
        int[][] ares=new int[9][9];
        for(int y=0;y<9;y++) {
            for (int x = 0; x < 9; x++) {
                if(board[y][x]=='.')
                    continue;
                int num=board[y][x]-'0'-1;
                int areai=(y/3)*3+x/3;
                System.out.println(y+","+x+","+areai+","+num);
                if(xs[x][num]==1||ys[y][num]==1||ares[areai][num]==1)
                    return false;
                else {
                    xs[x][num] = 1;
                    ys[y][num]=1;
                    ares[areai][num]=1;
                }
            }
        }
        return true;
    }

//    public static boolean isValidSudoku(char[][] board) {
//        Map<String,String> haved=new HashMap<>();
//        for(int y=0;y<9;y++) {
//            for (int x = 0; x < 9; x++) {
//                if(board[y][x]=='.')
//                    continue;
//                String v=String.valueOf(board[y][x]);
//                String kx="x"+y+"_"+board[y][x];
//                String ky="y"+x+"_"+board[y][x];
//                String karea=y/3+"_"+x/3+board[y][x];
//                if(haved.get(kx)!=null||haved.get(ky)!=null||haved.get(karea)!=null){
//                    return false;
//                }
//                haved.put(kx,v);
//                haved.put(ky,v);
//                haved.put(karea,v);
//            }
//        }
//        return true;
//    }
}
