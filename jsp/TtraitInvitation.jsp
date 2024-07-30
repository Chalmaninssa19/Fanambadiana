<%@page import="member.*,java.util.*,java.sql.*"%>
<%
    int idI = Integer.parseInt(request.getParameter("id"));
    Encouple couple = new Encouple();
    Invitation dem = new Invitation();
    int idConnect = Integer.parseInt(request.getParameter("partner1"));
    if( idI == 1){
        couple.insertEncouple(Integer.parseInt(request.getParameter("partner1")),Integer.parseInt(request.getParameter("partner2")));
        couple.insertIndisponible(Integer.parseInt(request.getParameter("partner1")));
        couple.insertIndisponible(Integer.parseInt(request.getParameter("partner2")));
        dem.deleteDemande(Integer.parseInt(request.getParameter("partner1")));
        response.sendRedirect("Accueil.jsp?idConnect="+idConnect);
    }

    else {
        dem.deleteDemande(Integer.parseInt(request.getParameter("partner1")));
        response.sendRedirect("Accueil.jsp?idConnect="+idConnect);
    }
%>