/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import model.XmlObject;
import org.xml.sax.SAXException;

/**
 *
 * @author User
 */
public class handle extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            XmlObject conv=new XmlObject();
            int counter=Integer.parseInt(request.getParameter("counter"));
            char operation=request.getParameter("value").charAt(0);
            String xmlString=request.getParameter("value").substring(1);
            conv.setParameters(xmlString, counter);
            try {
                conv.parse();
                if(operation=='1'){
                    out.print(conv.concat());
                    
                }
                if(operation=='2'){
                    ArrayList<String> s=conv.findUniqueSymbols();
                    out.print("<p>");
                    for(int i=0; i<s.size(); i++){
                        out.print(s.get(i)+"<br>");
                    }
                    out.print("</p>");
                    //out.print("Data: "+conv.concat());
                }
                if(operation=='3'){
                    if(!conv.validateName()){
                        out.print("<h5>Неверное имя!</h5>");
                    }
                    else if(!conv.validateNumber()){
                        out.print("<h5>Неверный номер!</h5>");
                    }
                    else{
                        out.print("<h5>Успешная валидация</h5>");
                    }
                    //out.print("Data: "+conv.concat());
                }
            } catch (ParserConfigurationException ex) {
                out.println("exception");
            } catch (SAXException ex) {
                out.println("exception");
                //Logger.getLogger(handle.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
