package servlets;

import java.io.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Note;

/**
 *
 * @author Raymond
 */
public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = getServletContext().getRealPath("/WEB-INF/note.txt");

        // to read files
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));

        String title = br.readLine();
        String contents = br.readLine();

        Note note = new Note(title, contents);
        request.setAttribute("note", note);

        br.close();

        if (request.getParameter("edit") == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                    .forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp")
                    .forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        // to write to a file
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
        String title = request.getParameter("title");
        String contents = request.getParameter("contents");
        pw.println(title);
        pw.printf(contents);
        Note note = new Note(title, contents);
        request.setAttribute("note", note);
        pw.close();

        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);
    }

}
