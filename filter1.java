/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author GENIUS
 */
public class filter1 implements Filter {
    
    //the configuration of the filter
    //we will use it in init method
    FilterConfig config;
    
    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        //getting request from servlet
        String fname = request.getParameter("fname");
        
        //the environment where the filter is running..
//        this to log into the server
//        config.getServletContext().log(fname + " logged in at " + new Date());
        
        
        //CREATING A FILE AND WRITING INTO IT..
        FileWriter file = new FileWriter(new File("loggusername.txt"), true);
        BufferedWriter writter = new BufferedWriter(file);
        writter.append(fname.toUpperCase() + " " + "logged in at ".toUpperCase() + new Date()  + "<br>");
        writter.newLine();
        writter.close();
        
        //to go to the a filter or to a servlet
        chain.doFilter(request, response);
        
    }

    

    /**
     * Destroy method for this filter
     */
    public void destroy() {        
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {
        //intializing the filter config
        config = filterConfig;
    }
    
}
