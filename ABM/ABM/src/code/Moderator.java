package code;

import java.awt.*;
import sim.portrayal.*;
import sim.util.*;
import sim.engine.*;

public class Moderator implements Steppable
{
    private static final long serialVersionUID = 1;
    public int modid;
    public int minV;
    public int timer=2;
    public int count; 
    int [][]pr;
    int [][]sr;
    static int counter=0;
    static int z_count=0;
    int [][]s1sagent;
    int [][]s1pagent;
    double avg=0;
    int diff=0;
    int x=0;
    int nsk,npk;
    double strat3=0;
    double strat4=0;
    double social=0;
    static int xx=0;
    
    PAgent []parr;
    SAgent []sarr;
    
    public Moderator(int myid,int nn,int prk){
    	modid=myid;
    	nsk=nn;
    	npk=prk;
    	s1sagent=new int [2][nsk];
    	s1pagent=new int [2][prk];
    	parr=new PAgent[prk];
    	sarr=new SAgent[nsk];
    	pr=new int[2][prk];
        sr=new int[2][nsk];
     }
    public void setpr(int k,int pr11,PAgent pp,int counn){
    	parr[k]=pp;
    	parr[k].mybid=pr11;
    	pr[0][k]=pr11;
    	pr[1][k]=1;
    }
    public void setsr(int k,int sr11,SAgent ss,int counn){
    	sarr[k]=ss;
    	sarr[k].mybid=sr11;
    	sr[0][k]=sr11;
    	sr[1][k]=1;
    }
    public double giveavg(){
    	return avg;
    }
    
    public void Psorting(PAgent parr[],int m,int n){
    	for(int i=0;i<3;i++){
			for(int j=0;j<2-i;j++){
				if(parr[j+1].mybid<parr[j].mybid){
					PAgent t=parr[j+1];
					parr[j+1]=parr[j];
					parr[j]=t;
				}
			}
		}
    	parr[0].cur_pos=0;
    	parr[1].cur_pos=1;
    	parr[2].cur_pos=2;
    	
    }
    
