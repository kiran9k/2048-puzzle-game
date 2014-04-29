package main_game;
//package game_logic;

public class grid {
	public static void create_grid(int[][] a,int[][] flag)
	{
		
		for(int i=0;i<flag.length;i++)
		{
			for(int j=0;j<flag[i].length;j++)
			{
				flag[i][j]=0;
				a[i][j]=0;
			}
		}	
	}
	
	public static void print_grid(int[][] a)
	{
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[i].length;j++)
			{
				if(a[i][j]!=0)
					System.out.print(a[i][j]+"  ");
				else
					System.out.print("."+ "  ");
			}
			System.out.print("\n");
		}
	}
}
