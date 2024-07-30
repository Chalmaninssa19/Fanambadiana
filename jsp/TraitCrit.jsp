<%@page import="person.*,java.util.*"%>

<%  
    int [] tab = new int[10];
    String sex = request.getParameter("sexe");

    tab[0] = Integer.parseInt(request.getParameter("idConnect"));
    tab[1] = Integer.parseInt(request.getParameter("salary"));
    tab[2] = Integer.parseInt(request.getParameter("religion"));
    tab[3] = Integer.parseInt(request.getParameter("fiavanana"));
    tab[4] = Integer.parseInt(request.getParameter("diplome"));
    tab[5] = Integer.parseInt(request.getParameter("physics"));

    CritereAnnexe criterPerso = new CritereAnnexe();
    criterPerso.insertCriterePersoAnnexe( tab, sex);
    response.sendRedirect("Accueil.jsp?value="+request.getParameter("idConnect"));

%>  .