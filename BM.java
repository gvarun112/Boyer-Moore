package bm;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class BM {
private static int[] test;
private static String Text;
private static String Pattern;
public static void main(String[] args) throws FileNotFoundException {
long initialTime = System.currentTimeMillis();
Scanner sc=new Scanner(System.in);
//System.out.println("Please enter the first string:");
Text=new Scanner(new File("filepath")).useDelimiter("\\Z").next();
//System.out.println(Text);
        //sc.next(); 
//System.out.println("Please enter the Pattern string:");
Pattern=sc.next();
sc.close();
Boyer();
search();
long finalTime = System.currentTimeMillis();
long timeTaken = finalTime - initialTime;
System.out.println("\nTime taken = " + timeTaken);
}
private static void Boyer() {
test = new int[256]; //As per ASCII values
for (int i=0 ; i<256 ; i++) {
test[i] = -1;
}
for (int i=0 ; i<Pattern.length() ; i++){
test[Pattern.charAt(i)] = i;
}
}
private static void search() {
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
int t = Text.length(), p = Pattern.length();
int i = 0;
int k;
boolean found = false;
while ( i <= t-p ) {
k = 0;
// System.out.println("i: "+i);
for(int j = p-1; j > 0 ; j-- ) {
if (Pattern.charAt(j) != Text.charAt(i+j)) {
k = Math.max(1, j-test[Text.charAt(i+j)]);
break;
}
}
if (k == 0){
System.out.println("Pattern found at index: "+i);
found = true;
i++;
}
else
i = i+k;
}
if(!found)
System.out.println("Pattern not found in Target");
}
}