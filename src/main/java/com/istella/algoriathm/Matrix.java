package com.istella.algoriathm;

/**
 * @author liunan13
 * @date 2021/5/21
 * @description
 */
public class Matrix {

    public static void main(String[] args){
//        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(matrix);
        for(int y=0;y<matrix.length;y++)
            for (int x=0;x<matrix.length;x++){
                System.out.println(matrix[y][x]);
            }
    }

    /**
     * 给定一个 n×n 的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转 90 度。
     *
     * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnhhkv/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param matrix
     *
     *
     *
     * 左上(i,i)，左下(end-i,i)，右下(end-i,end-i)，右上(i,end-i)
     */
    public static void rotate(int[][] matrix) {
        int size=matrix.length;
        int end=size-1;
        int turn=size/2;
        System.out.println("size="+size+" end="+end+" turn="+turn);
        for(int i=0;i<turn;i++){
            int csize=(size-2*i);
            for(int j=0;j<csize-1;j++){
                int lu_y=i,lu_x=i+j;
                int ld_y=end-i-j,ld_x=i;
                int rd_y=end-i,rd_x=end-i-j;
                int ru_y=i+j,ru_x=end-i;
                System.out.println("i="+i+",j="+j);
                System.out.println("lu "+lu_y+","+lu_x+","+matrix[lu_y][lu_x]);
                System.out.println("ld "+ld_y+","+ld_x+","+matrix[ld_y][ld_x]);
                System.out.println("rd "+rd_y+","+rd_x+","+matrix[rd_y][rd_x]);
                System.out.println("ru "+ru_y+","+ru_x+","+matrix[ru_y][ru_x]);
                int t=matrix[lu_y][lu_x];
                System.out.println(t);
                matrix[lu_y][lu_x]=matrix[ld_y][ld_x];
                matrix[ld_y][ld_x]=matrix[rd_y][rd_x];
                matrix[rd_y][rd_x]=matrix[ru_y][ru_x];
                matrix[ru_y][ru_x]=t;
                System.out.println("lu "+lu_y+","+lu_x+","+matrix[lu_y][lu_x]);
                System.out.println("ld "+ld_y+","+ld_x+","+matrix[ld_y][ld_x]);
                System.out.println("rd "+rd_y+","+rd_x+","+matrix[rd_y][rd_x]);
                System.out.println("ru "+ru_y+","+ru_x+","+matrix[ru_y][ru_x]);
            }
        }
    }
}
