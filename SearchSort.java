public class SearchSort
{
   public static void main(String[] args)
   {
      int[] num1 = new int[5];
      int n1 = findNum(num1, 3);
      int[] num2 = new int[]{1, 2, 3, 4, 5};
      int n2 = findNum(num2, 4);
      int[] num3 = new int[]{0, 1, 0, 1};
      int n3 = findNum(num3, 1);
      System.out.println(n1 + ", " + n2 + ", " + n3);
      int number = mailboxSearch(num2, 5);
      System.out.println(number);
   }
   
   public static int findNum(int[] nums, int value)
   {
      for (int times = 0; times < nums.length; times++)
      {
         if(nums[times] == value)
         {
            return times;
         }
      } 
      return -1;   
   }
   
   public static int mailboxSearch(int[] inputArray, int targetValue)
   {
      int end = inputArray.length - 1;
      int start = 0;
      //int index = length/2;
      //int diff = index/4;
      while(start <= end)
      {
         int mid = (start + end) / 2;
         if(targetValue < inputArray[mid])
         {
            end = mid - 1;
         }
         else if(targetValue > inputArray[mid])
         {
            start = mid;
         }
         else
         {
            return mid;
         }
      }
      return -1;
   }
}