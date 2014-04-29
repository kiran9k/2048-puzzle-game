package main_game;
//package game_logic;

public class winner {

	public static boolean win_condition(int[][] a)
	{
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[i].length;j++)
			{
				if(a[i][j]==2048)
				{
					System.out.println("You won");
					return true;
				}
			}
		}
		return false;
	}
	public static boolean out_condition(int[][] a,int[][] flag)
	{
		int sum=0;
		for(int i=0;i<flag.length;i++)
		{
			for(int j=0;j<flag[i].length;j++)
			{
				sum+=flag[i][j];
			}
		}
		if(sum>=16)
		{
			boolean valid =false;
			for(int i=0;i<a.length;i++)
			{
				for(int j=0;j<a[i].length;j++)
				{
					if(i+1<a.length && a[i][j]==a[i+1][j])
					{ 
						valid= true;
						break;
					}
					if(j+1<a.length && a[i][j]==a[i][j+1])
					{
						valid= true;
						break;
					}
				}
			}
			if(valid==false)
				return true; // out
			
		}
		return false;
	}
}
