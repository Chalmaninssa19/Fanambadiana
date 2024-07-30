<%@page import="person.*,java.util.*"%>

<% 
    PersonAnnexe personAnnexe = new PersonAnnexe();
    Vector <String> tabString = new Vector<>();
    int [] tabInt = new int[8];

    tabString.add(request.getParameter("name"));
    tabString.add(request.getParameter("pwd"));
    tabString.add(request.getParameter("sexe"));
    tabString.add(request.getParameter("pays"));

    tabInt[0] = Integer.parseInt(request.getParameter("salary"));
    tabInt[1] = Integer.parseInt(request.getParameter("religion"));
    tabInt[2] = Integer.parseInt(request.getParameter("fiavanana"));
    tabInt[3] = Integer.parseInt(request.getParameter("diplome"));
    tabInt[4] = Integer.parseInt(request.getParameter("physics"));

    personAnnexe.insertPersoAnnexe( tabString, tabInt);
    response.sendRedirect("ChoiceCritere.jsp?value="+tabString.get(0));

%>