package servlets;

import questions.QuestionAndAnswerArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


@WebServlet("")
public class MainServlet extends HttpServlet {


    static int AMOUNT_OF_QUESTIONS = 40;

    ArrayList<QuestionAndAnswerArrayList.Cell> questionAndAnswerArrayList = QuestionAndAnswerArrayList.getQuestionAndAnswerArrayList(AMOUNT_OF_QUESTIONS);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // resp.sendRedirect("index.jsp");

        String massage = getGeneratedMassage();

        req.setAttribute("something", getGeneratedMassage());
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String htmlAnswers = "<html>\n" +
                "<head>\n" +
                "    <title>Hello Servlet</title>\n" +
                "</head>\n" +
                "<body>";

        for(int i=0;i<AMOUNT_OF_QUESTIONS;i++){
            String answer = req.getParameter("answer"+i);
            htmlAnswers = htmlAnswers + " <br>\n"+
                    i + ") ";
            if (questionAndAnswerArrayList.get(i).getAnswer().equals(answer)){
                htmlAnswers = htmlAnswers + " +++ ";
            }else{
                htmlAnswers = htmlAnswers + " --- ";
            }
        }
        htmlAnswers = htmlAnswers + "</body></html>";
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.format(htmlAnswers);
    }

    String getGeneratedMassage() {
        String tmp = "";
        for (int i = 0; i < AMOUNT_OF_QUESTIONS; i++) {
            tmp = tmp + "<br>\n" + questionAndAnswerArrayList.get(i).getQuestion() +
                    " =  <input type='text' name='answer" + i + "'> " ; //questionAndAnswerArrayList.get(i).getAnswer();
        }
        return tmp;
    }
}
