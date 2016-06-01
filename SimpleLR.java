import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class SimpleLR {

	static JFrame frame;
	private final Action action = new SwingAction();

	static String[][] ir=new String[15][10];
	static String[][] il=new String[15][10];
	static String gl[]=new String[10],tempr[]=new String[15];
	static int in[]=new int[15];
	static String dfa[][]=new String[15][15];
	static String dfa1[][]=new String[15][15];
	static String gr[]=new String[10],read[]=new String[15];
	static int n=0,a,l=0,i=0,rr=0,j=0,ns=0,p1,k,p,tn=0; 
	static String temp="\0",t1=null,temp2,templ,ptr;
	private JLabel label;
	private JButton button;
	private JButton button_1;
	private JButton btnActionTable;
	private JButton btnNewButton;
	static char ntermnl[],termnl[];
	static int ntlen,tlen;
	static String grmr[][],fst[],flw[];
	private JButton btnGotoTable;
	private JButton btnNewButton_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleLR window = new SimpleLR();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				File inputFile = new File("C:\\Users\\Harshad\\Desktop\\t1.txt");
			     File tempFile = new File("C:\\Users\\Harshad\\Desktop\\t2.txt");
			     if (!tempFile.exists()) {
						try {
							tempFile.createNewFile();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
			    BufferedReader reader = null;
				try {
					reader = new BufferedReader(new FileReader(inputFile));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    BufferedWriter writer = null;
				try {
					writer = new BufferedWriter(new FileWriter(tempFile));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			    String currentLine;

			    try {
					while((currentLine = reader.readLine()) != null)
					{
					  String trimmedLine = currentLine.replace("->"," ");
					  writer.write(trimmedLine);
					  writer.newLine();
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    try {
					reader.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    try {
					writer.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    inputFile.delete();
			    tempFile.renameTo(inputFile);
			  

			    BufferedReader bufferedReader = null;
				try {
					bufferedReader = new BufferedReader(new FileReader(inputFile));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			     String line;
			    try {
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
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}   
			    // Always close files.
			    try {
					bufferedReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  

			    System.out.println("THE GRAMMER IS AS FOLLOWS");
			    for(int i=0;i<n;i++){
			  	  System.out.print(gl[i]+"->");
			  	  System.out.println(gr[i]);
			    	}

				try1();
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
			
			
			
			
			File temp31 = new File("C:\\Users\\Harshad\\Desktop\\t5.txt");
		    
			if (!temp31.exists()) {
					try {
						temp31.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			 BufferedWriter writer31 = null;
				try {
					writer31 = new BufferedWriter(new FileWriter(temp31));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			String tableLine1 = null;
					
			for(int y=0;y<ns;y++){
			//System.out.println("index:"+ir[y][0].indexOf('.')+"lenth:"+ir[y][0].length()+"ir"+ir[y][0]+"y:"+y);
			if(ir[y][0].indexOf('.')==(ir[y][0].length()-1)){
				//System.out.println("inside if:");
				for(p=0;p<n;p++){
					//System.out.println("gr[p]:"+gr[p]+"  ir[y][0].length():"+ir[y][0].substring(0,ir[y][0].length()-1)+"p:"+p);
					if(gr[p].equals(ir[y][0].substring(0,ir[y][0].length()-1))){
						//System.out.println("inside p:"+p+"gl[p]"+gl[p]);		
						for(int u=0;u<ntlen;u++){
							//System.out.println("inside u for:"+ntermnl[u]+"index:"+gl[p].indexOf(ntermnl[u]));
						 if(gl[p].indexOf(ntermnl[u])==0){
							 //System.out.println("inside in the if");
						String kop=removeDuplicates(flw[u]);
						 //System.out.println("inside kop: "+kop+"kop.leg: "+kop.length());
						for(int tq=0;tq<kop.length();tq++)
						  {dfa1[y][p]=kop.substring(tq,tq+1);
						  if(dfa1[y][p]!=null){
		                       tableLine1 = ("("+y+", "+"'"+dfa1[y][p]+"')->R"+(p+1));
								try {
		       					
		     					  writer31.write(tableLine1);
		     					  writer31.newLine();
		     					
		     				} catch (IOException e1) {
		     					// TODO Auto-generated catch block
		     					e1.printStackTrace();
		     				}
							} 
						  //System.out.println("inside dfa:"+p+"kop.substring(tq,tq+1):"+kop.substring(tq,tq+1));

						System.out.println("I"+y+"'"+dfa1[y][p]+"'->R"+p);}
						}
					}
				}
				}
			}
			}
			try {
				writer31.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			System.out.println("\n\t\tDFA TABLE IS AS FOLLOWS\n\n\n");
			 File temp = new File("C:\\Users\\Harshad\\Desktop\\t3.txt");
			 File temp32 = new File("C:\\Users\\Harshad\\Desktop\\t6.txt");
		     if (!temp.exists()) {
					try {
						temp.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		     if (!temp32.exists()) {
					try {
						temp32.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			    
		     BufferedWriter writer32 = null;
				try {
					writer32 = new BufferedWriter(new FileWriter(temp32));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		     BufferedWriter writer3 = null;
				try {
					writer3 = new BufferedWriter(new FileWriter(temp));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			    String tableLine = null;
                String tableline2;
                int fig=0;
			    
			for(i=0;i<ns;i++){
				
				System.out.print("I"+i+":  ");
				for(j=0;j<ns;j++){
					fig=0;
					if(dfa[i][j]!=(null)){
						System.out.println("'"+dfa[i][j]+"'->I"+j);
						System.out.println("'"+dfa[i][j]+"'->I"+j);
						if(dfa[i][j]!=null)
                         tableLine=("("+i+" ,"+"'"+dfa[i][j]+"'"+")->S"+j);
						 tableline2=("("+i+" ,"+"'"+dfa[i][j]+"'"+")->"+j);
                         System.out.println("inside table line:"+tableLine);
                         try {
                        	//System.out.println("inside p:"+p+"gl[p]"+gl[p]);		
     						for(int u=0;u<ntlen;u++){
     							//System.out.println("inside u for:"+ntermnl[u]+"index:"+gl[p].indexOf(ntermnl[u]));
     						 if(dfa[i][j].indexOf(ntermnl[u])==0){
                        	 writer32.write(tableline2);
                        	 writer32.newLine();
                        	 fig=1;
                        	 break;
     						 }
     						 }
     						if(fig==0){
       					  writer3.write(tableLine);
       					  writer3.newLine();
       					  fig=0;}
       					
       				} catch (IOException e1) {
       					// TODO Auto-generated catch block
       					e1.printStackTrace();
       				}
					}
				}
			}
			
			try {
				writer3.close();
				writer32.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("ns:"+ns);
			
			
			
			}
			
		});
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
	
	
	
	
	
	
	static void try1(){
	
	String nt = null,t = null;
	int i,j,n = 0;
	int check[]=new int[5];
	String k = null;
	for(i=0;i<SimpleLR.n;i++){
		
		if(k==null)
		k=gl[i];
		else{
			if(k.indexOf(gl[i])<0)
			k=k+gl[i];}
	}
    System.out.println("I m here");
	for(i=0;i<k.length();i++){
		 //System.out.println("k.length:"+k.length()+"i:"+i);
     for(j=0;j<SimpleLR.n;j++){
    	 //System.out.println("SimpleLr.n:"+SimpleLR.n+"value of gl[j]:"+gl[j]+"j:"+j+"k.sub:"+k.substring(i,i+1));
		if(k.substring(i,i+1).equals(gl[j])){
			// System.out.println("check[i]:"+check[i]);
			check[i]++;
		}
		
	}}
	
	
	
	nt=k;
	System.out.println("value of nt:"+nt);
	ntlen=nt.length();
	ntermnl=new char[ntlen];
	ntermnl=nt.toCharArray();
	System.out.println("Enter the terminals");
	t="";
	tlen=t.length();
	termnl=new char[tlen];
	termnl=t.toCharArray();
	System.out.println("Specify the grammar(Enter 9 for epsilon production)");
	grmr=new String[ntlen][];
	int p=0;
	for(i=0;i<ntlen;i++)
	{
	System.out.println("Enter the number of productions for "+ntermnl[i]);
	try {
		
		n=check[i];
	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	grmr[i]=new String[n];
	System.out.println("Enter the productions");
	for(j=0;j<n;j++) {
		grmr[i][j]=gr[p];
		p=p+1;
	}
	}
	fst=new String[ntlen];
	for(i=0;i<ntlen;i++)
	fst[i]=first(i);
	System.out.println("First Set");
	for(i=0;i<ntlen;i++)
	System.out.println(removeDuplicates(fst[i]));
	flw=new String[ntlen];
	for(i=0;i<ntlen;i++)
	flw[i]=follow(i);
	System.out.println("Follow Set");
	for(i=0;i<ntlen;i++)
	System.out.println(removeDuplicates(flw[i]));
	
	 File temp12 = new File("C:\\Users\\Harshad\\Desktop\\t4.txt");
     if (!temp12.exists()) {
			try {
				temp12.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
     BufferedWriter writer12 = null;
		try {
			writer12 = new BufferedWriter(new FileWriter(temp12));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	    String tableLine12;

	    for(i=0;i<ntlen;i++){
				     tableLine12=(ntermnl[i]+": "+removeDuplicates(flw[i]));
				     System.out.println("tableLine2: "+tableLine12+"ntlen:"+ntlen+"flw[i]"+flw[i]);
                     try {
     					
   					  writer12.write(tableLine12);
   					  writer12.newLine();
   					
   				} catch (IOException e1) {
   					// TODO Auto-generated catch block
   					e1.printStackTrace();
   				}
				}
			
		
		try {
			writer12.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}



	static String first(int i)
	{int k,l=0,found=0,j;
	String temp=" ",str=" ";
	for(j=0;j<grmr[i].length;j++) //number of productions
	{for(k=0;k<grmr[i][j].length();k++,found=0) //when nonterminal has epsilon production
	{for(l=0;l<ntlen;l++) //finding nonterminal
	{if((grmr[i][j].charAt(k)==ntermnl[l])&&(i!=l)) //for nonterminal in first set
	{str=first(l);
	if(!(str.length()==1 && str.charAt(0)=='9')) //when epsilon production is the only nonterminal production
	temp=temp+str;
	found=1;
	break;}}
	if(found==1)
	{if(str.contains("9")) //here epsilon will lead to next nonterminal’s first set
	continue;}
	else //if first set includes terminal
	{
		int z=0,count=0;
		for(z=0;z<ntlen;z++)
		{
			if(grmr[i][j].charAt(k)==ntermnl[z])
				count++;
		}
		if(count==0)
		{
		temp=temp+grmr[i][j].charAt(k);
		break;}}}}
	return temp;	}
	
	
	static String follow(int i)
	{	char pro[],chr[];
		String temp=" ";
		int j,k,l,m,n,found=0;
		if(i==0)
			temp="$";
		for(j=0;j<ntlen;j++)
		{for(k=0;k<grmr[j].length;k++) //entering grammar matrix
		{
			pro=new char[grmr[j][k].length()];
			pro=grmr[j][k].toCharArray();
			for(l=0;l<pro.length;l++) //entering each production
			{
			if(pro[l]==ntermnl[i]) //finding the nonterminal whose follow set is to be found
			{
				if(l==pro.length-1) //if it is the last terminal/non-terminal then follow of current non-terminal
				{
					if(j<i)
						temp=temp+flw[j];
				}
				else
				{
					for(m=0;m<ntlen;m++)
					{
						if(pro[l+1]==ntermnl[m]) //first of next non-terminal otherwise (else later…)
						{
							chr=new char[fst[m].length()];
							chr=fst[m].toCharArray();
							for(n=0;n<chr.length;n++)
							{if(chr[n]=='9') //if first includes epsilon
							{if(l+1==pro.length-1)
								temp=temp+follow(j); //when non-terminal is second last
							else
								temp=temp+follow(m);}
							else
								temp=temp+chr[n]; //include whole first set except epsilon
							}
							found=1;}}
					if(found!=1)
						temp=temp+pro[l+1]; //follow set will include terminal(else is here)
					}}}}}
			return temp;}
	
	
	static String removeDuplicates(String str)
	{	int i;
		char ch;
		boolean seen[] = new boolean[256];
		StringBuilder sb = new StringBuilder(seen.length);
	for(i=0;i<str.length();i++)
	{	ch=str.charAt(i);
		if (!seen[ch])
		{seen[ch] = true;
		sb.append(ch);}
	}
	return sb.toString();
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/**
	 * Create the application.
	 */
	public SimpleLR() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		label = new JLabel("Simple LR Parser");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 24));
		label.setBounds(31, 42, 315, 28);
		frame.getContentPane().add(label);
		
		button = new JButton("ITEM SETS");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				itemset newset =new itemset();
				newset.setVisible(true);
				
			}
		});
		button.setBounds(32, 125, 110, 23);
		frame.getContentPane().add(button);
		
		button_1 = new JButton("GRAMMER");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				grammer g=new grammer();
				g.setVisible(true);
			}
		});
		button_1.setBounds(152, 125, 110, 23);
		frame.getContentPane().add(button_1);
		
		btnActionTable = new JButton("ACTION TABLE");
		btnActionTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				parse1 p;
				try {
					p = new  parse1();
					p.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnActionTable.setBounds(272, 125, 125, 23);
		frame.getContentPane().add(btnActionTable);
		
		btnNewButton = new JButton("FOLLOW");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				parsetable p1;
				try {
					p1= new  parsetable();
					p1.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(152, 180, 110, 23);
		frame.getContentPane().add(btnNewButton);
		
		btnGotoTable = new JButton("GOTO TABLE");
		btnGotoTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				gototable p4;
				try {
					p4= new  gototable();
					p4.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnGotoTable.setBounds(31, 180, 111, 23);
		frame.getContentPane().add(btnGotoTable);
		
		btnNewButton_1 = new JButton("Dy ItemSet");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				it newset =new it();
				newset.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(272, 180, 125, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
