import java.util.Random;

public class sorting {
	static int sortingData[]=new int[10000000];
	static int max=0,N;
public static double bubble(int[] ar,int N) {
	
	int arr []=new int[N];
	for(int j=0;j<N;j++)
	{
		arr[j]=ar[j];
	}
	double beforeTime = System.currentTimeMillis();

	for(int i=0;i<N-1;i++) {
		for(int j=0;j<N-1-i;j++)
			if(arr[j]>=arr[j+1]) {
				int tmp=arr[j+1];
				arr[j+1]=arr[j];
				arr[j]=tmp;
			}
	}

	double afterTime = System.currentTimeMillis(); 
	double secDiffTime = (afterTime - beforeTime)/1000.0;
	
	return secDiffTime;
	
}
public static double selection(int[] ar,int N) {
	int arr []=new int[N];
	
	for(int j=0;j<N;j++)
	{
		arr[j]=ar[j];
	}
	double beforeTime = System.currentTimeMillis();
	for(int i=N-1;i>0;i--) {
		 max=i;
		for(int j=0;j<=i;j++) {
			if(arr[max]<arr[j])
				max=j;
		}
		int tmp=arr[max];
		arr[max]=arr[i];
		arr[i]=tmp;
	}
	
	double afterTime = System.currentTimeMillis(); 
	double secDiffTime = (afterTime - beforeTime)/1000.0;
	
	return secDiffTime;
	
}
public static double insertion(int[] ar,int N) {
	int key,k,arr []=new int[N];
	
	for(int j=0;j<N;j++)
	{
		arr[j]=ar[j];
	}
	double beforeTime = System.currentTimeMillis();
	for(int i=1;i<N;i++) {
		key=arr[i];
		k=i-1;
		while(k>=0 && arr[k]>key) {
			arr[k+1]=arr[k];
			k--;
		}
		arr[k+1]=key;
	}
	double afterTime = System.currentTimeMillis(); 
	double secDiffTime = (afterTime - beforeTime)/1000.0;
	
	return secDiffTime;
}
public static void merge(int a[], int m, int middle, int n)
{
	int i = m;
	int j = middle + 1;
	int temp = m;
	
	while (i <= middle && j <= n)
	{
		if (a[i] <= a[j])
		{
			sortingData[temp] = a[i];
			i++;
		}
		else
		{
			sortingData[temp] = a[j];
			j++;
		}
		temp++;
	}

	if(i>middle)
	{
		for (int t = j; t <= n; t++)
		{
			sortingData[temp] = a[t];
			temp++;
		}
	}
	else
	{
		for (int t = i; t <= middle; t++)
		{
			sortingData[temp] = a[t];
			temp++;
		}
	}

	for (int t = m; t <= n; t++)
	{
		a[t] = sortingData[t];
	}
}
public static void mergesort(int[] ar,int l,int r) {
	
	if(l<r) {
		int m=(l+r)/2;
		mergesort(ar,l,m);
		mergesort(ar,m+1,r);
		
		merge(ar,l,m,r);
	}
	
}
	public static void main(String[] args) {
		double T=0,Ts=0,Ti=0,Tm=0,time []=new double[43];
		Random rand=new Random();
		int t=0;
		for(int q=1;q<=3;q++) 
		{
			if(q==1)
				N=1000;
			else if(q==2)
				N=10000;
			else
				N=100000;
			int ran[]=new int[N];
			int back[]=new int[N];
		for(int i=0;i<10;i++) {					//랜덤데이터 10개 생성
			
			for(int j=0;j<N;j++)
			{
				ran[j]=rand.nextInt(N)+1;
			
			}
		
		T=T+bubble(ran,N);						//랜덤데이터 버블정렬
		Ts=Ts+selection(ran,N);					//랜덤데이터 선택정렬
		Ti=Ti+insertion(ran,N);					//랜덤데이터 삽입정렬
		int arr []=new int[N];
		for(int z=0;z<N;z++)
		{
			arr[z]=ran[z];
			
		}
		double beforeTime = System.currentTimeMillis();
		mergesort(arr,0,N-1);
		double afterTime = System.currentTimeMillis(); 
		double secDiffTime = (afterTime - beforeTime)/1000.0;
		
		Tm=Tm+secDiffTime;
		}
		time[0]=T/10.0;double a=time[0];System.out.printf("%.5f\n",a);	
		time[1]=Ts/10.0;a=time[1];System.out.printf("%.5f\n",a);	
		time[2]=Ti/10.0;a=time[2];System.out.printf("%.5f\n",a);
		time[3]=Tm/10.0;a=time[3];System.out.printf("%.5f\n",a);
		for(int j=0;j<N;j++)					//내림차순데이터 생성
		{
			back[j]=N-j;
		}
		time[4]=bubble(back,N);a=time[4];System.out.printf("%.5f\n",a);			//내림차순데이터 버블정렬
		time[5]=selection(back,N);a=time[5];System.out.printf("%.5f\n",a);			//내림차순데이터 선택정렬
		time[6]=insertion(back,N);a=time[6];System.out.printf("%.5f\n",a);		//내림차순데이터 삽입정렬
		int arr []=new int[N];
		for(int z=0;z<N;z++)
		{
			arr[z]=back[z];
			
		}
		double beforeTime = System.currentTimeMillis();
		mergesort(back,0,N-1);
		double afterTime = System.currentTimeMillis(); 
		double secDiffTime = (afterTime - beforeTime)/1000.0;
		time[7]=secDiffTime;a=time[7];System.out.printf("%.5f\n",time[7]);
		
	}
		System.out.println("\t\tRandom1000\tReverse1000\tRandom10000\tReverse10000\tRandom100000\tReverse100000\t");
		System.out.printf("Bubble		%.5f		%.5f		%.5f		%.5f		%.5f		%.5f\n",time[0],time[4],time[8],time[12],time[16],time[20]);
		System.out.printf("Selection	%.5f		%.5f		%.5f		%.5f		%.5f		%.5f\n",time[1],time[5],time[9],time[11],time[17],time[21]);
		System.out.printf("Insertion	%.5f		%.5f		%.5f		%.5f		%.5f		%.5f\n",time[2],time[6],time[10],time[13],time[18],time[22]);
		System.out.printf("Merge		%.5f		%.5f		%.5f		%.5f		%.5f		%.5f\n",time[3],time[7],time[11],time[14],time[19],time[23]);
	}
	
}
