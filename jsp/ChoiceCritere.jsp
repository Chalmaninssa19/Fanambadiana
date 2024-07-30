<%@page import="person.*,java.util.*"%>

<%  
    PersonAnnexe connecte = new PersonAnnexe();
    String nameConnect = request.getParameter("value");
    int idConnect = connecte.idConnect(nameConnect);  
    String sex = connecte.memberSexe( idConnect );
    sex = connecte.sexOppose(sex);
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Fanambadiana</title>
        <meta charset="utf-8">
    </head>
    <body>
        <h1>Please choice your preference :</h1>
        <form action="TraitCrit.jsp">
            <input type="hidden" name="idConnect" value="<% out.print(idConnect); %>"/>
            <input type="hidden" name="sexe" value="<% out.print(sex); %>" />
            <p>Salary : <input type="number" name="salary"/></p>
            <select name="religion">
            <p>Religion :
                <option type="text" value="1">Oui</option>
                <option type="text" value="0">Non</option>
            </p>
            </select>            <p>Fiavanana : <input type="number" name="fiavanana"/></p>
            <p>Diplome : <input type="number" name="diplome"/></p>
            <p>Physics : <input type="number" name="physics"/></p>
            <p><input type="submit" value="Valid"/></p>
        </form>
    </body>
</html>