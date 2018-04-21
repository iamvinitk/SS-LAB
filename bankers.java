import java.util.Scanner;


public class bankers {

	int n,m;
	int[][] all=new int[10][10];
	
	int[][] max=new int[10][10];
	
	int[][] avail=new int[1][10];
	
	int[][] avail1=new int[1][10];
	
	int[][] need=new int[10][10];
	
	
	
	public void need()
	{
		
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				
				need[i][j]=max[i][j]-all[i][j];
				
			}
			
		
		}
		
	}	
	
	
	public void input()
	{
		Scanner s=new Scanner(System.in);
		
		
		System.out.println("Enter no. of processes\n");
		m=s.nextInt();
		
		System.out.println("Enter no. of resources\n");
		n=s.nextInt();
		
		System.out.println("Enter allocated\n");
		
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				
				all[i][j]=s.nextInt();
				
			}
			
		}
		System.out.println("Enter max\n");
		
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				
				max[i][j]=s.nextInt();
				
			}
			
		}
		System.out.println("Enter available\n");
		
			for(int j=0;j<n;j++)
			{
				
				avail[0][j]=s.nextInt();
				avail1[0][j]=avail[0][j];
			}
			
		
			
			
			
	}

		public boolean check(int p)
		{
			for(int i=0;i<n;i++)
			{
				
				if(avail[0][i]<need[p][i])
				{
					return false;
					
				}
			}
			
			return true;
			
		}
		
		
		public void algorithm()
		{
			
			need();
			
			int c=0;
			boolean status[]=new boolean[m];
			
			while(c<m)
			{
				boolean allocated =false;
				
				for(int i=0;i<m;i++)
				{
					
					if(!status[i] && check(i))
					{
						status[i]=true;
						allocated=true;
						
						c++;
						
						System.out.println("allocated process"+i);
						
						for(int j=0;j<n;j++)
						{
							
							avail[0][j]=avail[0][j]+all[i][j];
						}
					}
				}
				
				if(!allocated)
				{
					
					break;
				}
				
				if(c==m)
				{
					
					System.out.println("safe");
				}
				
				else
					System.out.println("not safe");
			}
			
		}
		
		
		public void resource(int pid,int request[][])
		{
			int c=0;
			need();
			
			for(int i=0;i<m;i++)
			{
				for(int j=0;j<n;j++)
				{
					
					System.out.print(" \t"+need[i][j]);
					
				}
				
				System.out.println(" \n");
			}
			
			
				for(int j=0;j<n;j++)
				{
					if(request[0][j]>need[pid][j])
					{
						
						System.out.print(request[0][j]);
						System.out.println(need[pid][j]);
							System.out.println(" error");
						
						
					}
					
					else if(request[0][j]>avail[0][j])
					{
						System.out.println(" must wait");
					
					}
					else
					{
						System.out.print(c);
						c++;
					}
					
					
					
				}
				
				
				if(c==n)
				{
					for(int l=0;l<n;l++)
					{
						avail1[0][l]=avail1[0][l]-request[0][l];
						all[pid][l]=all[pid][l]+request[0][l];
						need[pid][l]=need[pid][l]-request[0][l];
						
						
						
					}
					
					System.out.println(" allocated");
				}
				
			for(int i=0;i<m;i++)
			{
				for(int j=0;j<n;j++)
				{
					
					System.out.println(" \t"+need[i][j]);
					
				}
				
				System.out.println(" \n");
			}
			
			
			
		}
			
			public static void main(String args[])
			{
				int[][] request=new int[1][10];
				Scanner sc=new Scanner(System.in);
				bankers b=new bankers();
				b.input();
				b.algorithm();
				System.out.println("enter pid\n");
				int pid=sc.nextInt();
				System.out.println("enter request\n");
				
				for(int i=0;i<3;i++)
					request[0][i]=sc.nextInt();
					
				
				b.resource(pid,request);
			}
			
	
	
	
}


