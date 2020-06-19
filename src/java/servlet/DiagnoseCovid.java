/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import covid.ejb.CovidBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author se7en
 */
@WebServlet(name = "DiagnoseCovid", urlPatterns = {"/DiagnoseCovid"})
public class DiagnoseCovid extends HttpServlet {

    CovidBeanLocal covidBean = lookupCovidBeanLocal();

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
            if(request.getParameter("info") != null){
                int corona = covidBean.getCorona();
                int influenza = covidBean.getInfluenza();
                int flu = covidBean.getFlu();
                int demam = covidBean.getDemam();
                int diare = covidBean.getDiare();
                int lainnya = covidBean.getLainnya();
                request.setAttribute("corona", corona);
                request.setAttribute("influenza", influenza);
                request.setAttribute("flu", flu);
                request.setAttribute("demam", demam);
                request.setAttribute("diare", diare);
                request.setAttribute("lainnya", lainnya);

                RequestDispatcher rd = getServletContext().getRequestDispatcher("/infografis.jsp");
                rd.include(request, response);
            }
            else{
              boolean batuk, demam, sumbat, nafas, dahak, diare, lemas;
            String nama = request.getParameter("nama");
            String keluhan = request.getParameter("keluhan");
            String tanggal = request.getParameter("tanggal");
            String diagnosa = "";
            String gejala = "";
            String penanganan1= ""; String penanganan2= ""; String penanganan3= "";
            batuk = Boolean.parseBoolean(request.getParameter("batuk"));
            demam = Boolean.parseBoolean(request.getParameter("demam"));
            sumbat = Boolean.parseBoolean(request.getParameter("sumbat"));
            nafas = Boolean.parseBoolean(request.getParameter("nafas"));
            dahak = Boolean.parseBoolean(request.getParameter("dahak"));
            diare = Boolean.parseBoolean(request.getParameter("diare"));
            lemas = Boolean.parseBoolean(request.getParameter("lemas"));
            if (batuk){
                if (demam){
                    if (diare){
                        diagnosa = "Influenza";
                        gejala = "Batuk, demam, diare";
                        penanganan1 = "Konsumsi obat non-aspirin, seperti acetaminophen dan ibuprofen, serta dekongestan";
                        penanganan2 = "Menghirup uap hangat";
                        penanganan3 = "Menggunakan minyak esensial & konsumsi obat anti diare";
                        covidBean.addInfluenza();
//                        covidBean.addCorona("influenza");
                    }
                    else if (nafas || dahak || lemas){
                        diagnosa = "Corona";
                        gejala = "Batuk, demam, pernafasan tidak normal atau dahak kental atau anggota tubuh lemas";
                        penanganan1 = "Isolasi mandiri 14 hari";
                        penanganan2 = "Tetap terhidrasi & istirahat cukup";
                        penanganan3 = "Minum paracetamol";
                        covidBean.addCovid();
//                        covidBean.addCorona("corona");
                    }
                    else{
                        diagnosa = "Influenza";
                        gejala = "Batuk, demam";
                        penanganan1 = "Konsumsi obat non-aspirin, seperti acetaminophen dan ibuprofen, serta dekongestan";
                        penanganan2 = "Menghirup uap hangat";
                        penanganan3 = "Menggunakan minyak esensial";
                        covidBean.addInfluenza();
//                        covidBean.addCorona("influenza");
                    }
                }
                else{
                    if (diare){
                        diagnosa = "Diare";
                        gejala = "Batuk & diare";
                        covidBean.addDiare();
//                        covidBean.addCorona("diare");
                    }
                    else if (nafas || dahak){
                        diagnosa = "Corona atau flu";
                        gejala = "Pernafasan tidak normal atau dahak kental";
                        penanganan1 = "Isolasi mandiri 14 hari";
                        penanganan2 = "Tetap terhidrasi & istirahat cukup";
                        penanganan3 = "Minum paracetamol";
                        covidBean.addCovid();
//                        covidBean.addCorona("corona");
                    }
                    else if (sumbat){
                        diagnosa = "Flu biasa";
                        gejala = "Batuk & hidung tersumbat";
                        penanganan1 = "Istirahat yang cukup & meminum obat";
                        penanganan2 = "Menghirup uap hangat";
                        penanganan3 = "Menggunakan minyak esensial";
                        covidBean.addFlu();
//                        covidBean.addCorona("flu");
                    }
                    else{
                        diagnosa = "Lainnya";
                        gejala = "Batuk";
                        penanganan1 = "Istirahat yang cukup";
                        penanganan2 = "Konsumsi vitamin C";
                        penanganan3 = "Konsumsi sirup batuk";
                        covidBean.addLainnya();
//                        covidBean.addCorona("lainnya");
                    }
                }
            }
            else if (!batuk && demam){
                if (diare){
                    diagnosa = "Influenza";
                    gejala = "Demam & diare";
                    penanganan1 = "Konsumsi obat non-aspirin, seperti acetaminophen dan ibuprofen, serta dekongestan";
                    penanganan2 = "Menghirup uap hangat";
                    penanganan3 = "Menggunakan minyak esensial & konsumsi obat anti diare";
                    covidBean.addInfluenza();
//                    covidBean.addCorona("influenza");
                }
                else if (nafas || dahak || lemas){
                    diagnosa = "Corona";
                    gejala = "Ppernafasan tidak normal atau dahak kental atau anggota tubuh lemas";
                    penanganan1 = "Isolasi mandiri 14 hari";
                    penanganan2 = "Tetap terhidrasi & istirahat cukup";
                    penanganan3 = "Minum paracetamol";
                    covidBean.addCovid();
//                    covidBean.addCorona("corona");
                }
                else{
                    diagnosa = "Demam";
                    gejala = "Demam";
                    penanganan1 = "Istirahat yang cukup";
                    penanganan2 = "Konsumsi obat penurun panas";
                    penanganan3 = "Menggunakan minyak esensial";
                    covidBean.addDemam();
//                    covidBean.addCorona("demam");
                }
            }
            else if (!demam && !batuk && nafas){
                if (diare){
                    diagnosa = "Diare";
                    gejala = "Diare";
                    penanganan1 = "Konsumsi obat antidiare";
                    penanganan2 = "Minum oralit";
                    penanganan3 = "Konsumsi makanan probiotik";
                    covidBean.addDiare();
//                    covidBean.addCorona("diare");
                }
                else if (dahak || lemas){
                    diagnosa = "Corona";
                    gejala = "Pernafasan tidak normal dan dahak kental atau anggota tubuh lemas";
                    penanganan1 = "Isolasi mandiri 14 hari";
                    penanganan2 = "Tetap terhidrasi & istirahat cukup";
                    penanganan3 = "Minum paracetamol";
                    covidBean.addCovid();
//                    covidBean.addCorona("corona");
                }
                else{
                    diagnosa = "Lainnya";
                    gejala = "Pernafasan tidak normal";
                    penanganan1 = "Istirahat yang cukup";
                    penanganan2 = "Konsumsi vitamin C";
                    penanganan3 = "Menggunakan minyak esensial";
                    covidBean.addLainnya();
//                    covidBean.addCorona("lainnya");
                }
            }
            else if (!demam && !batuk && !nafas && diare){
                diagnosa = "Diare";
                gejala = "Diare";
                penanganan1 = "Konsumsi obat antidiare";
                penanganan2 = "Minum oralit";
                penanganan3 = "Konsumsi makanan probiotik";
                covidBean.addDiare();
//                covidBean.addCorona("diare");
            }
            else{
                diagnosa = "Lainnya";
                gejala = "Anggota tubuh lemas atau hidung tersumbat";
                penanganan1 = "Istirahat yang cukup";
                penanganan2 = "Konsumsi vitamin C";
                penanganan3 = "Menggunakan minyak esensial";
                covidBean.addLainnya();
//                covidBean.addCorona("lainnya");
            }
            request.setAttribute("diagnosa", diagnosa);
            request.setAttribute("nama", nama);
            request.setAttribute("tanggal", tanggal);
            request.setAttribute("gejala", gejala);
            request.setAttribute("penanganan1", penanganan1);
            request.setAttribute("penanganan2", penanganan2);
            request.setAttribute("penanganan3", penanganan3);
//            int value = covidBean.getCorona();
//            out.println("Operand: " + value + "<br />");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/hasil.jsp");
            rd.include(request, response);  
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

    private CovidBeanLocal lookupCovidBeanLocal() {
        try {
            Context c = new InitialContext();
            return (CovidBeanLocal) c.lookup("java:global/Covid19/CovidBean!covid.ejb.CovidBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
