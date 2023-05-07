//import java.util.*;
import java.lang.Character;
class Element
{
    double n;
    char op='\0';
    public Element(double num,char ope)
    {
        this.n=num;
        this.op=ope;
    }

}
class Calc //extends Element
{
    boolean isOperator(char c)
    {
        boolean rtn = false;
        char[] ops = new char[] {'/','*','+','-'};
        for (char i : ops) {
            if(i == c)
                rtn = true;
        }
        return rtn;
    }
    Element[] StringtoTree(String s)
    {
        String a="";
        double temp;
        char c;
        int k=0,i,l=s.length();
        Element[] ele = new Element[10];
        for(i=0;i<l;i++)
        {
            c=s.charAt(i);
            if(Character.isDigit(c)||c=='.')
            {
                a+=c;
                if(!Character.isDigit(s.charAt(i+1)) && s.charAt(i+1)!='.')
                {
                    temp=Double.parseDouble(a);
                    a="";
                    ele[k] = new Element(temp, '\0');
                    k++;
                }
            }
            else if(isOperator(c))
            {
                ele[k] = new Element(0, c);
                k++;
            }
        }
        return ele;
    }
    public void display(Element[] e)
    {
        for (Element i : e) {
            System.out.println("["+i.op+"],("+i.n+")|");
        }
    }
    
    
}
