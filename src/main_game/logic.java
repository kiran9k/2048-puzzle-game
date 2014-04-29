package main_game;
//package game_logic;

import java.util.Random;

public class logic {
	
	public static void fill_next_random(int[][] a,int[][]flag)
	{
		int random_int=0;
		Random generator = new Random();
		random_int=(generator.nextInt(2)+1)*2;
		//System.out.println(random_int);
		int random_pos=-1;
		int i,j;
		do
		{
			random_pos=generator.nextInt(16);
			i=random_pos/4;
			j=random_pos%4;
			//System.out.println(i+" " +j);
		}while(flag[i][j]!=0);
		a[i][j]=random_int;
		flag[i][j]=1;
	}	
	
	public static int left_movement(int[][] a,int[][]flag,int score)
	{
		boolean recent_change_flag=false;
		for(int k=0;k<3;k++)
		{
		for(int i=0;i<a.length;i++)
		{
			recent_change_flag=false;
			for(int j=1;j<a[i].length;j++)
			{
				if(a[i][j-1]==a[i][j] && a[i][j]!=0 && ! recent_change_flag && flag[i][j]!=2 && flag[i][j-1]!=2)
				{
					a[i][j-1]+=a[i][j-1];
					score+=(a[i][j-1]);
					a[i][j]=0;
					flag[i][j-1]=2;
					flag[i][j]=0;
					recent_change_flag=true;
					continue;
				}
				recent_change_flag=false;
				if(flag[i][j-1]==0 && flag[i][j]!=0)
				{
					a[i][j-1]=a[i][j];
					flag[i][j-1]=flag[i][j];
					a[i][j]=0;
					flag[i][j]=0;
					continue;
				}			
			}
		}
		}
		return score;
	}
	public static int  right_movement(int[][] a,int[][]flag,int score)
	{
		boolean recent_change_flag=false;
		for(int k=0;k<3;k++)
		{
		for(int i=0;i<a.length;i++)
		{
			recent_change_flag=false;
			for(int j=a[i].length-2;j>=0;j--)
			{
				if(a[i][j+1]==a[i][j] && a[i][j]!=0&& ! recent_change_flag && flag[i][j]!=2 && flag[i][j+1]!=2)
				{
					a[i][j+1]+=a[i][j+1];
					score+=(a[i][j+1]);
					flag[i][j+1]=2;
					a[i][j]=0;
					flag[i][j]=0;
					recent_change_flag=true;
					continue;
				}
				recent_change_flag=false;
				if(flag[i][j+1]==0 && flag[i][j]!=0)
				{
					a[i][j+1]=a[i][j];
					flag[i][j+1]=flag[i][j];
					a[i][j]=0;
					flag[i][j]=0;
					continue;
				}			
			}
		}
		}
		return score;
	}
	
	public static int up_movement(int[][] a,int[][]flag,int score)
	{
		boolean recent_change_flag=false;
		for(int k=0;k<3;k++)
		{
		for(int j=0;j<a.length;j++)
		{
			recent_change_flag=false;
			for(int i=1;i<a[j].length;i++)
			{
				if(a[i][j]==a[i-1][j]  && a[i][j]!=0 && ! recent_change_flag && flag[i][j]!=2 && flag[i-1][j]!=2)
				{
					a[i-1][j]+=a[i][j];
					score+=(a[i][j]);
					flag[i-1][j]=2;
					a[i][j]=0;
					flag[i][j]=0;
					recent_change_flag=true;
					continue;
				}
				recent_change_flag=false;
				if(flag[i][j]!=0 && flag[i-1][j]==0)
				{
					a[i-1][j]=a[i][j];					
					a[i][j]=0;
					flag[i-1][j]=flag[i][j];
					flag[i][j]=0;
					continue;
				}			
			}
		}
		}
		return score;
	}
	public static int down_movement(int[][] a,int[][]flag,int score)
	{
		boolean recent_change_flag=false;
		for(int k=0;k<3;k++)
		{
		for(int j=0;j<a.length;j++)
		{
			recent_change_flag=false;
			for(int i=a[j].length-2;i>=0;i--)
			{
				if(a[i][j]==a[i+1][j] && a[i][j]!=0 && ! recent_change_flag && flag[i][j]!=2 && flag[i+1][j]!=2)
				{
					a[i+1][j]+=a[i][j];
					score+=(a[i][j]);
					flag[i+1][j]=2;
					a[i][j]=0;
					flag[i][j]=0;
					recent_change_flag=true;
					continue;
				}
				recent_change_flag=false;
				if(flag[i][j]!=0 && flag[i+1][j]==0)
				{
					a[i+1][j]=a[i][j];
					flag[i+1][j]=flag[i][j];
					a[i][j]=0;
					flag[i][j]=0;
					continue;
				}			
			}
		}
		}
		return score;
	}
	public static boolean movement_checker(int[][]flag,int[][]flag2)
	{
		for(int i=0;i<flag.length;i++)
		{
			for(int j=0;j<flag[i].length;j++)
			{
				if(flag[i][j]!=flag2[i][j])
				{					
					return true;
				}
			}
		}
		return false;
	}
}
