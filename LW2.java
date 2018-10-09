
/**
 *
 * @author Oguzhan BAYRAK - LLfu-16*   -Erasmus Student
 *  
 */
public class LW2 {

    public static void main(String[] args) {
        String name = "Oguzhan";                             //7 => row         n
        String surname = "Bayrak";                           //6 => columns     m
        int n = name.length();          
        int m = surname.length();
        int matrix[][] = new int[n][m];     
        double array[] = new double[m];
        double arrayRow[]= new double[n];
        double averageRowWithOutM[] = new double[n];
        double averageColumnWithOutM[]=new double[m];
        int count = 0,numberOfwithOutM=0,numberOfWithOutMColumn=0;
        double minimumAverageRow,minimumAverageColumn = 0; 
//Loop 1 => This loop is generate random numbers from n to n+m
        for(int i = 0; i < n ; i++){
             for(int j = 0; j < m; j++){
                matrix[i][j] = (int)((Math.random()*10)+6);
                System.out.print(matrix[i][j]+"\t");        
                arrayRow[i] += matrix[i][j];                 //arrayRow[i] => This array is gather all number in rows in this way We can find average!                                                         
                if(matrix[i][j]!=m){                         //(!=m) means  if the generate of number equals my surname length don't take this number.
                    averageRowWithOutM[i] += matrix[i][j];
                    numberOfwithOutM++;                     //I used a integer value(numberOfwithOutM) because I'm have to find how many numbers without my surname.
                                                            //It's necesarry for find to average without m numbers  
                }
            }              
                arrayRow[i] = arrayRow[i]/m;                                   //the average of rows
                averageRowWithOutM[i] =averageRowWithOutM[i]/numberOfwithOutM; //the average of rows without m
                System.out.printf("  Average:   %.2f\t",arrayRow[i]);          
                System.out.printf("WithOut m :%.2f",averageRowWithOutM[i]);
                numberOfwithOutM =0;                                            //I'm supposed to reset numberOfwithOutM everytime if I can't this numberOfwithOutM always will increase and I won't find rows of average without m. 
                System.out.println("");   
        }
        
         minimumAverageRow=averageRowWithOutM[0];                           //If we want to find minimum average we should assign first value from arrays then after we can compare numbers inside of  arrays.
                for(int q=0;q<n;q++){                                       //this if-else block is find to minimum value without m number.
                    if(minimumAverageRow>averageRowWithOutM[q]){
                        minimumAverageRow=averageRowWithOutM[q];
                    }
                }
                 System.out.printf("Minumum Without Row m => :%.2f\n",minimumAverageRow); 
 
//Loop2 => This loop is different other loop who firstly looking column then row,for example this loop is working like this (0,0)(1,0)(2,0)(3,0)...       
        for(int x = 0; x < m ; x++){
            for(int y = 0; y < n; y++){
                array[x] += matrix[y][x];           //array[x] => this array is keeping all gathered column numbers.
                if(matrix[y][x]!=m){
                    averageColumnWithOutM[x]+=matrix[y][x];
                    numberOfWithOutMColumn++;
                }    
                 if(n == matrix[y][x]){                 //If the number is equals my name's length,count number increase.
                     count++;
                 } 
            }
            array[x] = array[x]/n;                                          //column average!
            averageColumnWithOutM[x] = averageColumnWithOutM[x]/numberOfWithOutMColumn;
                minimumAverageColumn = averageColumnWithOutM[0];
                for(int q=0;q<m;q++){                                       //This loop is find minimumColumn average without m like other loop.
                    if(minimumAverageColumn>averageColumnWithOutM[q]){
                        minimumAverageColumn=averageColumnWithOutM[q];
                    }
                }
               //  System.out.printf("\tMinumum Without Column m => :%.2f",minimumAverageColumn);

            System.out.printf(""+x+". Column:"+"%.2f\t=>",array[x]);
            System.out.printf(" Without m average :%.2f\n",averageColumnWithOutM[x]);           //column without m average!!!
            numberOfWithOutMColumn =0;
            
        }   
            System.out.printf("Minumum Without Column m => :%.2f\t",minimumAverageColumn);
            System.out.println("\nhow many equals n : "+count);                // n = 7; how many numbers equals 7;         
    
            
//third Loop for compare One dimension arrays (13.question)
            double maximumRow = arrayRow[0];                      //We assigned first array's value maximumRow then we can compare other number.
            for(int q=0 ; q<n; q++){                             //If we want to find maximum numbers we're have to compare other numbers
                 if(maximumRow<=arrayRow[q]){
                     maximumRow=arrayRow[q];  
                 } 
            }
             System.out.printf("max Row: %.2f ",maximumRow);
             
             double maximumColumn = array[0];
             for(int q=0 ; q<m; q++){
                 if(maximumColumn<=array[q]){
                     maximumColumn=array[q];  
                 } 
            }
             System.out.printf("\nmax Column: %.2f ",maximumColumn);
             
             if(maximumRow>maximumColumn){     //and we found maximum values of row and column.We can comparing now. 
                 System.out.printf("\n This row is greater than column : %.2f",maximumRow);
             }
             else{
                 System.out.println("\nColumn is greater than row!");
             }     
// It's below loop for 14.question 
        int oddNumbersValue=0;                      //We want to find how many numbers are equals odd number.
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(matrix[i][j]!=n && matrix[i][j]%2==1){   //If the number of generate equals n and partition to 2 equals odd number ; Increase to oddNumberValue
                         oddNumbersValue++;
                    }
                }
            }
                 System.out.println("\nTHE AMOUNT OF ODD NUMBER : "+oddNumbersValue);
 
    }
    
}
