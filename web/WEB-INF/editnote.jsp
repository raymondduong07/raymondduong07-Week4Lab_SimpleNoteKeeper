<%-- 
    Document   : editnote
    Created on : 3-Oct-2020, 12:43:08 PM
    Author     : Raymond
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        <form method="post" action="note">
            Title: <input type="text" name="title" value="text"><br>
            Contents: 
            <textarea name="contents">text</textarea>
            <br><input type="submit" value="Save">
        </form>
    </body>
</html>