    public void Ssorting(SAgent sarr[],int m){
    	for(int i=m;i<3;i++){
			for(int j=m;j<2-i+m;j++){
				if(sarr[j+1].mybid>sarr[j].mybid){
					SAgent t=sarr[j+1];
					sarr[j+1]=sarr[j];
					sarr[j]=t;
				}
			}
		}
    	sarr[0].cur_pos=0;
    	sarr[1].cur_pos=1;
    	sarr[2].cur_pos=2;
    	
    }
    public void step( final SimState state )
    {  
    	int count=0;
    	int scount=0;
    	double strat1,strat2;
    	int pcount=0;	
        if(timer%2==1){
            Environment environment = (Environment)state;
            if(timer<2*Gen.number){
            	counter++;
           //// 	System.out.println("* =========================================================================");
         ////   	System.out.println("* Parr[0]: "+parr[0].mybid+" , "+parr[0].indicator+"|| Parr[1]: "+parr[1].mybid+" , "+parr[1].indicator+"|| Parr[2]:"+parr[2].mybid+" , "+parr[2].indicator);
         ////   	System.out.println("* Sarr[0]: "+sarr[0].mybid+" , "+sarr[0].indicator+"|| Sarr[1]: "+sarr[1].mybid+" , "+sarr[1].indicator+"|| Sarr[2]:"+sarr[2].mybid+" , "+sarr[2].indicator);
    
            	for(int i=0;i<3;i++){
        			for(int j=0;j<2-i;j++){
        				if(parr[j+1].mybid<parr[j].mybid){
        					PAgent t=parr[j+1];
        					parr[j+1]=parr[j];
        					parr[j]=t;
        				}
        			}
        		}
            	parr[0].cur_pos=0;
            	parr[1].cur_pos=1;
            	parr[2].cur_pos=2;
           //// 	System.out.println("* Pairs formed: "+z_count);
            	int pp=0;
            	while(pp<3){
            		if(sarr[pp].indicator>0)
            			break;
            		pp++;	
            	}
            	Ssorting(sarr,pp);
            	int o=0;
            	avg=0;
            	while(o<3){
            		if(parr[o].indicator>=1)
            			avg=avg+parr[o].mybid;
            		o++;
            	}
            	int i=0;
            	while(i<3){
            		if(parr[i].indicator!=0)
            			count++;
            		i++;
            	}
            	if(count!=0)
            	avg=avg/count;
            	i=0;
            	while(i<3){
            		if(parr[i].mybid<=avg)
            			pcount++;
            		if(sarr[i].mybid>=avg)
            			scount++;
            		i++;
            	}
       ////     	System.out.println("*"+pcount+" "+scount+" "+ avg);
            	i=0;
            	int j=0;
            	int k=0;
            	
           //// 	System.out.println("*----------------Initial Bids----------------");
           //// 	System.out.print("* primary: ");
            	while (i<3)
            	{
            		////if(parr[i].indicator>=1)
            	////		System.out.print("* "+parr[i].mybid+" "+" "+parr[i].indicator+" id:"+parr[i].id+" ||");
            		i++;
            	}
            	i=0;
            	////System.out.println();
            	////System.out.print("* Secondary: ");
            	while (i<3)
            	{
            	////	if(sarr[i].indicator>=1)
            		////	System.out.print("* "+sarr[i].mybid+" "+sarr[i].indicator+"  id:"+sarr[i].id+" ||");
            		i++;
            	}
           //// 	System.out.println();
            	i=0;
            	while(i<3){
            		if(parr[i].mybid<=avg && parr[i].indicator!=0){
            			j+=parr[i].indicator;
            		}
            		if(sarr[i].mybid>=avg && sarr[i].indicator!=0){
            			k+=sarr[i].indicator;
            		}
            		i++;
            	}
            	 x=j;
            	if(j>k)
            		x=k;
            ////	System.out.println("* x:"+x);
            ////	System.out.println("* z_count: "+z_count);;
            	i=z_count;
            	j=0;
           //// 	System.out.println("*---------------Active Bids------------------");
           //// 	System.out.print("* Primary: ");
            	int tt=0;
            	while(tt<3){
            		if(parr[tt].indicator>0)
            			break;
            		tt++;	
            	}
                int tt1=0;
                int xp=x;
                int xs=x;
            	while(tt1<x){
            		if(parr[tt].indicator>xp){
            			tt1=tt1+xp;
            			parr[tt].indicator-=xp;
            			s1pagent[1][parr[tt].id] += xp-tt1;
                		s1pagent[0][parr[tt].id] += (xp)*avg;
                		strat3=strat3+(avg-parr[tt].mybid)*xp;
               //// 		System.out.print( "*"+parr[tt].id+" formed "+ xp+" Pairs |||");
                		xp=0;
                		
                		break;
            		}
            		else{
            			tt1=tt1+parr[tt].indicator;
            			s1pagent[1][parr[tt].id] += parr[tt].indicator;
                		s1pagent[0][parr[tt].id] += parr[tt].indicator*avg;
                		strat3=strat3+(avg-parr[tt].mybid)*parr[tt].indicator;
                		xp-=parr[tt].indicator;
            	/////		System.out.print("*"+parr[tt].id+ " formed "+parr[tt].indicator+" Pairs |||");
            			parr[tt].indicator=0;
                		
            		}
            		tt++;
            	}
        ////    	System.out.println();
            	
            	////System.out.print("* Secondry: ");
             	tt=0;
            	while(tt<3){
            		if(sarr[tt].indicator>0)
            			break;
            		tt++;	
            	}
                tt1=0;
            	while(tt1<x){
            		if(sarr[tt].indicator>xs){
            			tt1=tt1+xs;
            			sarr[tt].indicator-=xs;
            			s1sagent[1][sarr[tt].id] += xs-tt1;
                		s1sagent[0][sarr[tt].id] += (xs)*avg;
                		strat4=strat4+(sarr[tt].mybid-avg)*xs; 
                	////	System.out.print( "*"+sarr[tt].id+" formed"+ xs+" Pairs |||");
                		xs=0;
                		break;
            		}
            		else{
            			tt1=tt1+sarr[tt].indicator;
            			s1sagent[1][sarr[tt].id] += sarr[tt].indicator;
                		s1sagent[0][sarr[tt].id] += sarr[tt].indicator*avg;
                		strat4=strat4+(sarr[tt].mybid-avg)*sarr[tt].indicator; 
            		////	System.out.print("*"+sarr[tt].id+ " formed"+ sarr[tt].indicator+" Pairs |||");
            			xs-=sarr[tt].indicator;
            			sarr[tt].indicator=0;
                		}
            		tt++;
            	}
            	
      ////      	System.out.println();
            	////System.out.println("*Mod  timer: "+timer);
            	z_count=z_count+x;
            	////System.out.println("*Parr[0]: "+parr[0].mybid+" Parr[1]: "+parr[1].mybid+" Parr[2]:"+parr[2].mybid);
            	////System.out.println("*Sarr[0]: "+sarr[0].mybid+" , "+sarr[0].indicator+" Sarr[1]: "+sarr[1].mybid+" , "+sarr[1].indicator+" Sarr[2]:"+sarr[2].mybid+" , "+sarr[2].indicator);
            	
            	
              ////	System.out.println("*"+s1pagent[0][0] +":" + s1pagent[1][0]+ "  ,  "+ s1pagent[0][1] +":" + s1pagent[1][1]+ "  ,  " + s1pagent[0][2] +":" + s1pagent[1][2]);
              ////  System.out.println("*"+s1sagent[0][0] +":" + s1sagent[1][0]+ "  ,  "+ s1sagent[0][1] +":" + s1sagent[1][1]+ "  ,  " + s1sagent[0][2] +":" + s1sagent[1][2]);
                
                //--------------------------------
                strat1 = (nsk+npk)*100;
                strat2 = (s1pagent[0][0]+s1pagent[0][1]+s1pagent[0][2])*2*0.1;
                social=strat3+strat4;
                //System.out.println("*Social Welfare I = "+social);
                
                //--------------------------------
        
            }
          
        }timer++;
        if(timer==2*Gen.number) {

        	double fact=sarr[0].factor+sarr[1].factor+sarr[2].factor;
        	System.out.println(fact+"   Social Welfare I = " +social);
        	DrawGraph.arr1[0][xx]=(int)(fact*200);
        	DrawGraph.arr1[1][xx++]=(int)(social/80);
        	Gen.gtimer++;
        	if(Gen.gtimer==2*Gen.number)
        	{
        		System.out.println("Mod I");
        		DrawGraph.cmain();
        		//System.exit(0);
        		for(int i=0;i<Gen.number;i++)
        		{
        			System.out.println(DrawGraph.arr2[0][i] +" "+DrawGraph.arr2[1][i]);
        		}
        		System.out.println();
        		for(int i=0;i<Gen.number;i++)
        		{
        			System.out.println(DrawGraph.arr1[0][i] +" "+DrawGraph.arr1[1][i]);
        		}
        		//System.exit(0);
        	}
        }
  }
        
    
}
