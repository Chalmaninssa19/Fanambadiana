<%@page import="person.*,java.util.*,java.sql.*"%>
<% 
    int idConnect = Integer.parseInt(request.getParameter("value"));
    PersonAnnexe  person = new PersonAnnexe();
    CritereAnnexe critPers = new CritereAnnexe();
    ResultSet res = person.member(idConnect);
    ResultSet allMembers = person.selectPersonAnnexe();
    ResultSet noteCrit = critPers.selectIdCritere( idConnect );
    ResultSet noteConnecte = person.getNoteConnect(idConnect);
    int noteConnect = 0;
    int note =0;
    if( noteConnecte.next()) {
        noteConnect = noteConnecte.getInt(1);
    }
    while ( noteCrit.next()) {
        note = Integer.parseInt(noteCrit.getString(9));
    }

    Vector <Integer> tab = person.recommandations( note );
    ResultSet personRecommand = null;
        System.out.print(tab.size());
    for ( int i = 0; i < tab.size(); i++) {
        System.out.print(personRecommand);
        personRecommand = person.member(tab.get(i));
    }

    Vector <Integer> datas = new Vector<>();
    Demande dem = new Demande();
    Raikitra raikitra = new Raikitra();
%>

<!DOCTYPE html>
<html>
    <head>
        <title>Fanambadiana</title>
        <meta charset="utf-8">
    </head>
    <body>
        <h1>My profile :</h1>
        <table border="1px">
        <tr>
            <th>Name</th>
            <th>Sex</th>
            <th>Country</th>
            <th>Salary</th>
            <th>Religion</th>
            <th>Fiavanana</th>
            <th>Diplom</th>
            <th>Physics</th>
        </tr>
        <tr>
        <% while(res.next()) { %>
            <td><% out.print(res.getString(2)); %></td>
            <td><% out.print(res.getString(4)); %></td>
            <td><% out.print(res.getString(5)); %></td>
            <td><% out.print(res.getString(6)); %></td>
            <td><% out.print(res.getString(7)); %></td>
            <td><% out.print(res.getString(8)); %></td>
            <td><% out.print(res.getString(9)); %></td>
            <td><% out.print(res.getString(10)); %></td>
        <% } %>    
        </tr>
           
        </table>

        <h1>Member's lists :</h1>
        <table border="1px">
            <tr>
                <th>Name</th>
                <th>Salary</th>
                <th>Religion</th>
                <th>Diplom</th>
            </tr>
            <% while(allMembers.next()) { %>
            <tr>
                <td><% out.print(allMembers.getString(2)); %></td>
                <td><% out.print(allMembers.getString(6)); %></td>
                <td><% out.print(allMembers.getString(7)); %></td>
                <td><% out.print(allMembers.getString(8)); %></td>
            </tr>
            <% } %>
        </table>
        <%  if ( tab.size()!=0 && raikitra.verifyRaikitra(idConnect) != true) { %>
        <h1>Our recommandations for you :</h1>
        <table border="1px">
            <tr>
                <th>Name</th>
                <th>Sex</th>
                <th>Country</th>
                <th>Salary</th>
                <th>Religion</th>
                <th>Fiavanana</th>
                <th>Diplome</th>
                <th>Physics</th>
                <th>Note</th>
            </tr>
            <% 
            while(personRecommand.next()) { %>
            <tr>
                <td><% out.print(personRecommand.getString(2)); %></td>
                <td><% out.print(personRecommand.getString(4)); %></td>
                <td><% out.print(personRecommand.getString(5)); %></td>
                <td><% out.print(personRecommand.getString(6)); %></td>
                <td><% out.print(personRecommand.getString(7)); %></td>
                <td><% out.print(personRecommand.getString(8)); %></td>
                <td><% out.print(personRecommand.getString(9)); %></td>
                <td><% out.print(personRecommand.getString(10)); %></td>
                <td><% out.print(personRecommand.getString(11)); %></td>
                <td><a href="TraitMatching.jsp?idDemandeur=<% out.print(idConnect); %>&idInvite=<% out.print(personRecommand.getString(1)); %>">Matching</a></td>
            </tr>
        <% } } %>
        </table>
        <% if( dem.verifyInvitation(idConnect)) { %>
        <h1>Invitation :</h1>
        <%
            int invitation = dem.demandeur(idConnect); 
            ResultSet invit = person.member(invitation);
            while(invit.next()) {
        %>
            <p><% out.print(invit.getString(2)); %> vous a envoye une invitation le
                <% out.print(dem.dateInvitation(invit.getInt(1))); %> 
                <a href="TraitInvite.jsp?partner1=<% out.print(idConnect); %>&partner2=<% out.print(invitation); %>&id=1">Accepter</a>
                <a href="TraitInvite.jsp?partner1=<% out.print(idConnect); %>&partner2=<% out.print(invitation); %>&id=2">Refuser</a>
            </p>
        <% } }
        else {
            if( raikitra.verifyRaikitra(idConnect) ) {
                ResultSet couples = raikitra.selectCouple(idConnect);
                while(couples.next()) { 
                    String name1 = person.memberName(couples.getInt(2));
                    String name2 = person.memberName(couples.getInt(3));
                %>
                    <p><% out.print(name1); %> est en couple avec <% out.print(name2); %>
                        le <% out.print(couples.getDate(4)); %>
                    </p>
               <% }
            }
            else {}
        }
        
        %>

    </body>
</html>