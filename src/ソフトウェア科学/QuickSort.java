package ソフトウェア科学;

public class QuickSort {
	static void Quicksort(int[] array,int start,int end)
    {
        if(start<end)
        {
            int key=array[start];//初始化保存基元
            int i=start,j;//初始化i,j
            for(j=start+1;j<=end;j++)
            {
                if(array[j]<key)//如果此处元素小于基元，则把此元素和i+1处元素交换，并将i加1，如大于或等于基元则继续循环
                {
                    int temp=array[j];
                    array[j]=array[i+1];
                    array[i+1]=temp;
                    i++;
                }
                
            }
            array[start]=array[i];//交换i处元素和基元
            array[i]=key;
            Quicksort(array, start, i-1);//递归调用
            Quicksort(array, i+1, end);
            
        }
        
    }

}

