/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
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
    String name;
    String login;
    String email;
    String pnumber;
    String msg;
    String s;
    Document document;
    public void setString(String s){
        this.s=s;
    }
    
    public void parse() throws ParserConfigurationException, SAXException, IOException{
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
       DocumentBuilder builder = factory.newDocumentBuilder();
       InputSource is = new InputSource(new StringReader(this.s));
       Document doc=builder.parse(is);
       doc.getDocumentElement().normalize();
       this.document=doc;
       Element element = (Element) doc.getElementsByTagName("name").item(0);
       this.name=element.getTextContent();
       element=(Element) doc.getElementsByTagName("login").item(0);
       this.login=element.getTextContent();
       element=(Element) doc.getElementsByTagName("email").item(0);
       this.email=element.getTextContent();
       element=(Element)doc.getElementsByTagName("pnumber").item(0);
       this.pnumber=element.getTextContent();
       element=(Element)doc.getElementsByTagName("msg").item(0);
       this.msg=element.getTextContent();
       //return "Root element :" + doc.getDocumentElement().getNodeName();
    }
    public String concat(){
        String[] parameters={this.name,this.login,this.email, this.pnumber, this.msg};
        String str="";
        for (int i = 0; i < parameters.length; i++) {
          //Element element = (Element) this.document.getElementsByTagName(tags[i]).item(0);
          str=str.concat(parameters[i]);
        }
       
       return str;
    }
    
    public ArrayList<String> findUniqueSymbols(){
        String[] parameters={this.name,this.login,this.email, this.pnumber, this.msg};
        
        ArrayList<String> symbols=new ArrayList<String>();
        for (int i = 0; i < parameters.length; i++) {
          String word=parameters[i];
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
        boolean check = pat.matcher(this.name).matches();
        return check;
    }
    public boolean validateEmail(){
        Pattern pat = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                    "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");  
        boolean check = pat.matcher(this.email).matches();
        return check;
    }
    
}
