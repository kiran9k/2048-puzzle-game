package main_game;
//package game_logic;

import java.util.Arrays;
import java.util.Scanner;

public class main_game_without_gui {
	public static void deep_copy(int[][] flag ,int[][] flag2)
	{
		for (int i = 0; i < flag.length; i++)
		{
			  flag2[i] = Arrays.copyOf(flag[i], flag[i].length);
		}
	}
	// insert new elements only if there's change in grid layout 
	public static void main(String[] args) {
		int score=0;
		// TODO Auto-generated method stub
		int[][] a = new int[4][4];
		int[][] flag = new int[4][4];
		int[][] flag2 = new int[4][4];
		grid.create_grid(a, flag);
		
		logic.fill_next_random(a, flag);
		grid.print_grid(a);
		System.out.println("$$$$$$$$$$$$$$$$$$");
		grid.print_grid(flag);
		Scanner input=new Scanner(System.in);
		int num;
		int i=0;
		boolean valid_user_move=false;
		// real game
		while(true)
		{
			valid_user_move=false;
			System.out.println("choice:");
			num=input.nextInt();
			deep_copy(flag,flag2);
			if(num==8)
			{
				score=logic.up_movement(a, flag,score);							
			}
			else if(num==6)
			{
				score=logic.right_movement(a, flag,score);
			}
			else if(num==4)
			{
				score=logic.left_movement(a, flag,score);
			}
			else if(num==2)
			{
				score=logic.down_movement(a, flag,score);
			}
			
			// replace all 2 of flag
			//grid.print_grid(flag);
			flag_2_replace(flag);
			//grid.print_grid(flag2);
			//grid.print_grid(flag);
			valid_user_move=logic.movement_checker(flag, flag2);
			if(valid_user_move)
			{
				logic.fill_next_random(a, flag);
				grid.print_grid(a);
				i++;
			}
			if(winner.out_condition(a,flag))
			{
				System.out.println("Your Score :" +score);
				System.out.println("you lose");
				break;
			}
			if(winner.win_condition(a))
			{
				System.out.println("Your Score :" +score);
				//you won
				break;
			}
			
			
		}
	}
	public static void flag_2_replace(int[][] flag) {
		// TODO Auto-generated method stub
		for(int i=0;i<flag.length;i++)
		{
			for(int j=0;j<flag[i].length;j++)
			{
				if(flag[i][j]==2)
					flag[i][j]=1;
			}
		}
	}

}
