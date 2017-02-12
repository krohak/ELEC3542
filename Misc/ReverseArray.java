public class ReverseArray {

public static void reverse(int[] list) {

int i = 0, j = list.length -1;

while (i<j) {


  int temp;
  temp = list[i];
  list[i] = list[j];
  list[j] = temp;


      i++;
      j--;

      }
    }


public static void main(String[] args){


int arr[] = {11,10,9,8,7,6,5,4,3,2,1};

reverse(arr);

for (int i=0; i<arr.length; i++) System.out.println(arr[i]);




      }


}
