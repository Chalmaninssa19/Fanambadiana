<!DOCTYPE html>
<html>
    <head>
        <title>Fanambadiana</title>
        <meta charset="utf-8">
    </head>
    <body>
        <h1>Inscription's page</h1>
        <form action="Traitement.jsp">
            <p>Your name :<input type="text" name="name"/></p>
            <p>Your password :<input type="text" name="pwd"/></p>
            <p>Sexe : 
                <select name="sexe">
                    <option type="text" value="Masculin">Maculin</option>
                    <option type="text" value="Feminin">Feminin</option>
                </select>
            </p>
            <p>Country :
                <select name="pays">
                    <option type="text" value="africain">Africain</option>
                    <option type="text" value="malagasy">Malagasy</option>
                    <option type="text" value="francais">Francais</option>
                    <option type="text" value="americain">Americain</option>
                    option type="text" value="autres">Autres</option>
                </select>
            </p>
            <p>Salary : <input type="number" name="salary"/></p>
            <p>Religion : 
                <select name="religion">
                    <option type="text" value="1">Oui</option>
                    <option type="text" value="0">Non</option>
                </select>
            </p>
            <p>Fiavanana : <input type="number" name="fiavanana"/></p>
            <p>Diplome : <input type="number" name="diplome"/></p>
            <p>Physics : <input type="number" name="physics"/></p>

            <p><input type="submit" value="Save"/></p>
        </form>
    </body>
</html>