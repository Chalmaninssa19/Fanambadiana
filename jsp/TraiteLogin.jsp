<%@page import="person.*,java.util.*"%>

<% 
    String name = request.getParameter("name");
    String pwd = request.getParameter("pwd");
    PersonAnnexe person = new PersonAnnexe();

    if(person.verifyPwd(pwd, name )) {
        int idConnect = person.idConnect(name);
        response.sendRedirect("Accueil.jsp?value="+idConnect);
    }
    else {
        response.sendRedirect("Login.jsp?");
    }

%>