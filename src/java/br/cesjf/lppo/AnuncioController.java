package br.cesjf.lppo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AnuncioController", urlPatterns = {"/listar.html", "/novo.html"})
public class AnuncioController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getRequestURI().contains("listar.html")) {
            List<Anuncio> lista = new ArrayList<>();
            AnuncioDAO dao = new AnuncioDAO();
            lista = dao.listaTodos();

            request.setAttribute("anuncio", lista);
            request.getRequestDispatcher("/WEB-INF/listar.jsp").forward(request, response);
        } else if (request.getRequestURI().contains("novo.html")) {
            request.getRequestDispatcher("/WEB-INF/novo.jsp").forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getRequestURI().contains("novo.html")) {
            Anuncio novoAnc = new Anuncio();
            novoAnc.setNome(request.getParameter("nome"));
            novoAnc.setDescricao(request.getParameter("descricao"));

            AnuncioDAO dao = new AnuncioDAO();
            dao.criar(novoAnc);

            response.sendRedirect("listar.html");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
