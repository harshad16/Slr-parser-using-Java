import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class slr {
	static String[][] ir=new String[15][10];
	static String[][] il=new String[15][10];
	static String gl[]=new String[10],tempr[]=new String[15];
	static int in[]=new int[15];
	static String dfa[][]=new String[15][15];
	static String gr[]=new String[10],read[]=new String[15];
	static int n=0,a,l=0,i=0,rr=0,j=0,ns=0,p1,k,p,tn=0; 
	static String temp="\0",t1=null,temp2,templ,ptr;
	
	
	
	public static void main(String[] args) throws Exception {
	 File inputFile = new File("C:\\Users\\Harshad\\Desktop\\t1.txt");
     File tempFile = new File("C:\\Users\\Harshad\\Desktop\\t2.txt");
     if (!tempFile.exists()) {
			tempFile.createNewFile();
		}
    BufferedReader reader = new BufferedReader(new FileReader(inputFile));
    BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

    String currentLine;

    while((currentLine = reader.readLine()) != null)
    {
  	  String trimmedLine = currentLine.replace("->"," ");
  	  writer.write(trimmedLine);
  	  writer.newLine();
    }
    reader.close();
    writer.close();
    inputFile.delete();
    tempFile.renameTo(inputFile);
  

    BufferedReader bufferedReader =  new BufferedReader(new FileReader(inputFile));
     String line;
    while((line = bufferedReader.readLine()) != null) {
        //System.out.println(line);
    	try{
        gl[n]=line.substring(0,1);
        a=line.length();
        gr[n]=line.substring(2,a);
        n++;}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    }   
    // Always close files.
    bufferedReader.close();  

    System.out.println("THE GRAMMER IS AS FOLLOWS");
    for(int i=0;i<n;i++){
  	  System.out.print(gl[i]+"->");
  	  System.out.println(gr[i]);
    	}
    il[0][0]="Z";
    ir[0][0]=".S";
    in[0]++;
    l = 0;
    for(i=0;i<n;i++){
    	 //System.out.println("in[0]:"+in[0]+" "+"ir[]:"+ir[0][l].substring(1,2)+" i:"+i);
    	temp=ir[0][l].substring(1,2);
    	l++;
    	for(j=0;j<rr;j++)
    		{if(temp.equals(read[j].substring(0,1)))
    			{ //System.out.println("temp:"+temp+"read[j]:"+read[j]+"l:"+l);
    			break;}}
    if(j==rr){//System.out.println("read[rr]:"+read[rr]+"j:"+j);
    	read[rr]=temp;
    	//System.out.println("inside j=rr:rr:"+rr+"temp:"+temp+"read[rr]:"+read[rr]);
    	rr++;}
    else
    	{//System.out.println("inside else");
		  continue;}
    
	  for(j=0;j<n;j++){
		  //System.out.println("inside 2 for:gl:"+gl[j].trim());
		  if(temp.equals(gl[j].trim())){
			  //System.out.println("inside gl[j]:"+gl[l]);
			  ir[0][in[0]]=".";
			  ir[0][in[0]]=ir[0][in[0]].concat(gr[j]);
			  il[0][in[0]]=gl[j];
			  in[0]++;
			  //System.out.println("inside ir[j]:"+ir[0][in[0]]+"il[j]"+il[0][in[0]]);
		  }
	  }
}
ns++;
System.out.println("\nI"+(ns-1)+":");
for(int i=0;i<in[0];i++)
	 System.out.println("\t"+(il[0][i])+"->"+(ir[0][i]));

for(l=0;l<ns;l++){

	 //System.out.println("Going to canonical");
	 canonical(l);}

System.out.println("\n\t\tDFA TABLE IS AS FOLLOWS\n\n\n");
for(i=0;i<ns;i++){
	
	System.out.print("I"+i+":  ");
	for(j=0;j<ns;j++){
		if(dfa[i][j]!=(null)){
			System.out.println("'"+dfa[i][j]+"'->I"+j);

		}
	}
	System.out.println("\n");

}
	
	
	
	}



	@SuppressWarnings("null")
	private static void canonical(int l) {
		int t1=0,rr1=0,b;
		String read1[] = new String[15],ptr1;
		
		for(int i=0;i<in[l];i++){//System.out.println("l:"+l);
			temp2=".";
			ir[l][i].trim();
	        b=ir[l][i].indexOf('.');
			   //System.out.println("b:"+b);
			ptr1=ir[l][i].substring(b,ir[l][i].length());
		    	 // System.out.println("ptr1:"+ptr1);
			t1=ir[l][i].length()-ptr1.length();
			//System.out.println("ir:"+ir[l][i]);
				//System.out.println("t1:"+t1+"prt1:"+ptr1.length()+"ir.lenght"+ir[l][i].length());
		
				if(t1+1==ir[l][i].length())
				{ //System.out.println("inside for t1+1");
				  continue;}
				
			temp2=temp2+ir[l][i].charAt(t1+1);
				//System.out.println("temp2:"+temp2);
			for(j=0;j<rr1;j=j+1){
				 if(temp2.equals(read1[j])){
                	//  System.out.println("inside for temp2 equals:"+temp2+"read[j]"+read1[j]+"j:"+j);
                	  break;}}
			
			//System.out.println("inside  j:"+read1[rr1]+temp2+"rr1:"+rr1+"and j:"+j);
			if(j==rr1){
				//System.out.println("inside  j:"+read1[rr1]+temp2+j);
				read1[rr1]=temp2;
			    //System.out.println("inside  j: after read1:"+read1[rr1]+temp2);
			    rr1++;
			}
			else
				{//System.out.println("inside else");
				continue;}
     		for(j=0;j<in[0];j++){
				//System.out.println("inside for temp2;"+temp2);
				if(ir[l][j]==null)
				{	p1=-1;
				    ptr=null;}
				else
				p1=ir[l][j].indexOf(temp2);
				//System.out.println("inside for p1;"+p1);
				if(p1==-1)
					ptr=null;
				else
				ptr=ir[l][j].substring(p1, temp2.length());
			if(ptr != null){
					//System.out.println("inside ptr!=null tn"+tn);
					if(templ==null)
                   templ=il[l][j].substring(0,1);
					else
						templ=templ+il[l][j].charAt(0);
                   //System.out.println("inside ptr!=null templ:"+templ);
                   tempr[tn]=ir[l][j];
                   //System.out.println("inside ptr!=null tempr:"+tempr[tn]+" l:"+l+" j:"+j);
                   tn++;
				}
			}
			
			for(j=0;j<tn;j++){
				//System.out.println("inside for of tn:"+tn);
				b=tempr[j].indexOf('.');
				//System.out.println("inside for b;"+b);
				ptr=tempr[j].substring(b);
				//System.out.println("inside for ptr:"+ptr);
				p=tempr[j].length()-ptr.length();
				//System.out.println("p:"+p);
				//System.out.println("tempr[j]:"+tempr[j]);
				StringBuffer str1=new StringBuffer(tempr[j]);
				str1.setCharAt(p,tempr[j].charAt(p+1));
				tempr[j]=str1.toString();
				//System.out.println("tempr[j]:"+tempr[j]);
				str1.setCharAt(p+1,'.');
				tempr[j]=str1.toString();
				//System.out.println("tempr[j]:"+tempr[j]+" "+tempr[j].indexOf('.'));
				
				if(il[ns][in[ns]]==null)
					il[ns][in[ns]]=templ.substring(j,j+1);
			    else
				il[ns][in[ns]]=templ.substring(j,j+1);
				//System.out.println("tempr[j]:"+tempr[j]+" "+tempr[j].indexOf('.'));
				ir[ns][in[ns]]=tempr[j];
				//System.out.println("ir[ns][in[ns]]:"+ir[ns][in[ns]]);
				
				in[ns]++;
			}
			
			moreprod();
			
			for(j=0;j<ns;j++)
			{   int g=compstruct(ns,j);
				if(g==1){
					//System.out.println("i m inside");
					il[ns][0]= null;
					StringBuffer str3,str4;
					for(k=0;k<in[ns];k++){
						str3=new StringBuffer(ir[ns][k]);
						str3.setCharAt(0, '\0');
						ir[ns][k]=str3.toString();}
					in[ns]=0;

					dfa[l][j]=temp2.substring(1,2);
					break;
				}
			}
			StringBuffer str5,str6;
			if(j<ns)
			{   
				tn=0;
				for(j=0;j<15;j++)
				{   	templ=null;
				        tempr[j]=null;
				}
				continue;
			}
			dfa[l][j]=temp2.substring(1,2);
			System.out.println("\n\nI"+ns+":");
			for(j=0;j<in[ns];j++)
				System.out.println("\n\t"+il[ns][j]+"->"+ir[ns][j]);
			
			ns++;
			tn=0;
			
			for(j=0;j<15;j++){
				templ=null;
				tempr[j]=null;
				}
			
		}
	}



	private static int compstruct(int y,int u) {

				int t;
		if(in[y]!=in[u])
			{return 0;}
		
		if(!il[y][0].equals(il[u][0]))
			return 0;
		for(t=0;t<in[y];t++)
		{
			if(!ir[y][t].equals(ir[u][t]))
				return 0;
		}
		// TODO Auto-generated method stub
		return 1;
	}



	@SuppressWarnings("unused")
	private static void moreprod() {
		//System.out.println("inside moreprod()");
		int t=0,r,s,l1=0,rr1=0,b;
		String read1[] = new String[15],ptr1;
		
		for(r=0;r<in[ns];r++)
		{
			b=ir[ns][l1].indexOf('.');
			//System.out.println("b:"+b);
			
			ptr1=ir[ns][l1].substring(b,ir[ns][l1].length());
			//System.out.println("ptr1:"+ptr1);
			//System.out.println("b:"+b+"ptr1:"+ptr1+"ir[ns][l1]:"+ir[ns][l1]);
			t=ir[ns][l1].length()-ptr1.length();
			//System.out.println("ns:"+ns+"l1:"+l1+"t:"+t);
			if(t+1==ir[ns][l1].length())
				{//System.out.println("inside for t1+1");
				l1++;
				continue;
				}
			//System.out.println("ns:"+ns+"l1:"+l1);
			//System.out.println("temp"+temp);
			temp=ir[ns][l1].substring(t+1,t+2);
			//System.out.println("temp"+temp+" "+ir[ns][l1].charAt(t+1));
			l1++;
			//System.out.println("temp"+temp+"l1:"+l1);
			for(s=0;s<rr1;s++){
                  if(temp.equals(read1[s])){
                	  //System.out.println("inside for tempequals:"+temp+"re:"+read1[s]);
                	  break;}
			}
			if(s==rr1){
				//System.out.println("inside  s:"+read1[rr1]+temp+s);
				read1[rr1]=temp;
			    rr1++;
			    //System.out.println("inside  j:"+read1[rr1-1]+temp);
			}
			else
				{//System.out.println("inside else");
				continue;}
			for(s=0;s<n;s++){
				//System.out.println("inside for ");
				//System.out.println("inside for gl[s]:"+gl[s]+" and il[ns][in[ns]:"+il[ns][in[ns]-1] +"and ns:"+ns);
				//System.out.println("inside for "+temp);
				if(gl[s].equals(temp)){
					//System.out.println("inside gl[s]=temp ns"+ns);
					
					ir[ns][in[ns]]=".";
					ir[ns][in[ns]]=ir[ns][in[ns]].concat(gr[s]);

					//System.out.println("inside ir[ns][in[ns]]"+ir[ns][in[ns]]);
                   il[ns][in[ns]]=gl[s];
                   //System.out.println("inside il[ns][in[ns]]"+il[ns][in[ns]] );
                   in[ns]++;
				}
			}		
	   }
			// TODO Auto-generated method stub
	}
}
