<%@page import="person.*,java.util.*,java.sql.*"%>
<%
    int idI = Integer.parseInt(request.getParameter("id"));
    Raikitra couple = new Raikitra();
    Demande dem = new Demande();
    int idConnect = Integer.parseInt(request.getParameter("partner1"));
    if( idI == 1){
        couple.insertRaikitra(Integer.parseInt(request.getParameter("partner1")),Integer.parseInt(request.getParameter("partner2")));
        couple.insertIndispo(Integer.parseInt(request.getParameter("partner1")));
        couple.insertIndispo(Integer.parseInt(request.getParameter("partner2")));
        dem.deleteDemande(Integer.parseInt(request.getParameter("partner1")));
        response.sendRedirect("Accueil.jsp?value="+idConnect);
    }

    else {
        dem.deleteDemande(Integer.parseInt(request.getParameter("partner1")));
        response.sendRedirect("Accueil.jsp?value="+idConnect);
    }
%>