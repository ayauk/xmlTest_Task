/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author User
 */
public class XmlObject {
    String s;
    ArrayList<String> values;
    public int valuesAmount;
    Document document;
    
    public void setParameters(String s, int i){
        this.s=s;
        this.valuesAmount=i;
    }
    
    public ArrayList<String> parse() throws ParserConfigurationException, SAXException, IOException{
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
       DocumentBuilder builder = factory.newDocumentBuilder();
       InputSource is = new InputSource(new StringReader(this.s));
       Document doc=builder.parse(is);
       doc.getDocumentElement().normalize();
       this.document=doc;
       String[] tags=new String[10];
       for(int i=0; i<this.valuesAmount;i++){
           tags[i]="val"+i;
       }
       Element element;
       ArrayList<String> values=new ArrayList<String>();
       for(int i=0;i<this.valuesAmount;i++){
          element = (Element) doc.getElementsByTagName(tags[i]).item(0);
           String s=element.getTextContent();
           values.add(s);
       }
       this.values=values;
       return values;
    }
    public String concat(){
        String str="";
        for (int i = 0; i < this.valuesAmount; i++) {
          str=str.concat(this.values.get(i));
        }
       
       return str;
    }
    //альтернативный метод с хэш сетом
    /*public ArrayList<String> findUniqueSymbols(){
        
        ArrayList<String> words=this.values;
        ArrayList<String> uniqueSymbols=new ArrayList();
        
        for(int i=0; i<words.size(); i++){
            String curWord=words.get(i);
            StringBuilder curUniqueSymbols = new StringBuilder();
            Set<Character> symbols=new HashSet<Character>();
            for(int j=0; j<curWord.toCharArray().length; j++){
                //symbols.add(curWord.toCharArray()[j]);
                if(!symbols.contains(curWord.toCharArray()[j])){
                    symbols.add(curWord.toCharArray()[j]);
                    curUniqueSymbols.append(curWord.toCharArray()[j]);
                }
            }
            uniqueSymbols.add(curUniqueSymbols.toString());
        }
        return uniqueSymbols;
    }*/
    public ArrayList<String> findUniqueSymbols(){
        ArrayList<String> symbols=new ArrayList<String>();
        for (int i = 0; i < this.values.size(); i++) {
          String word=this.values.get(i);
          if(!word.isEmpty()){
            String temp=word+": ";
            for(int j=0; j<word.length(); j++){
                char symbol=word.charAt(j);
                if(word.indexOf(symbol)==word.lastIndexOf(symbol)){
                    temp=temp+symbol+" ";
                }
            }
            symbols.add(temp);
          }
        }
        return symbols;
    }
    
    public boolean validateName(){
        Pattern pat = Pattern.compile("^[a-zA-Z]+$");  
        boolean check = pat.matcher(this.values.get(0)).matches();
        return check;
    }
    public boolean validateNumber(){
        Pattern pat = Pattern.compile("[0-9]+"); 
        boolean check=false;
        for(int i=1; i<this.values.size(); i++){
            if(pat.matcher(this.values.get(i)).matches()){
                check=true;
            }
        }
        return check;
    }
    
}
